package CompositePattern;

public class Main {

    public static void main(String[] args) {
        // Folder
        Folder root = new Folder("root");
        Folder home = new Folder("home");
        Folder pcy = new Folder("pcy");
        Folder music = new Folder("music");
        Folder picture = new Folder("picture");
        Folder doc = new Folder("doc");
        Folder usr = new Folder("usr");

        // File
        File track1 = new File("track1");
        File track2 = new File("track2");
        File pic1 = new File("pic1");
        File doc1 = new File("doc1");
        File java = new File("java");

        root.addComponent(home);
            home.addComponent(pcy);
                pcy.addComponent(music);
                    music.addComponent(track1);
                    music.addComponent(track2);
                pcy.addComponent(picture);
                    picture.addComponent(pic1);
                pcy.addComponent(doc);
                    doc.addComponent(doc1);

        root.addComponent(usr);
            usr.addComponent(java);

        show(root);
    }

    private static void show(Component root) {
        System.out.println(root.getClass().getName() + "|" + root.getName());

        if (root instanceof Folder) {
            for (Component c : ((Folder) root).getChildren()) {
                show(c);
            }
        }
    }
}
