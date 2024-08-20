import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HTML_Creator Creat = new HTML_Creator();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the file name or path: ");
            String filenameIn = sc.nextLine();
            Creat.GetFilenameIn(filenameIn);
        }
    }
}
