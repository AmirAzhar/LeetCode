// 433. Minimum Genetic Mutation
// https://leetcode.com/problems/minimum-genetic-mutation/description/

var minMutation = function (start, end, bank) {
  const queue = new Queue([[start, 0]]);
  bank = new Set(bank);

  while (!queue.isEmpty()) {
    const [curMutation, iterations] = queue.dequeue();

    if (curMutation === end) return iterations;

    for (let mutation of bank) {
      if (!isValidMutation(mutation, curMutation)) continue;
      queue.enqueue([mutation, iterations + 1]);
      bank.delete(mutation);
    }
  }

  return -1;

  function isValidMutation(s1, s2, dif = 0) {
    for (let i = 0; i < 8; i++) {
      if (s1[i] !== s2[i]) dif++;
      if (dif > 1) return false;
    }
    return true;
  }
};
