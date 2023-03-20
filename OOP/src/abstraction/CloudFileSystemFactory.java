package abstraction;

public class CloudFileSystemFactory {

    public static CloudFileSystem createCloudFileSystem(CloudId cloudId) {
        if (cloudId == CloudId.DROPBOX) {
            return new DropBoxFileSystem();
        } else if (cloudId == CloudId.BOX) {
            return new BoxFileSystem();
        }
        
        return null;
    }
}
