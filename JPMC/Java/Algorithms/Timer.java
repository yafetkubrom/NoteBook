
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class Timer {
    public static void main(String[] args)throws ParseException {
        int arr[] = {1, 3, 4, 6, 4, 6, 9, 5, 10, 34, 34, 65, 200};

        long startTime = System.nanoTime();

        
        // function
        bubbleSort(arr);


        long endTime = System.nanoTime();
    
        long durationInNano = (endTime - startTime);    // total time in nano seconds
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(durationInNano);
        
        System.out.println("Nano : " + durationInNano);
        System.out.println("Millis : " + durationInMillis);
    }

    private static void bubbleSort(int arr[]) {
        int n = arr.length;
        int i, j, temp;
        for (i = 0; i < n - 1; i++)
            for (j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                }
    } 
}


/* 
compile 
    - cd ..
    - javac Algorithms/Timer.java
run
    - java Algorithms.Timer
*/