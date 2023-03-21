package segregation;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class CashClient {
    private static final String DEFAULT_TRANSFORM = "";

    private SecretKeySpec keySpec;
    private IvParameterSpec ivSpec;

    private RestTemplate restTemplate = new RestTemplate();
    private Object api = null;

    private Res post(Req req) throws Exception {
        String reqBody = toJson(req);

        Cipher cipher = Cipher.getInstance(DEFAULT_TRANSFORM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        String encReqBody = new String(Base64.getEncoder().encode(cipher.doFinal(reqBody.getBytes())));

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(api, encReqBody, String.class);

        String encRespBody = responseEntity.getBody();

        Cipher cipher2 = Cipher.getInstance(DEFAULT_TRANSFORM);
        cipher2.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        String respBody = new String(Base64.getEncoder().encode(cipher.doFinal(reqBody.getBytes())));

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

    private static class IvParameterSpec implements AlgorithmParameterSpec {

    }

    private static class SecretKeySpec implements Key {

        @Override
        public String getAlgorithm() {
            return null;
        }

        @Override
        public String getFormat() {
            return null;
        }

        @Override
        public byte[] getEncoded() {
            return new byte[0];
        }
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
