// Basic File Operations (Read, Write, Copy)

import java.io.*;
import java.util.*;
import java.nio.file.*;

class SeventyThree {
    public static void main(String args[]) {
        try {  
            FileWriter fwrite = new FileWriter("./z.txt");
            fwrite.write("Bhavanshu Dalwadi");
            fwrite.close();
            System.out.println("File Writen.");

            System.out.println("File Contains: ");
            File file = new File("./z.txt");
            Scanner dataReader = new Scanner(file);
            while (dataReader.hasNextLine()) {
                System.out.println(dataReader.nextLine());
            }
            dataReader.close();

            File file1 = new File("./z.txt");
            File file2 = new File("./zz.txt");
            Files.copy(file1.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }  
    }
}