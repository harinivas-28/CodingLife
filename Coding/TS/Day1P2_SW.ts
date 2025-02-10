const s = "RRBBRRBRBRRBRRBRRB";
const L = 6;
let res = L;

function getAnswer(s: string, L:number){
    let cnt = 0;
    for(let i=0;i<L;i++){
        if(s[i]==='B') cnt++;
    }
    res = Math.min(res, L-cnt);
    for(let i=L;i<s.length;i++){
        if(s[i-L]==='B') cnt--;
        if(s[i]==='B') cnt++;
        res = Math.min(res, L-cnt);
    }
    return res;
}

console.log(getAnswer(s, L));