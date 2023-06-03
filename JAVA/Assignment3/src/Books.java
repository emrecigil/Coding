import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Books {
    private String type;
    private int id;
    private boolean used;
    private Date startDate;
    private Date finishDate;
    private boolean uzatma;
    public Books(String type, int id,Boolean used,Date startDate,Date finishDate,boolean uzatma){
        this.id = id;
        this.type = type;
        this.used = used;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.uzatma = uzatma;
    }

    public boolean isUzatma() {
        return uzatma;
    }

    public void setUzatma(boolean uzatma) {
        this.uzatma = uzatma;
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
    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
}
