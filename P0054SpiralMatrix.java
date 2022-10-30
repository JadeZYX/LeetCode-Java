import java.util.ArrayList;
import java.util.List;

public class P0054SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<Integer>();
    if (matrix.length == 0 || matrix[0].length == 0)
      return res;
    int rowStart = 0, rowEnd = matrix.length - 1;
    int colStart = 0, colEnd = matrix[0].length - 1;
    while (rowStart <= rowEnd && colStart <= colEnd) {
      //traverse right
      for (int i = colStart; i <= colEnd; i++) {
        res.add(matrix[rowStart][i]);
      }
      rowStart++;
      //traverse down
      for (int j = rowStart; j <= rowEnd; j++) {
        res.add(matrix[j][colEnd]);
      }
      colEnd--;
      if(rowStart<=rowEnd){
        //traverse left
        for (int k = colEnd; k >= colStart; k--) {
          res.add(matrix[rowEnd][k]);
        }
      }
      rowEnd--;

      if(colStart<=colEnd){
        //traverse up
        for (int n = rowEnd; n >= rowStart; n--) {
          res.add(matrix[n][colStart]);
        }
      }
      colStart++;
    }
    return res;
  }
}
/*
        P0054SpiralMatrix P54 = new P0054SpiralMatrix();
        System.out.println(P54.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
 */