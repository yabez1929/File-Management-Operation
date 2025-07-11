import java.io.*;
import java.util.Scanner;

/**
 * FileReadWriteModify
 *
 * A menu-driven Java console program that performs basic file operations on a text file.
 * Supports writing (overwriting), reading, appending, and modifying file contents.
 *
 * Author: Yabez Yalsatty
 * College: B.K. Birla College, Kalyan
 * Course: B.Sc. Computer Science, Semester III
 */
public class filereadwritemodify {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "sample.txt"; // File to read/write

        while (true) {
            // Display menu
            System.out.println("\n--- File Operations Menu ---");
            System.out.println("1. Write to file (overwrite)");
            System.out.println("2. Read from file");
            System.out.println("3. Append to file");
            System.out.println("4. Replace file content");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            switch (choice) {
                case 1:
                    // Overwrite the file
                    System.out.println("Enter text to write (will overwrite):");
                    String overwriteData = scanner.nextLine();
                    writeToFile(filePath, overwriteData, false);
                    break;

                case 2:
                    // Read the file
                    System.out.println("\nFile Content:");
                    readFromFile(filePath);
                    break;

                case 3:
                    // Append data to file
                    System.out.println("Enter text to append:");
                    String appendData = scanner.nextLine();
                    writeToFile(filePath, appendData, true);
                    break;

                case 4:
                    // Replace file content (same as overwrite)
                    System.out.println("Enter new content to replace existing:");
                    String newData = scanner.nextLine();
                    writeToFile(filePath, newData, false);
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting program.");
                    return;

                default:
                    // Invalid input
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    /**
     * Writes or appends data to a file.
     *
     * @param filePath The path to the file.
     * @param data     The content to write to the file.
     * @param append   If true, appends data; if false, overwrites existing content.
     */
    public static void writeToFile(String filePath, String data, boolean append) {
        try (FileWriter writer = new FileWriter(filePath, append)) {
            writer.write(data + System.lineSeparator()); // Write with a newline
            System.out.println("File write successful.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads and prints the content of a file line by line.
     *
     * @param filePath The path to the file.
     */
    public static void readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean empty = true;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                empty = false;
            }

            if (empty) {
                System.out.println("[File is empty]");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Create it first using Write option.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
