package Encapsulation;

public class TokenProvider {

    public void verifyEmail(String token) {
        Member mem = findByToken(token);

        if(mem == null) throw new BadTokenException();

        if (mem.getVerificationEmailStatus() == 2) {
            throw new AlreadyVerifiedException();
        } else {
            mem.setVerificationEmailStatus(2);
        }
    }

    private static class Member {

        private String email;
        private int verificationEmailStatus;

        public Member(String email) {
            this.email = email;
        }

        public int getVerificationEmailStatus() {
            return verificationEmailStatus;
        }

        public void setVerificationEmailStatus(int verificationEmailStatus) {
            this.verificationEmailStatus = verificationEmailStatus;
        }
    }



    private Member findByToken(String token) {
        return new Member("email");
    }

    private static class BadTokenException extends RuntimeException {
    }

    private static class AlreadyVerifiedException extends RuntimeException {
    }
}
