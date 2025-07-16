package CompanyQuestions;
// AMAZON Q
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


class AlexaCommandValidator {
    private static ValidateAlexa.Validator validator;
    @BeforeEach
    public void setup(){
        Set<String> banned = new HashSet<>(Arrays.asList("shut ip", "kill","explode"));
        List<ValidateAlexa.Rule> rules = Arrays.asList(
                new ValidateAlexa.StartsWithAlexa(),
                new ValidateAlexa.NoRepeatedWords(),
                new ValidateAlexa.MaxLength(10),
                new ValidateAlexa.BannedWords(banned)
        );
        validator = new ValidateAlexa.Validator(rules);
    }
    @Test
    void testValidCommand(){
        assertTrue(validator.validate("Alexa turn on the lights"));
    }
    @Test
    void testMissingAlexa() {
        assertFalse(validator.validate("turn on the lights"));
    }

    @Test
    void testConsecutiveRepeat() {
        assertFalse(validator.validate("Alexa turn turn on"));
    }

    @Test
    void testRestrictedWord() {
        assertFalse(validator.validate("Alexa shut up"));
    }

    @Test
    void testExtraSpaces() {
        assertTrue(validator.validate("   Alexa   turn   off  "));
    }

    @Test
    void testMaxWordsExceeded() {
        assertFalse(validator.validate("Alexa one two three four five six seven eight nine ten eleven"));
    }

    @Test
    void testNullInput() {
        assertFalse(validator.validate(null));
    }

    @Test
    void testEmptyInput() {
        assertFalse(validator.validate(""));
    }

}
