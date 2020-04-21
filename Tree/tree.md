# 树

## 树的定义

- 深度是从root到n1唯一的路径的长

- 高度是从n1到一片树叶的最长路径的长

## 树的遍历两种写法(循环，递归)

```java
//这是前序遍历，如果需要中序遍历，把sout这行放在中间就可以
public void traverseTree(TreeNode root){
    if(root!=null){
        System.out.println(root.val);
        traverseTree(root.left);
        traverseTree(root.right);
    }
}
//非递归遍历
public void traverseTree(TreeNode root){
    while(root!=null){
        System.out.println(root.val);
        if(root.left!=null){
            root = root.left;
            System.out.println(root.val);
        }
        if(root.right!=null){
            root =root.right;
      	    System.out.println(root.val);     
        }
    }
}
```