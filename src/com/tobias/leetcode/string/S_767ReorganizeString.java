package com.tobias.leetcode.string;




import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty string.
 *
 * Example 1:
 *
 * Input: S = "aab"  aaaabcc
 * Output: "aba"    abacaca
 * Example 2:
 *
 * Input: S = "aaab"
 * Output: ""
 * Note:
 *
 * S will consist of lowercase letters and have length in range [1, 500].
 */
public class S_767ReorganizeString {



    public String reorganizeString(String S) {

        return "";
    }

    /**
     * Runtime: 4 ms, faster than 46.96% of Java online submissions for Reorganize String.
     * Memory Usage: 38.8 MB, less than 21.75% of Java online submissions for Reorganize String.
     */
    public String reorganizeStringByList(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }

        if (map.size() < 2) {
            return "";
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> (o2.getValue() - o1.getValue()));
        int i = 0;
        Map.Entry<Character, Integer> first = list.get(i++);
        Map.Entry<Character, Integer> second = list.get(i++);

        StringBuilder result = new StringBuilder();
        while (first.getValue() != 0 && second.getValue() != 0) {

            result.append(first.getKey());
            first.setValue(first.getValue() - 1);
            if (first.getValue() == 0 && list.size() > i) {
                first = list.get(i++);
            }
            result.append(second.getKey());
            second.setValue(second.getValue() - 1);
            if (second.getValue() == 0 && list.size() > i) {
                second = list.get(i++);
            }
        }

        Map.Entry<Character, Integer> finalEntry = first.getValue() <= 2 && second.getValue() == 0 ? first : (first.getValue() == 0 && second.getValue() <= 2 ? second : null);

        if (finalEntry != null) {
            int index = 0;
            Character key = finalEntry.getKey();
            for (int j = 0; j < result.length(); j++) {
                if (finalEntry.getValue() == 0) {
                    return result.toString();
                }
                char c = result.charAt(index);
                if (c != key) {
                    if (index == 0) {
                        result.insert(0, key);
                        finalEntry.setValue(finalEntry.getValue() - 1);
                        index = 1;
                    } else if (result.charAt(index - 1) != key){
                        result.insert(index, key);
                        finalEntry.setValue(finalEntry.getValue() - 1);
                        index++;
                    }
                }
                index++;
            }
            if (finalEntry.getValue() == 1) {
                result.append(key);
                return result.toString();
            }
            return finalEntry.getValue() == 0 ? result.toString() : "";
        } else {
            return "";
        }

    }

    public static void main(String[] args) {
        S_767ReorganizeString reorganizeString = new S_767ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao"));
        System.out.println(reorganizeString.reorganizeString("abbabbaaab"));
        System.out.println(reorganizeString.reorganizeString("vvvlo"));
        System.out.println(reorganizeString.reorganizeString("sfffp"));
        System.out.println(reorganizeString.reorganizeString("aaaabcc"));
        System.out.println(reorganizeString.reorganizeString("aaaaabcc"));
        System.out.println(reorganizeString.reorganizeString("aba"));
        System.out.println(reorganizeString.reorganizeString("aaab"));
    }
}
