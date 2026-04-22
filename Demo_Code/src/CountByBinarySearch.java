public class CountByBinarySearch {

    // 返回出现次数
    public int count(int[] sortedNums, int target) {
        if (sortedNums == null || sortedNums.length == 0) return 0;

        int first = findFirst(sortedNums, target);
        if (first == -1) return 0;

        int last = findLast(sortedNums, target);
        return last - first + 1;//有序数组的下标之差+1=元素个数
    }

    // 查找第一个出现的位置
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;  // 继续向左找
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // 查找最后一个出现的位置
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;   // 继续向右找
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] asd) {
        CountByBinarySearch s = new CountByBinarySearch();
        int[] nums = {1,2,5,7,8,9,10,12,15,26,26,26,37,84,88};

        int count = s.count(nums, 26);
        System.out.println("26出现了 " + count + " 次");  // 输出：3
    }
}