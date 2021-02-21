package com.csu.sparsearray;
/*
实现稀疏数组
 */
public class SparseArray01 {
    public static void main(String[] args) {
        //实现一个原始的11*11的二维数组
        int chessArr1[][] = new int [11][11];
        chessArr1[1][2] = 1;    //第2行第3列有一个值1
        chessArr1[2][4] = 2;    //第3行第5列有一个值2

        //输出原始的二维数组
        for (int[] row : chessArr1){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        //将二维数组转成稀疏数组
        //思路：先遍历二维数组，得到非0个数
        int sum = 0;
        for (int i = 0;i < chessArr1.length;i ++){
            for (int j = 0;j < chessArr1.length;j ++){
                if (chessArr1[i][j] != 0){
                    sum ++;
                }
            }
        }
        System.out.println("sum=" + sum);
        //创建对应的稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        //这是第一行的数据
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //遍历二维数组，将非0的值存放到稀疏数组中去
        int count = 0;     //count用于记录是第几个非0数据
        for (int i = 0;i < chessArr1.length;i ++){
            for (int j = 0;j < chessArr1.length;j ++){
                if (chessArr1[i][j] != 0){
                    count ++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为:");
        for (int i = 0;i < sparseArray.length;i ++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();



        //将稀疏数组恢复成原始的二维数组
        //1、先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArr2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];    //稀疏数组的第一行第一、二列就是二维数组的行列数
        //2、读取稀疏数组后几行的数据，并赋给原始的二维数组即可
        for (int i = 1;i < sparseArray.length;i ++){            //从第二行开始遍历，i=1
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];        //第几行第几列=值
        }
        //3、遍历输出二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
