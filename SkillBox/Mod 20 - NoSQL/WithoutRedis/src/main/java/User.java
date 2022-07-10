import java.util.Date;

public class User {

    private int id;
    private Date dateReg;

    public User(int id, Date dateReg) {
        this.id = id;
        this.dateReg = dateReg;
    }

    public int getId() {
        return id;
    }

    public Date getDateReg(){
        return dateReg;
    }
}