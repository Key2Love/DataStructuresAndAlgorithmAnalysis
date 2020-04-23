package composite;
import java.util.ArrayList;

/**
 * @program: algorithm
 * @description: 树目录
 * 用Composite模式创建一个树形菜单，
 * 其中树形菜单的每个节点包含名称(Name)属性。
 * 需要把一个树形菜单输出。
 * Level_1
 *             Level_2_1
 *                             Level_3_1_1
 *                             Level_3_1_2
 *             Level_2_2
 *                             Level_3_2_1
 *                             Level_3_2_2
 * @author: Sunbuhui7
 * @create: 2020-04-15 22:04
 **/

public class Node {
    private String name;
    private int depth;
    private Node left;
    private Node right;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(){ }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }
}
