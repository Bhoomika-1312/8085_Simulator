package memory;

import java.io.FileWriter;
import java.io.IOException;

public class Log {

    private FileWriter writer;

    public void setWriter(FileWriter writer) {
        this.writer = writer;
    }

    public void write(String message) {
        try {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}