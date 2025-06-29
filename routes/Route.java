package routes;
import Memory.*;
public class Route extends Instruction{
    public void seperate(String line) {
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
}