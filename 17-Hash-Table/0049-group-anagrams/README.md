
JS 的写法可以通过。

```js
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
    const n = strs.length;
    const ans = new Map();
    const prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103];
    const mod = 1e9 + 7;
    for (let i = 0; i < n; i++) {
        let hash = 1;
        for (let j = 0; j < strs[i].length; j++) {
            let num = strs[i].charCodeAt(j) - 97;
            hash = ((hash % mod) * (prime[num] % mod)) % mod;
        }
        if (!ans.get(hash)) ans.set(hash, []);
        ans.get(hash).push(strs[i]);
    }
    return [...ans.values()];
};
```