package abstraction;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BoxService {
    public InputStream getInputStream() {
        return null;
    }

    public List<FileInfo> getFiles() {
        return new ArrayList<>();
    }
}
