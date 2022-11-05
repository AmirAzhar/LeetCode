// 212. Word Search II
// https://leetcode.com/problems/word-search-ii/description/

var findWords = function (board, words) {
  const ans = [];

  if (!board || !words || board.length < 1) return [];

  const root = buildTrie(words);

  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[0].length; j++) {
      dfs(board, i, j, root, ans);
    }
  }

  return ans;
};

function dfs(board, i, j, trie, ans) {
  const w = board[i][j];

  if (!trie.children.has(w)) return;

  trie = trie.children.get(w);

  if (trie.word) {
    ans.push(trie.word);
    trie.word = null;
  }

  board[i][j] = "#";
  if (i > 0) dfs(board, i - 1, j, trie, ans);
  if (j > 0) dfs(board, i, j - 1, trie, ans);
  if (i < board.length - 1) dfs(board, i + 1, j, trie, ans);
  if (j < board[0].length - 1) dfs(board, i, j + 1, trie, ans);
  board[i][j] = w;
}

function buildTrie(words) {
  const root = new TrieNode();

  words.forEach((w) => {
    let node = root;

    for (let i = 0; i < w.length; i++) {
      let c = w[i];

      if (!node.children.has(c)) node.children.set(c, new TrieNode());

      node = node.children.get(c);
    }

    node.word = w;
  });

  return root;
}

class TrieNode {
  constructor() {
    this.word = null;
    this.children = new Map();
  }
}
