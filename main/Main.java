// package main;

// import java.io.*;
// import java.util.*;
// import routes.*;

// public class Main {
//     public static void main(String[] args) {
//         Route i = new Route();
//         FileWriter writer = null;

//         try {
//             File file = new File("hey.txt");
//             writer = new FileWriter("log.txt", false);
//             i.setWriter(writer); 
//             Scanner sc = new Scanner(file);
//             i.program_Counter = 0x2000;
//             while (sc.hasNextLine()) {
//                 String line = sc.nextLine();
//                 i.update(line);
//             }
//             sc.close();
//             i.program_Counter = 0x2000;
//             while (i.Memory[i.program_Counter] != null) {
//                 i.log("Instruction: " + Integer.toHexString(i.program_Counter).toUpperCase() + "  : " + i.Memory[i.program_Counter] + "\n");
//                 i.seperate(i.Memory[i.program_Counter]);
//                 String flags = i.view_flags();
//                 i.log("Accumulator: " + Long.toHexString(i.registers.get("A")).toUpperCase() + "\n");
//                 i.log(flags+"  ");
//                 i.log("\n");
                
//             }
//         } catch (FileNotFoundException e) {
//             System.out.println("File not found: " + e.getMessage());
//         } catch (IOException e) {
//             System.out.println("IO error: " + e.getMessage());
//         } finally {
//             try {
//                 if (writer != null) writer.close();
//             } catch (IOException e) {
//                 System.out.println("Failed to close writer: " + e.getMessage());
//             }
//         }
//     }
// }


package main;

import java.io.*;
import java.util.*;
import routes.*;

public class Main {
    public static void main(String[] args) {
        Route simulator = new Route();
        try {
            File file = new File("hey.txt");
            Scanner sc = new Scanner(file);
            FileWriter writer = new FileWriter("log.txt", false);
            simulator.setWriter(writer);
            simulator.loadProgram(sc);
            simulator.execute();
            sc.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        }
    }
}