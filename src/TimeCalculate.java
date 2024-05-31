/*Name   : U.A. Pragathi Sithmini
UOW id : w1810216
IIT id : 20200351*/

public class TimeCalculate {
    long end;
    long start;
    public void startTime(){  // to calculate the start time of the algorithm
        start = System.nanoTime();
    }
    public void endTime(){    // to calculate the end time of the algorithm
        end = System.nanoTime();
    }
    public void timeElapsed(){       // calculate the elapsed time to execute the algorithm
        long execution = end - start;
        System.out.println("Execution time in nanoseconds: " + execution);
        System.out.println("Execution time in milliseconds: " + execution/ 1000000);
    }
}
