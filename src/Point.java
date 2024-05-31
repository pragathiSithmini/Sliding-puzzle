/*Name   : U.A. Pragathi Sithmini
UOW id : w1810216
IIT id : 20200351*/

import java.util.Objects;

public class Point {
    public int x;
    public int y;
    public String direction;
    public Point previous;

    public Point(PointBuilder pointBuilder){  // The constructor with builder pattern.
        this.x = pointBuilder.x;
        this.y = pointBuilder.y;
        this.direction = pointBuilder.direction;
        this.previous = pointBuilder.previous;
    }

    public static class PointBuilder{  // A builder class to build the point object according to different scenarios.
        private int x;
        private int y;
        private Point previous;
        private String direction;

        public PointBuilder setX(int x) {
            this.x = x;
            return this;
        }
        public PointBuilder setY(int y) {
            this.y = y;
            return this;
        }
        public PointBuilder setDirection(String direction) {   // Set the direction where the point is coming from.
            this.direction = direction;
            return this;
        }
        public PointBuilder setPrevious(Point previous) {
            this.previous = previous;
            return this;
        }

        public Point build(){
            return new Point(this);
        }

    }

    @Override
    public String toString() {
        if(direction == null){
            return String.format("%s (%d, %d)","", x, y);
        }else{
            return String.format("%s (%d, %d)", direction, x, y);
        }
    }

    @Override
    public boolean equals(Object o) {
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() { return Objects.hash(x, y); }

    public Point offset(int ox, int oy, String direction) {     // The change of coordinates from the current point to the next point.
        return new PointBuilder().setX(x + ox).setY(y + oy).setPrevious(this).setDirection(direction).build();
    }
}