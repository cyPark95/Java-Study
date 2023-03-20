package abstraction;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class SCloudService implements CloudFile {
    @Override
    public List<FileInfo> getFiles() {
        return null;
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasUrl() {
        return false;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public void copyFromUrl(String url) {

    }

    @Override
    public void copyFromInputStream(InputStream in, String name) {

    }

    @Override
    public void write(FileOutputStream fileOutputStream) {

    }
}
