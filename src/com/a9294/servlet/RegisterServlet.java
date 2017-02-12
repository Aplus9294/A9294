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
			Class.forName("com.mysql.jdbc.Driver");// 加载数据库驱动
			String url = "jdbc:mysql://localhost:3306/db_a9494User";
			String username = "root";
			String password = "78711116814ZKybb";
			con = DriverManager.getConnection(url, username, password); // 获取数据库连接
			if (con != null) {
				System.out.println("数据库连接成功");
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
		// 设置request与response的编码
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 获取表单中属性值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String secQuestion = request.getParameter("secQuestion");
		String secQuestionAns = request.getParameter("secQuestionAns");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		// 判断数据库是否连接成功
		if (con != null) {
			try {
				// 插入注册信息的SQL语句(使用?占位符)
				String sql = "insert into tb_a9294user(username,password,sex,secQuestion,secQuestionAns,email,birthday) "
						+ "values(?,?,?,?,?,?,?)";
				// 创建PreparedStatement对象
				PreparedStatement ps = con.prepareStatement(sql);
				// 对SQL语句中的参数动态赋值
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, sex);
				ps.setString(4, secQuestion);
				ps.setString(5, secQuestionAns);
				ps.setString(6, email);
				ps.setString(7, birthday);
				// 执行更新操作
				ps.executeUpdate();
				// 获取PrintWriter对象
				PrintWriter out = response.getWriter();
				// 输出注册结果信息
				out.print("<center><h1>");
				out.print(username + "注册成功！");
				out.print("</h1></center>");
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 发送数据库连接错误提示信息
			response.sendError(500, "数据库连接错误！");
		}
	}
}
