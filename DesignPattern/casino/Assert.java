package casino;

/**
 *资产类，实现了Iexchange接口，将资产转换成cash
 */
public class Assert implements Iexchange{
    private String type;
    private int value;

    @Override
    public Cash exchange() {
        return new Cash(value);
    }
}
