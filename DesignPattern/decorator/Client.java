/**
 * @program: algorithm
 * @description: Client端
 * @author: Sunbuhui7
 * @create: 2020-04-15 21:35
 **/

public class Client {
    public String print(Recipt recipt) {
        StringBuffer sb = new StringBuffer();
        sb.append("-------------------\n");
        sb.append("东北大学发票系统\n");
        sb.append("-------------------\n");
        sb.append(recipt.getName() + "\n");
        sb.append("-------------------\n");
        sb.append("合计  " + recipt.price());
        return sb.toString();
    }

    public static void main(String[] args) {
        Recipt recipt = new ReciptImpl();
        System.out.println(new Client().print(recipt));
        recipt = new Coke(recipt);
        System.out.println(new Client().print(recipt));
        recipt = new Coke(recipt);
        recipt = new SmallBagBag(recipt);
        System.out.println(new Client().print(recipt));
    }
}
