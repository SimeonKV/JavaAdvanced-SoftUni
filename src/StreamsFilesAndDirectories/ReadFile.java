package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

/*
* You are given a file named "input.txt". Read and print all of its contents
* as a sequence of bytes (the binary representation of the ASCII code for each character) separated by a single comma.
 * */
public class ReadFile {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("src/input.txt");


            while(true){
               int reader = fis.read();

               if(reader == -1 ){
                   break;
               }
                System.out.print(Integer.toBinaryString(reader) + " ");

            }

        }catch (IOException io){
            io.printStackTrace();
        }finally {
            try {
                fis.close();
            }catch (IOException io){
                io.printStackTrace();
            }
        }


    }
}
