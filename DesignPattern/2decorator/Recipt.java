/**
 * @program: algorithm
 * @description: 发票的抽象类
 * @author: Sunbuhui7
 * @create: 2020-04-14 22:30
 **/

public abstract class Recipt {
    //商品名
    public String name = "商品";
    public abstract String getName();

    //价格，由子类实现
    public abstract double price();

}
