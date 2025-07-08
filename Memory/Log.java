package Memory;
import java.io.FileWriter;
import java.io.IOException;

public class Log extends Flags{
    protected FileWriter writer;
    public void setWriter(FileWriter writer) {
        this.writer = writer;
    }
    public void log(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}