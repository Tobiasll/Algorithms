package rudiments;

import com.tobias.rudiment.array.MyArray;
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

  @Test
  public void test2() {
    int n = -5;
    String result = "";
    while (n != 0) {
      result += n % 2;
      n = n >> 1;
    }
    System.out.println(result);
  }


}
