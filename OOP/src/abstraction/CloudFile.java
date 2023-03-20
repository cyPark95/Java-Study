package abstraction;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public interface CloudFile {

    List<FileInfo> getFiles();

    InputStream getInputStream();

    String getName();

    boolean hasUrl();

    String getUrl();

    void copyFromUrl(String url);

    void copyFromInputStream(InputStream in, String name);

    void write(FileOutputStream fileOutputStream);
}
