/*Name   : U.A. Pragathi Sithmini
UOW id : w1810216
IIT id : 20200351*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapParser {
    private Point start;
    private Point end;
    String[][] map;

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public String[][] getMap() {
        return map;
    }

    public void createMap(String fileName) {
        int x_axis = 0;
        int y_axis = 0;
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                x_axis = line.length();
                y_axis++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        String[][] map = new String[x_axis][y_axis];
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            int j=0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                for (int k = 0; k < data.length(); k++) {
                    if ('.'==data.charAt(k)) {
                        map[j][k] = "0";
                    } else if ('0'==data.charAt(k)) {
                        map[j][k] = "1";
                    } else {
                        map[j][k] = "0";
                        if ('S'==data.charAt(k)) {
                            this.start = new Point.PointBuilder().setX(k).setY(j).build();
                        }else{
                            this.end = new Point.PointBuilder().setX(k).setY(j).build();
                        }
                    }
                }
                j++;
            }
            myReader.close();
            this.map = map;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
