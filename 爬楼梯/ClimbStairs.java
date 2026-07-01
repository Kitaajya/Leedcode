public int climbStairs(int n) {
    int l=1;int r=2;
    if(n==1) return 1;
    if(n==2) return 2;
    for(int i=3;i<=n;i++){
        int next=l+r;
        l=r;
        r=next;
    }
    return r;
}

void main() {
    System.out.println(climbStairs(44));
}
