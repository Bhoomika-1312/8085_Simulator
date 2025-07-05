package routes;
import java.io.FileWriter;
import java.io.IOException;
import Memory.*;
public class Route extends Instruction{
    private FileWriter writer;
    public void seperate(String line) {
        String[] parts = line.split("[ ,]+");
        String ins = parts[0];
        ins = ins.toUpperCase();
        switch (ins) {
            case "MVI":
                mvi(parts);
                break;
            case "MOV":
                mov(parts);
                break;
            case "ADD":
                add(parts);
                break;
            case "ADI":
                adi(parts);
                break;
            case "SUB":
                sub(parts);
                break;
            case "SUI":
                sui(parts);
                break;
            case "INR":
                inr(parts);
                break;
            case "DCR":
                dcr(parts);
                break;
            case "CMA":
                cma();
                break;
            case "ANA":
                ana(parts);
                break;
            case "ANI":
                ani(parts);
                break;
            case "ORA":
                ora(parts);
                break;
            case "ORI":
                ori(parts);
                break;
            case "XRA":
                xra(parts);
                break;
            case "XRI":
                xri(parts);
                break;
            case "JMP":
                jmp(parts);
                break;
            case "JZ":
                jz(parts);
                break;
            case "JNZ":
                jnz(parts);
                break;
            case "STA":
                sta(parts);
                break;
            case "LDA":
                lda(parts);
                break;
            case "ACI":
                aci(parts);
                break;
            case "CMC":
                cmc();
                break;
            case "CPI":
                cpi(parts);
                break;
        }
    }
    public void setWriter(FileWriter writer) {
        this.writer = writer;
    }
    public void log(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}