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
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			List<Student> list = dao.getAllStudents();
			resp.setContentType("application/json");
			String json = gson.toJson(list);
			resp.getWriter().write(json);
		} catch (Exception e) {
			resp.sendError(500, e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			Student student = gson.fromJson(req.getReader(), Student.class);
			dao.insertUser(student);
			resp.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			resp.sendError(500, e.getMessage());
		}
	}

	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			Student student = gson.fromJson(req.getReader(), Student.class);
			dao.updateUser(student);
			resp.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			resp.sendError(500, e.getMessage());
		}
	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			dao.deleteUser(id);
			resp.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			resp.sendError(500, e.getMessage());
		}
	}
}
