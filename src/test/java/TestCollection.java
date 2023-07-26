import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestCollection {
  @Test
  public void  testLinkedHashMap() {
    int size = 5;
    LinkedHashMap<Integer, Integer>  map = new LinkedHashMap<Integer, Integer>(5, 0.75f, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e) {
        return size() > size;
      }
    };
    for (int i = 0; i < size; i++) {
     map.put(i, i) ;
    }
    System.out.println(map);
    map.get(3);
    System.out.println(map);
    map.get(1);
    System.out.println(map);
    map.put(5, 5);
    System.out.println(map);
  }

}
