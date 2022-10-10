/**
 * @param {string} s
 * @return {number}
 */
//  var scoreOfParentheses = function(s) {
//      function splitChunk(s) {
//         if (!s.includes('(') && !s.includes(')')) return Number(s)
//         return _split(s).map(x => {
//             if (x === '()') return 1
//             if (x[0] === '(' && x[x.length - 1] === ')') return 2 * splitChunk(x.slice(1, -1))
//             if (!x.includes('(') && !x.includes(')')) return Number(x)
//         }).reduce((x,y) => {
//             return x + y
//         }, 0)
    
//     }
//     return splitChunk(s)
// };
// console.log(
//     scoreOfParentheses("(1)()()"),
//     scoreOfParentheses("(())"),
//     scoreOfParentheses("()()"),
//     scoreOfParentheses("((()(())))"),
//     scoreOfParentheses("(()(()))"),
// )

// function _split(s) {
//     const t = s.split('')
//     let result = []
//     let result2 = []
//     let acc = 0
//     const len = t.length
//     for(let i = 0; i < len; i ++) {
//         if (t[i] == '(') {
//             result.push(t[i])
//             acc++
//         } else if (t[i] === ')') {
//             result.push(t[i])
//             acc--
//             if (acc === 0) {
//                 result2.push(result.join(''))
//                 result = []
//             }
//         } else {
//             result.push(t[i])
//         }
//     }
//     return result2
// }



function scoreOfParentheses(s) {
    let stack = []
    s = s.split('')
    while(s.length !== 0) {
        const t = s.shift()
        if (t === '(') stack.push('(')
        else {
            const t = [')']
            let tt = stack.pop()
            while(tt !== '(') {
                t.unshift(tt)
                tt = stack.pop()
            }
            t.unshift(tt)
            if (t.length === 2) {
                processStack(stack, '1')
            }  else {
                processStack(stack,  2 * t[1])
            }
            
        }
    }
    return Number(stack[0])
    function processStack(stack, x) {
        if (!stack.length) stack.push(x)
        else if ('()'.includes(stack[stack.length - 1])) {
            stack.push(x)
        } else {
            stack[stack.length - 1] = String(Number(stack[stack.length - 1]) + Number(x))
        }
    }
}

console.log(
    scoreOfParentheses("()()()"),
    scoreOfParentheses("(())"),
    scoreOfParentheses("()()"),
    scoreOfParentheses("(()())"),
    scoreOfParentheses("(()(()))"),
)