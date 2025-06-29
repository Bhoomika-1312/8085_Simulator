package Memory;
import java.util.Map;
import java.util.HashMap;

class Registers{
    public Map<String, Long> registers = new HashMap<>();
    public Registers() {
        registers.put("A", 0L);
        registers.put("B", 0L);
        registers.put("C", 0L);
        registers.put("D", 0L);
        registers.put("E", 0L);
        registers.put("H", 0L);
        registers.put("L", 0L);
    }

}
