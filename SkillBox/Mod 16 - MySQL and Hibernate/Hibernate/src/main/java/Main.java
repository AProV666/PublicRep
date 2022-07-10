import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        String hql = "CREATE TABLE `LinkedPurchaseList`(`student_id` int(10) unsigned NOT NULL,`course_id` int(10) unsigned NOT NULL)";
        Query query = session.createSQLQuery(hql).addEntity(LinkedPurchaseList.class);

//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<LinkedPurchaseList> query = builder.createQuery(LinkedPurchaseList.class);
//        Root<LinkedPurchaseList> root = query.from(LinkedPurchaseList.class);
//        query.select(root);
//        List<LinkedPurchaseList>

        //Получение списка курсов
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Course> query = builder.createQuery(Course.class);
//        Root<Course> root = query.from(Course.class);
//        query.select(root);
//        List<Course> courseList = session.createQuery(query).getResultList();
//        for(Course course : courseList) {
//            System.out.println(course.getName());
//        }

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> query1 = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = query1.from(PurchaseList.class);
        query1.select(root);
        List<PurchaseList> purchaseList = session.createQuery(query1).getResultList();

        CriteriaQuery<Course> query2 = builder.createQuery(Course.class);
        Root<Course> root2 = query2.from(Course.class);
        query2.select(root2);
        List<Course> courseList = session.createQuery(query2).getResultList();

        CriteriaQuery<Student> query3 = builder.createQuery(Student.class);
        Root<Student> root3 = query3.from(Student.class);
        query3.select(root3);
        List<Student> studentList = session.createQuery(query3).getResultList();

        for(int i = 0; i < purchaseList.size(); i++) {
            LinkedPurchaseList linked = new LinkedPurchaseList();
            Integer stId = 0;
            Integer cId = 0;
            for(int j = 0; j < studentList.size(); j++) {
                if(purchaseList.get(i).getStudentName().equals(studentList.get(j).getName())) {
                    stId = studentList.get(j).getId();
                }
            }
            for(int k = 0; k < courseList.size(); k++) {
                if(purchaseList.get(i).getCourseName().equals(courseList.get(k).getName())){
                    cId = courseList.get(k).getId();
                }
                KeySubscription key = new KeySubscription();
                key.setStudentId(stId);
                key.setCourseId(cId);
                linked.setId(key);
                session.save(linked);
            }
        }

//        Transaction transaction = session.beginTransaction();
        //Создание нового курса
//        Course course = new Course();
//        course.setName("Новый курс");
//        course.setType(CourseType.BUSINESS);
//        course.setTeacherId(1);

        //Изменение курса
//        Course course = session.get(Course.class, 47);
//        course.setName("Совсем новый курс");

        //Удаление курса
//        Course course = session.get(Course.class, 47);
//        session.delete(course);

//        Course course = session.get(Course.class, 1);
//        List<Student> studentList = course.getStudents();
//        for(Student student : studentList) {
//            System.out.println(student.getName());
//        }

//        KeySubscription key = new KeySubscription();
//        key.setStudentId(1);
//        key.setCourseId(10);
//
//        Subscription subscription = session.get(Subscription.class, key);
//        System.out.println(subscription.getSubscriptionDate());
//
//        KeyPurchaseList key2 = new KeyPurchaseList();
//        key2.setStudentName("Жариков Афанасий");
//        key2.setCourseName("Веб-разработчик c 0 до PRO");
//
//        PurchaseList purchaseList = session.get(PurchaseList.class, key2);
//        System.out.println(purchaseList.getPrice());

//        session.save(course); //при добавлении и изменении

        transaction.commit();
        sessionFactory.close();
    }
}
