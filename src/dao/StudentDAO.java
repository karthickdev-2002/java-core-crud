package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	 public void insertUser(Student s) throws SQLException {
	        Connection conn = DBUtil.getConnection();
	        PreparedStatement ps = conn.prepareStatement("INSERT INTO students(name,email,age) VALUES(?,?,?)");
	        ps.setString(1, s.getName());
	        ps.setString(2, s.getEmail());
	        ps.setDouble(3, s.getAge());
	        ps.executeUpdate();
	        conn.close();
	    }

	    public void updateUser(Student s) throws SQLException {
	        Connection conn = DBUtil.getConnection();
	        PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=?, email=?, age=? WHERE id=?");
	        ps.setString(1, s.getName());
	        ps.setString(2, s.getEmail());
	        ps.setDouble(3, s.getAge());
	        ps.setInt(4, s.getId());
	        ps.executeUpdate();
	        conn.close();
	    }

	    public void deleteUser(int id) throws SQLException {
	        Connection conn = DBUtil.getConnection();
	        PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?");
	        ps.setInt(1, id);
	        ps.executeUpdate();
	        conn.close();
	    }
}
