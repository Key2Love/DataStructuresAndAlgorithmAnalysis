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

public class TreeDir {
    private String name;
    private ArrayList subDir = new ArrayList<TreeDir>();

    public TreeDir(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void add(TreeDir sonDir){
        subDir.add(sonDir);
    }


}
