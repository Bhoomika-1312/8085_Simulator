package main;

import java.io.*;
import java.util.*;
import routes.*;

public class Main {
    public static void main(String[] args) {
        Route i = new Route();
        FileWriter writer = null;

        try {
            File file = new File("hey.txt");
            writer = new FileWriter("log.txt", false);
            i.setWriter(writer); 
            Scanner sc = new Scanner(file);
            i.program_Counter = 0x2000;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                i.update(line);
            }
            sc.close();
            i.program_Counter = 0x2000;
            while (i.Memory[i.program_Counter] != null) {
                i.seperate(i.Memory[i.program_Counter]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Failed to close writer: " + e.getMessage());
            }
        }
    }
}
