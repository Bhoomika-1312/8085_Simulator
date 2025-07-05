package Memory;

class Memory extends Bits{
    public String Memory[] = new String[65536];

    public void update(String line){
        String[] parts = line.split("[ ,]+");
        String ins = parts[0];
        ins = ins.toUpperCase();
        switch (ins) {
            case "MVI": {
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                String replaced_string = parts[2].toUpperCase().replace("H"," ").trim();
                Long hexval = Long.parseLong(replaced_string,16);
                Memory[program_Counter] = String.format("%02X", hexval & 0xFF);
                program_Counter += 1;
                break;}
            case "MOV":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                break;
                }
            case "ADD":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                break;
                }
            case "ADI":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                String replaced_string = parts[1].toUpperCase().replace("H"," ").trim();
                Long hexval = Long.parseLong(replaced_string,16);
                Memory[program_Counter] = String.format("%02X", hexval & 0xFF);
                program_Counter += 1;
                break;
                }
            case "SUB":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                break;
                }
            case "SUI":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                String replaced_string = parts[1].replace("H"," ").trim();
                Long hexval = Long.parseLong(replaced_string,16);
                Memory[program_Counter] = String.format("%02X", hexval & 0xFF);
                program_Counter += 1;
                break;
                }
            case "INR":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                break;
                }
            case "DCR":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                break;
                }
            case "CMA":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                break;
                }
            case "ANA":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                break;
                }
            case "ANI":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                String replaced_string = parts[1].replace("H"," ").trim();
                Long hexval = Long.parseLong(replaced_string,16);
                Memory[program_Counter] = String.format("%02X", hexval & 0xFF);
                program_Counter += 1;
                break;
                }
            case "ORA":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                break;
                }
            case "ORI":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                String replaced_string = parts[1].replace("H"," ").trim();
                Long hexval = Long.parseLong(replaced_string,16);
                Memory[program_Counter] = String.format("%02X", hexval & 0xFF);
                program_Counter += 1;
                break;
                }
            case "XRA":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                break;
                }
            case "XRI":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                String replaced_string = parts[1].replace("H"," ").trim();
                Long hexval = Long.parseLong(replaced_string,16);
                Memory[program_Counter] = String.format("%02X", hexval & 0xFF);
                program_Counter += 1;
                break;
                }
            case "JMP":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                String replaced_string = parts[1].replace("H"," ").trim();
                Long hexval = Long.parseLong(replaced_string,16);
                Memory[program_Counter] = String.format("%02X", hexval & 0xFF);
                program_Counter += 1;
                Memory[program_Counter] = String.format("%02X",(hexval>>8)&0xFF);
                program_Counter += 1;
                break;
                }
            case "JZ":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                String replaced_string = parts[1].replace("H"," ").trim();
                Long hexval = Long.parseLong(replaced_string,16);
                Memory[program_Counter] = String.format("%02X", hexval & 0xFF);
                program_Counter += 1;
                Memory[program_Counter] = String.format("%02X",(hexval>>8)&0xFF);
                program_Counter += 1;
                break;
                }
            case "JNZ":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                String replaced_string = parts[1].replace("H"," ").trim();
                Long hexval = Long.parseLong(replaced_string,16);
                Memory[program_Counter] = String.format("%02X", hexval & 0xFF);
                program_Counter += 1;
                Memory[program_Counter] = String.format("%02X",(hexval>>8)&0xFF);
                program_Counter += 1;
                break;
                }
            case "STA":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                String replaced_string = parts[1].toUpperCase().replace("H"," ").trim();
                Long hexval = Long.parseLong(replaced_string,16);
                Memory[program_Counter] = String.format("%02X", hexval & 0xFF);
                program_Counter += 1;
                Memory[program_Counter] = String.format("%02X",(hexval>>8)&0xFF);
                program_Counter += 1;
                break;}
            case "LDA":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                String replaced_string = parts[1].toUpperCase().replace("H"," ").trim();
                Long hexval = Long.parseLong(replaced_string,16);
                Memory[program_Counter] = String.format("%02X", hexval & 0xFF);
                program_Counter += 1;
                Memory[program_Counter] = String.format("%02X",(hexval>>8)&0xFF);
                program_Counter += 1;
                break;}
            case "ACI":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                String replaced_string = parts[1].toUpperCase().replace("H","").trim();
                Long hexval = Long.parseLong(replaced_string,16);
                Memory[program_Counter] = String.format("%02X", hexval & 0xFF);
                program_Counter += 1;
                break;
            }
            case "CMC":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                break;
            }
            case "CPI":{
                Memory[program_Counter] = line.toUpperCase();
                program_Counter+=1;
                String replaced_string = parts[1].toUpperCase().replace("H","").trim();
                int hexval = Integer.parseInt(replaced_string, 16);
                Memory[program_Counter] = String.format("%02X", hexval & 0xFF);
                program_Counter += 1;
                break;
            }
        }
    }
}