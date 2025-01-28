// ARRAY
const arr = [3, 4, 6, 2, 3, 1, 0, 9, 7, 8];
const target = 9;
for(let i=0;i<arr.length;i++){  // 1
    if(arr[i]===target){
        console.log(`Target found at index ${i}`);
        break;
    }
}
for(const ele of arr){  // 2
    if(ele===target){
        console.log(`Target found`);
        break;
    }
}
arr.forEach((idx, ele)=>{ // 3
    if(ele===target){
        console.log(`Target found at ${idx-1}`);
        return;
    }
})
const idx = arr.findIndex(ele => ele===target); // 4
console.log(idx);

// STRING
const str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
const t2 = "S";
for(let char of str){   // 1
    if(char===t2){
        console.log(`${t2} found`);
        break;
    }
}
const idx2 = Array.from(str).findIndex(ele => ele===t2);    // 2
console.log(idx2);
const idx3 = str.indexOf(t2);   // 3
console.log(idx3);
console.log(str.includes(t2))   // 4
// OBJECTS
const obj = {
    0: "Hari",
    1: "Mani",
    2: "KC",
    3: "Lalit"
}
const t3 = "Mani";
for(let item in obj){   // 1
    if(obj[item]===t3){
        console.log(`Target found ${item}:${obj[item]}`);
        break;
    }
}
const k = Object.keys(obj);
console.log(k); // Gives an array of keys
const v = Object.values(obj);
console.log(v);
const ind = v.indexOf(t3); // 3
console.log(ind);
const en = Object.entries(obj); // Returns Array of Arrays with Key and it's Value
console.log(en); 
for(const sub of en){   // 4
    if(sub[1]===t3){
        console.log(`Target ${t3} found at ${sub[0]}`);
        break;
    }
}
// SETS
const set = new Set(arr);
console.log(set);
if(set.has(target)){    // 1
    console.log(`${target} is in Set`);
}
// 2 -> for each loop
// 3 -> Normal for loop
let map = new Map();
map.set('name', 'Alice');
map.set('age', 25);
console.log(map);