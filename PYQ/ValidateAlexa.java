package PYQ;
import java.util.*;
// AMAZON Q
/*
Question: Validate Alexa commands based on a set of rules, like:
 * First word must be "Alexa"
 * No repeated words back-to-back
 * And other similar constraints
 */
// CHECK OUT JUnit CLASS WHICH IS A CUSTOM TESTER FOR THIS
public class ValidateAlexa {
    abstract static class Rule {
        abstract boolean isValid(String[] words);
        abstract String getErrorMessage();
    }
    static class StartsWithAlexa extends Rule {
        @Override
        boolean isValid(String[] words) {
            return words.length>0 && words[0].equalsIgnoreCase("alexa");
        }
        @Override
        String getErrorMessage() {
            return "Command is not starting with Alexa";
        }
    }
    static class NoRepeatedWords extends Rule {
        @Override
        boolean isValid(String[] words) {
            for(int i=0;i<words.length-1;i++){
                if(words[i].equalsIgnoreCase(words[i+1])) return false;
            }
            return true;
        }
        @Override
        String getErrorMessage() {
            return "Command contains consecutive repeating words";
        }
    }
    static class MaxLength extends Rule {
        private final int MaxWordsLength;
        public MaxLength(int n){
            this.MaxWordsLength = n;
        }
        @Override
        boolean isValid(String[] words) {
            return words.length <= MaxWordsLength;
        }
        @Override
        String getErrorMessage() {
            return "Command consists of more than max words length";
        }
    }
    static class BannedWords extends Rule {
        Set<String> bannedWords;
        public BannedWords(Set<String> bw){
            this.bannedWords = bw;
        }
        @Override
        boolean isValid(String[] words) {
            for(String w: words){
                if(bannedWords.contains(w.toLowerCase())) return false;
            }
            return true;
        }
        @Override
        String getErrorMessage() {
            return "Command consists of Banned/Restricted Words";
        }
    }
    static class Validator {
        List<Rule> rules;
        public Validator(List<Rule> rules){
            this.rules = rules;
        }
        boolean validate(String command){
            if(command==null) return false;
            String[] words = command.trim().split("\\s+");
            for(Rule rule: rules){
                if(!rule.isValid(words)){
                    System.out.println("Validation Failed: "+rule.getErrorMessage());
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args){
        Set<String> banned = new HashSet<>(Arrays.asList("shut ip", "kill","explode"));
        List<Rule> rules = Arrays.asList(
                new StartsWithAlexa(),
                new NoRepeatedWords(),
                new MaxLength(10),
                new BannedWords(banned)
        );
        Validator validator = new Validator(rules);
        System.out.println(validator.validate("Alexa Turn on"));
    }
}
