package Encapsulation;

import java.util.Objects;

public class AuthService {

    private PasswordEncoder passwordEncoder = new PasswordEncoder();

    public AuthResult authenticate(String id, String pw) {
        Member mem = findOne(id);

        if(mem == null) return AuthResult.NO_MATCH;

        if (mem.getVerificationEmailStatus() != 2) {
            return AuthResult.NO_EMAIL_VERIFIED;
        }

        if (passwordEncoder.isPasswordValid(mem.getPassword(), pw, mem.getId())) {
            return AuthResult.SUCCESS;
        }

        return AuthResult.NO_MATCH;
    }

    private static class Member {

        private String id;
        private String pw;
        private int verificationEmailStatus;

        public String getId() {
            return id;
        }

        public String getPassword() {
            return pw;
        }

        public int getVerificationEmailStatus() {
            return verificationEmailStatus;
        }
    }



    private Member findOne(String id) {
        return new Member();
    }

    private enum AuthResult {
        SUCCESS, NO_MATCH, NO_EMAIL_VERIFIED
    }

    private static class PasswordEncoder {
        public boolean isPasswordValid(String password, String pw, String id) {
            return id != null && Objects.equals(password, pw);
        }
    }
}
