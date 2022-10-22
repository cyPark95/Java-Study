package me.pcy;

public class Moim {

    public int maxNumberOfAttendees;

    public int numberOfEnrollment;

    public boolean isEnrollmentFull() {
        if(maxNumberOfAttendees == 0) {
            return false;
        }

        if(numberOfEnrollment < maxNumberOfAttendees) {
            return false;
        }

        return true;
    }
}
