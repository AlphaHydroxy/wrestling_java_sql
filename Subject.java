package example.codeclan.com.wrestling;

import java.sql.ResultSet;

import db.SqlRunner;

/**
 * Created by user on 26/06/2017.
 */

public class Subject {

    private String name;
    private String description;
    private int counselor_id;
    private int id;

    public Subject(String name, String description, int counselor_id) {
        this.name = name;
        this.description = name;
        this.counselor_id = counselor_id;
    }

    public static void all() {
        String sql = "SELECT * FROM subjects;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                int counselor_id = rs.getInt("counselor_id");
                System.out.println("Subject:" + name);
                System.out.println("Description:" + description);
                System.out.println("Counselor ID:" + counselor_id);
                System.out.println();
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }

    public static void deleteAll() {
        String sql = "DELETE FROM subjects;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void getSubjectName() {
        String sql = String.format("SELECT subjects.id, subjects.name FROM subjects;");
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("Subject ID: " + id);
                System.out.println("Subject name: " + name);
                System.out.println();
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }



    public static void getAllDetails() {
        String sql = String.format("SELECT subjects.name, subjects.description, counselors.first_name, counselors.nick_name, counselors.last_name, counselors.member_since, counselors.email, counselors.telephone FROM subjects INNER JOIN counselors ON counselors.id = subjects.counselor_id WHERE subjects.id = %d;");
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String first_name = rs.getString("first_name");
                String nick_name = rs.getString("nick_name");
                String last_name = rs.getString("last_name");
                String member_since = rs.getString("member_since");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                System.out.println("Subject:" + name);
                System.out.println("Description:" + description);
                System.out.println("First name:" + first_name);
                System.out.println("Nick name:" + nick_name);
                System.out.println("Last name:" + last_name);
                System.out.println("Member since:" + member_since);
                System.out.println("Email:" + email);
                System.out.println("Telephone:" + telephone);
                System.out.println();
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }
}