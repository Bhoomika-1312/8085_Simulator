
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
            
        }
    }
    void mvi(String parts[]){
        String new_string = parts[2];
        if(new_string.endsWith("H") || new_string.endsWith("h")){
            new_string = parts[2].substring(0,parts[2].length()-1);
        }
        long val = Long.parseLong(new_string,16);
        registers.put(parts[1].toUpperCase(),val);
    }
    void mov(String parts[]){
        String sender = parts[2].toUpperCase();
        String receiver = parts[1].toUpperCase();
        long val = registers.get(sender);
        registers.put(receiver,val);
    }
    void add(String parts[]){
        String init = parts[1].toUpperCase();
        Long val = registers.get(init);
        Long val2 = registers.get("A");
        registers.put("A",val+val2);
        String Hex_value = Long.toHexString(registers.get("A"));
        changes_flags();
        System.out.println("Value of Accumulator after add operation is :" + Hex_value.toUpperCase() + "H");
    }

}
