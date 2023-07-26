import java.util.Arrays;

public class All {
  public static int sum = 0;

  public static void solution(int[] arr, int index) {
    if (index == arr.length) {
      sum++;
      System.out.println(Arrays.toString(arr));
      return;
    }
    for (int i = index; i < arr.length; i++) {
      System.out.format("index %s, i: %s, needSwap %s, arr:%s\n", index, i, needSwap(arr, index, i), Arrays.toString(arr));
      if (!needSwap(arr, index, i)) {
        continue;
      }
      swap(arr, index, i);
      solution(arr, index + 1);
      swap(arr, index, i);
    }
  }

  public static boolean needSwap(int arr[], int from, int to) {
    if (from == to) {
      return true;
    }
    if (arr[from] == arr[to]) {
      return false;
    }
    for (int i = to; i < arr.length -1 ; i++) {
      if (arr[to] == arr[to + 1]) {
       return false;
      }

    }
    return true;
  }


  public static void swap(int[] arr, int from, int to) {
    int temp = arr[from];
    arr[from] = arr[to];
    arr[to] = temp;
  }

  public static void main(String[] args) {
    solution(new int[]{1, 2, 2}, 0);
    System.out.println(sum);
  }
}
