package TemplateMethodPattern;

public abstract class AbstGameConnectHelper {

    // 보안 과정: 보안 관련 부분을 처리합니다.
    protected abstract String doSecurity(String string);

    // 인증 과정: id와 password가 일치하는지 확인합니다.
    protected abstract boolean authentication(String id, String password);

    // 권한 과정: 접속자가 유료 회원인지 무료회원인지, 게임 마스터 인지 확인합니다.
    protected abstract int authorization(String userName);

    // 접속 과정: 접속자에게 커넥션 정보를 넘겨줍니다.
    protected abstract String connection(String info);

    // 템플릿 메소드
    public String requestConnection(String id, String str) {
        // 보안 과정 -> 암호화 된 문자열을 복호화
        String password = doSecurity(str);

        // 인증 과정
        if (!authentication(id, password)) {
            throw new Error("아이디 암호 불일치");
        }

        // 권한 과정
        int i = authorization(id);

        String role;
        switch (i) {
            case 0:
                role = "게임 마스터";
                break;
            case 1:
                role = "유료 회원";
                break;
            case 2:
                role = "무료 회원";
                break;
            case 3:
                role = "권한 없음";
                break;
            default:
                role = "기타";
                break;
        }

        // 접속 과정
        return connection("[" + id + "]" + role);
    }
}
