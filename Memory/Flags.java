package Memory;

class Flags extends Memory{
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
    void view_flags(){
        System.out.println("ZERO FLAG :" + Zero);
        System.out.println("PARITY FLAG :" + Parity);
        System.out.println("SIGN FLAG :" + Sign);
        System.out.println("AUXILIARY FLAG :" + Auxiliary_carry);
        System.out.println("CARRY FLAG :" + Carry);
        return ;
    }
    void flags(){
        changes_flags();
        view_flags();
    }
}
