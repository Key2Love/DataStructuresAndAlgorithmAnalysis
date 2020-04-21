package casino;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

public class JettonFactory {
    private static final JettonFactory INSTANCE = new JettonFactory();
    private static final Map<Integer,Jetton> hm = new HashMap<>();
    public static Jetton getJetton(Integer unit){
        Jetton jetton = hm.get(unit);
        if (jetton==null){
            jetton = new Jetton(unit);
            hm.put(unit,jetton);
        }
        return jetton;
    }
}
