public class ReverseIntegerNumber {
    //找出n有几位数
    public static int find(int n) {
        if ((n >= 0 && n < 10) || (n > -10 && n <= -1)) return 1;
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    public static int reverse(int n) {
        int l;
        l = find(n);
        int[] store = new int[l];
        for (int i = 0; i < l; i++) {
            store[i] = n % 10;
            n = n / 10;
        }
        int[] reverseStore = new int[l];
        for (int j = l - 1; j >= 0; j--) {
            reverseStore[j] = store[j];       //这里直接把值传给reverseStore[]，意义不大，我也不知道当时怎么想的
        }
        long answer = 0;
        int power = 0;
        for (int k = 0; k < l; k++) {
            power = (int) Math.pow(10, l - k - 1);
            answer += (long) reverseStore[k] * power;
        }
        if(answer>Integer.MAX_VALUE||answer<Integer.MIN_VALUE) return 0;
        return (int)((answer));
    }

    public static void main(String[] a) {
          System.out.println(reverse(1534236469));
          System.out.println(reverse(5987));
         System.out.println(reverse(987675456));
    }
}
