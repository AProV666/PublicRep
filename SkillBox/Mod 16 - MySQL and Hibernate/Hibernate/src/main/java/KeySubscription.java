import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class KeySubscription implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId(int i) {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        KeySubscription key = (KeySubscription) obj;
        if(studentId != key.studentId) {
            return false;
        }
        if(courseId != key.courseId) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 666;
        int result = 1;
        result = prime * result + studentId;
        result = prime * result + courseId;
        return result;
    }
}
