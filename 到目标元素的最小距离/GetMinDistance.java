public int getMinDistance(int[] nums, int target, int start) {
    int min=Integer.MAX_VALUE;
    for(int i=0;i<nums.length;i++){
        if(nums[i]==target)
            min=Math.min(min,Math.abs(i-start));
    }
    
    return min;
}

void main() {
    int[]nums=new int[]{1,2,3,4,5};
    int target=5;
    int start=3;
    System.out.print(getMinDistance(nums,target,start));
}
