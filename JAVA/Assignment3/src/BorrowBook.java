import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BorrowBook extends AddMandB{
    public static void BookandMembertypeSearch(String bookid,String memberid,String date){
        SimpleDateFormat bicim = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate;
        try {
            startDate = bicim.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        boolean bookCheck = false;
        boolean memberCheck = false;
        String booktype = null;
        String membertype = null;
        for(Books s : books){
            if (s.getId() == Integer.parseInt(bookid) && !s.isUsed()){
                booktype = s.getType();
                bookCheck = true;
                break;
            }
        }
        for (Members s : members){
            if (s.getId() == Integer.parseInt(memberid)){
                membertype = s.getType();
                memberCheck = true;
                break;
            }
        }
        if (bookCheck && memberCheck){
            BorrowingBook(booktype,membertype,bookid,memberid, startDate,date);
        } else if (!bookCheck) {
            System.out.println("You cannot borrow this book!");
        } else {
            System.out.println("There is no such a member!!");
        }
    }
    public static void BorrowingBook(String booktype, String memberType, String bookid, String memberid, Date date
    ,String strdate){
            if (booktype.equals("H")){
                System.out.println("You cannot borrow this book!");
            }
            else if (booktype.equals("P")&& memberType.equals("A")) {
                for (Members s : members){
                    if (s.getId() == Integer.parseInt(memberid) && s.getBorrowBook().size() < 4){
                        ArrayList arrayList = new ArrayList<>(s.getBorrowBook());
                        arrayList.add(bookid);
                        arrayList.add(strdate);
                        s.setBorrowBook(arrayList);
                        System.out.format("The book [%s] was borrowed by member [%s] at "+strdate+"\n",
                                bookid,memberid);
                        break;
                    }else if (s.getBorrowBook().size() >= 4){
                        System.out.println("You have exceeded the borrowing limit!");
                    }

                }
                for (Books s : books){
                    if (s.getId() == Integer.parseInt(bookid)) {
                        s.setUsed(true);
                        s.setStartDate(date);
                        Calendar takvim = Calendar.getInstance();
                        takvim.setTime(date);
                        takvim.add(Calendar.WEEK_OF_YEAR,2);
                        Date finishTime = takvim.getTime();
                        s.setFinishDate(finishTime);
                        break;

                    }
                }
            }
            else if (booktype.equals("P") && memberType.equals("S")){
                for (Members s : members){
                    if (s.getId() == Integer.parseInt(memberid) && s.getBorrowBook().size() < 2){
                        ArrayList arrayList = new ArrayList<>(s.getBorrowBook());
                        arrayList.add(bookid);
                        arrayList.add(strdate);
                        s.setBorrowBook(arrayList);
                        System.out.format("The book [%s] was borrowed by member [%s] at "+strdate+"\n",
                                bookid,memberid);
                        break;
                    }else if (s.getBorrowBook().size() >= 4){
                        System.out.println("You have exceeded the borrowing limit!");
                        break;
                    }
                }
                for (Books s : books){
                    if (s.getId() == Integer.parseInt(bookid)) {
                        s.setUsed(true);
                        s.setStartDate(date);
                        Calendar takvim = Calendar.getInstance();
                        takvim.setTime(date);
                        takvim.add(Calendar.WEEK_OF_YEAR,1);
                        Date finishTime = takvim.getTime();
                        s.setFinishDate(finishTime);
                        break;
                    }
                }
            }
    }
}
