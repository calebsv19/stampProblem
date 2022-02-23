import java.lang.*;
import java.util.*;

public class StampCreate {
    private int[] optimized; // number of stamps required for each N
    private int size; // amount of possible N
    private int[] stamps; // stamp cost values

    // creates optimal values for each N
    public StampCreate(int[] stamps, int start){
        optimized = new int[start];
        size = start;
        this.stamps = stamps;

        stampRun(stamps, size);

        System.out.print("");
    }

    // call to go down each possible path based on stamp values
    public void stampRun(int[] stamps, int start){
        int minimum = Integer.MAX_VALUE;

        for (int i = stamps.length - 1; i >= 0; i--){
            int num = start - stamps[i];
            if (num == 0){
                minimum = 0;
            } else if (num > 0){
                if (optimized[num - 1] == 0){
                    stampRun(stamps,num);
                }

                if (optimized[num - 1] < minimum){
                    minimum = optimized[num - 1];
                }
            }
        }

        if (minimum == Integer.MAX_VALUE){
            minimum = 0;
        }
        optimized[start - 1] = minimum + 1;
    }

    // returns optimal list of stamps to get the given N
    public List<Integer> getStamp(int num){
        List<Integer> stampPer = new ArrayList<>();
        System.out.print("Stamps for " + num + ":");
        getStampHelp(stampPer, num);
        return stampPer;

    }
    
    // returns optimal list of stamps to get the given N
    private void getStampHelp(List<Integer> stampPer, int start){
        int stamp = 0;
        if (start > 0) {
            for (int i = 0; i < stamps.length; i++) {
                int num = start - stamps[i];
                if (optimized[start - 1] == 1){
                    stamp = start;
                } else if (num > 0) {
                    if (optimized[num - 1] + 1 == optimized[start - 1]) {
                        stamp = stamps[i];
                    }
                }
            }
        }
        System.out.print(" " + stamp);
        stampPer.add(stamp);
        if (start - stamp > 0){
            getStampHelp(stampPer, start - stamp);
        }
    }
}
