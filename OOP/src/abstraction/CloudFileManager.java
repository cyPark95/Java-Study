package abstraction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CloudFileManager {

    public List<FileInfo> getFileInfos(CloudId cloudId) {
        if (cloudId == CloudId.DROPBOX) {
            DropBoxClient dDClient = new DropBoxClient();
            // ...
            return dDClient.getFiles();
        } else if (cloudId == CloudId.BOX) {
            BoxService boxSvc = new BoxService();
            // ...
            return boxSvc.getFiles();
        }

        return null;
    }

    public void download(FileInfo file, File localTarget) throws IOException {
        if (file.getCloudId() == CloudId.DROPBOX) {
            DropBoxClient dc = new DropBoxClient();
            FileOutputStream out = new FileOutputStream(localTarget);
            out.close();
        } else if (file.getCloudId() == CloudId.BOX) {
            BoxService boxSvc = new BoxService();
            InputStream in = boxSvc.getInputStream(file.getFileId());
            FileOutputStream out = new FileOutputStream(localTarget);
        }
    }

    public FileInfo copy(FileInfo fileInfo, CloudId to) {
        CloudId from = fileInfo.getCloudId();
        if (to == CloudId.DROPBOX) {
            DropBoxClient dbClient = new DropBoxClient();
            if (from == CloudId.BOX) {
                // ...
            }
        } else if (to == CloudId.BOX) {
            BoxService boxService = new BoxService();
            if (from == CloudId.DROPBOX) {
                // ...
            }
        }

        return null;
    }
}
