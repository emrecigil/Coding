import java.util.ArrayList;

public class Members {
    private String type;
    private int id;
    private ArrayList Borrowbook;
    private ArrayList readbooksayi;
    static ArrayList borrow = new ArrayList<>();
    static ArrayList read = new ArrayList<>();
    public Members(String type,int id,ArrayList booksayi,ArrayList readbooksayi) {
        this.id = id;
        this.type = type;
        this.Borrowbook = booksayi;
        this.readbooksayi = readbooksayi;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList getBorrowBook() {
        return Borrowbook;
    }

    public void setBorrowBook(ArrayList booksayi) {
        this.Borrowbook = booksayi;
    }

    public ArrayList getReadbooksayi() {
        return readbooksayi;
    }

    public void setReadbooksayi(ArrayList readbooksayi) {
        this.readbooksayi = readbooksayi;
    }
    public static String toString1(){
        Integer userıd = null;
        for (Members s : AddMandB.members){
            if ( s.getBorrowBook().size() > 0 ) {
                borrow.addAll(s.getBorrowBook());
                userıd = s.getId();
            }
        }
        for (int i = 0; i < borrow.size(); i++){
            return String.format("The book [%s] was borrowed by member [%s] at %s",
                    borrow.get(i),userıd,borrow.get(i + 1));
        }
        return null;
    }
    public static String toString2(){
        Integer userıd = null;
        for (Members s : AddMandB.members){
            if (s.getReadbooksayi().size() > 0){
                read.addAll(s.getReadbooksayi());
                userıd = s.getId();
            }
        }
        for (int i = 0; i < read.size(); i++){
            return String.format("The book [%s] was read in library by member [%s] at %s",
                    read.get(i),userıd, read.get(i + 1));
        }
        return null;
    }
}
