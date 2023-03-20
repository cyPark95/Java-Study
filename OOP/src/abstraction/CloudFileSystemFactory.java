package abstraction;

public class CloudFileSystemFactory {

    public static CloudFileSystem createCloudFileSystem(CloudId cloudId) {
        if (cloudId == CloudId.DROPBOX) {
            return new DropBoxFileSystem();
        } else if (cloudId == CloudId.BOX) {
            return new BoxFileSystem();
        } else if (cloudId == CloudId.SCLOUD) {
            return new SCloudFileSystem();
        }
        
        return null;
    }
}
