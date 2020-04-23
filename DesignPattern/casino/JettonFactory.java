package casino;

import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * JettonFactory的工厂类，采用单例模式。
 * 使用一个hashmap来保存Jetton保证了Jetton的唯一性，flyweight模式
 */
public class JettonFactory {
    private static final JettonFactory INSTANCE = new JettonFactory();
    private  Map<Integer,Jetton> hm = new HashMap<>();
    public static Jetton getJetton(Integer unit){
        Jetton jetton = INSTANCE.hm.get(unit);
        if (jetton==null){
            jetton = new Jetton(unit);
            INSTANCE.hm.put(unit,jetton);
        }
        return jetton;
    }
    private JettonFactory(){

    }
    public static JettonFactory getInstance(){
        return INSTANCE;
    }

}
