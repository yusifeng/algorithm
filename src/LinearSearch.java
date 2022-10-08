public class LinearSearch {
    // 阻止外部使用这个私有方法
    private LinearSearch(){}
    //范型
    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i ++) {
            // 类对象的判断方法
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // 基本数据类型的包装类
        Integer[] data = {1, 2, 3, 4, 6};
        int res = LinearSearch.search(data, 16);
        System.out.println(res);

        Student[] data2 = {
                new Student("aaa"),
                new Student("bbb"),
                new Student("ddd"),
        };

        Student david = new Student("ccc");
        int res1 = LinearSearch.search(data2, david);
        System.out.println(res1);
    }
}
