package casino;

/**
 * 采用builder模式
 */
public class WagerBuilder {
    private Wager wager = new Wager();

    public void buildId(int id){
        wager.setId(id);
    }
    public void buildJetton(Jetton jetton,int num){
        wager.add(jetton,num);
    }

    public Wager buildWager(){
        return wager;
    }
}
