package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
* Read the file named "input.txt" and write to another file every character's ASCII representation.
Write every space or new line as it is, e.g. as a space or a new line.

* */
public class CopyBytes {
    static final char SPACE_CHARACTER = ' ';
    static final char NEWLINE_CHARACTER = '\n';
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;


        try{
            fr = new FileReader("src/input.txt");
            fw = new FileWriter("src/03.CopyBytesOutput.txt");

          while(true){
              int reader = fr.read();

              if(!checkForValidIndex(reader)){
                  break;
              }
              if(checkIfCharacterNewLine(reader) || checkIfCharacterSpace(reader)){
                  fw.write(reader);
              }else{
                  writeAsASCIIValue(reader,fw);
              }

          }




        }catch (IOException io){
            io.printStackTrace();
        }finally {
            try{
                fr.close();
                fw.close();
            }catch (IOException io){
                io.printStackTrace();
            }

        }


    }

    private static void writeAsASCIIValue(int reader, FileWriter fw) {
        String value = convertReaderToStr(reader);

        for (int i = 0; i < value.length() ; i++) {
            char character = value.charAt(i);

            try{
                fw.write(character);
            }catch (IOException io){
                io.printStackTrace();
            }

        }

    }

    private static String  convertReaderToStr(int reader) {
        return String.valueOf(reader);
    }

    private static boolean checkForValidIndex(int reader) {
        return reader != -1;
    }

    private static boolean checkIfCharacterNewLine(int reader) {
        return (char) reader == NEWLINE_CHARACTER;
    }

    private static boolean checkIfCharacterSpace(int reader) {
        return (char) reader == SPACE_CHARACTER;
    }
}
