package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.xacthucchitietbean;
import bo.hoadonbo;
import bo.xacthucchitietbo;

/**
 * Servlet implementation class AdminXTChiTietDonHangController
 */
@WebServlet("/AdminXTChiTietDonHangController")
public class AdminXTChiTietDonHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminXTChiTietDonHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String mhd = request.getParameter("mhd");
			String mact = request.getParameter("mct");
			
			ArrayList<xacthucchitietbean> dscthd = new ArrayList<xacthucchitietbean>();
			xacthucchitietbo xtcthdbo = new xacthucchitietbo();
			hoadonbo hdbo = new hoadonbo();
			
			if(mact != null) {
				long kq = xtcthdbo.SetDaMua(Long.parseLong(mact));
				int countchuamua = xtcthdbo.CountDonHangChuaMua(Long.parseLong(mhd));
				if(countchuamua == 0) {
					hdbo.SetHDDaMua(Long.parseLong(mhd));
				}
			}
			
			if(mhd !=null) {
				dscthd = xtcthdbo.GetCTHoaDon(Long.parseLong(mhd));
			}
			
			request.setAttribute("dscthd", dscthd);
			RequestDispatcher rd = request.getRequestDispatcher("AdminXTChiTietDonHang.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
