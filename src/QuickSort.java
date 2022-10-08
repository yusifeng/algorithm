import java.util.Random;

public class QuickSort {
    private QuickSort() {}
    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }
    public static <E extends Comparable<E>> void sort2ways(E[] arr) {
        sort2ways(arr, 0, arr.length - 1);
    }
    // 双路排序
    private static <E extends Comparable<E>> void sort2ways(E[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition2(arr, l, r);
        sort2ways(arr, l, p - 1);
        sort2ways(arr, p + 1, r);
    }
    public static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        // 循环不变量 arr[l+1 ... j] < 0; arr[j+1 .... i] v > 0
        int j = l;
//        添加随机化
//        int p = l + (new Random()).nextInt(r - l + 1);
//        swap(arr, l, p);
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j ++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }
    public static <E extends Comparable<E>> int partition2(E[] arr, int l, int r) {
        // 循环不变量 arr[l+1 ... i-1] <= 0; arr[i+1 .... r] v >= 0
        // 添加随机化
//        int p = l + (new Random()).nextInt(r - l + 1);
//        swap(arr, l, p);
        int i = l + 1, j = r;
        while(true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) { i ++; };
            while (j >= i && arr[j].compareTo(arr[l]) > 0) { j --; };
            if (i >= j) break;
            swap(arr, i, j);
            i ++;
            j --;
        }
        swap(arr, l, j);
        return j;

    }
    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void main(String[] args) {
        Integer[] array = {1, 3, 5, 34, 56, 7, 89, 34, 32, 6, 67, 67, 423, 132,4, 324};
        QuickSort.sort2ways(array);
        for (int i = 0; i < array.length; i ++) {
            System.out.println(array[i]);
        }
    }
}
