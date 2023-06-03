import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Extend extends AddMandB{
    public static String uzat(String bookId,String memberId,String date){
        Calendar takvim = Calendar.getInstance();
        emre:
        for (Books s : books){
            if (s.getId() == Integer.parseInt(bookId) && !s.isUzatma()){
                for (Members m : members ){
                    String format = String.format("The deadline of book [%s] was extended by member [%s] at %s\n" +
                                    "New deadline of book [%s] is %s"
                            , bookId, memberId, date, bookId, date);
                    if (m.getId() == Integer.parseInt(memberId)&&m.getType().equals("S")){
                        takvim.setTime(s.getFinishDate());
                        takvim.add(Calendar.WEEK_OF_YEAR,1);
                        s.setFinishDate(takvim.getTime());
                        s.setUzatma(true);
                        return format;
                    } else if (m.getId() == Integer.parseInt(memberId)&&m.getType().equals("A")) {
                        takvim.setTime(s.getFinishDate());
                        takvim.add(Calendar.WEEK_OF_YEAR,2);
                        s.setFinishDate(takvim.getTime());
                        s.setUzatma(true);
                        return format;
                    }
                }
            }else{
                return "You cannot extend the deadline!";
            }
        }
        return null;
    }
}
