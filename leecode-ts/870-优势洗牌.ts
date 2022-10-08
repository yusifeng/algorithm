// 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。

// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。


function advantageCount(nums1: number[], nums2: number[]): number[] {
    nums1 = nums1.sort((a,b)=>a-b)
    nums2 = nums2.sort((a,b)=>a-b)
    console.log(nums1, nums2)

    return [1]
};

const nums1 = [12,24,8,32] 
const nums2 = [13,25,32,11]
console.log(advantageCount(nums1, nums2))