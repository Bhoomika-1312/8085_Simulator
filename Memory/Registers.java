package memory;

import java.util.Map;
import java.util.HashMap;

public class Registers {
    private Map<String, Integer> registers;
    public Registers() {
        registers = new HashMap<>();
        registers.put("A", 0);
        registers.put("B", 0);
        registers.put("C", 0);
        registers.put("D", 0);
        registers.put("E", 0);
        registers.put("H", 0);
        registers.put("L", 0);
    }
    public int get(String reg) {
        return registers.getOrDefault(reg.toUpperCase(), 0);
    }
    public void set(String reg, int value) {
        registers.put(reg.toUpperCase(), value);
    }
}