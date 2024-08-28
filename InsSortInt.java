import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class InsSortInt {
    public static void main(String[] args) {
        File file = new File("randInts.txt");

        int nums[] = new int[1000];
        
        try {
            Scanner scan = new Scanner(file);

            int i=0;
            while (scan.hasNextLine()) {
                int n = scan.nextInt();
                nums[i] = n;
                i++;
            }
            scan.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        int[] sorted = insertionSort(nums, 1000);

        System.out.println("smallest: " + sorted[0]);
        System.out.println("biggest: " + sorted[999]);
    }

    static int[] insertionSort(int[] input, int n) {
        int[] ret = input;

        for(int i=0; i<n; i++) {
            int j=i-1;
            while(j >= 0 && ret[j] > ret[j+1]) {
                int tmp = ret[j];
                ret[j] = ret[j+1];
                ret[j+1] = tmp;
                j--;
            }
        }

        return ret;
    }
}
