import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class KeyPurchaseList implements Serializable {

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        KeyPurchaseList key = (KeyPurchaseList) obj;
        if (studentName != key.studentName) {
            return false;
        }
        if (courseName != key.courseName) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 666;
        int result = 1;
        result = prime * result + studentName.hashCode();
        result = prime * result + courseName.hashCode();
        return result;
    }
}
