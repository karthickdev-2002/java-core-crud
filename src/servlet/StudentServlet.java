package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.Student;

import com.google.gson.Gson;

public class StudentServlet extends HttpServlet {

	private StudentDAO dao = new StudentDAO();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			List<Student> list = dao.getAllStudents();
			resp.setContentType("application/json");
			String json = new Gson().toJson(list);
			resp.getWriter().write(json);
		} catch (Exception e) {
			resp.sendError(500, e.getMessage());
		}
	}
}
