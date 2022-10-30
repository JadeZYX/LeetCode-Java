public class P0048RotateImage {

  public void rotate0(int[][]matrix){
    int len = matrix.length;
    //左侧对角线交换
    for(int i = 0;i<len;i++){
      // 只要便利下三角
      for(int j = i; j<matrix[0].length;j++){
        int temp = matrix[i][j];
        //因为是N*N矩阵，所以ij和ji是可以对调的，不存在溢出
        matrix[i][j] = matrix[j][i];
        matrix[j][i]=temp;
      }
    }
    //同行对称交换 左右翻转 处理列
    for(int i = 0; i<len;i++){
      for(int j =0;j<=len/2-1;j++){
        int temp = matrix[i][j];
        matrix[i][j]=matrix[i][len-1-j];
        matrix[i][len-1-j] = temp;
      }
    }
  }

  public void rotate1 (int[][]matrix){ //需要掌握 O（M）
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
    int len = matrix.length;
    for(int i = 0;i<len/2;i++){//行！限制圈数，外圈到内圈，每一圈开始在第几行，每一圈都是从对角线上的点为起点
      for(int j = i;j<len-1-i;j++){//列！限制每一圈旋转时候的列数，列数起始位置就是上层的i
        int temp = matrix[i][j];//每次旋转某圈的起点坐标
        matrix[i][j] = matrix[len-1-j][i];//先 diagonal then vertical
        matrix[len-1-j][i]=matrix[len-1-i][len-1-j];//horizontal then vertical
        matrix[len-1-i][len-1-j]=matrix[j][len-1-i];//horizontal then diagonal
        matrix[j][len-1-i]=temp;
      }
    }
  }
}


/*
 这道题目是要求in-place修改，不能创建新的matrix。所以不能return。如果没有这个条件，他们隐藏的关系式其实是
 matrix[i][j] = matrix[j][len-1-i].
 第一行变成了第三列，第二行transpose到第二列，第三行对应第一列
 第一列变成第一行，第二列变成第二行，第三列是第三行

 90度rotate可以分成两个部分，第一是对角线交换，即
 matrix[i][j] = matrix[j][i],这种情况下第一个和最后一个是不改变的。第二部分就是同一行对称交换 symmetrically flip it。
 */