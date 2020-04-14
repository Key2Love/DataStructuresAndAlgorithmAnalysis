/**
 * @program: algorithm
 * @description: 装饰类
 * @author: Sunbuhui7
 * @create: 2020-04-13 22:14
 **/

public abstract class ReceiptDecorator implements Receipt{
    protected Receipt decoratorShape;

    public ReceiptDecorator(Receipt decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    @Override
    public void print() {
        decoratorShape.print();
    }
}
