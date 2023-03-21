package segregation;

public class CashClient {

    private RestTemplate restTemplate = new RestTemplate();
    private Object api = null;

    private Cryptor cryptor;

    public CashClient(Cryptor cryptor) {
        this.cryptor = cryptor;
    }

    private Res post(Req req) throws Exception {
        String reqBody = toJson(req);

        String encReqBody = cryptor.encrypt(reqBody);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(api, encReqBody, String.class);

        String encRespBody = responseEntity.getBody();

        String respBody = cryptor.decrypt(encRespBody);

        return jsonToObj(respBody);
    }

    private Res jsonToObj(String respBody) {
        return null;
    }

    private String toJson(Req req) {
        return null;
    }

    private static class Req {

    }

    private static class Res {

    }

    private static class ResponseEntity<T> {
        public T getBody() {
            return null;
        }
    }

    private static class RestTemplate {
        public ResponseEntity<String> postForEntity(Object api, String encReqBody, Class<String> stringClass) {
            return null;
        }
    }
}
