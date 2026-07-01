public int dominantIndex(int[] nums) {
    int[] arr = new int[nums.length];
    for (int i = 0; i < arr.length; i++)
        arr[i] = nums[i];
    Arrays.sort(arr);
    int max = arr[arr.length - 1];
    int index=0;
    for(int j=0;j<nums.length;j++)
        if(nums[j]==max)
            index=j;
    int k=0;
    while(k<arr.length&&arr[k]!=max){
        if((arr[k]*2<=max||arr[k]==0)) k++;
        else return -1;
    }
    return index;
}
void main() {
    int[]nums=new int[]{3,6,1,0};
    System.out.print(dominantIndex(nums));
}
