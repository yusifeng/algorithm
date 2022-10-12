/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number[]} nums
 * @return {number}
 */
//  var numComponents = function(head, nums) {
//    const node = genList(head)
//     let result = 0
//     let acc = 0
//     let curNode = node
//     for (let i = 0; i < nums.length; i ++) {
//         let curNum = nums[i]
//         if (curNum === curNode.val) {
//             curNode = curNode.next
//             acc++
//         } else {
//             result = Math.max(acc, result)
//             curNode = node
//         }
//     }
//     return result
// };

var numComponents = function(head, nums) {
    const node = genList(head)
    while (nums.length) {
        if ()
    }
 };
 

function genList(arr) {
    let result = null
    let result2 = null
    arr.forEach(x => {
        if (!result) {
            result = new ListNode(x)
            result2 = result
        } else {
            const t = new ListNode(x)
            result.next = t
            result = t
        }
    })
    return result2
}



function ListNode(val, next) {
         this.val = (val===undefined ? 0 : val)
         this.next = (next===undefined ? null : next)
}

let rs = numComponents([0,1,2,3,4], [0,3,1,4])
console.log(rs)
