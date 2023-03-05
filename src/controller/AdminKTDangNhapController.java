package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.adminbean;
import bo.adminbo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class AdminKTDangNhapController
 */
@WebServlet("/AdminKTDangNhapController")
public class AdminKTDangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminKTDangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		try {
			String un = request.getParameter("un");
			String pass = request.getParameter("pass");
			
			adminbean adbean = new adminbean();
			adminbo adbo = new adminbo();

			int demLogin;

			if (session.getAttribute("countLogin") == null) {
				demLogin = 0;
				session.setAttribute("countLogin", 0);
			} else {
				demLogin = (int) session.getAttribute("countLogin");
			}
			
			if(request.getParameter("lou")!=null && request.getParameter("lou")!="")
				session.setAttribute("dnad", null);

			if (un != null && pass != null && demLogin < 3) {
				adbean = adbo.KTDangNhap(un, adbo.ConvertPassMD5(pass));
//				khbean = khbo.KTDangNhap(un,pass);
//				System.out.print(khbean);
				
				
				if (adbean != null) {

					demLogin = 0;
					session.setAttribute("countLogin", demLogin);
					session.setAttribute("dnad", adbean);
					RequestDispatcher rd = request.getRequestDispatcher("AdminTrangChuController");
					rd.forward(request, response);
				} else {
					demLogin = demLogin + 1;
					session.setAttribute("countLogin", demLogin);
					request.setAttribute("kt", 1);
					RequestDispatcher rd = request.getRequestDispatcher("AdminDangNhap.jsp");
					rd.forward(request, response);
				}

			} else  {
				if (demLogin >= 3) {
					Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
					request.setCharacterEncoding("UTF-8");
					String answer = request.getParameter("answer");
					if (answer == null) {
						demLogin = demLogin + 1;
						session.setAttribute("countLogin", demLogin);
					}

					else if (captcha.isCorrect(answer)) {
						demLogin = 0;
						session.setAttribute("countLogin", demLogin);
//						response.getWriter().print("CaptCha dung");

					} else {
						demLogin = demLogin + 1;
						session.setAttribute("countLogin", demLogin);
//						response.getWriter().print("CaptCha sai");
					}
				}

				RequestDispatcher rd = request.getRequestDispatcher("AdminDangNhap.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
