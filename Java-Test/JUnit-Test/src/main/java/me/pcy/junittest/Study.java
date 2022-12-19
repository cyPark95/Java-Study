package me.pcy.junittest;

import java.time.LocalDateTime;


public class Study {
    private StudyStatus status = StudyStatus.DRAFT;

    private int limit;

    private String name;

    private LocalDateTime openedDateTime;

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

    public LocalDateTime getOpenedDateTime() {
        return openedDateTime;
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
