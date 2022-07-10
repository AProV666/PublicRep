import javax.persistence.*;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    @GeneratedValue
    private KeySubscription id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    public KeySubscription getId() {
        return id;
    }

    public void setId(KeySubscription id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
