/**
 * @program: algorithm
 * @description: 可乐
 * @author: Sunbuhui7
 * @create: 2020-04-14 22:36
 **/

public class Coke extends GoodsAbstract {
    private double price = 4;
    private Recipt myRecipt;
    private String name = "可乐330ml";

    @Override
    public String getName() {
        return myRecipt.getName() + "\n" + name + "  " + price;
    }

    @Override
    public double price() {
        return myRecipt.price() + price;
    }

    public Coke(Recipt temp) {
        myRecipt = temp;
    }

    public static void main(String[] args) {
        Recipt recipt = new ReciptImpl();
        recipt = new Coke(recipt);
        recipt = new Coke(recipt);
        recipt = new SmallBagBag(recipt);
        System.out.println("-------------------");
        System.out.println("东北大学发票系统");
        System.out.println("-------------------");
        System.out.println(recipt.getName());
        System.out.println("-------------------");
        System.out.println("合计  " + recipt.price());
    }
}
