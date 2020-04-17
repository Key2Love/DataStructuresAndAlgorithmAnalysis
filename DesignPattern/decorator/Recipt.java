/**
 * @program: algorithm
 * @description: 发票的抽象类
 * 首先定义了发票的抽象类，有两个抽象方法。
 * @author: Sunbuhui7
 * @create: 2020-04-14 22:30
 **/


public abstract class Recipt {
    //获取商品名
    public abstract String getName();

    //获取价格，由子类实现
    public abstract double price();

}
