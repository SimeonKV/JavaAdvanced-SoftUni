package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        FileInputStream fis = null;
        Scanner scanner = null;

        FileWriter fw = null;
        BufferedWriter bw = null;

        try{
            fis = new FileInputStream("src/input.txt");
            scanner = new Scanner(fis);
            fw = new FileWriter("src/04.ExtractIntegersOutput.txt");
            bw = new BufferedWriter(fw);

            String value = "";
            while(scanner.hasNext()){

                if(scanner.hasNextInt()){
                   value = scanner.next();
                   bw.write(value + System.lineSeparator());
                   bw.flush();
                }

                value = scanner.next();
            }

        }catch (IOException io){
            io.printStackTrace();
        }finally {
           if(scanner != null) {
               scanner.close();
           }

           try {
               if(bw != null) {
                   bw.close();
               }
           }catch (IOException io){
               io.printStackTrace();
           }
        }


    }
}
