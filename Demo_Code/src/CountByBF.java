//判断一个元素在数组中出现了几次，直接暴力算法
public class CountByBF {
    public int count(int[]nums,int target){
        int i=0;
        int count=0;
        while(i<nums.length){
            if(nums[i]==target){
                count++;
            }
            i++;
        }
        return count;
    }
    public static void main(String[]asd){
        CountByBF t=new CountByBF();
        System.out.println(t.count(new int[]{1,1,1,1,3},1));
    }
}
