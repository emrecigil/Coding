import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReturnBook extends AddMandB {
    public static void checkBookandMember(String bookId,String memberId, String date){
        SimpleDateFormat bicim = new SimpleDateFormat("yyyy-MM-dd");
        Date teslimDate;
        try {
            teslimDate = bicim.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        for (Books s : books){
            if (s.getFinishDate() != null) {
                if (s.getId() == Integer.parseInt(bookId) && s.getFinishDate().before(teslimDate)) {
                    System.out.println("The book [" + bookId + "] was returned by member [" +
                            memberId + "]at " + date + "Fee: 1");
                    s.setStartDate(null);
                    s.setUsed(false);
                    s.setFinishDate(null);
                    break;
                } else if (s.getId() == Integer.parseInt(bookId) && (s.getFinishDate().after(teslimDate))) {
                    s.setStartDate(null);
                    s.setUsed(false);
                    s.setFinishDate(null);
                    System.out.println("The book [" + bookId + "] was returned by member [" +
                            memberId + "] at " + date + " Fee: 0");
                    break;
                }
            }else if (s.getFinishDate() == null && s.getId() == Integer.parseInt(bookId)){
                s.setStartDate(null);
                s.setUsed(false);
                s.setFinishDate(null);
                System.out.println("The book [" + bookId + "] was returned by member [" +
                        memberId + "] at " + date + " Fee: 0");
                break;
            }
        }
        for (Members s : members){
            if (s.getId() == Integer.parseInt(memberId) && s.getBorrowBook().contains(bookId)){
                ArrayList arrayList = new ArrayList<>(s.getBorrowBook());
                arrayList.remove(bookId);
                arrayList.remove(arrayList.indexOf(bookId)+1);
                s.setBorrowBook(arrayList);
                break;
            } else if (s.getId() == Integer.parseInt(memberId) && s.getReadbooksayi().contains(bookId)) {
                ArrayList arrayList = new ArrayList<>(s.getReadbooksayi());
                arrayList.remove(bookId);
                arrayList.remove(arrayList.indexOf(bookId)+1);
                s.setReadbooksayi(arrayList);
                break;
            }

        }

    }
}
