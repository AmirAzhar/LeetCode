// 841. Keys and Rooms
// https://leetcode.com/problems/keys-and-rooms/description/

function canVisitAllRooms(rooms) {
  // Set to keep track of which rooms have been visited
  const visited = new Set();
  // Queue to store keys that have been found
  const queue = [];
  // Add the first room (room 0) to the visited set and add its keys to the queue
  visited.add(0);
  queue.push(...rooms[0]);

  // Keep going until there are no more keys to explore
  while (queue.length > 0) {
    // Take the first key from the queue
    const key = queue.shift();
    // If the key's corresponding room has not been visited yet
    if (!visited.has(key)) {
      // Add it to the visited set
      visited.add(key);
      // And add its keys to the queue
      queue.push(...rooms[key]);
    }
  }

  // Return true if all rooms have been visited, false otherwise
  return visited.size === rooms.length;
}
