//package edu.dalhousie.business.Scholarship;
//
//import edu.dalhousie.database.ExecuteQuery;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//
//public class ScholarshipBusiness {
//
//    String courseName;
//    String userName;
//    int r;
//
//    Connection connection;
//
//
////    public ScholarshipBusiness(String courseName, String userName) throws Exception {
////        this.courseName = courseName;
////        this.userName = userName;
////    }
//
//    public String computeDummy() throws Exception {
//
////        DatabaseConnectivity connectivity = new DatabaseConnectivity();
////        connection = connectivity.getDatabaseConnection();
////        Statement stmt = connection.createStatement();
////        String SQL = "SELECT * FROM users WHERE userName='" + userName + "' && userPassword='qwerty123'";
////        ResultSet rs = stmt.executeQuery(SQL);
////        while (rs.next()) {
////            String r = rs.getString("userName");
////            System.out.println("hshsdfiudsiy "+r);
////        }
////        System.out.println("Heloo" + r);
//
//        ExecuteQuery executeQuery = new ExecuteQuery();
//        String SQL = "SELECT * FROM users WHERE userName= '" + userName + "' && userPassword= 'qwerty123'" ;
//        ResultSet rs = executeQuery.executeUpdateSQL(SQL);
//        while (rs.next()) {
//            String r = rs.getString("userName");
//            System.out.println("hello,an " + r);
//        }
//
//        return "";
//
////        if (courseName == "Master of applied computer science") {
////            AddNewApplicationFormObject obj = new AddNewApplicationFormObject();
////            System.out.println(obj.getResult());
////        }
////        return "";
//    }
//
//    public String computeResult(float score) {
//        String decision = "";
//        if (score >= 400) {
//            decision = "Congrats! You have eligible for scholarship";
//        } else {
//            decision = "Sorry, you are not eligible for scholarship";
//        }
//        return decision;
//    }
//}
