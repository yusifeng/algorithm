public class BinarySearch {
    private BinarySearch() {}
    public static <E extends Comparable<E>>int search(E[] data, E target) {
        int l = 0, r = data.length - 1;
        int mid = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) {
                break;
            } else if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
                mid = - 1;
            } else {
                r = mid - 1;
                mid = - 1;
            }
        }
        return mid;
    }
    public static <E extends Comparable<E>>int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }
    private static <E extends Comparable<E>>int searchR(E[] data, int l, int r, E target) {
        // 递归到底的情况
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (data[mid].compareTo(target) == 0) {
            return mid;
        } else if (data[mid].compareTo(target) < 0){
            return searchR(data, mid + 1, r, target);
        } else {
            return searchR(data, l, mid - 1, target);
        }
    }
    public static <E extends Comparable<E>> int upper(E[]data, E target) {
        int l = 0, r = data.length;
        while (l < r) {
            int mid = l + (r - l ) / 2;
            if (data[mid].compareTo(target) <= 0)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
    public static <E extends Comparable<E>> int lower(E[]data, E target) {
        int l = -1, r = data.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) >= 0)
                r = mid + 1;
            else
                l = mid;
        }
        return l;
    }
    public static void main(String[] args) {
        Integer[] data = {1, 2, 4, 5, 6, 7, 8};
        System.out.println(BinarySearch.lower(data, 11));
    }
}
