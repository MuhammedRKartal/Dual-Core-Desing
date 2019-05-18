import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class assembler {
    public static void main(String[]args) throws FileNotFoundException {
        String needed = "";
        Scanner reader = new Scanner(new File("C:\\Users\\hiroh\\Desktop\\inputfile.txt"));
        while (reader.hasNext()){
            String str = reader.nextLine();
            String[] split = str.split(" ");
            needed += combineInstruction(split[0],split[1])+ " ";
        }
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream("C:\\Users\\hiroh\\Desktop\\outputfile.asm"), "utf-8"));
            writer.println("v2.0 raw");
            writer.println(needed);
        } catch (IOException ex) {
            // Report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }


    public static String combineInstruction(String ins , String adr){
        //System.out.println(returnBinary(ins) + decimalToBinary(adr));
        return binaryToHex(returnBinary(ins) + decimalToBinary(adr));
    }

    public static String returnBinary(String ins){
        String instNumber = "";
        if(ins.equals("BZ"))
            instNumber = "000000";
        else if(ins.equals("BN"))
            instNumber = "000001";
        else if(ins.equals("ST"))
            instNumber = "000010";
        else if(ins.equals("RL"))
            instNumber = "000011";
        else if(ins.equals("LI"))
            instNumber = "000100";
        else if(ins.equals("LM"))
            instNumber = "000101";
        else if(ins.equals("AD"))
            instNumber = "000110";
        else if(ins.equals("SB"))
            instNumber = "000111";
        else return null;

        return instNumber;
    }


    private static String decimalToBinary(String adrDec){
        int n, count = 0, a;
        String adrBin = "";
        int adrInt = Integer.parseInt(adrDec);

        adrBin = Integer.toBinaryString(adrInt);

        String zeroes= "";
        String fullAdr = "";
        for (int i= 0; i<5-adrBin.length(); i++){
            zeroes+="0";
        }
        fullAdr=zeroes+adrBin;
        return fullAdr;
    }



    private static String binaryToHex(String binary) {
        int decimalValue = 0;
        int length = binary.length() - 1;
        for (int i = 0; i < binary.length(); i++) {
            decimalValue += Integer.parseInt(binary.charAt(i) + "") * Math.pow(2, length);
            length--;
        }
        if(decimalValue != 00000000000){
            return decimalToHex(decimalValue);
        }
        return "00";
    }
    private static String decimalToHex(int decimal){
        String hex = "";
        while (decimal != 0){
            int hexValue = decimal % 16;
            hex = toHexChar(hexValue) + hex;
            decimal = decimal / 16;
        }
        return hex;
    }

    private static char toHexChar(int hexValue) {
        if (hexValue <= 9 && hexValue >= 0)
            return (char)(hexValue + '0');
        else
            return (char)(hexValue - 10 + 'A');
    }











}
