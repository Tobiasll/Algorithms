package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Given an array of string words. Return all strings in words which is substring of another word in any order.
 *
 * String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
 *
 * Example 1:
 *
 * Input: words = ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
 * ["hero","as"] is also a valid answer.
 * Example 2:
 *
 * Input: words = ["leetcode","et","code"]
 * Output: ["et","code"]
 * Explanation: "et", "code" are substring of "leetcode".
 * Example 3:
 *
 * Input: words = ["blue","green","bu"]
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] contains only lowercase English letters.
 * It's guaranteed that words[i] will be unique.
 */
public class S_1408StringMatchingInArray {

    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (!result.contains(word)) {
                for (String s : words) {
                    if (s.length() > word.length() && s.contains(word) && !result.contains(word)) {
                        result.add(word);
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        Test test = new Test();
        for (int i = 0; i < 5; i++) {
             final int finalI = i;
            synchronized (test) {
            }
            Future<?> submit = executorService.submit(() -> test.test(finalI));
            submit.get();

        }
    }

    static class Test {

        public  int count =0;
        public void test(final int target) {
           int cur = 0;
            for (; cur < 10; cur++) {
                count++;
                if (0 == count % 2) {
                    synchronized (this) {
                        System.out.println(target + ":" + count + ":" + cur);
                    }
                }
            }
        }
    }
}
