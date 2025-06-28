class instruction extends Flags{
    void seperate(String line) {
        String[] parts = line.split("[ ,]+");
        String ins = parts[0];
        switch (ins) {
            case "mvi":
                mvi(parts);
                break;
            case "MVI":
                mvi(parts);
                break;
            case "mov":
                mov(parts);
                break;
            case "MOV":
                mov(parts);
                break;
            case "add":
                add(parts);
                break;
            case "ADD":
                add(parts);
                break;
            case "adi":
                adi(parts);
                break;
            case "ADI":
                adi(parts);
                break;
            case "sub":
                sub(parts);
                break;
            case "SUB":
                sub(parts);
                break;
            case "sui":
                sui(parts);
                break;
            case "SUI":
                sui(parts);
                break;
            case "INR":
                inr(parts);
                break;
            case "inr":
                inr(parts);
                break;
            case "dcr":
                dcr(parts);
                break;
            case "DCR":
                dcr(parts);
                break;
            case "cma":
                cma();
                break;
            case "CMA":
                cma();
                break;
            case "ana":
                ana(parts);
                break;
            case "ANA":
                ana(parts);
                break;
            case "ANI":
                ani(parts);
                break;
            case "ani":
                ani(parts);
                break;
            case "ora":
                ora(parts);
                break;
            case "ORA":
                ora(parts);
                break;
            case "ORI":
                ori(parts);
                break;
            case "ori":
                ori(parts);
                break;
            case "xra":
                xra(parts);
                break;
            case "XRA":
                xra(parts);
                break;
            case "XRI":
                xri(parts);
                break;
            case "xri":
                xri(parts);
                break;
            case "jmp":
                jmp(parts);
                break;
            case "JMP":
                jmp(parts);
                break;
            case "jz":
                jz(parts);
                break;
            case "JZ":
                jz(parts);
                break;
            case "JNZ":
                jnz(parts);
                break;
            case "jnz":
                jnz(parts);
                break;
        }
    }
    void mvi(String parts[]){
        try{
            String new_string = parts[2];
            if(new_string.endsWith("H") || new_string.endsWith("h")){
                new_string = parts[2].substring(0,parts[2].length()-1);
            }
            long val = Long.parseLong(new_string,16);
            registers.put(parts[1].toUpperCase(),val);
            program_Counter+=2;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void mov(String parts[]){
        try{
            String sender = parts[2].toUpperCase();
            String receiver = parts[1].toUpperCase();
            long val = registers.get(sender);
            registers.put(receiver,val);
            program_Counter+=1;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void add(String parts[]){
        try{
            String init = parts[1].toUpperCase();
            Long val = registers.get(init);
            Long val2 = registers.get("A");
            val = (val+val2) & 0xFF;
            registers.put("A",val);
            String Hex_value = Long.toHexString(registers.get("A"));
            System.out.println("Value of Accumulator after ADD operation is : 0" + Hex_value.toUpperCase() + "H");
            flags();
            program_Counter+=1;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void adi(String parts[]){
        try{
            String new_string = parts[1];
            if(new_string.endsWith("H") || new_string.endsWith("h")){
                new_string = parts[1].substring(0,parts[1].length()-1);
            }
            long val = Long.parseLong(new_string,16);
            val+=registers.get("A");
            val = val & 0xFF;
            registers.put("A",val);
            String Hex_value = Long.toHexString(registers.get("A"));
            System.out.println("Value of Accumulator after ADI operation is : 0" + Hex_value.toUpperCase() + "H");
            flags();
            program_Counter+=2;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void sub(String parts[]){
        try{
            String sender = parts[1].toUpperCase();
            Long val = registers.get(sender);
            Long val2 = registers.get("A");
            val2-=val;
            val2 = val2 & 0xFF;
            registers.put("A",val2);
            String Hex_value = Long.toHexString(registers.get("A"));
            System.out.println("Value of Accumulator after SUB operation is : 0" + Hex_value.toUpperCase() + "H");
            flags();
            program_Counter+=1;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
        
    }
    void sui(String parts[]){
        try{
            String new_string = parts[1];
            if(new_string.endsWith("H") || new_string.endsWith("h")){
                new_string = parts[1].substring(0,parts[1].length()-1);
            }
            long val = Long.parseLong(new_string,16);
            Long val2 = registers.get("A");
            val2 = val2-val;
            val2 = val2 & 0xFF;
            registers.put("A",val2);
            String Hex_value = Long.toHexString(registers.get("A"));
            System.out.println("Value of Accumulator after SUI operation is : 0" + Hex_value.toUpperCase() + "H");
            flags();
            program_Counter+=2;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void inr(String parts[]){
        try{
            String incrementer = parts[1].toUpperCase();
            Long val = registers.get(incrementer);
            val = (val+1)&0xFF;
            registers.put(incrementer,val);
            program_Counter+=1;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void dcr(String parts[]){
        try{
            String incrementer = parts[1].toUpperCase();
            Long val = registers.get(incrementer);
            val = (val-1)&0xFF;
            registers.put(incrementer,val);
            program_Counter+=1;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void cma(){
        try{
            Long val = registers.get("A");
            val = ~val & 0xFF; 
            registers.put("A",val);
            program_Counter+=1;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void ana(String parts[]){
        try{
            String reg = parts[1].toUpperCase();
            Long val = registers.get(reg);
            Long val2 = registers.get("A");
            val = (val & val2) & 0xFF;
            registers.put("A",val);
            program_Counter+=1;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void ani(String parts[]){
        try{
            String new_string = parts[1];
            if(new_string.endsWith("H") || new_string.endsWith("h")){
                new_string = parts[1].substring(0,parts[1].length()-1);
            }
            long val = Long.parseLong(new_string,16);
            Long val2 = registers.get("A");
            val2 = val2 & val;
            val2 = val2 & 0xFF;
            registers.put("A",val2);
            String Hex_value = Long.toHexString(registers.get("A"));
            flags();
            program_Counter+=2;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void ora(String parts[]){
        try{
            String reg = parts[1].toUpperCase();
            Long val = registers.get(reg);
            Long val2 = registers.get("A");
            val = (val|val2) & 0xFF;
            registers.put("A",val);
            program_Counter+=1;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void ori(String parts[]){
        try{
            String new_string = parts[1];
            if(new_string.endsWith("H") || new_string.endsWith("h")){
                new_string = parts[1].substring(0,parts[1].length()-1);
            }
            long val = Long.parseLong(new_string,16);
            Long val2 = registers.get("A");
            val2 = val2 | val;
            val2 = val2 & 0xFF;
            registers.put("A",val2);
            String Hex_value = Long.toHexString(registers.get("A"));
            flags();
            program_Counter+=2;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void xra(String parts[]){
        try{
            String reg = parts[1].toUpperCase();
            Long val = registers.get(reg);
            Long val2 = registers.get("A");
            val = (val^val2) & 0xFF;
            registers.put("A",val);
            program_Counter+=1;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void xri(String parts[]){
        try{
            String new_string = parts[1];
            if(new_string.endsWith("H") || new_string.endsWith("h")){
                new_string = parts[1].substring(0,parts[1].length()-1);
            }
            long val = Long.parseLong(new_string,16);
            Long val2 = registers.get("A");
            val2 = val2 ^ val;
            val2 = val2 & 0xFF;
            registers.put("A",val2);
            String Hex_value = Long.toHexString(registers.get("A"));
            flags();
            program_Counter+=2;
        }
        catch (Exception e) {
            System.out.println("Invalid instruction!!");
        }
    }
    void jmp(String parts[]){
        String val = parts[1].toUpperCase().replace("H", "");
        int address = Integer.parseInt(val,16);
        if(address<65536) program_Counter=address;
        else System.out.println("Invalid address");
    }
    void jz(String parts[]){
        if(registers.get("A")==0) {
            String val = parts[1].toUpperCase().replace("H", "");
            int address = Integer.parseInt(val,16);
            if(address<65536) program_Counter=address;
            else System.out.println("Invalid address");
        }
        else{
            program_Counter+=3;
        }
    }
    void jnz(String parts[]){
        if(registers.get("A")!=0) {
            String val = parts[1].toUpperCase().replace("H", "");
            int address = Integer.parseInt(val,16);
            if(address<65536) program_Counter=address;
            else System.out.println("Invalid address");
        }
        else{
            program_Counter+=3;
        }
    }
}
