package memory;

public class Flags {

    private boolean zero;
    private boolean sign;
    private boolean parity;
    private boolean carry;
    private boolean auxiliaryCarry;  

    private Registers registers;

    public Flags(Registers registers) {
        this.registers = registers;
    }
    public void update(int result) {
        zero = (result & 0xFF) == 0;
        sign = (result & 0x80) != 0;

        int count = Integer.bitCount(result & 0xFF);
        parity = (count % 2 == 0);
        carry = (result > 255);
    }

    public void setCarry(boolean val) {
        carry = val;
    }
    public void setZero(boolean val) {
        zero = val;
    }
    public void setSign(boolean val) {
        sign = val;
    }
    public void setAuxiliaryCarry(boolean val) {  
        auxiliaryCarry = val;
    }
    public boolean isZero() {
        return zero;
    }
    public boolean isCarry() {
        return carry;
    }
    public void setParity(boolean val) {
        parity = val;
    }
   public String view() {
        return "FLAGS -> Z:" + zero +
               " S:" + sign +
               " P:" + parity +
               " C:" + carry +
               " AC:" + auxiliaryCarry;  
    }
}