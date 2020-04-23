package casino;

import java.util.Objects;

/**
 * 筹码。
 * 需要重写Jetton类的equals(),hashcode()方法。
 */
public class Jetton implements Iexchange {
    private int unit;

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }


    public Jetton(int unit) {
        this.unit = unit;
    }

    @Override
    public Cash exchange() {
        return new Cash(this.getUnit());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jetton jetton = (Jetton) o;
        return unit == jetton.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit);
    }

    public static void main(String[] args) {
        Jetton j1 = new Jetton(1);
        Jetton j2 = new Jetton(1);
        Jetton j3 = new Jetton(2);
        System.out.println(j1.equals(j2));
        System.out.println(j2.equals(j3));
    }
}
