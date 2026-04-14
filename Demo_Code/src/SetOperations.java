import java.util.Arrays;

public class SetOperations {
    //并集运算,数组拼接
    /*
      n1=[1,3,4,5,6,37,74,234,231,31]
      n2=[3,4,3,12,34,12,55,12,12,45,3]
      预期：
      union[n1.length+n2.length]=[1,3,4,5,6,37,74,234,231,31,~~ 3,4,3,12,34,12,55,12,12,45,3];
      union[]在delete(int[]nums)的作用下排序并去重

      **/
    /*
     ===========================================集合的差===========================================
       n1={1,2,3,5,6,  8,9,14,15},n1.length=9;
       n2={1,2,    6,7,8        },n2.length=5;
      第一种情况：输入difference(int[]n1,int[]n2)->
      预期：n1-n2={3,5,9,14,15};
      解释：元素属于n1但不属于n2；
      另一种情况：如果输入difference(int[]n2,int[]n1)->
      预期：n2-n1={7};
      解释：只有元素7符合元素属于n2但不属于n1；
    */
    /**
     * n1=[1,3,4,5,6],n1.length=5
     * n2=[7,8,9,12,4,5,6],n2.length=7
     * union(n1,n2)=[1,3,4,5,6,~~ 7,8···]
     * **/
    //去重函数
    public static int[] deleteRepetition(int[]nums){
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
        n1=deleteRepetition(n1);
        n2=deleteRepetition(n2);
        Arrays.sort(n1);
        Arrays.sort(n2);
        int[] a=new int[n2.length+n1.length];
        for(int i = 0; i<n1.length; i++) a[i]=n1[i];
        for(int j=0;j<n2.length;j++) a[n1.length+j]=n2[j];
        return deleteRepetition(a);
    }
    //返回所有公共元素
    public static int[] commentElementInArray(int[]n1, int[]n2){
        n1=(deleteRepetition(n1));
        n2=(deleteRepetition(n2));
        Arrays.sort(n1);
        Arrays.sort(n2);
        int[] a=new int[Math.min(n1.length,n2.length)];
        int count=0;
        for(int i=0;i<n1.length;i++){
            for(int j=0;j<n2.length;j++){
                if(n1[i]==n2[j]) {
                    a[count] = n1[i];
                    count++;
                    break;
                }
            }
        }
        int[] result=new int[count];
        for(int i=0;i<count;i++){
            result[i]=a[i];
        }
        return result;
    }
    //寻找元素当且仅当元素属于n1但不属于n2
    public static int[] difference(int[]n1,int[]n2){
        n1=deleteRepetition(n1);
        n2=deleteRepetition(n2);
        Arrays.sort(n1);
        Arrays.sort(n2);
        //检查n1里面是否有n2的元素
        int[]a=new int[n1.length+n2.length];
        int count=0;
        for(int i=0;i<n1.length;i++){
            a[count]=n1[i];
            for(int j=0;j<n2.length;j++){
                if(a[count]==n2[j]){
                    a[count]=0;
                    break;
                }
            }
            if(a[count]!=0) count++;
        }
        int[]result=new int[count];
        for(int i=0;i<result.length;i++) result[i]=a[i];
        return result;
    }
    public static void main(String[]asd){
        int[]n1={1, 3, 4, 5, 6, 37, 74, 234, 231, 31,24,356};
        int[]n2={3,4,3,12,34,12,55,12,12,45,3};
        System.out.println("n1="+ Arrays.toString(n1));
        System.out.println("n2="+ Arrays.toString(n2));
        System.out.println("并集运算"+Arrays.toString(union(n1, n2))+"长度："+union(n1,n2).length);
        System.out.println("返回集合差"+Arrays.toString(difference(n1, n2)));
        System.out.println("返回公共元素："+Arrays.toString(commentElementInArray(n1, n2)));
    }
}
