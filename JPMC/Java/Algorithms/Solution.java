import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;

public class Solution {
    // 1 First Unique Character in a string
    public int firstUniqChar(String s) {
        // example 
        // s = "array", output = 4
        int i;
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        for (i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }

    // 2 
    public List<List<String>> groupAnagrams(String[] strs) {
        // example strs = ["eat", "tea", "wat"]
        // output = [["eat", "tea"], ["wat"]]
        if (strs == null || strs.length == 0) return new ArrayList<>();
        char[] temp;
        String t;

        HashMap<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            temp = str.toCharArray();
            Arrays.sort(temp);
            //t = temp.toString();
            t = String.valueOf(temp);
            if (!hm.containsKey(t)) hm.put(t, new ArrayList<>());
            hm.get(t).add(str);
        }
        
        return new ArrayList<>(hm.values());
    }

    // 3
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int left = 0, right = s.length() - 1;       // left = 0, right = 30
        char cLeft, cRight;
        while(left <= right) {
            cLeft = s.charAt(left);
            cRight = s.charAt(right);
            if (!Character.isLetterOrDigit(cLeft)) left++;
            else if (!Character.isLetterOrDigit(cRight)) right--;
            else {
                if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) return false;
                right--;
                left++;
            } 
        }
        return true;
    }

    // 4
    public boolean isValid(String s) {  
        HashMap<Character, Character> container = new HashMap<>();
        Stack<Character> stack = new Stack<Character>();

        container.put('[', ']');
        container.put('{', '}');
        container.put('(', ')');

        for (char c : s.toCharArray()) {
            if (container.containsKey(c)) stack.push(container.get(c));
            else if (stack.isEmpty() || stack.pop() != c) return false;
            
        }
        
        return stack.isEmpty();
    }

    // 5
    public int searchInsert(int[] nums, int target) {
        // must write algorithm with O(logn) time complexity
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    // 6
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int i, j, temp;
        for (i = 0; i < (n + 1) / 2; i++) {
            for (j = 0; j < n / 2; j++) {
                temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    // 7
    public int[] twoSum(int[] nums, int target) {
        // example
        // nums = [2, 7, 11, 15], target = 9
        // output = [0,1]
        /* O(n^2)
        int i, j;
        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) return new int[] {i, j};
            }
        }
        return new int[] {0 , 0};
        */
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {    // 9 - 7 = 2
                result[1] = i;  // 1
                result[0] = map.get(target - nums[i]);  // 9 - 7 = 2, 0
                return result;
            }
            map.put(nums[i], i);    // map = 2, 0
        }
        return result;
    }

    // 8
    public List<List<Integer>> threeSum(int[] nums) {
        // example
        // nums = [-1, 0, 1, 2, -1, -4]
        // result = [[-1, 0, 1], [-1, -1, 2]]   non duplicate & equal zero
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int left, right, total;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            left = i + 1;   // 1
            right = len - 1;    // 5
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            while (left < right) {
                total = nums[i] + nums[left] + nums[right];
                if (total < 0) left++;
                else if (total > 0) right--;
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    // 9
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode on = head;
        int len = 1;
        while (on != null) {
            len++;
            on = on.next;
        }

        int leftIndex = len - n - 1;    // 2 - 1 - 1 = 0
        if (leftIndex == 0) return head.next;

        on = head;
        while (leftIndex > 1) {
            leftIndex--;
            on = on.next;
        }
        on.next = on.next.next;
        return head;
    }

    // 10
    public ListNode reverseList(ListNode head) {
        // example head = 1->2->3
        ListNode on = head; // ListNode on = head;
        ListNode prev = null;   // ListNode prev = null
        ListNode temp;      // ListNode temp;
        while (on != null) {
            temp = on.next;     // temp = on.next
            on.next = prev;     // on.next = prev
            prev = on;          // prev = on
            on = temp;          // on = temp
        }
        return prev;
    }

    // 11
    public boolean hasCycle(ListNode head) {
        // using floyd's algorithm
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // 12
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode item;
        int size;
        queue.add(root);
        if (root == null) return levels;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size > 0) {
                item = queue.remove();
                level.add(item.val);
                if (item.left != null) queue.add(item.left);
                if (item.right != null) queue.add(item.right);
                size--;
            }
            levels.add(level);
            level = new ArrayList<>();
        }  
        return levels;
    } 

    // 13 
    public int maxDepth(TreeNode root) {
        // faster
        if (root == null) return 0;
        // return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right));

        // takes less space
        int height = 0, size;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode item;
        queue.add(root);
        while (!queue.isEmpty()) {
            height++;
            size = queue.size();
            while (size > 0) {
                item = queue.remove();
                if (item.left != null) queue.add(item.left);
                if (item.right != null) queue.add(item.right);
                size--;
            }
        }
        return height;
    }

    // 16
    public int[] sortArray(int[] nums) {
        // Arrays.sort(nums);
        // return nums;

        if (nums.length < 2) return nums;
        int len = nums.length;
        int mid = len / 2;
        int[] L = new int[mid];
        System.arraycopy(nums, 0, L, 0, mid);

        int[] R = new int[len - mid];
        System.arraycopy(nums, mid, R, 0, len - mid);

        L = sortArray(L);
        R = sortArray(R);

        int i = 0, j = 0, k = 0;
        while (i < L.length && j < R.length) {
            if (L[i] < R[j]) nums[k++] = L[i++];
            else nums[k++] = R[j++];
        }

        while (i < L.length) nums[k++] = L[i++];
        while (j < R.length) nums[k++] = R[j++];

        return nums;
    }

    // 19
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int i, j;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (i = 0; i < len1; i++) {
            for (j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) dp[i+1][j+1] = dp[i][j] + 1;
                else dp[i+1][j+1] = Math.max(dp[i + 1][j], dp[i][j + 1]); 
            }
        }
        return dp[len1][len2];
    }
}

// alternative to number 1

/* start ***************** 
HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
        
************************** end */