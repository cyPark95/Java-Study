package encapsulation;

public class TokenProvider {

    public void verifyEmail(String token) {
        Member mem = findByToken(token);

        if(mem == null) throw new BadTokenException();

        mem.verifyEmail();
    }

    private static class Member {

        private String email;
        private int verificationEmailStatus;

        public Member(String email) {
            this.email = email;
        }

        public void verifyEmail() {
            if (verificationEmailStatus == 2) {
                throw new AlreadyVerifiedException();
            } else {
                verificationEmailStatus = 2;
            }
        }

        public boolean isEmailVerified() {
            return verificationEmailStatus == 2;
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
