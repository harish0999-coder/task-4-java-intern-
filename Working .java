import java.io.*;
import java.util.Scanner;

public class NotesManager {
    private static final String FILE_NAME = "notes.txt";

    // Method to write notes to the file
    public static void writeNotes(String notes, boolean append) {
        try (FileWriter writer = new FileWriter(FILE_NAME, append)) {
            writer.write(notes + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to read notes from the file
    public static void readNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Notes in file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. File does not exist.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nNotes Manager");
            System.out.println("1. Add Note (Append)");
            System.out.println("2. Overwrite Notes");
            System.out.println("3. Read Notes");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter note to append: ");
                    String appendNote = scanner.nextLine();
                    writeNotes(appendNote, true);
                    System.out.println("Note appended successfully.");
                    break;
                case "2":
                    System.out.print("Enter note to overwrite existing notes: ");
                    String overwriteNote = scanner.nextLine();
                    writeNotes(overwriteNote, false);
                    System.out.println("Notes overwritten successfully.");
                    break;
                case "3":
                    readNotes();
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
        scanner.close();
        System.out.println("Exiting Notes Manager. Goodbye!");
    }
}
