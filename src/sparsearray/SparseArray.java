package sparsearray;

/**
 *当一个数组存在大量的0，只存储了少量的数据时。我们为了节省空间，只需要将数据的位置和值存储下来即可
 * 例如，原数组如下：
 * 1   0   0   0
 * 0   1   0   0
 * 可转成稀疏数组：
 * 2   4   2
 * 0   0   1
 * 1   1   1
 * 下面的代码实现了两种数组的互相转换
 */
public class SparseArray {
    public int[][] ArrayToSpareArray(int[][] Array){
        int count = 0;
        for (int i = 0; i < Array.length; i++)
            for (int j = 0; j < Array.length; j++)
                if (Array[i][j] != 0)
                    count++;
        int[][] SpareArray = new int[count + 1][3];
        SpareArray[0][0] = Array.length;
        SpareArray[0][1] = Array[0].length;
        SpareArray[0][2] = count;
        count = 1;
        for (int i = 0; i < Array.length; i++)
            for (int j = 0; j < Array.length; j++)
                if (Array[i][j] != 0){
                    SpareArray[count][0] = i;
                    SpareArray[count][1] = j;
                    SpareArray[count][2] = Array[i][j];
                    count++;
                }
        return SpareArray;
    }
    public int[][] SparseArrayToArray(int[][] SparseArray){
        int[][] Array = new int[SparseArray[0][0]][SparseArray[0][1]];
        for (int i = 1; i <= SparseArray[0][2]; i++){
            Array[SparseArray[i][0]][SparseArray[i][1]] = SparseArray[i][2];
        }
        return Array;
    }
    public void print(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }
    }
}