package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {


  public static List<List<Integer>> kSumTrim(int[] a, int target, int k) {
    List<List<Integer>> result = new ArrayList<>();
    // 传入数组长度小于k值时直接放回
    if (a == null || a.length < k || k < 2) {
      return result;
    }
    Arrays.sort(a);
    // 传入当前数组， 目标，k个数， 开始索引为第一个0， 最后的结合集合，路径集合
    kSumTrim(a, target, k, 0, result, new ArrayList<>());
    return result;
  }

  private static void kSumTrim(int[] a, int target, int k, int start, List<List<Integer>> result,
      List<Integer> path) {
    // 因为数组已经被排序过了，所以直接获取该数组的最后一位作为最大值
    int max = a[a.length - 1];
    // 递归结束条件，数组开始最小值的k个值比目标值还大，数组结束最大值的k个值比目标值还小，不符合条件，无须遍历，直接返回
    // 例如a={-4, -1, 1, 1, 2} target = 2, k = 2, -4 * 2 = -8 < 2/ 2 * 2 = 4 > 2;
    if (a[start] * k > target || max * k < target) {
      return;
    }

    // 将情况分成两种，一种是计算将两个数相加等于目标值的情况，直接遍历整个数组将左边值和右边值相加看是否等于目标值，
    // 另一种是k大于2的需要多个数相加最后等于目标值的情况，需要递归遍历，使用回溯算法，递归缩小范围
    if (k == 2) {                        // 2 Sum
      // 将开始下标设为0
      int left = start;
      int right = a.length - 1;
      // 左游标递增，右游标递减，所以条件是左游标小于右游标
      while (left < right) {
        // 相加结果小于目标，说明左游标值太小，需要移动左游标拿到比当前值更大的左值
        if (a[left] + a[right] < target) {
          left++;
        }
        // 和上去情况相反，结果大于目标，右值过大，需要递减右游标拿到更小的右值
        else if (a[left] + a[right] > target) {
          right--;
        }
        // 两数相加后符合目标要求
        else {

          result.add(new ArrayList<>(path));
          result.get(result.size() - 1).addAll(Arrays.asList(a[left], a[right]));
          left++;
          right--;
          // 避免前面的左值和当前左值重复添加进结果集合
          while (left < right && a[left] == a[left - 1]) {
            left++;
          }
          // 避免后面的右值和当前右值重复添加进结果集合
          while (left < right && a[right] == a[right + 1]) {
            right--;
          }
        }
      }
    } else {                        // k Sum
      for (int i = start; i < a.length - k + 1; i++) {
        // 当前值与前一个值相同，可以直接让左游标递增
        if (i > start && a[i] == a[i - 1]) {
          continue;
        }
        // 当前值加上k个最大值后仍小于目标值，需要拿到更大的左值，直接continue
        if (a[i] + max * (k - 1) < target) {
          continue;
        }
        // k个当前值大于目标，因为当前值后面的值均大于等于当前值，所以完全没必要往后遍历，直接跳出循环，结束递归
        if (a[i] * k > target) {
          break;
        }
        // k个当前值等于目标值
        if (a[i] * k == target) {
          // 当前下标的值是否与下标后的值相等，如果相等，则可以直接把这几个值全部加进集合中，然后直接结束循环和递归
          if (a[i + k - 1] == a[i]) {
            // 调价一个新的集合到结果集合中
            result.add(new ArrayList<>(path));
            // 创建一个临时集合来存放后面的k个值
            List<Integer> temp = new ArrayList<>();
            for (int x = 0; x < k; x++) {
              temp.add(a[i]);
            }
            result.get(result.size() - 1).addAll(temp);    // Add result immediately.
          }
          break;
        }
        // 不符合以上要求，将值添加进路径结合中
        path.add(a[i]);
        // 当前数组， 缩小target的值， 减少一个k， 开始位置为当前位置加一， 结果集合， 路径集合
        kSumTrim(a, target - a[i], k - 1, i + 1, result, path);
        path.remove(path.size() - 1);        // Backtracking
      }
    }
  }
}
