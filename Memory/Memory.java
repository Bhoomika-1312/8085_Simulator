package memory;

public class Memory {
    private String[] memory;
    public Memory() {
        memory = new String[65536];
    }
    public void set(int address, String value) {
        memory[address] = value;
    }
    public String get(int address) {
        return memory[address];
    }
    public boolean hasInstruction(int address) {
        return memory[address] != null;
    }
}