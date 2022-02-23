import java.util.List;
import java.util.*;

public class StampMain {
    public static final int SIZE = 12;

    public static void main(String[] args){
        Random r = new Random();
        int[] stamps = new int[]{1, 4, 5};

        StampCreate first = new StampCreate(stamps, SIZE);

        for (int i = 0; i < 20; i++){
            first.getStamp(r.nextInt(SIZE));
            System.out.println();
        }

        List<Integer> temp = first.getStamp(SIZE);
    }
}
