package me.pcy.architecturetest.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@ToString
public class Member {

    @Id
    private Long id;

    private String email;
}
