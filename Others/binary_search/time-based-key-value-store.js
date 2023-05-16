// 981. Time Based Key-Value Store
// https://leetcode.com/problems/time-based-key-value-store/description/

var TimeMap = function () {
  this.hashMap = new Map();
};

TimeMap.prototype.set = function (key, value, timestamp) {
  if (this.hashMap.has(key)) {
    let arr = this.hashMap.get(key);
    arr.push([timestamp, value]);
    this.hashMap.set(key, arr);
  } else {
    let arr = [timestamp, value];
    this.hashMap.set(key, [arr]);
  }
  return null;
};

TimeMap.prototype.get = function (key, timestamp) {
  // Base case 1 & 2: key does not exist, or no prev timesetamps, return ""
  let arr = this.map.get(key);
  if (!this.map.has(key) || arr[0][0] > timestamp) return "";

  // Use Binary Search to look for the required value
  const index = binarySearch(arr, timestamp);
  if (arr[index][0] > timestamp) return arr[index - 1][1];
  return arr[index][1];
};

function binarySearch(arr, timestamp) {
  let start = 0,
    end = arr.length - 1,
    mid;
  // Iterate while start not meets end
  while (start <= end) {
    // Find the mid index
    mid = Math.floor((start + end) / 2);

    // If element is present at mid, return True
    if (arr[mid][0] === timestamp) return mid;
    // Else look in right
    else if (arr[mid][0] < timestamp) start = mid + 1;
    // Or look left
    else end = mid - 1;
  }
  return mid;
}
