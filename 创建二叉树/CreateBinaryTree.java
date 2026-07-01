class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public TreeNode createBinaryTree(int[][] descriptions) {
    //description[][3]->[a][b][1]->b是a的左子树
    TreeNode root1=new TreeNode();
    TreeNode root=root1;
    for(int i=0;i<descriptions.length;i++){
        for(int j=0;j<descriptions[i].length;j++){
            if(descriptions[j][2]==1) root.left.val=descriptions[j][1];
            else if(descriptions[j][2]==0) root.right.val=descriptions[j][1];
        }
    }
    return root;
}

void main() {
    int[][] descriptions = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
    TreeNode root =createBinaryTree(descriptions);
    System.out.println("根节点值: " + (root != null ? root.val : "null"));
}

