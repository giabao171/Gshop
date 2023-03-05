package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.adminbean;
import bean.loaibean;
import bo.loaibo;
import bo.mohinhbo;

/**
 * Servlet implementation class AdminThemSanPhamController
 */
@WebServlet("/AdminThemSanPhamController")
public class AdminThemSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminThemSanPhamController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			
			if (request.getParameter("noterr") != "1") {
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
				loaibo lbo = new loaibo();
				ArrayList<loaibean> dsloai = null;
				dsloai = lbo.GetDsLoai();
				request.setAttribute("dsloai", dsloai);
				mohinhbo mhbo = new mohinhbo();
				try {
					String mamohinh = null, tenmohinh = null, soluong = null, gia = null, maloai = null,
							nhasanxuat = null, idreview = null, anhupload = null;

					List<FileItem> fileItems = upload.parseRequest(request);
					for (FileItem fileItem : fileItems) {
						if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
							String nameimg = fileItem.getName();
							if (!nameimg.equals("")) {
								String dirUrl = request.getServletContext().getRealPath("") + "Gshop";
								File dir = new File(dirUrl);
								if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
									dir.mkdir();
								}
								String fileImg = dirUrl + File.separator + nameimg;
								File file = new File(fileImg);// tạo file
								try {
									fileItem.write(file);// ghi file
									anhupload = "Gshop/" + nameimg;
									System.out.println(anhupload);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else {
							String tentk = fileItem.getFieldName();
							if (tentk.equals("txtmamohinh"))
								mamohinh = fileItem.getString("UTF-8");
							if (tentk.equals("txttenmohinh"))
								tenmohinh = fileItem.getString("UTF-8");
							if (tentk.equals("txtsoluong"))
								soluong = fileItem.getString("UTF-8");
							if (tentk.equals("maloai"))
								maloai = fileItem.getString("UTF-8");
							if (tentk.equals("txtnhasanxuat"))
								nhasanxuat = fileItem.getString("UTF-8");
							if (tentk.equals("txtidreview"))
								idreview = fileItem.getString("UTF-8");
							if (tentk.equals("txtgia"))
								gia = fileItem.getString("UTF-8");

						}
					}
					int kt = mhbo.KTDemMoHinh(mamohinh);
					if(kt == 0 ) {
						mhbo.ThemMoHinh(mamohinh, tenmohinh, Integer.parseInt(soluong), Integer.parseInt(gia), maloai,
								anhupload, nhasanxuat, idreview);
//						RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLySanPhamController");
//						rd.forward(request, response);
						response.sendRedirect("AdminQuanLySanPhamController");
					}
					else {
						request.setAttribute("ebox", "1");
						RequestDispatcher rd = request.getRequestDispatcher("AdminThemSanPham.jsp");
						rd.forward(request, response);
					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				RequestDispatcher rd = request.getRequestDispatcher("AdminThemSanPham.jsp");
				rd.forward(request, response);
			}else {
				loaibo lbo = new loaibo();
				ArrayList<loaibean> dsloai = null;
				
				dsloai = lbo.GetDsLoai();
				request.setAttribute("dsloai", dsloai);
				RequestDispatcher rd = request.getRequestDispatcher("AdminThemSanPham.jsp");
				rd.forward(request, response);
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
