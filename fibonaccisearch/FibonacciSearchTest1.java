package com.csu.search.fibonaccisearch;

import java.util.Arrays;

/*
    斐波那契查找代码实现
 */
public class FibonacciSearchTest1 {
    public static int maxSize = 20;     //设定斐波那契数列的个数为20

    public static void main(String[] args) {
        int[] arr = {1,8, 10, 89, 1000, 1234};

        System.out.println(fibSearch(arr,1));
    }


    //因为mid=low+F(k-1)-1,需要使用到斐波那契数列，需要先获取到一个斐波那契数列
    //用非递归的方式得到一个斐波那契数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2;i < maxSize;i ++){
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }


    //编写斐波那契查找算法
    /**
     * 使用非递归的方式编写算法
     * @param arr 数组
     * @param key   需要查找的值
     * @return  找到返回下标，没有返回-1
     */
    public static int fibSearch(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        int k = 0;      //表示斐波那契分割数值的那个下标
        int mid = 0;    //存放mid的值
        int[] f = fib();    //获取到斐波那契数列

        //获取到斐波那契分割数的下标
        while (high > f[k] - 1){
            k ++;
        }
        //因为f[k]这个值可能>数组的长度，因此需要使用Arrays类构造一个新的数组并指向arr
        int[] temp = Arrays.copyOf(arr,f[k]);       //原数组是arr，新的数组的长度是f[k]，不足的部分使用0补齐
        //实际上需要使用arr数组中最后的数填充temp
        for (int i = high + 1;i < temp.length;i ++){
            temp[i] = arr[high];
        }//举例:temp={1,8, 10, 89, 1000, 1234,0,0} => temp={1,8, 10, 89, 1000, 1234,1234,1234}

        //使用while循环来处理要查找的数key
        while (low <= high){        //只有这个条件满足就可以一直找
            mid = low + f[k-1] - 1;
            if (key < temp[mid]){       //说明应该继续向数组的前面查找(左边)
                high = mid - 1;
                //为什么是k--?
                //1、全部的元素=前面的元素+后面的元素  2、f[k]=f[k-1]+f[k-2]
                // 3、因为前面有f[k-1]个元素，所以我们可以继续拆分成f[k-1]=f[k-2]+f[k-3],
                // 即在f[k-1]的前面继续查找，即k-1，即在下次循环mid=f[k-1-1]-1;
                k --;
            }else if (key > temp[mid]){         //说明我们应该继续向数组的后面查找(右边)
                low = mid + 1;
                //为什么是k-2呢？
                //1、全部的元素=前面的元素+后面的元素 2、f[k]=f[k-1]+f[k-2]
                //3、因为后面有f[k-2]，所以可以拆分f[k-1] = f[k-3] + f[k - 4]
                //4、即f[k-2]的前面可以进行查找k -= 2
                //5、即下次循环mid =low + f[k-1-2] - 1
                k -= 2;
            }else {     //找到
                //需要确定返回的是哪个下标
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}


