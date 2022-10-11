/**
 * @param {number[]} nums
 * @return {number[][]}
 */
 var permute = function(nums) {
    console.log('nums', nums)
    if (nums.length === 1) return [nums]
    let result = []
    nums.forEach((_, index) => {
        const tNums = remain(nums, index)
        let nextRes = permute(tNums)
        // if (index == 0 && nums.length == 3) {
        //     console.log(nextRes)
        // }
        console.log('nextRes', nextRes)
        nextRes.forEach(x => {
            x.unshift(_); // 之前选取的数字插到剩余数组求得的全排列所有结果数组的首位
            result.push(x);
        })

    })
    console.log('result', result)
    return result


    function remain(x, index) {
        const xx = x.slice()
        xx.splice(index, 1)
        return xx
    }
};

console.log(permute([1,2,3]))