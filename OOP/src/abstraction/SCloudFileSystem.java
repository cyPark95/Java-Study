package abstraction;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SCloudFileSystem implements CloudFileSystem {

    @Override
    public List<FileInfo> getFileInfos() {
        return null;
    }

    @Override
    public void download(FileInfo file, File localTarget) throws IOException {

    }

    @Override
    public void copyFrom(CloudFile file) {

    }
}
