package decorator;

/**
 * @program: algorithm
 *小包包
 * 继承抽象商品，override了getName() price()
 * @author: Sunbuhui7
 * @create: 2020-04-14 23:03
 **/

public class SmallBagBag extends GoodsAbstract{
    private double price =5.20;
    private Recipt myRecipt;
    private String name = "小包包330g";
    @Override
    public String getName() {
        return myRecipt.getName()+"\n"+name+"  "+price;
    }

    @Override
    public double price() {
        return myRecipt.price() + price;
    }
    public SmallBagBag(Recipt temp){
        myRecipt = temp;
    }
}
