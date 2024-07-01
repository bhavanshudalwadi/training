import java.io.*;
import java.util.*;

class SeventyFour {

    public static void main(String[] args) throws java.io.IOException {
        String commandLine;

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            System.out.print("shell> ");

            commandLine = console.readLine();

            if (commandLine.equals("")) {
                continue;
            }

            if (commandLine.equals("help")) {
                System.out.println();
                System.out.println("Welcome to the shell");
                System.out.println("--------------------");
                System.out.println();
                System.out.println("Commands to use:");
                System.out.println("1) cat example.txt");
                System.out.println("2) exit");
                System.out.println("3) clear");
                System.out.println();
                System.out.println("---------------------");
                System.out.println();
            }

            if (commandLine.equals("clear")) {
                for( int cls = 0; cls < 100; cls++ ) {
                    System.out.println();
                }
            }

            if(commandLine.startsWith("cat")) {
                File file = new File("./"+commandLine.split(" ", 2)[1]);
                Scanner dataReader = new Scanner(file);
                while (dataReader.hasNextLine()) {
                    System.out.println(dataReader.nextLine());
                }
                dataReader.close();
            }else {
                System.out.println("Incorrect Command");
            }

            if (commandLine.equals("exit")) {
                System.out.println("Terminating the Shell");
                System.out.println("Good Buy :)");
                System.exit(0);
            }
        }
    }
}