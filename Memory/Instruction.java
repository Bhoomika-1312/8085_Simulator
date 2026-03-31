package memory;
import java.util.Map;
import java.util.HashMap;
public class Instruction {

    private Registers registers;
    private Memory memory;
    private Flags flags;
    private Log log;
    private Map<String, Integer> size;
    public Instruction(Registers r, Memory m, Flags f, Log l) {
        size = new HashMap<>();

        size.put("MOV", 1);
        size.put("ADD", 1);
        size.put("SUB", 1);
        size.put("INR", 1);
        size.put("DCR", 1);
        size.put("CMA", 1);
        size.put("CMC", 1);
        // size.put("RAL", 1);
        // size.put("RAR", 1);
        // size.put("RLC", 1);
        // size.put("RRC", 1);
        size.put("HLT", 1);
        size.put("MVI", 2);
        size.put("ADI", 2);
        size.put("ACI", 2);
        size.put("SUI", 2);
        size.put("SBI", 2);
        size.put("ANI", 2);
        size.put("ORI", 2);
        size.put("XRI", 2);
        size.put("CPI", 2);
        size.put("LDA", 3);
        size.put("STA", 3);
        // size.put("LHLD", 3);
        // size.put("SHLD", 3);
        size.put("JMP", 3);
        size.put("JZ", 3);
        size.put("JNZ", 3);
        // size.put("JC", 3);
        // size.put("JNC", 3);
        // size.put("CALL", 3);
        // size.put("CZ", 3);
        // size.put("CNZ", 3);
        this.registers = r;
        this.memory = m;
        this.flags = f;
        this.log = l;
    }
    public int getSize(String ins) {
        return size.getOrDefault(ins.toUpperCase(), 1);
    }
    private boolean calculateParity(int value) {
        return Integer.bitCount(value & 0xFF) % 2 == 0;
    }
    // Main execute function
    public int execute(String line, int pc) {

        String[] parts = line.split("[ ,]+");
        String ins = parts[0].toUpperCase();

        switch (ins) {
            case "MVI":
                return mvi(parts)+pc;
            case "MOV":
                return mov(parts)+pc;
            case "ADD":
                return add(parts)+pc;  
            case "ADI":
                return adi(parts)+pc;
            case "SUB":
                return sub(parts)+pc;
            case "SUI":
                return sui(parts)+pc;
            case "INR":
                return inr(parts)+pc;
            case "DCR":
                return dcr(parts)+pc;
            case "CMA":
                return cma()+pc;
            case "XRI":
                return xri(parts)+pc;
            case "JMP":
                return jmp(parts);
            case "JZ":
                return jz(parts);
            case "JNZ":
                return jnz(parts);
            case "STA":
                return sta(parts)+pc;
            case "LDA":
                return lda(parts)+pc;
            case "ACI":
                return aci(parts)+pc;
            case "CMC":
                return cmc()+pc;
            case "CPI":
                System.out.println("Executing CPI with operand: " + parts[1]);
                return cpi(parts)+pc;
            case "ANA":
                return ana(parts)+pc;
            case "ANI":
                return ani(parts)+pc;
            case "ORA":
                return ora(parts)+pc;
            case "XRA":
                return xra(parts)+pc;
            default:
                log.write("Break instruction: " + ins);
                return 0;
        }
    }


    private int mvi(String parts[]) {
        try {
            String valStr = parts[2].toUpperCase().replace("H", "");
            int val = Integer.parseInt(valStr, 16);

            String reg = parts[1].toUpperCase();
            registers.set(reg, val);

            if (!reg.equals("A")) {
                log.write("Register " + reg + " : " +
                    Integer.toHexString(val).toUpperCase());
            }

            return 2;

        } catch (Exception e) {
            log.write("Invalid MVI");
            return 1;
        }
    }
    private int mov(String parts[]) {
        try {
            String dest = parts[1].replace(",", "").toUpperCase();
            String src = parts[2].toUpperCase();
            System.out.println("MOV " + dest + src);

            int val = registers.get(src);
            registers.set(dest, val);

            if (!dest.equals("A")) {
                log.write("Register " + dest + " : " +
                    Integer.toHexString(val).toUpperCase());
            }

            return 1;

        } catch (Exception e) {
            log.write("Invalid MOV");
            return 1;
        }
    }
    private int add(String parts[]) {
        try {
            String reg = parts[1].toUpperCase();

            int val1 = registers.get("A");
            int val2 = registers.get(reg);

            int result = val1 + val2;

            flags.setParity(calculateParity(result & 0xFF));
            flags.setCarry(result > 255);
            flags.setZero((result & 0xFF) == 0);
            flags.setSign((result & 0x80) != 0);
            flags.setAuxiliaryCarry(((val1 & 0x0F) + (val2 & 0x0F)) > 0x0F);
            registers.set("A", result & 0xFF);
            return 1;

        } catch (Exception e) {
            log.write("Invalid ADD");
            return 1;
        }
    }
    private int adi(String parts[]) {
        try {
            String valStr = parts[1].toUpperCase().replace("H", "");
            int val = Integer.parseInt(valStr, 16);

            int acc = registers.get("A");

            int result = acc + val;
            flags.setParity(calculateParity(result & 0xFF));
            flags.setCarry(result > 255);
            flags.setZero((result & 0xFF) == 0);
            flags.setSign((result & 0x80) != 0);
            flags.setAuxiliaryCarry(((acc & 0x0F) + (val & 0x0F)) > 0x0F);

            registers.set("A", result & 0xFF);

            return 2;

        } catch (Exception e) {
            log.write("Invalid ADI");
            return 1;
        }
    }
    private int sub(String parts[]) {
        try {
            String reg = parts[1].toUpperCase();

            int acc = registers.get("A");
            int val = registers.get(reg);

            int result = acc - val;
            flags.setParity(calculateParity(result & 0xFF));
            flags.setCarry(acc < val); 
            flags.setZero((result & 0xFF) == 0);
            flags.setSign((result & 0x80) != 0);
            flags.setAuxiliaryCarry((acc & 0x0F) < (val & 0x0F));

            registers.set("A", result & 0xFF);

            return 1;

        } catch (Exception e) {
            log.write("Invalid SUB");
            return 1;
        }
    }
    private int sui(String parts[]) {
        try {
            String valStr = parts[1].toUpperCase().replace("H", "");
            int val = Integer.parseInt(valStr, 16);

            int acc = registers.get("A");

            int result = acc - val;

            flags.setParity(calculateParity(result & 0xFF));
            flags.setCarry(acc < val);
            flags.setZero((result & 0xFF) == 0);
            flags.setSign((result & 0x80) != 0);
            flags.setAuxiliaryCarry((acc & 0x0F) < (val & 0x0F));

            registers.set("A", result & 0xFF);

            return 2;

        } catch (Exception e) {
            log.write("Invalid SUI");
            return 1;
        }
    }
    private int inr(String[] parts) {
        try {
            String reg = parts[1].toUpperCase();
            int val = registers.get(reg);

            flags.setAuxiliaryCarry(((val & 0x0F) + 1) > 0x0F);

            val = (val + 1) & 0xFF;

            flags.setParity(calculateParity(val));
            flags.setZero(val == 0);
            flags.setSign((val & 0x80) != 0);

            registers.set(reg, val);

            return 1;

        } catch (Exception e) {
            log.write("Invalid INR");
            return 1;
        }
    }
    private int dcr(String[] parts) {
        try {
            String reg = parts[1].toUpperCase();
            int val = registers.get(reg);

            flags.setAuxiliaryCarry((val & 0x0F) == 0);

            val = (val - 1) & 0xFF;

            flags.setParity(calculateParity(val));
            flags.setZero(val == 0);
            flags.setSign((val & 0x80) != 0);

            registers.set(reg, val);

            return 1;

        } catch (Exception e) {
            log.write("Invalid DCR");
            return 1;
        }
    }
    private int cma() {
        int val = registers.get("A");
        val = (~val) & 0xFF;
        registers.set("A", val);
        return 1;
    }
    private int ana(String[] parts) {
        int val = registers.get(parts[1].toUpperCase());
        int acc = registers.get("A");

        int result = (val & acc) & 0xFF;

        registers.set("A", result);

        flags.setParity(calculateParity(result));
        flags.setCarry(false);
        flags.setAuxiliaryCarry(true);
        flags.setZero(result == 0);
        flags.setSign((result & 0x80) != 0);

        return 1;
    }
    private int ani(String[] parts) {
        int val = Integer.parseInt(parts[1].replace("H",""), 16);
        int acc = registers.get("A");

        int result = (acc & val) & 0xFF;

        registers.set("A", result);

        flags.setParity(calculateParity(result));
        flags.setCarry(false);
        flags.setAuxiliaryCarry(true);
        flags.setZero(result == 0);
        flags.setSign((result & 0x80) != 0);

        return 2;
    }
    private int ora(String[] parts) {
        int val = registers.get(parts[1].toUpperCase());
        int acc = registers.get("A");

        int result = (val | acc) & 0xFF;

        registers.set("A", result);

        flags.setParity(calculateParity(result));
        flags.setCarry(false);
        flags.setAuxiliaryCarry(false);
        flags.setZero(result == 0);
        flags.setSign((result & 0x80) != 0);

        return 1;
    }
    private int ori(String[] parts) {
        int val = Integer.parseInt(parts[1].replace("H",""), 16);
        int acc = registers.get("A");

        int result = (acc | val) & 0xFF;

        registers.set("A", result);

        flags.setParity(calculateParity(result));
        flags.setCarry(false);
        flags.setAuxiliaryCarry(false);
        flags.setZero(result == 0);
        flags.setSign((result & 0x80) != 0);

        return 2;
    }
    private int xra(String[] parts) {
        int val = registers.get(parts[1].toUpperCase());
        int acc = registers.get("A");

        int result = (val ^ acc) & 0xFF;

        registers.set("A", result);
        
        flags.setParity(calculateParity(result));
        flags.setCarry(false);
        flags.setAuxiliaryCarry(false);
        flags.setZero(result == 0);
        flags.setSign((result & 0x80) != 0);

        return 1;
    }
    private int xri(String parts[]) {
        try {
            int data = Integer.parseInt(parts[1], 16);

            int val1 = registers.get("A");
            int result = val1 ^ data;

            flags.setZero((result & 0xFF) == 0);
            flags.setSign((result & 0x80) != 0);
            flags.setParity(calculateParity(result & 0xFF));

            flags.setCarry(false);
            flags.setAuxiliaryCarry(false);

            registers.set("A", result & 0xFF);
            return 2;

        } catch (Exception e) {
            log.write("Invalid XRI");
            return 2;
        }
    }
    private int jmp(String parts[]) {
        try {
            int addr = Integer.parseInt(parts[1], 16);
            return addr ;

        } catch (Exception e) {
            log.write("Invalid JMP");
            return 0;
        }
    }
    private int jz(String parts[]) {
        try {
            int addr = Integer.parseInt(parts[1], 16);

            if (flags.isZero()) {
                return addr; 
            }
            return 3;   
        } catch (Exception e) {
            log.write("Invalid JZ");
            return 3;
        }
    }
    private int jnz(String parts[]) {
        try {
            int addr = Integer.parseInt(parts[1], 16);

            if (!flags.isZero()) {
                return addr;
            }
            return 3;

        } catch (Exception e) {
            log.write("Invalid JNZ");
            return 3;
        }
    }
    private int sta(String parts[]) {
        try {
            int addr = Integer.parseInt(parts[1], 16);
            memory.set(addr, Integer.toHexString(registers.get("A")).toUpperCase());
            return 3;

        } catch (Exception e) {
            log.write("Invalid STA");
            return 3;
        }
    }
    private int lda(String parts[]) {
        try {
            int addr = Integer.parseInt(parts[1], 16);
            int value = Integer.parseInt(memory.get(addr), 16);
            registers.set("A", value);
            return 3;

        } catch (Exception e) {
            log.write("Invalid LDA");
            return 3;
        }
    }
    private int aci(String parts[]) {
        try {
            int data = Integer.parseInt(parts[1], 16);

            int val1 = registers.get("A");
            int carry = flags.isCarry() ? 1 : 0;

            int result = val1 + data + carry;

            flags.setZero((result & 0xFF) == 0);
            flags.setSign((result & 0x80) != 0);
            flags.setParity(calculateParity(result & 0xFF));
            flags.setCarry(result > 255);
            flags.setAuxiliaryCarry(((val1 & 0x0F) + (data & 0x0F) + carry) > 0x0F);

            registers.set("A", result & 0xFF);
            return 2;

        } catch (Exception e) {
            log.write("Invalid ACI");
            return 2;
        }
    }
    private int cmc() {
        flags.setCarry(!flags.isCarry());
        return 1;
    }
    private int cpi(String parts[]) {
        try {
            // System.out.println("Executing CPI with operand: " + parts[1]);
            String dataStr = parts[1].replace("H", "").replace("h", "");
            int data = Integer.parseInt(dataStr, 16);
            int val1 = registers.get("A");
            int result = val1 - data;
            flags.setZero((result & 0xFF) == 0);
            flags.setSign((result & 0x80) != 0);
            flags.setParity(calculateParity(result & 0xFF));
            flags.setCarry(result < 0);
            flags.setAuxiliaryCarry((val1 & 0x0F) < (data & 0x0F));

            return 2;

        } catch (Exception e) {
            log.write("Invalid CPI");
            return 2;
        }
    }
}
