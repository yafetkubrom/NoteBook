//import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] alphabets = new int[26];
        for (char c : word1.toCharArray()) {
            alphabets[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            if (--alphabets[c - 'a'] < 0) return false;
        }

        return true;
    }

    static boolean isAnagramWithNumber(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        // ask if we considering or ignoring the number

        
        // consider numbers
        /*
        int[] alphanumeric = new int[36];
        for (char ch : word1.toCharArray()) {
            if (Character.isLetter(ch)) alphanumeric[ch - 'a' + 10]++;
            else alphanumeric[Character.getNumericValue(ch)]++;
        }

        for (char ch : word2.toCharArray()) {
            if (Character.isLetter(ch) && --alphanumeric[ch - 'a' + 10] < 0) return false;
            else if (Character.isDigit(ch) && --alphanumeric[Character.getNumericValue(ch)] < 0) return false;
        }
        */

        // if not considered
        int[] alphabets = new int[26];
        for (char ch : word1.toCharArray()) {
            if (Character.isLetter(ch)) alphabets[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            if (Character.isLetter(ch) && --alphabets[ch - 'a'] < 0) return false;  
        }
        
        return true;
    }

    static boolean isAnagramWithUpperCase(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        // if uppercase is considered
        /*
        int[] alphabets = new int[58];
        for (char ch : word1.toCharArray()) {
            alphabets[ch - 'A']++;
        }

        for (char ch : word2.toCharArray()) {
            if (--alphabets[ch - 'A'] < 0) return false;
        }
        // a 97 - A 65 = 32
        */

        // if uppercase is not considered
        int[] alphabets = new int[26];
        for (char ch : word1.toLowerCase().toCharArray()) {
            alphabets[ch - 'a']++;
        }

        for (char ch : word2.toLowerCase().toCharArray()) {
            if (--alphabets[ch - 'a'] < 0) return false;
        }
        return true;
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        char[] temp;
        String s;
        for (String str : strs) {
            temp = str.toCharArray();
            Arrays.sort(temp);
            s = String.valueOf(temp);
            if (!map.containsKey(s)) map.put(s, new ArrayList<>());
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }

    static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        } 
        return true;
    }
    public static void main(String[] args) {
        
        /*Scanner input = new Scanner(System.in);
        System.out.print("Enter first word : ");
        String word1 = input.next();
        System.out.print("Enter second word : ");
        String word2 = input.next();*/

        /*String[] strs = {"eat", "tea", "ate", "word", "ordw", "yafet"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);*/

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String str = input.next();

        System.out.println("Palindrome? : " + isPalindrome(str));

        /*System.out.println("\nChoose one\n1. isAnagram\n2. isAnagramWithNumber\n3. isAnagramWithUpperCase....");
        int reply = input.nextInt();

        switch (reply) {
            case 1:
                System.out.println("result : " + isAnagram(word1, word2));
                break;
            case 2:
                System.out.println("result : " + isAnagramWithNumber(word1, word2));
                break;
            case 3:
                System.out.println("result : " + isAnagramWithUpperCase(word1, word2));
                break;
            default:
                break;
        }
*/
    }
}

/* original
int len = word1.length();
        if (len != word2.length()) return false;
        int i;
        int t;
        //char arr1[] = word1.toCharArray();
        //char arr2[] = word2.toCharArray();
        Hashtable<Character, Integer> ht = new Hashtable<>();
        for (i = 0; i < len; i++) {
            // word1
            if (ht.containsKey(word1.charAt(i))) {
                t = ht.get(word1.charAt(i));
                ht.put(word1.charAt(i), ++t);
            } else {
                ht.put(word1.charAt(i), 1);
            }

            // word2
            if (ht.containsKey(word2.charAt(i))) {
                t = ht.get(word2.charAt(i));
                ht.put(word2.charAt(i), --t);
            } else {
                ht.put(word2.charAt(i), -1);
            }
        }

        for (i = 0; i < word1.length(); i++) {
            if (ht.get(word1.charAt(i)) != 0) {
                return false;
            }
        }
        
        return true;
        */


        /*

        group of anagrams
        return list of lists
        
        index (DB)
        ACID (DB)

        multithreading

        microservice - main function
            - load balance
            - circuit service
            - scalibility 
            - security
            - usability
            - add to your dependency 

        static pages post where?


        behaivor
        1. multiple tasks. how would you prioritize.
            - S - creating REST API. 
            - T - had to sync backend with db
            - A - on a meeting, we prioritize on how long it takes, and dependent on 
            - R - able to finish within sprint
        2. performance improvement in your application on your own
            - S - on RestAPI, wrote a code to query from DB 
            - T - fastest and easiest
            - A - i know of ORM called Dapper that was faster so i implemented it. 
            - R - added more dependency but when ran successfully, it was faster.
        3. about a time where your contribution made a huge impact.
            - S - when decideing to use C# when developing our REST API
            - T - researched fastest but helpful way to learn
            - A - i collected it and added notes
            - R - used by new comers
        4. tell me about a time where you suggested out-of-the-box solution.
            - S - 
            - T - 
            - A - 
            - R - 
        5. technologies based on your field.
            - S
            - T
            - A
            - R
        6. how would you go look for feedback from supervisor and how would you act in positive and negative
            - S - 
            - T - 
            - A - positive - how fast i learned
                - negative - missing deadline
            - R - P - I felt good and wanted to notice others's accomplishments
                - N - time for introspective
        7. what you learned in the last month
            - S - learned more about microservices in .net
            - T
            - A
            - R
        8. someone who had a big impact on your career.
            - S - I am a programmer because of David Malan (May-len)
            - T - thought me the basics and made me fall in love with programming.
            - A - he was knowledged but made it intersting. he was passioned. 
            - R

        S(ituation)
        T(ask)
        A(ction)
        R(esult)

        ask about the company. how they like it. ask about your role.

        */

        // star acrynmous for technical 

        /*
        if (word1.length() != word2.length()) return false;

        int[] freq = new int[26];
        for (char c : word1.toCharArray()) {
            ++freq[c - 'a'];
        }

        for (char c : word2.toCharArray()) {
            if (--freq[c - 'a'] < 0) return false;
        }
        return true;

        */

        // first Unique Character
// input : String s
// output : int
// return index of first unique character


// State Farm Interview
// Explain why your background and experience would be a good fit for this job.
// What do you currently do for work?
// Describe a time when you had to take in new information quickly.
// Where do you see yourself in 5 years?
// They asked me a bunch of OOP questions, specifically in Design patterns.
// Asked me about tech stack background, and my experiences using different programming languages
// AWS
// What are some good coding practices?

// Code problem asking me to reformat an input file to match to something more like a JSON.
// Given a string return the index of the first unique character.
//


/*Map<String, List<String>> map = new HashMap<>();
        char[] temp;
        String t;

        for (String str : strs) {
            temp = str.toCharArray();
            Arrays.sort(temp);
            t = String.valueOf(temp);

            map.computeIfAbsent(t, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());*/