/**
 * @param {string} s
 * @return {number}
 */
 var scoreOfParentheses = function(s) {
     function splitChunk(s) {
        if (!s.includes('(') && !s.includes(')')) return Number(s)
        return _split(s).map(x => {
            if (x === '()') return 1
            if (x[0] === '(' && x[x.length - 1] === ')') return 2 * splitChunk(x.slice(1, -1))
            if (!x.includes('(') && !x.includes(')')) return Number(x)
        }).reduce((x,y) => {
            return x + y
        }, 0)
    
    }
    return splitChunk(s)
};
console.log(
    scoreOfParentheses("(1)()()"),
    scoreOfParentheses("(())"),
    scoreOfParentheses("()()"),
    scoreOfParentheses("((()(())))"),
    scoreOfParentheses("(()(()))"),
)

function _split(s) {
    const t = s.split('')
    let result = []
    let result2 = []
    let acc = 0
    const len = t.length
    for(let i = 0; i < len; i ++) {
        if (t[i] == '(') {
            result.push(t[i])
            acc++
        } else if (t[i] === ')') {
            result.push(t[i])
            acc--
            if (acc === 0) {
                result2.push(result.join(''))
                result = []
            }
        } else {
            result.push(t[i])
        }
    }
    return result2
}
