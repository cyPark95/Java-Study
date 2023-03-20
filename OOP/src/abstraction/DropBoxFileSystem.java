package abstraction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DropBoxFileSystem implements CloudFileSystem {

    DropBoxCloudFile dBCloutFile = new DropBoxCloudFile();

    @Override
    public List<FileInfo> getFileInfos() {
        // ...
        return dBCloutFile.getFiles();
    }

    @Override
    public void download(FileInfo file, File localTarget) throws IOException {
        FileOutputStream out = new FileOutputStream(localTarget);
        out.close();
    }

    @Override
    public void copyFrom(CloudFile file) {
        if (file.hasUrl()) {
            dBCloutFile.copyFromUrl(file.getUrl());
        } else {
            dBCloutFile.copyFromInputStream(file.getInputStream(), file.getName());
        }
    }
}
