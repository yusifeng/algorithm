import java.util.Arrays;

public class MergeSort {
    private MergeSort() {}
    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        sort2(arr, 0, arr.length - 1);
    }
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        sort3(arr, 0, arr.length - 1);
    }
    public static <E extends Comparable<E>> void sort4(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort4(arr, 0, arr.length - 1, temp);
    }
    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    // 优化点一： 如果右侧的最小已经大于左侧的最大，就不需要执行merge
    public static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        sort2(arr, l, mid);
        sort2(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }
    public static <E extends Comparable<E>> void sort3(E[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        if (l >= r) return;
        int mid = (l + r) / 2;
        sort3(arr, l, mid);
        sort3(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }
    public static <E extends Comparable<E>> void sort4(E[] arr, int l, int r, E[] temp) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        sort2(arr, l, mid);
        sort2(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge4(arr, l, mid, r, temp);
        }
    }
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid +1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }
    // 重要的优化
    private static <E extends Comparable<E>> void merge4(E[] arr, int l, int mid, int r, E[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid +1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static <E extends Comparable<E>> void sortBU(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;
//        遍历区间的长度sz
        for (int sz = 1; sz < n; sz += sz) {
            for (int i = 0;i + sz < n; i += sz + sz) {
                merge4(arr, i,i + sz - 1, Math.min(i + 2 * sz - 1, n - 1), temp);
            }
        }
    }
    public static void main(String[] args) {
        Integer[] arr = {2, 4, 1, 7, 3, 6, 5, 8};
        MergeSort.sort4(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
