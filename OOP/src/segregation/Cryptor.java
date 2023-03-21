package segregation;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class Cryptor {
    private static final String DEFAULT_TRANSFORM = "";

    private SecretKeySpec keySpec;
    private IvParameterSpec ivSpec;

    public String encrypt(String plain) throws Exception {
        Cipher cipher = Cipher.getInstance(DEFAULT_TRANSFORM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        return new String(Base64.getEncoder().encode(cipher.doFinal(plain.getBytes())));
    }

    public String decrypt(String encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance(DEFAULT_TRANSFORM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        return new String(Base64.getEncoder().encode(cipher.doFinal(encrypted.getBytes())));
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
}
