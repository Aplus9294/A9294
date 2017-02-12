/**
 * 
 */
package com.a9294.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author a9294
 * @version 20170103
 *
 */
@WebServlet(name = "registerServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 6632451220913246529L;
	private Connection con = null;

	public RegisterServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");// �������ݿ�����
			String url = "jdbc:mysql://localhost:3306/db_a9494User";
			String username = "root";
			String password = "78711116814ZKybb";
			con = DriverManager.getConnection(url, username, password); // ��ȡ���ݿ�����
			if (con != null) {
				System.out.println("���ݿ����ӳɹ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����request��response�ı���
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// ��ȡ��������ֵ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String secQuestion = request.getParameter("secQuestion");
		String secQuestionAns = request.getParameter("secQuestionAns");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		// �ж����ݿ��Ƿ����ӳɹ�
		if (con != null) {
			try {
				// ����ע����Ϣ��SQL���(ʹ��?ռλ��)
				String sql = "insert into tb_a9294user(username,password,sex,secQuestion,secQuestionAns,email,birthday) "
						+ "values(?,?,?,?,?,?,?)";
				// ����PreparedStatement����
				PreparedStatement ps = con.prepareStatement(sql);
				// ��SQL����еĲ�����̬��ֵ
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, sex);
				ps.setString(4, secQuestion);
				ps.setString(5, secQuestionAns);
				ps.setString(6, email);
				ps.setString(7, birthday);
				// ִ�и��²���
				ps.executeUpdate();
				// ��ȡPrintWriter����
				PrintWriter out = response.getWriter();
				// ���ע������Ϣ
				out.print("<center><h1>");
				out.print(username + "ע��ɹ���");
				out.print("</h1></center>");
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// �������ݿ����Ӵ�����ʾ��Ϣ
			response.sendError(500, "���ݿ����Ӵ���");
		}
	}
}
