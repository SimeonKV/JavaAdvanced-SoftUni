package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/*
* Read the file named "input.txt" that is provided for this exercise and write
*  all its content to a file while skipping any punctuation. Skip the following symbols: ',', '.', '!', '?'.
* */
public class WriteToFile {
    public static void main(String[] args) {
        List<Character> skipPunctuations = List.of(',','.','!','?');
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try{
            fis = new FileInputStream("src/input.txt");
            fos = new FileOutputStream("src/02.WriteToFileOutput.txt");

            while(true){
                int reader = fis.read();

                if(reader == -1){
                    break;
                }

                char readerAsChar = (char) reader;
                if(!skipPunctuations.contains(readerAsChar)){
                    fos.write(readerAsChar);
                }

            }

        }catch (IOException io){
            io.printStackTrace();
        }finally {
            try {
                    fis.close();
                    fos.close();
            }catch (IOException io){
                io.printStackTrace();
            }
        }




    }
}
