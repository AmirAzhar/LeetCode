// 223. Rectangle Area
// https://leetcode.com/problems/rectangle-area/description/

var computeArea = function (ax1, ay1, ax2, ay2, bx1, by1, bx2, by2) {
  return Math.max(ax1, bx1) < Math.min(ax2, bx2) &&
    Math.max(ay1, by1) < Math.min(ay2, by2)
    ? (ax2 - ax1) * (ay2 - ay1) +
        (bx2 - bx1) * (by2 - by1) -
        (Math.min(ax2, bx2) - Math.max(ax1, bx1)) *
          (Math.min(ay2, by2) - Math.max(ay1, by1))
    : (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
};
