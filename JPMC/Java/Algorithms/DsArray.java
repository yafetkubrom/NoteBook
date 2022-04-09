
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;

public class DsArray {

    public String[] getTopics() {
        String[] topics = {"History", "Science", "Philosophy", "Math"};
        return topics;
    }

    public static void main(String[] args) {

        /* Declaring an array

        DsArray array = new DsArray();
        String[] topics = array.getTopics();
        System.out.println(Arrays.toString(topics));

        // declare empty array
        
        String[] words = new String[2];
        words[0] = "Hello";
        words[1] = "World";

        // foreach 
        
        for (String word : words) {
            System.out.println(word);
        }

        */

        /* array to list to do more

        int[] intArray = new int[] {5, 4, 3, 2, 1};
        List<Integer> aList = new ArrayList<>();
        for (int i : intArray) aList.add(i);
        */

        // array to stream to simplify if must

        /* sort (quicksort for primitive and mergesort for others)
        int[] iArray = new int[] {5,4,3,2,1};
        Arrays.sort(iArray);
        System.out.println(Arrays.toString(iArray));
        */

    }
}

// another option is stream

// ArrayList<generic> name = new ArrayList<generic>(); 
// generic - Integer, Double, Char
// primitive - int, double, char

// In arraylist, removing elements when looping can cause problem.
// removing element moves up the rest of elements therefore one element might get skipped when iterator ++;
// use i--