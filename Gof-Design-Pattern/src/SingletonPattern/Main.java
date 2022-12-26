package SingletonPattern;

public class Main {

    public static void main(String[] args) {
        SystemSpeaker speaker1 = SystemSpeaker.getInstance();
        SystemSpeaker speaker2 = SystemSpeaker.getInstance();

        System.out.println("speaker1.volume[" + speaker1.getVolume() + "] == speaker2.volume[" + speaker2.getVolume() + "]: " + (speaker1.getVolume() == speaker2.getVolume()));

        speaker1.setVolume(9);
        System.out.println("speaker1.volume[" + speaker1.getVolume() + "] == speaker2.volume[" + speaker2.getVolume() + "]: " + (speaker1.getVolume() == speaker2.getVolume()));

        speaker2.setVolume(1);
        System.out.println("speaker1.volume[" + speaker1.getVolume() + "] == speaker2.volume[" + speaker2.getVolume() + "]: " + (speaker1.getVolume() == speaker2.getVolume()));
    }
}
