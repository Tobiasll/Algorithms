package com.tobias.leetcode.array;


import java.util.*;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class S_692TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(map.size() + 2, (o1, o2) -> {
            Integer count1 = map.get(o1);
            Integer count2 = map.get(o2);
            if (!count1.equals(count2)) {
                return count2 - count1;
            }
            return o1.compareTo(o2);
        });
        for (String word: map.keySet()) {
            priorityQueue.offer(word);
        }
        List<String> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(priorityQueue.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        S_692TopKFrequentWords topKFrequentWords = new S_692TopKFrequentWords();
        System.out.println(topKFrequentWords.topKFrequent(new String[]{"rmrypv","zgsedk","jlmetsplg","wnfbo","hnnftqf","bxlr","sviavwoxss","jdbgvc","zddeno","rxgw","hnnftqf","hdmvplne","rlmdt","jlmetsplg","ous","rmrypv","fwxulnpit","dmhuq","rxgw","ledleb","bxlr","indbvb","ckqqibnx","cub","ijww","ehd","hfhlfqzkcn","sviavwoxss","rxgw","bxjxpfp","mgqj","oic","ptk","fwxulnpit","ijww","sviavwoxss","bgfvfa","zfkgsudxq","alkq","dmhuq","zddeno","rxgw","zgsedk","amarxpg","bgfvfa","wnfbo","sviavwoxss","sviavwoxss","alkq","nmclxk","zgsedk","bwowfvira","ous","bxlr","zddeno","rxgw","ous","wnfbo","rmrypv","sviavwoxss","ehd","zgsedk","jlmetsplg","abxvhyehv","ledleb","wnfbo","bgfvfa","bwowfvira","amarxpg","wnfbo","bwowfvira","dmhuq","ouy","bxlr","rxgw","oic","hnnftqf","ledleb","rlmdt","oldainprua","ous","ckqqibnx","dmhuq","hnnftqf","oic","jlmetsplg","ppn","amarxpg","jlgfgwb","bxlr","bwowfvira","hdmvplne","oic","ledleb","bwowfvira","oic","ptk","dmhuq","abxvhyehv","ckqqibnx","indbvb","ypzfk","rmrypv","bxjxpfp","amarxpg","dmhuq","sviavwoxss","bwowfvira","zfkgsudxq","wnfbo","rxgw","jxkvrmajri","cub","abxvhyehv","bwowfvira","indbvb","ehd","ckqqibnx","oic","ptk","hnnftqf","ouy","oic","zgsedk","abxvhyehv","ypzfk","ptk","sviavwoxss","rmrypv","oic","ous","abxvhyehv","hnnftqf","hfhlfqzkcn","ledleb","cub","ppn","zddeno","indbvb","oic","jlmetsplg","ouy","bwowfvira","bklij","gucayxp","zfkgsudxq","hfhlfqzkcn","zddeno","ledleb","zfkgsudxq","hnnftqf","bgfvfa","jlmetsplg","indbvb","ehd","wnfbo","hnnftqf","rlmdt","bxlr","indbvb","jdbgvc","jlmetsplg","cub","jlgfgwb","ypzfk","indbvb","dmhuq","jlmetsplg","zgsedk","rmrypv","cub","rxgw","ledleb","rxgw","sviavwoxss","ckqqibnx","hdmvplne","dmhuq","wnfbo","jlmetsplg","bxlr","zfkgsudxq","bxjxpfp","ledleb","indbvb","ckqqibnx","ous","ckqqibnx","cub","ous","abxvhyehv","bxlr","hfhlfqzkcn","hfhlfqzkcn","oic","ten","amarxpg","indbvb","cub","alkq","alkq","sviavwoxss","indbvb","bwowfvira","ledleb"}, 41));
        System.out.println(topKFrequentWords.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(topKFrequentWords.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
        System.out.println(topKFrequentWords.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3));
        System.out.println(topKFrequentWords.topKFrequent(new String[]{"a","aa","aaa"}, 1));
    }
}
