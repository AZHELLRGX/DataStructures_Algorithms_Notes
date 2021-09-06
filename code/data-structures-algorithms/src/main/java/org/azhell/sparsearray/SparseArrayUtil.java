package org.azhell.sparsearray;

/**
 * 普通数组与稀疏数组互相转换
 */
public class SparseArrayUtil {
    private SparseArrayUtil() {
        // do nothing
    }

    /**
     * 普通二维数组转为稀疏数组
     *
     * @param normalArray 普通数组
     * @return 稀疏数组
     */
    public static int[][] convertToSparseArray(int[][] normalArray) {
        // 稀疏数组的第一行是行、列、有效数据个数
        int rowCount = normalArray.length;
        int columnCount = normalArray[0].length;

        // 统计有效元素个数
        int validValuesCount = 0;
        for (int[] ints : normalArray) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    validValuesCount++;
                }
            }
        }

        int[][] sparseArray = new int[validValuesCount + 1][3];
        sparseArray[0][0] = rowCount;
        sparseArray[0][1] = columnCount;
        sparseArray[0][2] = validValuesCount;

        // 下面每行记录有效元素的行、列、值
        int index = 1;
        for (int i = 0; i < normalArray.length; i++) {
            for (int j = 0; j < normalArray[i].length; j++) {
                if (normalArray[i][j] != 0) {
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = normalArray[i][j];
                    index++;
                }
            }
        }
        return sparseArray;
    }

    /**
     * 稀疏数据展开为普通数组
     *
     * @param sparseArray 稀疏数组
     * @return 普通数组
     */
    public static int[][] unfoldToNormalArray(int[][] sparseArray) {
        // 通过稀疏数组的第一行创建普通数组
        int[][] normalArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            normalArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return normalArray;
    }
}
