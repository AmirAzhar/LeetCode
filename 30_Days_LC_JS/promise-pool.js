// 2636. Promise Pool
// https://leetcode.com/problems/promise-pool/description/

/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Function}
 */
var promisePool = async function (functions, n) {
  async function exec() {
    if (!functions.length) return;
    const fn = functions.shift();
    await fn();
    await exec();
  }

  const promises = Array(n).fill().map(exec);
  await Promise.all(promises);
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */
