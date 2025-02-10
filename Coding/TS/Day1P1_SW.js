function findMinProd(n, l, r, nums) {
    var min = Number.MAX_VALUE;
    for (var k = 0; k <= (r - l + 1); k++) {
        var curr = 1;
        for (var i = 0; i < n; i++) {
            curr *= nums[i];
            if (i >= l - 1) {
                if (curr > 0) {
                    min = Math.min(min, curr);
                }
                if (nums[i - l + 1] === 0)
                    continue;
                curr /= nums[i - l + 1];
            }
        }
        l++;
    }
    return min === Number.MAX_VALUE ? -1 : min;
}
var n = 5, l = 2, r = 4;
var nums = [1, 2, 3, 4, 5];
console.log(findMinProd(n, l, r, nums));
