// 732. My Calendar III
// https://leetcode.com/problems/my-calendar-iii/description/

var MyCalendarThree = function() {
    // Dictionary where key is a specified start time  and value is the number of booking starting at that point
    this.bookings = {}
};

/** 
 * @param {number} start 
 * @param {number} end
 * @return {number}
 */
MyCalendarThree.prototype.book = function(start, end) {
    // Increment the start key indicating 1 more booking at that time
    this.bookings[start] = (this.bookings[start] || 0) + 1 

    // Decrement the end key indicating that 1 more booking could be made at that pos
    this.bookings[end] = (this.bookings[end] || 0) - 1

    let count = max = 0
    
    // Iterate through bookings
    for(const key in this.bookings) {

        // Get the number of current bookings alr made for each start/end time
        const val = this.bookings[key]

        // Update the running count on overlaps
        count += val

        // Keep the max bookings
        max = Math.max(max, count)
    }
    
    return max
    
};

/** 
 * Your MyCalendarThree object will be instantiated and called as such:
 * var obj = new MyCalendarThree()
 * var param_1 = obj.book(start,end)
 */