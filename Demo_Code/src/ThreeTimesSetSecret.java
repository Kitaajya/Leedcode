import java.util.Arrays;
import java.util.Random;

public class ThreeTimesSetSecret {

    //自然底数
    public final double e=Math.E;
    //实现数组反转
    public int[] reverse(int[] nums){
        int[]store=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--) store[nums.length-1-i]=nums[i];
        return store;
    }

    //求解数字长度
    public int length(int n){
        if(n<0) return -1;
        if(n<10) return 1;
        int count=0;
        do {
            n = n / 10;
            count++;
        } while (n != 0);
        return count;
    }
    //实现整数的pow
    public int pow(double base,double exl){
        int l=1;
        for(int i=0;i<exl;i++){
            l*= (int) base;
        }
        return l;
    }

    //int类型转换为数组
    public int[]parse(int n){
        int[]arr=new int[length(n)];
        for(int i=0;i<arr.length;i++){
            arr[i]=n/pow(10,length(n)-1);
            n=n-pow(10,length(n)-1)*arr[i];
        }
        return arr;
    }

    //概率
    public int[] result1(int s,int[]originalSecret){

        int[] secret=parse(s);//最终待反转的密码，s参数是密码的int类型
        int[]secretKey=new int[secret.length];//密钥
        Random r=new Random();
        if(originalSecret.length==secret.length) { //设计密钥
            for (int i = 0; i < secretKey.length; i++)
                secretKey[i] = r.nextInt(0, 9);
            for (int i = 0; i < secret.length; i++) {
                secret[i] = originalSecret[i] - secretKey[i];
            }
            //反转后的密码数组与密钥合并
            int[] store = new int[reverse(secret).length + secretKey.length];
            for (int i = 0; i < store.length; i++) {
                if (i < reverse(secret).length) {
                    store[i] = reverse(secret)[i];
                } else {
                    store[i] = secretKey[i - reverse(secret).length];
                }
            }
            return store;
        }
       return new int[]{-1,-1};
    }
    //实现数组里所有整数全部随机加或乘key
    public int[] result2(int password, int key){
        int[]p=parse(password);
       int[]store=result1(password,p);
       for(int i=0;i<store.length;i++){
           store[i]=store[i]+key;
       }
       return store;
    }
    public static void main(String[]asd){
        ThreeTimesSetSecret w=new ThreeTimesSetSecret();
        System.out.println(Arrays.toString(w.result2(1517560, 2)));

    }
}
