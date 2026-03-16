import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，
 * 并返回它们的数组下标。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。**/
public class TheFirstQuestion_3 {
    //找到欲求值的下标
    public static int find(int[] n,int t,int index){
        if(n[index]==t) return index;
        if(index>=n.length) return -1;
        else return find(n,t,index+1);
    }
  public static int[] twoSum(int[] nums, int target) {
      for(int i=0;i<nums.length;i++){
          int b=target-nums[i];
          int indexOfB=0;
          for(int j=0;j<nums.length;j++){
              if(b==nums[j]){
                  if(i!=find(nums,b,indexOfB)){
                      if(find(nums,b,indexOfB)<i) return new int[]{find(nums,b,indexOfB),i};
                      return new int[]{i,find(nums,b,indexOfB)};        //有序输出
                  }
              }
          }
      } return new int[]{-1,-1};
  }
    public static void main(String[]a){
      // System.out.println(find(new int[]{1,2,3,4,5,6,7},4,0));
        int[] am= twoSum(new int[]{1,2,3,4,5,6,7},30);
        int[] am1= twoSum(new int[]{3,3},6);
        System.out.println(Arrays.toString(am));
        System.out.println(Arrays.toString(am1));
    }
}
