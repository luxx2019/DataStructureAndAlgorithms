package sort.insertion;

/**
 * 插入排序的运行时间分析（假设每条语句运行时间相等）
 * 最好：5n - 4
 * 最坏：3/2n^2 + 7/2n - 4
 * 平均：3/4n^2 + 15/4n - 7/2
 *
 * 从输出来看，最坏和平均情况，大概维持在一个量级上，最好情况要远远小于这两者
 */
public class InsertionSortAnalysis {
    public static void main(String[] args) {
        // 一个制表符大概是4个字母的长度，两个半汉字
        System.out.println("输入规模n\t\t\t\t" + "最好情况\t\t\t\t" + "最坏情况\t\t\t\t" + "平均情况");

        for (int i = 10; i < 10000000; i += i){
            System.out.printf("%-20d%-20.0f%-20.0f%-20.0f\n", i, best(i), worest(i), average(i));
        }
    }

    public static double best(double n) {
        return 5 * n - 4;
    }

    public static double worest(double n) {
        return 3.0 / 2 * n * n + 7.0 / 2 * n - 4;
    }

    public static double average(double n) {
        return 3.0 / 4 * n * n + 15.0 / 4 * n - 7.0 / 2;
    }
}
