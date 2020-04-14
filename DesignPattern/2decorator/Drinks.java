/**
 * @program: algorithm
 * @description: 实现Receipt
 * @author: Sunbuhui7
 * @create: 2020-04-13 22:08
 **/

public class Drinks implements Receipt {
    private double num;
    @Override
    public String print() {
        return String.valueOf(num);
    }

    public Drinks(double num) {
        this.num = num;
    }
}
