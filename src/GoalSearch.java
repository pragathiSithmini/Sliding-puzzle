/*Name   : U.A. Pragathi Sithmini
UOW id : w1810216
IIT id : 20200351*/

import java.util.ArrayList;
import java.util.List;

public class GoalSearch {

    public static boolean IsWalkable(String[][] map, Point point) { // check the map to see if the point is walkable.
        if (point.y < 0 || point.y > map.length - 1) return false;   // If the point does not exist, return false. If the point is a stone (obstacles), return false.
        if (point.x < 0 || point.x > map[0].length - 1) return false;
        return map[point.y][point.x].equals("0");
    }

    public static List<Point> FindNeighbors(String[][] map, Point point) { // Each point can have maximum 4 neighbors. check the reachable points and return them.
        List<Point> neighbors = new ArrayList<>();
        Point up = point.offset(0,  1, "Go up to");
        Point down = point.offset(0,  -1, "Go down to");
        Point left = point.offset(-1, 0, "Go left to");
        Point right = point.offset(1, 0, "Go right to");
        if (IsWalkable(map, up)) neighbors.add(up);
        if (IsWalkable(map, down)) neighbors.add(down);
        if (IsWalkable(map, left)) neighbors.add(left);
        if (IsWalkable(map, right)) neighbors.add(right);
        return neighbors;
    }

    public static List<Point> FindPath(String[][] map, Point start, Point end) {  // Find the path from start to goal.
        boolean finished = false;
        List<Point> used = new ArrayList<>(); // The list of already reached points
        used.add(start);
        while (!finished) {  // if all points are traversed but the goal not found, stop the looping
            List<Point> newOpen = new ArrayList<>();  // list of newly found points in the map in each iteration of the neighbour search iteration
            for(int i = 0; i < used.size(); ++i){  // Iterate over the all the points reached before
                Point point = used.get(i);  // Get the point
                for (Point neighbor : FindNeighbors(map, point)) { // Find the neighbours of the point
                    if (!used.contains(neighbor) && !newOpen.contains(neighbor)) { // If the neighbour is not in the list of already reached points and not in the list of newly found points.
                        newOpen.add(neighbor); // Add the neighbour to the list of newly found points
                    }
                }
            }

            for(Point point : newOpen) { // Iterate over the newly found points
                used.add(point); // Add the point to the list of already reached points
                if (end.equals(point)) { // If the goal is found, stop the looping
                    finished = true;
                    break;
                }
            }

            if (!finished && newOpen.isEmpty()) // If no new point is found, stop the looping as no matter of continue the search
                return null;
        }

        List<Point> path = new ArrayList<>(); // The list of points that form the path
        Point point = used.get(used.size() - 1); // Get the last point in the list of already reached points
        while(point.previous != null) { // Loop untill the start point is reached (Because the start point has no previous point (null))
            path.add(0, point);
            point = point.previous;
        }
        return path;
    }
}
