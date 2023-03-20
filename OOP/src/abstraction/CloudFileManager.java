package abstraction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CloudFileManager {

    public List<FileInfo> getFileInfos(CloudId cloudId) {
        CloudFileSystem fileSystem = CloudFileSystemFactory.createCloudFileSystem(cloudId);
        return fileSystem.getFileInfos();
    }

    public void download(CloudFile file, File localTarget) throws IOException {
        file.write(new FileOutputStream(localTarget));
    }

    public void copy(CloudFile file, CloudId target) {
        CloudFileSystem fileSystem = CloudFileSystemFactory.createCloudFileSystem(target);
        fileSystem.copyFrom(file);
    }
}
