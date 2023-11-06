class SeatManager {
    private int currSeat = 0;
    private PriorityQueue<Integer> emptySeats;
    
    public SeatManager(int n) {
        emptySeats = new PriorityQueue<>();
    }
    
    public int reserve() {
        if (!emptySeats.isEmpty()) {
            return emptySeats.poll();
        }
        return ++currSeat;
    }
    
    public void unreserve(int seatNumber) {
        if (seatNumber == currSeat) --currSeat;
        else emptySeats.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */