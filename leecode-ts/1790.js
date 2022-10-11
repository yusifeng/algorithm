/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
 var areAlmostEqual = function(s1, s2) {
    if (s1 === s2) return true
    else {
        let a1 = []
        let a2 = []
        const len = s1.length
        for (let i = 0; i < len; i++) {
            if (s1[i] !== s2[i]) {
                a1.push(s1[i])
                a2.push(s2[i])
            } 
        }
        if (a1.length === a2.length && a1.length === 2 && a2.length === 2 && a1[0] === a2[1] && a1[1] === a2[0]) {
            return true
        } else {
            console.log(1)
            return false
        }
    }
};

console.log(areAlmostEqual('bank', 'kanb'))