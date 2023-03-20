package abstraction;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class DropBoxCloudFile implements CloudFile {

    private DropBoxClient dBClient = new DropBoxClient();

    @Override
    public List<FileInfo> getFiles() {
        return dBClient.getFiles();
    }

    @Override
    public InputStream getInputStream() {
        return new BufferedInputStream(System.in);
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
        InputStream in = getInputStream();
    }
}
