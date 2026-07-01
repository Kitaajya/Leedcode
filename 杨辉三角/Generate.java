/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 * **/
public List<List<Integer>> generate(int numRows){
    List<List<Integer>> r = new ArrayList<>();
    if(numRows==1){
       r.add(new ArrayList<>(Arrays.asList(1)));
       return r;
    }
    int[][]store=new int[numRows][];
    for(int i=0;i<store.length;i++) store[i]=new int[numRows];
    for(int i=0;i<numRows;i++)
        for(int j=0;j<numRows;j++) {
            store[i][0] = 1;
            if(j!=0) store[i][j]=0;
        }
    store[0][0]=1;
    store[1][0]=1;
    store[1][1]=1;
    for(int i=1;i<store.length;i++)
        for(int j=1;j<store[i].length;j++)
            store[i][j]=store[i-1][j-1]+store[i-1][j];
    int l=0;
    int[][]temp=new int[numRows][];
    for(int i=0;i<temp.length;i++)
        temp[i]=new int[++l];
    for(int i=0;i<temp.length;i++)
        for(int j=0;j<temp[i].length;j++)
            temp[i][j]=store[i][j];

    for(int i=0;i<temp.length;i++) {
        List<Integer> t = new ArrayList<>();
        for (int j = 0; j < temp[i].length; j++)
            t.add(temp[i][j]);
        r.add(t);
    }
    return r;
}
void main() {
    int k=3;
    System.out.println(generate(k));
}
