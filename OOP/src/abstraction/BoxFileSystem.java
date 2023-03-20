package abstraction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BoxFileSystem implements CloudFileSystem {

    private CloudFile bCloudFile = new BoxCloudFile();

    @Override
    public List<FileInfo> getFileInfos() {
        return bCloudFile.getFiles();
    }

    @Override
    public void download(FileInfo file, File localTarget) throws IOException {
        InputStream in = bCloudFile.getInputStream();
        FileOutputStream out = new FileOutputStream(localTarget);
    }

    @Override
    public void copyFrom(CloudFile file) {
        if (file.hasUrl()) {
            bCloudFile.copyFromUrl(file.getUrl());
        } else {
            bCloudFile.copyFromInputStream(file.getInputStream(), file.getName());
        }
    }
}
