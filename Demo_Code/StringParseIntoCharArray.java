public class StringParseIntoCharArray {
    public static char[] parse(String args) {
        char[]res=new char[args.length()];
        for(int i=0;i<res.length;i++) res[i]=args.charAt(i);
        return res;
    }
    public static void main(String[]asd){
        char[]a=parse("我是柯南·道尔的粉丝！");
        for(int i=0;i<a.length;i++) System.out.println(a[i]);
    }
}
