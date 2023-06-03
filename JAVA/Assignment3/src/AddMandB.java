import java.util.ArrayList;

public class AddMandB {
    static ArrayList<Books> books = new ArrayList<>();
    static ArrayList<Members> members = new ArrayList<>();
    static int idMember = 1;
    static int idBook = 1;
    static ArrayList academic = new ArrayList<>();
    static ArrayList academicInLibrary = new ArrayList<>();
    static ArrayList student = new ArrayList<>();
    static ArrayList studentInLibrary = new ArrayList<>();
    public static void addMember(String type){
        if (type.equals("A")) {
            members.add(new Members(type,idMember,academic,academicInLibrary));
            System.out.format("Created new member: Academic [id: %d]\n",idMember);
            idMember += 1;

        } else if (type.equals("S")) {
            members.add(new Members(type,idMember,student,studentInLibrary));
            System.out.format("Created new member: Student [id: %d]\n",idMember);
            idMember += 1;

        } else{
            System.out.println("Something went wrong!!!");
        }
    }
    public static void addBook(String type){
        if (type.equals("P")){
            books.add(new Books(type,idBook,false, null,null,false));
            System.out.format("Created new book: Printed [id: %d]\n",idBook);
            idBook += 1;
        } else if (type.equals("H")) {
            books.add(new Books(type,idBook,false, null,null,false));
            System.out.format("Created new book: Handwritten [id: %d]\n",idBook);
            idBook += 1;
        } else {
            System.out.println("Something went wrong!!!");
        }
    }
}
