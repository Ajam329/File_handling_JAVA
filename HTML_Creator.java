
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * HTML_Creator
 */
public class HTML_Creator {
    private Scanner fileIn;
    private PrintWriter fileOut;
    private String filenameIn;
    private String filenameOut;
    private int dotIndex;
    private String line = null;

    public static void main(String[] args) {
        
    }
    
    public void GetFilenameIn(String filenameIn){
        this.filenameIn = filenameIn;
        SetFilenameOut();
    }

    public void SetFilenameOut(){
        try {
            fileIn = new Scanner(new FileReader(filenameIn));
            dotIndex = filenameIn.lastIndexOf(".");
            if(dotIndex == -1){
                filenameOut = filenameIn+".html";
            }else{
                filenameOut = filenameIn.substring(0,dotIndex)+".html";
            }
            Creator();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    public void Creator() throws FileNotFoundException{
        fileOut = new PrintWriter(filenameOut);
        try {
            line = fileIn.nextLine();
        } catch (Exception e) {
            System.out.print("Error: "+e.getMessage());
        }
        if(line == null){
            System.out.println("This file is empty: ");
        }else{
            fileOut.println("<html>");
            fileOut.println("<head>");
            fileOut.println("</head>");
            fileOut.println("<body>");
            fileOut.println(line);
            while(fileIn.hasNextLine()){
                fileOut.println("<br>");
                line = fileIn.nextLine();

                if(line.isEmpty()){
                    fileOut.println("<br>");
                }else{
                    fileOut.println(line);
                }
            }
            fileOut.println("</body>");
            fileOut.println("</html>");

            System.out.println("File has been processed: ");
            fileIn.close();
            fileOut.close();
        }
    }

}