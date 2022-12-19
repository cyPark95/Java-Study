package me.pcy.mockitotest.domain;

import me.pcy.mockitotest.study.StudyStatus;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Study {

    @Id
    @GeneratedValue
    private Long id;
    private StudyStatus status = StudyStatus.DRAFT;

    private int limit;

    private String name;

    private LocalDateTime openedDateTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member owner;

    public void open() {
        openedDateTime = LocalDateTime.now();
        status = StudyStatus.OPENED;
    }

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

    public LocalDateTime getOpenedDateTime() {
        return openedDateTime;
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
