/*Name   : U.A. Pragathi Sithmini
UOW id : w1810216
IIT id : 20200351*/

import java.util.List;

public class GameDemo {

    public static void main(String[] args) {

        MapParser mapParser = new MapParser();  // crate a object from MapParser class
        TimeCalculate timeCalculate = new TimeCalculate();  // create a object from TimeCalculate Class
        System.out.println("\n**********-- THE GRAPH --**********\n");
        mapParser.createMap("C:\\Users\\user\\Desktop\\AlgobenchExample\\Example1/maze10_2.txt");  // Read the text file and create the data structure.
        System.out.println("\n*******-- Start Goal Search --*******\n");
        timeCalculate.startTime();   // call this method to calculate the start time
        System.out.println("1. Start at" + mapParser.getStart().toString());   // define the start point.
        List<Point> path = GoalSearch.FindPath(mapParser.getMap(), mapParser.getStart(), mapParser.getEnd()); // Create a Arraylist using Point data type.
        if (path != null) { // Check whether path is null or not null and if it is not null, start to find the shortest path.
            int step = 2;
            for (Point point : path) {
                System.out.println(step + ". " + point.toString());
                step++;
            }
            timeCalculate.endTime();  // call this method to calculate the end time
            System.out.println("Done !");
            System.out.println("-------------------------------------------------");
        }
        else                     // If path is null, display No path found.
            System.out.println("No path found");
            timeCalculate.endTime();  // call this method to calculate the end time

        timeCalculate.timeElapsed();  // call this method to get the the execution time
    }
}


