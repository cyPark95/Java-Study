package AdapterPattern;

public class AdapterImpl implements Adapter {

//    @Override
//    public Float twiceOf(Float f) {
//        return (float) Math.towTime(f.doubleValue());
//    }

    /**
     * 알고리즘을 변경하지 않고, 요구사항에 맞게 변경하여 사용할 수 있다.
     */
    @Override
    public Float twiceOf(Float f) {
        System.out.println("twiceOf 함수 호출 [" + f + "]");
        return Math.doubled(f.doubleValue()).floatValue();
    }

    @Override
    public Float halfOf(Float f) {
        return (float) Math.half(f.doubleValue());
    }
}
