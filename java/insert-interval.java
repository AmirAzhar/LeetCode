// https://leetcode.com/problems/insert-interval/description/

// Java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int[] toAdd = newInterval;

        for (int[] i : intervals){
            // Case 1: i comes before newInterval
            if (toAdd[0] > i[1]) list.add(i);

            // Case 2: i comes after newInterval{}
            else if (toAdd[1] < i[0]) {
                list.add(toAdd);
                toAdd = i;
            }

            // Case 3: overlapping interval
            else {
                toAdd[0] = Math.min(toAdd[0], i[0]);
                toAdd[1] = Math.max(toAdd[1], i[1]);
            }
        }

        list.add(toAdd);

        return list.toArray(new int[list.size()][]);
    }
}

// JS
var insert = function(intervals, newInterval) {
    let toAdd = newInterval
    let res = []

    for (let i of intervals){
        // case 1: i before toAdd
        if (toAdd[0] > i[1]) res.push(i);

        // case 2: i after toAdd
        else if (toAdd[1] < i[0]){
            res.push(toAdd)
            toAdd = i
        }

        // case 3: overlapping
        else {
            toAdd[0] = Math.min(toAdd[0], i[0])
            toAdd[1] = Math.max(toAdd[1], i[1])
        }
    }

    res.push(toAdd)

    return res
};

// for any interval in the input, it can
    // come before
    // come after
    // overlap
// create a placehholder [][] to hold value -> init to newInterval
// iterate through intervals i
    // if i happens before placeholder, simply add i to the res
    // if i happens after placeholder, add placeholder to res + updated placeholder to i
    // if overlap, udate the placeholder