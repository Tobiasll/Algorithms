package rudiments;

import com.tobias.rudiment.array.MyArray;
import java.util.LinkedHashMap;
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

  class LRUCache<K, V> extends LinkedHashMap {

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
    LRUCache<String, Integer> cache = new LRUCache<>();

    cache.put("a", 1);
    cache.put("b", 2);
    cache.put("c", 3);
    cache.get("a");
    System.out.println(cache);
    cache.put("d", 4);
    cache.put("e", 5);

    System.out.println(cache);

  }


}
