package example.codeclan.com.wrestling;

import java.sql.ResultSet;

import db.SqlRunner;

/**
 * Created by user on 26/06/2017.
 */

public class Counselor {

    private String first_name;
    private String nick_name;
    private String last_name;
    private String telephone;
    private String email;
    private String member_since;
    private int id;

    public Counselor(String first_name, String nick_name, String last_name, String telephone, String email, String member_since){
        this.first_name = first_name;
        this.nick_name = nick_name;
        this.last_name = last_name;
        this.telephone = telephone;
        this.email = email;
        this.member_since = member_since;
    }

    public void save() {
        String sql = String.format("INSERT INTO albums " +
                        "(first_name, nick_name, last_name, telephone, email, member_since) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s');"
                , this.first_name, this.nick_name, this.last_name,
                this.telephone, this.email, this.member_since);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all(){
        String sql = "SELECT * FROM counselors;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String nick_name = rs.getString("nick_name");
                String last_name = rs.getString("last_name");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                String member_since = rs.getString("member_since");
                System.out.println("First name:" + first_name);
                System.out.println("Nick name:" + nick_name);
                System.out.println("Last name:" + last_name);
                System.out.println("Telephone:" + telephone);
                System.out.println("Email:" + email);
                System.out.println("Member since:" + member_since);
                System.out.println();
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }

    public static void deleteAll() {
        String sql = "DELETE FROM counselors;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void delete() {
        String sql = String.format("DELETE FROM counselors WHERE id = %d;", this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

}
