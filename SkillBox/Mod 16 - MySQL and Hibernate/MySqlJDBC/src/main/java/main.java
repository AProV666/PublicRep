import java.sql.*;
import java.util.*;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT c.name, COUNT(*)/8 `count` " +
                    "FROM Courses c " +
                    "JOIN Subscriptions s ON s.course_id = c.id " +
                    "GROUP BY c.name;");

            while (resultSet.next()) {
                String courseName = resultSet.getString("name");
                String count = resultSet.getString("count");
                System.out.println(courseName + " = " + count);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        //С ПОМОЩЬЮ JAVA
//        List<String> courseNameList = new ArrayList<>();
//        List<String> courseIdList = new ArrayList<>();
//        List<Date> dateList = new ArrayList<>();
//
//        try {
//            Connection connection = DriverManager.getConnection(url, user, pass);
//            Statement statement = connection.createStatement();
//
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses");
//            while (resultSet.next()) {
//                String courseName = resultSet.getString("name");
//                courseNameList.add(courseName);
//            }
//            resultSet.close();
//
//            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM Subscriptions");
//            while (resultSet2.next()) {
//                String courseId = resultSet2.getString("course_id");
//                Date date = resultSet2.getDate("subscription_date");
//
//                courseIdList.add(courseId);
//                dateList.add(date);
//            }
//            resultSet2.close();
//
//            statement.close();
//            connection.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        Collections.sort(dateList);
//
//        int dateMin = dateList.get(0).getMonth();
//        int dateMax = dateList.get(dateList.size() - 1).getMonth();
//        int monthAmount = dateMax - dateMin;
//
//        for (String x : courseNameList) {
//            int courseAmount = 0;
//            int id = 1;
//
//            for (int j = 0; j < courseIdList.size(); j++) {
//                if (id == Integer.parseInt(courseIdList.get(j))) {
//                    courseAmount++;
//                }
//            }
//            System.out.println(x + " - " + ((double) (courseAmount) / monthAmount));
//            id++;
//        }
    }
}
