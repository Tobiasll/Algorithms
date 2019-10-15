package com.tobias.leetcode.string;


import java.util.LinkedList;
import java.util.List;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 *
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
 *
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 *
 *
 *
 * Example 1:
 *
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 *
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 *
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * Example 4:
 *
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * Example 5:
 *
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * Example 6:
 *
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 */
public class SimplifyPath71 {

  public String simplifyPath(String path) {
    StringBuilder result = new StringBuilder("/");
    String[] pathContent = path.split("/");
    // 使用ArrayList和LinkedList 两个内存使用相差不大,在1M内相互上下浮动
//    List<String> resultList = new ArrayList<>();
    List<String> resultList = new LinkedList<>();
    for (String s : pathContent) {
      if (!"".equals(s) && !".".equals(s) && !"..".equals(s)) {
        resultList.add(s);
      } else if ("..".equals(s)) {
        if (resultList.size() > 0) {
          resultList.remove(resultList.size() - 1);
        }
      }
    }
    for (String s : resultList) {
      result.append(s).append("/");
    }
    if (resultList.size() == 0) {
      result.append("/");
    }
    return result.substring(0, result.length() - 1);
  }

  public static void main(String[] args) {
    SimplifyPath71 simplifyPath71 = new SimplifyPath71();
    System.out.println(simplifyPath71.simplifyPath("/home/"));
    System.out.println(simplifyPath71.simplifyPath("/home//foo/"));
    System.out.println(simplifyPath71.simplifyPath("/a/./b/../../c/"));
    System.out.println(simplifyPath71.simplifyPath("/../"));
    System.out.println(simplifyPath71.simplifyPath("/a/../../b/../c//.//"));
  }

}
