package me.pcy.javatest.domain;

import me.pcy.javatest.study.StudyStatus;

import javax.persistence.*;


@Entity
public class Study {

    @Id
    @GeneratedValue
    private Long id;

    private StudyStatus status = StudyStatus.DRAFT;

    private int limit;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member owner;

    protected Study() {
    }

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit은 0보다 커야한다.");
        }

        this.limit = limit;
    }

    public Study(int limit, String name) {
        this.limit = limit;
        this.name = name;
    }

    public StudyStatus getStatus() {
        return this.status;
    }

    public int getLimit() {
        return limit;
    }

    public String getName() {
        return name;
    }

    public Member getOwner() {
        return owner;
    }

    public void setOwner(Member member) {
        owner = member;
    }

    @Override
    public String toString() {
        return "Study{" +
                "status=" + status +
                ", limit=" + limit +
                ", name='" + name + '\'' +
                '}';
    }
}
