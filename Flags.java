class Flags extends Memory{
    boolean Parity = false;
    boolean Zero = false;
    boolean Auxiliary_carry = false;
    boolean Sign = false;
    boolean Carry = false;

    void changes_flags(){
        if(registers.get("A")==0) Zero = true;
        else Zero = false;
        if(registers.get("A")<0) Sign = true;
        else Sign = false;
        int count = 0;
        Long val = registers.get("A");
        while(val!=0) {
            if((val & 1) == 1) count++;
            val = val>>1;
        }
        
        if(count%2==0)  Parity = true;
        else Parity = false;
        return;
    }
    void view_flags(){
        System.out.println("ZERO FLAG :" + Zero);
        System.out.println("PARITY FLAG :" + Parity);
        System.out.println("SIGN FLAG :" + Sign);
        // System.out.println("zERO FLAG :" + Zero);
        // System.out.println("zERO FLAG :" + Zero);
        return ;
    }

    void flags(){
        changes_flags();
        view_flags();
    }
}
