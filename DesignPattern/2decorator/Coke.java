/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-04-13 22:27
 **/

public class Coke extends ReceiptDecorator {
    public Coke(Receipt decoratorShape) {
        super(decoratorShape);
    }

    @Override
    public void print() {
        decoratorShape.print();

    }

    private void setPrint(Receipt decoratedRecipt){
        return
    }
}
