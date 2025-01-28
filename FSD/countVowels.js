const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const getVowelCount = (str) => {
    const vowels = str.match(/[aeiouAEIOU]/g) || [];
    const letters = str.match(/[b-dB-Df-hF-Hj-nJ-Np-tP-Tv-zV-Z]/g) || [];
    return {
        vowelCount: vowels.length,
        letterCount: letters.length
    };
}

const getVowelsCount = (str) => {
    const vowels = "aeiouAEIOU";
    let vC = 0, lC = 0;
    for(const c of str){
        if(c.match(/[a-zA-Z]/)){
            if(vowels.includes(c)){
                vC++;
            } else {
                lC++;
            }
        }
    }
    return {
        vC, lC
    };
}

const str = "Hello World!";
const {vowelCount, letterCount} = getVowelCount(str);
const {vC, lC} = getVowelsCount(str);
console.log(`Vowels: ${vowelCount}, Letters: ${letterCount}`);
console.log(`Vowels: ${vC}, Letters: ${lC}`);