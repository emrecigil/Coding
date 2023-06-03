import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream fileout = new PrintStream(new FileOutputStream(args[1]));
        System.setOut(fileout);
        readFile(args[0]);
    }
    public static void readFile(String file) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while ((line = reader.readLine()) != null){
            String[] elements = line.split("\t");
            switch (elements[0]){
                case "addBook":
                    AddMandB.addBook(elements[1]);
                    break;
                case "addMember":
                    AddMandB.addMember(elements[1]);
                    break;
                case "borrowBook":
                    BorrowBook.BookandMembertypeSearch(elements[1],elements[2],elements[3]);
                    break;
                case "readInLibrary":
                    ReadBook.CheckBookandMember(elements[1],elements[2],elements[3]);
                    break;
                case "returnBook":
                    ReturnBook.checkBookandMember(elements[1],elements[2],elements[3]);
                    break;
                case "extendBook":
                    System.out.println(Extend.uzat(elements[1],elements[2],elements[3]));
                    break;
                case "getTheHistory":
                    System.out.println(History.getHistory());
                    break;
            }
        }
        reader.close();
    }
}