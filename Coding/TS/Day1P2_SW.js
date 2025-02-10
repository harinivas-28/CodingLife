var s = "RRBBRRBRBRRBRRBRRB";
var L = 6;
var res = L;
function getAnswer(s, L) {
    var cnt = 0;
    for (var i = 0; i < L; i++) {
        if (s[i] === 'B')
            cnt++;
    }
    res = Math.min(res, L - cnt);
    for (var i = L; i < s.length; i++) {
        if (s[i - L] === 'B')
            cnt--;
        if (s[i] === 'B')
            cnt++;
        res = Math.min(res, L - cnt);
    }
    return res;
}
console.log(getAnswer(s, L));
