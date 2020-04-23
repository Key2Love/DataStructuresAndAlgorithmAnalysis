package composite;

/**
 * 用于创建满二叉树
 *
 * @author: Sunbuhui7
 * @create: 2020-04-21 20:59
 **/

public class TreeBuilder {
    private Node root;
    private int dep;
    private StringBuffer sb;

    /**
     * 起始传参
     * root,"Level_1"
     *
     * @param node
     * @param name
     */
    public void makeTree(Node node, String name) {
        Node left;
        Node right;
        if (node.getDepth() < this.dep) {
            left = new Node();
            right = new Node();
            node.setLeft(left);
            node.setRight(right);
            left.setDepth(node.getDepth() + 1);
            right.setDepth(node.getDepth() + 1);
            left.setName("Level_" + left.getDepth() + name + "1");
            right.setName("Level_" + right.getDepth() + name + "2");
            makeTree(left, name + "1_");
            makeTree(right, name + "2_");
        }
    }

    public void collect(Node root) {
        /*sb.append(root.getName());
        sb.append("\n");
        if (root.getLeft() != null && root.getRight() != null) {
            for (int i = 0; i <root.getDepth() ; i++) {
                sb.append("    ");
            }
            collect(root.getLeft());
            collect(root.getRight());
        }**/
        for (int i = 0; i < root.getDepth() - 1; i++) {
            sb.append("    ");
        }
        sb.append(root.getName());
        sb.append("\n");
        if (root.getLeft() != null) {
            collect(root.getLeft());
        }
        if (root.getRight() != null) {
            collect(root.getRight());
        }
    }

    public TreeBuilder(Node root, int dep, StringBuffer sb) {
        this.root = root;
        this.dep = dep;
        this.sb = sb;
    }

    public StringBuffer getSb() {
        return sb;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.setDepth(1);
        root.setName("Level_1");

        TreeBuilder tb = new TreeBuilder(root, 4, new StringBuffer());
        tb.makeTree(root, "_");
        tb.collect(root);
        System.out.println(tb.getSb().toString());
    }

}
