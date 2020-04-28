package casino;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 1、	使用创建型模式的一种来创建赌注（Factory Method模式）；
 * 2、	赌注实际上就是筹码的集合
 * （实际上是一种聚集，但是可以使用Composite模式练习一下）；
 */
public class    Wager implements   Iadd,Iexchange,Isum{
    private Map<Jetton, Integer> hm = new HashMap<Jetton, Integer>();
    private int id;

    public Map<Jetton, Integer> getHm() {
        return hm;
    }

    public Wager(){}
    public Wager(Map<Jetton, Integer> hm, int id) {
        this.hm = hm;
        this.id = id;
    }

    public void setHm(Map<Jetton, Integer> hm) {
        this.hm = hm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean add(Jetton jetton,int num) {
        if (hm.containsKey(jetton)){
            hm.put(jetton,hm.get(jetton)+num);
        }
        return true;
    }

    @Override
    public Cash exchange() {
        return new Cash(this.sum());
    }

    @Override
    public int sum() {
        int sum = 0;
        for (Map.Entry<Jetton, Integer> it:hm.entrySet()){
            sum += it.getKey().getUnit()*it.getValue();
        }
        return sum;
    }


}
