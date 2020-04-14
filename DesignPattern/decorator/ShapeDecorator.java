package decorator;

/**
 * @program: algorithm
 * @description: 创建实现了 Shape 接口的抽象装饰类。
 * @author: Sunbuhui7
 * @create: 2020-04-13 20:41
 **/

public abstract class ShapeDecorator implements Shape{
    protected Shape decoratedShape;
    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();

    }
}
