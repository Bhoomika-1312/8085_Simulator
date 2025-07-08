package Memory;

public class Flags extends MAIN_Memory{
    public boolean Parity = false;
    public boolean Zero = false;
    public boolean Auxiliary_carry = false;
    public boolean Sign = false;
    public boolean Carry = false;

    void zero(){
        if(registers.get("A")==0) Zero = true;
        else Zero = false;
    }
    void sign(){
        if(registers.get("A")<0) Sign = true;
        else Sign = false;
    }
    void parity(){
        int count = 0;
        Long val = registers.get("A");
        while(val!=0) {
            if((val & 1) == 1) count++;
            val = val>>1;
        }
        if(count%2==0)  Parity = true;
        else Parity = false;
    }
    void carry(Long result){
        Carry = (result > 256) ? true : false;
    }
    void aux_carry(Long value){
        Long lowerNibbleSum = (registers.get("A") & 0x0F) + (value & 0x0F);
        Auxiliary_carry = (lowerNibbleSum > 0x0F) ? true : false;
    }
    void changes_flags(){
        zero();
        sign();
        parity();
    }
    public String view_flags(){
        String content = ("FLAGS: " + "\n"+ " Sign: " + Sign + "\n" + " Parity: "  + Parity + "\n" + " Zero: " +Zero + "\n" + " Auxiliary Carry: " + Auxiliary_carry + "\n" + " Carry: " + Carry + "\n");
        return content;
    }
    void flags(){
        changes_flags();
    }
}
