package decorator;

/**
 * @program: algorithm
 * @description: 创建实现接口的实体类。
 * @author: Sunbuhui7
 * @create: 2020-04-13 20:38
 **/

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
