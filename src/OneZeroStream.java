//TODO 9.2.1
import java.io.InputStream;

public class OneZeroStream extends InputStream {
    private byte[] bytesArrays = {'1',' ', '0',' '};
    int i = 0;

    public int read() {
        if (i >= bytesArrays.length)
            i = 0;
        return bytesArrays[i++];

    }
}
