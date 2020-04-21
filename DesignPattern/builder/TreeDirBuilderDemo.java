package builder;
import composite.TreeDir;
import sun.reflect.generics.tree.Tree;

/**
 * @program: algorithm
 * @description: client，用于测试
 * @author: Sunbuhui7
 * @create: 2020-04-17 15:44
 **/

public class TreeDirBuilderDemo {
    public static void main(String[] args) {
        TreeDirBuilder treeDirBuilder = new TreeDirBuilder();
        TreeDir root = treeDirBuilder.getTreeDir();

    }
}
