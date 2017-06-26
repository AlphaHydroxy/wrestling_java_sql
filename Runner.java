package example.codeclan.com.wrestling;

import java.sql.ResultSet;
import java.util.Scanner;
import db.SqlRunner;

/**
 * Created by user on 26/06/2017.
 */

public class Runner {

    public static void main(String[] args) {
        Counselor.deleteAll();
        Subject.deleteAll();
        Counselor.all();
        Subject.all();

        Subject.getAllDetails();
        Subject.getSubjectName();

    }

}

