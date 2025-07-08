package Memory;
public class Instruction extends Log{
    public void mvi(String parts[]){
        try{
            String new_string = parts[2].toUpperCase();
            if(new_string.endsWith("H") || new_string.endsWith("h")){
                new_string = parts[2].substring(0,parts[2].length()-1);
            }
            long val = Long.parseLong(new_string,16);
            registers.put(parts[1].toUpperCase(),val);
            program_Counter+=2;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void mov(String parts[]){
        try{
            String sender = parts[2].toUpperCase();
            String receiver = parts[1].toUpperCase();
            long val = registers.get(sender);
            registers.put(receiver,val);
            program_Counter+=1;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void add(String parts[]){
        try{
            String init = parts[1].toUpperCase();
            Long val = registers.get(init);
            Long val2 = registers.get("A");
            val = (val+val2) & 0xFF;
            registers.put("A",val);
            String Hex_value = Long.toHexString(registers.get("A"));
            program_Counter+=1;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void adi(String parts[]){
        try{
            String new_string = parts[1].toUpperCase();
            if(new_string.endsWith("H") || new_string.endsWith("h")){
                new_string = parts[1].substring(0,parts[1].length()-1);
            }
            long val = Long.parseLong(new_string,16);
            val+=registers.get("A");
            val = val & 0xFF;
            registers.put("A",val);
            String Hex_value = Long.toHexString(registers.get("A"));
            program_Counter+=2;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void sub(String parts[]){
        try{
            String sender = parts[1].toUpperCase();
            Long val = registers.get(sender);
            Long val2 = registers.get("A");
            val2-=val;
            val2 = val2 & 0xFF;
            registers.put("A",val2);
            String Hex_value = Long.toHexString(registers.get("A"));
            program_Counter+=1;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
        
    }
    public void sui(String parts[]){
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
            program_Counter+=2;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void inr(String parts[]){
        try{
            String incrementer = parts[1].toUpperCase();
            Long val = registers.get(incrementer);
            val = (val+1)&0xFF;
            registers.put(incrementer,val);
            program_Counter+=1;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void dcr(String parts[]){
        try{
            String incrementer = parts[1].toUpperCase();
            Long val = registers.get(incrementer);
            val = (val-1)&0xFF;
            registers.put(incrementer,val);
            program_Counter+=1;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void cma(){
        try{
            Long val = registers.get("A");
            val = ~val & 0xFF; 
            registers.put("A",val);
            program_Counter+=1;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void ana(String parts[]){
        try{
            String reg = parts[1].toUpperCase();
            Long val = registers.get(reg);
            Long val2 = registers.get("A");
            val = (val & val2) & 0xFF;
            registers.put("A",val);
            program_Counter+=1;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void ani(String parts[]){
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
            program_Counter+=2;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void ora(String parts[]){
        try{
            String reg = parts[1].toUpperCase();
            Long val = registers.get(reg);
            Long val2 = registers.get("A");
            val = (val|val2) & 0xFF;
            registers.put("A",val);
            program_Counter+=1;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void ori(String parts[]){
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
            program_Counter+=2;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void xra(String parts[]){
        try{
            String reg = parts[1].toUpperCase();
            Long val = registers.get(reg);
            Long val2 = registers.get("A");
            val = (val^val2) & 0xFF;
            registers.put("A",val);
            program_Counter+=1;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void xri(String parts[]){
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
            program_Counter+=2;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void jmp(String parts[]){
        try{
            String val = parts[1].toUpperCase().replace("H", "");
            int address = Integer.parseInt(val,16);
            if(address<65536) program_Counter=address;
            else log("Invalid address");
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void jz(String parts[]){
        try{
            if(registers.get("A")==0) {
                String val = parts[1].toUpperCase().replace("H", "");
                int address = Integer.parseInt(val,16);
                if(address<65536) program_Counter=address;
                else log("Invalid address");
            }
            else{
                program_Counter+=3;
            }
        } 
        catch (Exception e) {
            log("Invalid instruction!!");
        }   
    }
    public void jnz(String parts[]){
        try{
            if(registers.get("A")!=0) {
                String val = parts[1].toUpperCase().replace("H", "");
                int address = Integer.parseInt(val,16);
                if(address<65536) program_Counter=address;
                else log("Invalid address");
            }
            else{
                program_Counter+=3;
            }
        } 
        catch (Exception e) {
            log("Invalid instruction!!");
        }   
    }
    public void sta(String parts[]){
        Long val = registers.get("A");
        String part = parts[1].replace("H"," ").trim();
        int address = Integer.parseInt(part, 16);
        Memory[address] = String.format("%02X", val & 0xFF);
        program_Counter+=3;
        flags();
    }
    public void lda(String parts[]){
        String address = parts[1].toUpperCase().replace("H"," ").trim();
        int val = Integer.parseInt(address,16);
        String total = Memory[val];
        Long number = Long.parseLong(total);
        registers.put("A",number);
        program_Counter+=3;
    }
    public void aci(String parts[]){
        try{
            String new_string = parts[1];
            if(new_string.endsWith("H") || new_string.endsWith("h")){
                new_string = parts[1].substring(0,parts[1].length()-1);
            }
            long val = Long.parseLong(new_string,16);
            int bool = (Carry==true) ? 1 : 0;
            aux_carry(val+bool);
            val+=registers.get("A")+bool;
            carry(val);
            val = val & 0xFF;
            registers.put("A",val);
            String Hex_value = Long.toHexString(registers.get("A"));
            program_Counter+=2;
            flags();
        }
        catch (Exception e) {
            log("Invalid instruction!!");
        }
    }
    public void cmc(){
        Carry = !Carry;
        program_Counter+=1;
        flags();
    }
    public void cpi(String parts[]){
        String data = parts[1].toUpperCase().replace("H","").trim();
        int comp = Integer.parseInt(data,16);
        long val = registers.get("A");
        if(val<comp) {
            Carry = true;
            Zero = false;
        }
        else if(val==comp) {
            Zero = true;
            Carry = false;
        }
        else {
            Carry = false;
            Zero = false;
        }
        program_Counter+=2;
        flags();
    }
}
