package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.khachhangbo;

/**
 * Servlet implementation class HoSoController
 */
@WebServlet("/HoSoController")
public class HoSoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HoSoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		try {
			String hoten = request.getParameter("hoten");
			String diachi = request.getParameter("diachi");
			String sdt = request.getParameter("sdt");
			String email = request.getParameter("email");
			String mk = request.getParameter("txtoldpass");
			String newmk = request.getParameter("txtnewpass");
			String cfmk = request.getParameter("txtcfpass");

			String dmkbtn = request.getParameter("dmkbtn");
			String cnbtn = request.getParameter("cnbtn");
			String backbtn = request.getParameter("backbtn");
			khachhangbo khbo = new khachhangbo();

			if (request.getParameter("noterr") != "1") {
				if (cnbtn != null) {
					khachhangbean khbean = (khachhangbean) session.getAttribute("dn");
					int kq = khbo.ThayDoiThongTin(hoten, diachi, sdt, email, khbean.getTendn(), khbean.getPass(),
							(long) khbean.getMakh());

					khachhangbean khmoi = khbo.KTDangNhap(khbean.getTendn(), khbean.getPass());
					session.setAttribute("dn", khmoi);

					response.sendRedirect("HoSo.jsp");
				} else if (backbtn != null) {
					response.sendRedirect("TrangChuController");
				}

				else if (dmkbtn != null) {
					khachhangbean khbeana = (khachhangbean) session.getAttribute("dn");
					if (khbo.ConvertPassMD5(mk).equals(khbeana.getPass())) {
						System.out.print("dung");
						if (newmk.equals(cfmk)) {
							int kq = khbo.ThayDoiThongTin(khbeana.getHoten(), khbeana.getDiachi(), khbeana.getSdt(),
									khbeana.getEmail(), khbeana.getTendn(), khbo.ConvertPassMD5(newmk),
									(long) khbeana.getMakh());

							khachhangbean khmoi = khbo.KTDangNhap(khbeana.getTendn(), khbo.ConvertPassMD5(newmk));
							session.setAttribute("dn", khmoi);
							response.sendRedirect("HoSo.jsp");
						} else {
							request.setAttribute("ebox", "1");
							RequestDispatcher rd = request.getRequestDispatcher("HoSo.jsp");
							rd.forward(request, response);
						}
					} else {
						request.setAttribute("ebox", "1");
						RequestDispatcher rd = request.getRequestDispatcher("HoSo.jsp");
						rd.forward(request, response);
					}
					System.out.print(khbeana.getPass());
				}
				else {
					response.sendRedirect("HoSo.jsp");
				}
				

			} else {
				response.sendRedirect("HoSo.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
