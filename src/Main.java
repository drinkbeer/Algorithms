import UnionFind.QuickFindUF;
import UnionFind.WeightedQuickUnionUF;

import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) {
//        int num = test1(34);
//        System.out.println(num);
//        test3();

//        int[] a = {38, 17, 16, 16, 7, 31, 39, 32, 2, 11};
//
//        selectSort(a);
//
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }

//        System.out.println(time(20));

        QuickFindUF qf = new QuickFindUF(10);
        qf.union(7, 2);
        qf.union(7, 4);
        qf.union(0, 3);
        qf.union(5, 4);
        qf.union(6, 9);
        qf.union(8, 4);
        int[] id = qf.getId();
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();

        WeightedQuickUnionUF wqf = new WeightedQuickUnionUF(10);
        wqf.union(2, 5);
        wqf.union(0, 1);
        wqf.union(2, 0);
        wqf.union(6, 4);
        wqf.union(4, 9);
        wqf.union(4, 8);
        wqf.union(6, 3);
        wqf.union(3, 0);
        wqf.union(2, 7);
        int[] id_wqf = wqf.getId();
        for (int i = 0; i < id_wqf.length; i++) {
            System.out.print(id_wqf[i] + " ");
        }
    }

    public int linearSearch(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k) return i;
        }
        return -1;
    }

    public int[] merge(int[] a, int[] b) {
        int pa = 0;
        int pb = 0;
        int pc = 0;
        int m = a.length;
        int n = b.length;
        int[] c = new int[m + n];
        while (pa < m && pb < n) {
            if (a[pa] < b[pb]) {
                c[pc++] = a[pa++];
            } else {
                c[pc++] = b[pb++];
            }
        }
        if (pa < m)
            while (pa < m) c[pc++] = a[pa++];
        else
            while (pb < n) c[pc++] = b[pb++];
        return c;
    }

    /*
    简单选择排序
    基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换，然后在剩下的数中选出最小的一个数与第二个位置的数交换，
    如此循环直到倒数第二个数和最后一个数比较为止
    时间复杂度T(n)：
    空间复杂度O(n)：
     */
    public static void selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j]) min = j;
            }
            if (i != min) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    /*
    T(n)
     */
    public static int time(int n) {
        int i = 1, count = 0;
        while (i <= n) {
            i = i * 2;
            count++;
        }
        return count;
    }

    /*
    T(n)
     */
    public static int time2(int n) {
        int count = 0, s = 0;
        while (s < n) {
            count++;
            s = s + count;
        }
        return count;
    }

    /*
    T(n)
     */
    public static int time3(int n) {
        int i = 1, count = 0;
        while (i <= n) {
            for (int j = 0; j < i; j++)
                count++;
            i = i * 2;
        }
        return count;
    }


    public static int test1(int num) {
        int count = 0;
        if (num == 1) {
            count++;
            return 1;
        } else if (num == 0) {
            return 0;
        } else {
            return test1(num / 2);
        }
    }

    public static void test2() {
        // byte
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();

        // short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();

        // int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();

        // long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();

        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE="
                + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE="
                + (int) Character.MAX_VALUE);
    }

    public static void test3() {
        String s = "中";
        byte[] b_gbk = new byte[0];
        byte[] b_utf8 = new byte[0];
        byte[] b_iso88591 = new byte[0];

        try {
            b_gbk = s.getBytes("GBK");
            b_utf8 = s.getBytes("UTF-8");
            b_iso88591 = s.getBytes("ISO8859-1");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(b_gbk);
        System.out.println(b_utf8);
        System.out.println(b_iso88591);
    }
}