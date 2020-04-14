package decorator;

/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-04-13 20:39
 **/

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
