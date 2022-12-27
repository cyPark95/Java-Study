package AbstractFactoryPattern.linux;

import AbstractFactoryPattern.abst.Button;

public class LinuxButton implements Button {

    @Override
    public void click() {
        System.out.println("라눅스 버튼 클릭");
    }
}
