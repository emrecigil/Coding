import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReadBook extends AddMandB{
    public static void CheckBookandMember(String bookId, String memberId,String date) {
        SimpleDateFormat bicim = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate;
        try {
            startDate = bicim.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        boolean checkBook = false;
        boolean checkMember = false;
        String bookType = null;
        String memberType = null;
        for (Books s : books){
            if (s.getId() == Integer.parseInt(bookId) && s.isUsed() == true) {
                System.out.println("You can not read this book!");
            }else if(s.getId() == Integer.parseInt(bookId) && s.isUsed() == false){
                bookType = s.getType();
                checkBook = true;
                break;
            }
        }
        for (Members s : members){
            if (s.getId() == Integer.parseInt(memberId)){
                checkMember = true;
                memberType = s.getType();
                break;
            }
        }
        if (checkBook && checkMember){
            ReadBookNow(bookId,memberId,memberType,bookType,startDate,date);
        }
    }
    public static void ReadBookNow(String bookId,String memberId,String membertype,String booktype,Date date
    ,String strdate){
        if ((booktype.equals("H")||booktype.equals("P")) && membertype.equals("A")){
            for (Members s : members){
                if (s.getId() == Integer.parseInt(memberId)) {
                    ArrayList arrayList = new ArrayList<>(s.getReadbooksayi());
                    arrayList.add(bookId);
                    arrayList.add(strdate);
                    s.setReadbooksayi(arrayList);
                    break;
                }

            }
            for (Books s : books) {
                if (s.getId() == Integer.parseInt(bookId)) {
                    s.setUsed(true);
                    s.setStartDate(date);
                    System.out.format("The book [%s] was read in library by member [%s] at "+strdate+"\n",
                            bookId,memberId);
                    break;
                }

            }
        } else if ((booktype.equals("P")) && membertype.equals("S")){
            for (Members s : members){
                if (s.getId() == Integer.parseInt(memberId)) {
                    ArrayList arrayList = new ArrayList<>(s.getReadbooksayi());
                    arrayList.add(bookId);
                    arrayList.add(strdate);
                    s.setReadbooksayi(arrayList);
                    break;
                }

            }
            for (Books s : books) {
                if (s.getId() == Integer.parseInt(bookId)) {
                    s.setUsed(true);
                    s.setStartDate(date);
                    System.out.format("The book [%s] was read in library by member [%s] at "+strdate+"\n",
                            bookId,memberId);
                    break;
                }

            }
        }else if ((booktype.equals("H")) && membertype.equals("S")){
            System.out.println("Students can not read handwritten books!");
        }
    }
}
