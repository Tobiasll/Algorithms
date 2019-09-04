package rudiments;

import com.tobias.rudiment.array.MyArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import org.junit.Test;

public class ArrayTest {

  @Test
  public void test1() {
    MyArray<Integer> array = new MyArray<>();

    System.out.println(array.getCapacityLength());
    System.out.println(array.isEmpty());
    System.out.println(array);
    array.addLast(1);
    array.addLast(3);
    array.addLast(4);
    array.addFirst(2);
    array.insert(3, 88);

    System.out.println(array.removeIndex(3));
    System.out.println(array.removeFirst());
    System.out.println(array.removeLast());
    System.out.println(array.set(1, 22));
    array.removeElement(1);
    System.out.println(array);
    System.out.println(array.getSize());
    System.out.println(array.get(0));


  }

  class LRUCache extends LinkedHashMap {

    @Override
    protected boolean removeEldestEntry(Entry eldest) {
      return size() > 4;
    }

    public LRUCache() {
      super(16, 0.75f, true);
    }
  }

  @Test
  public void test2() {
    LRUCache cache = new LRUCache();

    cache.put("a", 1);
    cache.put("b", 2);
    cache.put("c", 3);
    cache.get("a");
    System.out.println(cache);
    cache.put("d", 4);
    cache.put("e", 5);

    System.out.println(cache);

  }


  @Test
  public void test3() {

    String str = "逻辑卷管理器LVM可以将几块独立的硬盘组成一个“卷组”。https://hqjy-coursetest.oss-cn-shenzhen.aliyuncs.com/knowledge_base"
        + "/ppt/template/20190319/fa6adc75c6294c3dbff795138b09e8d8.pptx一个“卷组”又可以被分成几个“逻辑卷”。"
        + "这些逻辑卷在外界看起来就是一个个独立的硬盘分区。这种做法的好处在于，https://hqjy-coursetest.oss-cn-shenzhen.aliyuncs.com/knowledge"
        + "_base/ppt/template/20190319/fa6adc75c6294c3dbff795138b09e8d8.pptx"
        + "如果管理员某天意识到当初给某个分区划分的空间太小了，那么可以再往卷组里增加一块硬盘，"
        + "接着把这些富余的空间交给这个逻辑卷，这样就把“分区”扩大了。或者也可以动态地从另一个逻辑卷中“搜刮”一些存储空间，前提是这两个逻辑卷位于同一个卷组中。";

    List<String> list = new ArrayList<>(Arrays.asList(".pptx", ".doc"));
    List<String> result = new ArrayList<>();
    result.add("");
    while (str.contains("https://") || str.contains("http://")) {
      int prefix = str.contains("https://") ? str.indexOf("https://") :  str.indexOf("http://");
      for (String s : list) {
        if (str.contains(s)) {
          int suffix = str.indexOf(s);
          result.add(str.substring(prefix, suffix + s.length()));
          result.set(0, result.get(0) + str.substring(0, prefix) + " 【下载】");
          str = str.substring(suffix + s.length());
          break;
        }
      }
    }

    for (String s : result) {
      System.out.println(s);
    }

  }

  @Test
  public void test11() {
    System.out.println(1 << 5);
  }


}
