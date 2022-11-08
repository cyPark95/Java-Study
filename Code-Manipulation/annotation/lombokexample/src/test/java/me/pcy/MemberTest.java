package me.pcy;

import org.junit.Assert;
import org.junit.Test;

public class MemberTest {

    @Test
    public void getterSetter() {
        // given
        Member member = new Member();
        member.setName("pcy");

        // when

        // then
        Assert.assertEquals(member.getName(), "pcy");
    }
}