package me.pcy.mockitotest.domain;

import lombok.*;
import me.pcy.mockitotest.study.StudyStatus;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
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

    public Study(int limit, String name) {
        this.limit = limit;
        this.name = name;
    }
}
