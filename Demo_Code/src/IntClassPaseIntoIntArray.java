import java.util.Arrays;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 * 示例 2:
 *
 * 输入: num = 0
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= num <= 231 - 1**/


public class IntClassPaseIntoIntArray {
    public static int length(int num){
        if(num<0) return -1;
        if(num<10) return 1;
        int count=0;
        while(true){
            num=num/10;
            count++;
            if(num==0) return count;
        }
    }
    public static int[] paseIntToArray(int num) {
        if(num<0) return new int[]{-1};
        /*
          num=5567
        */
        int[] n=new int[length(num)];
        int i=0;
        int m;
        m=num;
        int sum=0;
        final int l=length(num);
        while(true){
              n[i]= (int) (m/(Math.pow(10,l-1-i)));//第一次：m->5567,->5567/1000=5->n[0];
              m= (int) (m-n[i]*Math.pow(10,l-1-i));//第一次：->5567-5000=567=m;
              i++;
              //第二次：m->567;
              //  567/10^2=5->n[1];
              //第二次：m=567-n[1]*100=67;
              //第三次：m=67;
              //  67/10=6=n[2];
              //  m=67-n[2]*10=7;
              //第四次：m=7
             //   n[3]=7/10^(4-1-3)=7;
             //   justify
             if(length(m)==1) {
                 n[l-1]=m;
                 break;
             }
         }
       return n;
    }
    public static void main(String[]args){
        System.out.println(Arrays.toString(paseIntToArray(95469)));
    }
}
