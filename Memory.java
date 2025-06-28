class Memory extends Bits{
    String Memory[] = new String[65536];

    void update(String line){
        String[] parts = line.split("[ ,]+");
        String ins = parts[0];
        switch (ins) {
            case "mvi":
                Memory[program_Counter] = line;
                program_Counter+=2;
                break;
            case "MVI":
                Memory[program_Counter] = line;
                program_Counter+=2;
                break;
            case "mov":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "MOV":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "add":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "ADD":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "adi":
                Memory[program_Counter] = line;
                program_Counter+=2;
                break;
            case "ADI":
                Memory[program_Counter] = line;
                program_Counter+=2;
                break;
            case "sub":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "SUB":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "sui":
                Memory[program_Counter] = line;
                program_Counter+=2;
                break;
            case "SUI":
                Memory[program_Counter] = line;
                program_Counter+=2;
                break;
            case "INR":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "inr":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "dcr":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "DCR":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "cma":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "CMA":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "ana":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "ANA":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "ANI":
                Memory[program_Counter] = line;
                program_Counter+=2;
                break;
            case "ani":
                Memory[program_Counter] = line;
                program_Counter+=2;
                break;
            case "ora":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "ORA":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "ORI":
                Memory[program_Counter] = line;
                program_Counter+=2;
                break;
            case "ori":
                Memory[program_Counter] = line;
                program_Counter+=2;
                break;
            case "xra":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "XRA":
                Memory[program_Counter] = line;
                program_Counter+=1;
                break;
            case "XRI":
                Memory[program_Counter] = line;
                program_Counter+=2;
                break;
            case "xri":
                Memory[program_Counter] = line;
                program_Counter+=2;
                break;
            case "jmp":
                Memory[program_Counter] = line;
                program_Counter+=3;
                break;
            case "JMP":
                Memory[program_Counter] = line;
                program_Counter+=3;
                break;
            case "jz":
                Memory[program_Counter] = line;
                program_Counter+=3;
                break;
            case "JZ":
                Memory[program_Counter] = line;
                program_Counter+=3;
                break;
            case "jnz":
                Memory[program_Counter] = line;
                program_Counter+=3;
                break;
            case "JNZ":
                Memory[program_Counter] = line;
                program_Counter+=3;
                break;
        }
    }
}