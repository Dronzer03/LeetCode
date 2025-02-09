package Graphs;

// As a theater booking system with N seats (1...N), You made a mistake while assigning tickets. And it ended up assigning 2 tickets to everyone instead of 1.
// M (where M < N) people who tried to book the ticket in your theater got 2 tickets instead of 1.
// so basically all the people who wants to watch the show ends up with two tickets.
// - To solve this mistake you decided to be smart and figure out if it's possible to cancel just 1 tickets instead of re assigning tickets to everyone?
// - If it's possible to just cancel one ticket which ticket you will cancel? (return list which represent cancelled ticket for ith person at ith index )
// Example:
// N: 5
// bookings : (6,2) (1,2) (1,6) (2,3) (3,4) (5,2)
// answer:
// Yes,
// cancel (2,1,6,2,3,2)

import java.util.*;

// (1,2) (1,2) (2,1) (3,4) (5,7) -> no
public class DoubleBookingsGoogle {
    public List<Integer> theatreBookings(int[][] bookings) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        for (int index = 0; index < bookings.length; index++) {
            isAssignable(bookings, index, map, seen);
        }

        List<Integer> cancelledSeats = new ArrayList<>();
        if (map.size() == bookings.length) {
            for (int person = 0; person < bookings.length; person++) {
                int seat1 = bookings[person][0];
                int seat2 = bookings[person][1];
                cancelledSeats .add(map.get(seat1) == person ? seat2 : seat1); // add the opposite seat which isn't assigned to that person, i.e cancelled seat
            }
        }
        return cancelledSeats;
    }

    private boolean isAssignable(int[][] bookings, int index, Map<Integer, Integer> map, Set<Integer> seen) {
        for (int seat : bookings[index]) {
            if (seen.contains(seat))
                continue;

            seen.add(seat);
            if (!map.containsKey(seat) || isAssignable(bookings, seat, map, seen)) {
                map.put(seat, index);
                return true;
            }
        }
        return false;
    }
}
