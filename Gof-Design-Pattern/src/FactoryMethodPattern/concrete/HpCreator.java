package FactoryMethodPattern.concrete;

import FactoryMethodPattern.framework.Item;
import FactoryMethodPattern.framework.ItemCreator;

import java.util.Date;

public class HpCreator extends ItemCreator {

    @Override
    protected void requestItemsInfo() {
        System.out.println("DB에서 체력 회복 물약 정보를 가져옵니다.");
    }

    @Override
    protected void createItemLog() {
        System.out.println("[" + new Date() + "]" + "체력 회복 물약을 생성합니다.");
    }

    @Override
    protected Item createItem() {
        return new HpPotion();
    }
}
