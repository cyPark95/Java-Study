package abstraction;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class BoxCloudFile implements CloudFile {

    private BoxService bSvc = new BoxService();

    @Override
    public List<FileInfo> getFiles() {
        return bSvc.getFiles();
    }

    @Override
    public InputStream getInputStream() {
        return bSvc.getInputStream();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasUrl() {
        return true;
    }

    @Override
    public String getUrl() {
        return "url";
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
