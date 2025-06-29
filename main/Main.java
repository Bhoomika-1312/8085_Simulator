package main;
import java.io.*;
import java.util.*;
import routes.*;
public class Main{
    public static void main(String[] args){
        Route i = new Route();  
        try{
            File file = new File("hey.txt");
            Scanner sc = new Scanner(file);
            i.program_Counter = 0x2000;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                i.update(line);
            } 
            sc.close();
            i.program_Counter = 0x2000;
            while(i.Memory[i.program_Counter]!=null) {
                i.seperate(i.Memory[i.program_Counter]);
            }
            System.out.println(i.Memory[8272]);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}

