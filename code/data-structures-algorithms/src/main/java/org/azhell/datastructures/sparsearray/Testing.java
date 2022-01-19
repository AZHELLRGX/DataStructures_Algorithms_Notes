package org.azhell.datastructures.sparsearray;

public class Testing {
    public static void main(String[] args) {
        // 创建一个普通数组
        int[][] normalArray = createNormalArray();
        // 打印看看
        printArray(normalArray);
        // 转换为稀疏数组
        int[][] sparseArray = SparseArrayUtil.convertToSparseArray(normalArray);
        printArray(sparseArray);

        // 稀疏数组展开为普通数组
        normalArray = SparseArrayUtil.unfoldToNormalArray(sparseArray);
        printArray(normalArray);
    }

    public static void printArray(int[][] array) {
        for (int[] ints : array) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + "\t");
                if (j == ints.length - 1) {
                    System.out.println();
                }
            }
        }
        System.out.println("+++++++++++++++++++");
    }

    public static int[][] createNormalArray() {
        int[][] normalArray = new int[6][7];
        normalArray[0][3] = 22;
        normalArray[0][6] = 15;
        normalArray[1][1] = 11;
        normalArray[1][5] = 17;
        normalArray[2][3] = -6;
        normalArray[3][5] = 39;
        normalArray[4][0] = 91;
        normalArray[5][2] = 28;
        return normalArray;
    }
}
