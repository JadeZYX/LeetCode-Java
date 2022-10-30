import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
  private List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> get(int n) {
    Integer[] arr = new Integer[n];
    for (int i = 1; i <= n; ++i) {
      arr[i-1] = Integer.valueOf(i);
    }
    getPermutation(arr, 0, n);
    return result;
  }

  private void getPermutation(Integer[] arr, int from, int to) {
    if (from == to-1) {
      result.add(new ArrayList<Integer>(Arrays.asList(arr)));
      return;
    }

    for (int i = from; i < to; ++i) {
      swap(arr, from, i);
      getPermutation(arr, from+1, to);
      swap(arr, from, i);
    }
  }

  private static void swap(Integer[] arr, int i, int j) {
    Integer temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
/*
      Permutation p = new Permutation();
        List<List<Integer>> result = p.get(3);
        for (int i = 0; i < result.size(); ++i) {
            for (int j = 0; j < result.get(i).size(); ++j) {
                System.out.print(result.get(i).get(j) + " ");
            }

            System.out.println();
        }
 */