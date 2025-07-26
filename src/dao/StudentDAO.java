package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.DBUtil;

public class StudentDAO {

	public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<Student>();
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            s.setAge(rs.getInt("age"));
            list.add(s);
        }
        conn.close();
        return list;
    }
}
