package me.pcy.dockertest.domain;

import lombok.*;
import me.pcy.dockertest.study.StudyStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Study {

    @Id
    @GeneratedValue
    private Long id;

    private StudyStatus status = StudyStatus.DRAFT;

    @Column(name = "limits")
    private int limit;

    private String name;

    private LocalDateTime openedDateTime;

    @OneToOne(cascade = ALL)
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

    public Long getOwnerId() {
        return owner.getId();
    }
}
