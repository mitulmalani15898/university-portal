/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.Payment.database;

import static edu.dalhousie.business.Payment.database.PaymentDetailsConstant.*;

public class PaymentDetailsQueryBuilder implements PaymentDetailsDAOQueryBuilder {
    private static PaymentDetailsQueryBuilder instance;
    private PaymentDetailsQueryBuilder(){

    }
    public static PaymentDetailsQueryBuilder getInstance(){
        if(instance==null){
            instance = new PaymentDetailsQueryBuilder();
        }
        return instance;
    }
    @Override
    public String selectEnrolledCoursesQuery(int id) {
        return "SELECT " +
                COURSE_NAME+
                ",CT." + COURSE_TYPE
                + ","+ STUDENT_ID
                + ",C." + COURSE_ID
                + " FROM " + COURSES_ENROLLED_TABLE + " AS CE"
                + " INNER JOIN " + COURSES_TABLE + " AS C ON CE."+COURSE_ID + " = "+ "C."+ COURSE_ID
                + " INNER JOIN " + COURSE_TYPE_TABLE + " AS CT ON CT."+ID + " = "+ "C."+ COURSE_TYPE
                + " WHERE " + STUDENT_ID + "= 1";

    }
}
