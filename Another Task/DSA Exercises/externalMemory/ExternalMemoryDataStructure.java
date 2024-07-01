import java.io.*;

public class ExternalMemoryDataStructure {
    private static final int BLOCK_SIZE = 4096; // Adjust as needed
    private String filePath;

    public ExternalMemoryDataStructure(String filePath) {
        this.filePath = filePath;
    }

    public void writeToDisk(byte[] data, long position) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            file.seek(position);
            file.write(data);
        }
    }

    public byte[] readFromDisk(long position, int length) throws IOException {
        byte[] data = new byte[length];
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            file.seek(position);
            file.read(data);
        }
        return data;
    }

    // Add methods for your specific external memory data structure operations

    public static void main(String[] args) {
        ExternalMemoryDataStructure externalMemory = new ExternalMemoryDataStructure("external_data.dat");

        // Example usage
        byte[] dataToWrite = "Hello, External Memory!".getBytes();
        long position = 0;

        try {
            externalMemory.writeToDisk(dataToWrite, position);

            byte[] readData = externalMemory.readFromDisk(position, dataToWrite.length);
            String result = new String(readData);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
