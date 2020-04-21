package builder;
import composite.TreeDir;
import sun.reflect.generics.tree.Tree;

/**
 * @program: algorithm
 * @description: 目录的builer
 * @author: Sunbuhui7
 * @create: 2020-04-17 15:31
 **/

public class TreeDirBuilder {
    StringBuffer sb = new StringBuffer();
    public TreeDir getTreeDir() {
        TreeDir level_1 = new TreeDir("level_1");
        TreeDir level_2_1 = new TreeDir("level_2_1");
        TreeDir level_2_2 = new TreeDir("level_2_2");
        TreeDir level_3_1_1 = new TreeDir("level_3_1_1");
        TreeDir level_3_1_2 = new TreeDir("level_3_1_2");
        TreeDir level_3_2_1 = new TreeDir("level_3_2_1");
        TreeDir level_3_2_2 = new TreeDir("level_3_2_2");
        level_1.add(level_2_1);
        level_1.add(level_2_2);
        level_2_1.add(level_3_1_1);
        level_2_1.add(level_3_1_2);
        level_2_2.add(level_3_2_1);
        level_2_2.add(level_3_2_2);
        return level_1;
    }

    public TreeDir getTreeDir(int depth) {
        for (int i = 1; i <depth ; i++) {
            sb.append("level");
            for (int j = ; j < ; j++) {

            }


        }

    }
}