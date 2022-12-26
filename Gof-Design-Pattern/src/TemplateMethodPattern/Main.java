package TemplateMethodPattern;

public class Main {

    public static void main(String[] args) {
        AbstGameConnectHelper helper = new DefaultGameConnectHelper();

        System.out.println("Request Connection : " + helper.requestConnection("아이디", "암호화된 비밀번호"));
    }
}
