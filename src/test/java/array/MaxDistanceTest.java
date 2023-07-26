package array;


import array.MaxDistance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistanceTest {

  @Test
  public void maxDistance() {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    list.add(Arrays.asList(1, 4));
    list.add(Arrays.asList(0, 5));
    Assertions.assertEquals(4, MaxDistance.maxDistance(list));

    list.clear();
    list.add(Arrays.asList(1, 2, 3));
    list.add(Arrays.asList(4, 5));
    list.add(Arrays.asList(1, 2, 3));
    Assertions.assertEquals(4, MaxDistance.maxDistance(list));


  }

  @Test
  public void maxDistanceMem() {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    list.add(Arrays.asList(1, 4));
    list.add(Arrays.asList(0, 5));
    Assertions.assertEquals(4, MaxDistance.maxDistanceMem(list));

    list.clear();
    list.add(Arrays.asList(1, 2, 3));
    list.add(Arrays.asList(4, 5));
    list.add(Arrays.asList(1, 2, 3));
    Assertions.assertEquals(4, MaxDistance.maxDistanceMem(list));
  }
}