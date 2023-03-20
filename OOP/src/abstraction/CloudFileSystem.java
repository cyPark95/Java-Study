package abstraction;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface CloudFileSystem {

    List<FileInfo> getFileInfos();

    void download(FileInfo file, File localTarget) throws IOException;

    void copyFrom(CloudFile file);
}
