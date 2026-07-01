public boolean findTargetIn2DPlants(int[][] plants, int target) {
    if(plants==null||plants.length==0) return false;
    for(int i=0;i<plants.length;i++){
        for(int j=0;j<plants[i].length;j++){
            if(plants[i][j]==target) return true;
        }
    }
    return false;
}

void main() {
    // 测试用例1：正常情况，target存在
    int[][] plants1 = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
    };
    System.out.println("测试1 (找5): " + findTargetIn2DPlants(plants1, 5)); // true

    // 测试用例2：target不存在
    System.out.println("测试2 (找20): " + findTargetIn2DPlants(plants1, 20)); // false

    // 测试用例3：边界值，最小元素
    System.out.println("测试3 (找1): " + findTargetIn2DPlants(plants1, 1)); // true

    // 测试用例4：边界值，最大元素
    System.out.println("测试4 (找17): " + findTargetIn2DPlants(plants1, 17)); // true

    // 测试用例5：空数组
    int[][] plants2 = {};
    System.out.println("测试5 (空数组): " + findTargetIn2DPlants(plants2, 5)); // false

    // 测试用例6：null数组
    System.out.println("测试6 (null): " + findTargetIn2DPlants(null, 5)); // false

    // 测试用例7：单行数组
    int[][] plants3 = {{1, 3, 5, 7, 9}};
    System.out.println("测试7 (单行找3): " + findTargetIn2DPlants(plants3, 3)); // true
    System.out.println("测试8 (单行找4): " + findTargetIn2DPlants(plants3, 4)); // false

    // 测试用例8：单列数组
    int[][] plants4 = {{1}, {3}, {5}, {7}, {9}};
    System.out.println("测试9 (单列找7): " + findTargetIn2DPlants(plants4, 7)); // true
    System.out.println("测试10 (单列找6): " + findTargetIn2DPlants(plants4, 6)); // false
}
