import java.util.Arrays;

public class UnionOperations {
    //并集运算,数组拼接
    /**
     * n1=[1,3,4,5,6,37,74,234,231,31]
     * n2=[3,4,3,12,34,12,55,12,12,45,3]
     * 预期：
     * union[n1.length+n2.length]=[1,3,4,5,6,37,74,234,231,31,~~ 3,4,3,12,34,12,55,12,12,45,3];
     * union[]在delete(int[]nums)的作用下排序并去重
     *
     * **/
    /**
     * n1=[1,3,4,5,6],n1.length=5
     * n2=[7,8,9,12,4,5,6],n2.length=7
     * union(n1,n2)=[1,3,4,5,6,~~ 7,8···]
     * **/
    public static int[] delete(int[]nums){
        int j=0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return Arrays.copyOf(nums, j + 1);
    }
    public static int[] union(int[]n1, int[]n2){
        int[] a=new int[n2.length+n1.length];
        for(int i = 0; i<n1.length; i++) a[i]=n1[i];
        for(int j=0;j<n2.length;j++) a[n1.length+j]=n2[j];
        return delete(a);
    }
    public static void main(String[]asd){
        int[]n1={1, 3, 4, 5, 6, 37, 74, 234, 231, 31,24,356};
        int[]n2={3,4,3,12,34,12,55,12,12,45,3};
        System.out.println(Arrays.toString(union(n1, n2))+"长度："+union(n1,n2).length);
    }
}
