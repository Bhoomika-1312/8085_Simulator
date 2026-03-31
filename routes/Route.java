package routes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import memory.Memory;
import memory.Registers;
import memory.Flags;
import memory.Log;
import memory.Instruction;

public class Route {
    private Registers registers;
    private Memory memory;
    private Flags flags;
    private Instruction instruction;
    private Log log;
    public Route() {
        registers = new Registers();
        memory = new Memory();
        flags = new Flags(registers);
        log = new Log();
        instruction = new Instruction(registers, memory, flags, log);
    }
    public void setWriter(FileWriter writer) {
        log.setWriter(writer);
    }
    public void loadProgram(Scanner sc) {
        int address = 0x2000;
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                memory.set(address, line);
                String ins = line.split(" ")[0];
                address += instruction.getSize(ins);
            }
        }
    }
    public void execute() {
        int pc = 0x2000;
        while (memory.get(pc) != null) {
            String instr = memory.get(pc);
            try{
                log.write("Instruction: " + instr);
                pc = instruction.execute(instr, pc);
                log.write("Accumulator: " + Integer.toHexString(registers.get("A")).toUpperCase());
                log.write("Program Counter: " + Integer.toHexString(pc).toUpperCase());
                log.write(flags.view());
                log.write("\n");
            
            } catch (Exception e) {
                System.out.println("Error at instruction: " + instr);
                System.out.println(e.getMessage());
            }
        }
    }
}
