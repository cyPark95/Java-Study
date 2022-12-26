package SingletonPattern;

public class SystemSpeaker {

    static private SystemSpeaker instance;
    private int volume;

    private SystemSpeaker(){
        volume = 5;
    }

    public static SystemSpeaker getInstance() {
        if (instance == null) {
            instance = new SystemSpeaker();
            System.out.println("인스턴스 새로 생성!");
        } else {
            System.out.println("생성된 인스턴스 사용!");
        }

        return instance;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
