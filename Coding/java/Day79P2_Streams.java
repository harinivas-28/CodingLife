package Coding.java;
/*
Given a list of EventAttendance (eventId, attendeeName, durationMinutes),
Your task is to consider only attendees who stayed ≥ 60 minutes.
For each event, display the Event ID (ascending order), List of qualified
attendee names (alphabetically sorted) and Count of such attendees.

Example 1
---------
Sample Input:
4
E101 John 90
E101 Alice 55
E101 Zara 75
E102 Mark 120

Sample output:
E101 [John, Zara] Count=2
E102 [Mark] Count=1

Example 2
---------
Sample Input:
11
E502 Carl 90
E502 Dan 45
E501 Ana 100
E502 Evan 75
E501 Beth 61
E502 Fred 20
E301 Ron 30
E301 Tony 60
E302 Lily 75
E302 Kevin 50
E301 Maya 90

Sample Output:
E301 [Maya, Tony] Count=2
E302 [Lily] Count=1
E501 [Ana, Beth] Count=2
E502 [Carl, Evan] Count=2

*/
import java.util.*;
import java.util.stream.*;

public class Day79P2_Streams {
    static class EventAttendance {
        String id, name;
        int dt;
        public EventAttendance(String id, String name, int dt){
            this.id = id;
            this.name = name;
            this.dt = dt;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<EventAttendance> l = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            String[] line = sc.nextLine().split(" ");
            l.add(new EventAttendance(line[0], line[1], Integer.parseInt(line[2])));
        }
        Map<String, List<String>> g = l.stream()
                .filter(ea -> ea.dt>=60)
                .collect(Collectors.groupingBy(ea->ea.id, Collectors.mapping(ea->ea.name, Collectors.toList())));
        g.entrySet().stream().sorted(Map.Entry.comparingByKey()).
                forEach(ea->{
                    List<String> names = ea.getValue();
                    Collections.sort(names);
                    System.out.println(ea.getKey()+" "+names+" Count="+names.size());
                });

    }
}
