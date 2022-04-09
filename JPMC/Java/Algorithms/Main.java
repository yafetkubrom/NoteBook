//import java.util.Arrays;
//import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner input = new Scanner(System.in);

        // 1 First Unique Character in a string
        /*
        String s = "array";
        System.out.println(solution.firstUniqChar(s));
        */

        // 2 Group Anagrams
        /*
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> output = solution.groupAnagrams(input);
        for (List<String> strs : output) {
            for (String str : strs) {
                System.out.print(str + " ");
            }
            System.out.println("");
        }
        */

        // 3 Valid Palindrome
        /*
        String s = "A man, a plan, a canal: Panama";
        //String s = "0P";
        System.out.println(solution.isPalindrome(s));
        */

        // 4 Valid Parentheses
        /*
        System.out.print("Valid Parentheses\nEnter String : ");
        String s = input.next();
        System.out.println(solution.isValid(s));
        */

        // 5 Search Insert Position
        /*
        int[] nums = {1, 3, 5, 6};
        System.out.printf("Search Insert Position\nnums : %s\nEnter target : ", Arrays.toString(nums));
        int target = input.nextInt();
        System.out.println("result : " + solution.searchInsert(nums, target));
        */

        // 6 Rotate Image
        /*
        1 2 3       7 4 1
        4 5 6   ->  8 5 2
        7 8 9       9 6 3
        */
        /*
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] arr : matrix){
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution.rotate(matrix);
        for (int[] arr : matrix){
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        */

        // 7 Two Sums
        /*
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] output = solution.twoSum(nums, target);
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
        */

        // 8 Three Sums
        /*
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        for (List<Integer> temp : result) {
            for (int t : temp) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
        */

        // 9 Remove Nth Node From End Of List
        /*
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        //ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        
        ListNode on = head;
        while (on != null) {
            System.out.print(on.val);
            on = on.next;
        }
        System.out.println();

        head = solution.removeNthFromEnd(head, 2);

        on = head;
        while (on != null) {
            System.out.print(on.val);
            on = on.next;
        }
        System.out.println();
        */

        // 10 Reverse Linked List
        /*
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode on = head;
        while (on != null) {
            System.out.print(on.val);
            on = on.next;
        }
        System.out.println();

        head = solution.reverseList(head);

        on = head;
        while (on != null) {
            System.out.print(on.val);
            on = on.next;
        }
        System.out.println();
        */

        // 12 Binary Tree Level Order Traversal
        
        /*
            3
           / \
          9  20
             / \
            15  7
        */
        /*
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
        */

        // 13 Max Depth of Binary Tree

        /*
            3
           / \
          9  20
             / \
            15  7
        */
        /*
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Max Depth : " + solution.maxDepth(root));
        */

        // 16 Sort An Array
        /*
        int[] nums = {5, 2, 3, 1};
        System.out.print("Before Sorted ");
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();

        nums = solution.sortArray(nums);
        System.out.print("After Sorted ");
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        */

        // 19 Longest Common Subsequence
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("LCS : " + solution.longestCommonSubsequence(text1, text2));
    }
}
