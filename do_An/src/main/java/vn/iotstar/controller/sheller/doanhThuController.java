package vn.iotstar.controller.sheller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Ellipse2D;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Base64;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.DoanhThuModel;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.services.IDatPhongService;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.impl.DatPhongServiceImpl;
import vn.iotstar.services.impl.KhachSanServiceImpl;

@WebServlet(urlPatterns = {"/sheller/doanhThu"})
public class doanhThuController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IKhachSanService khachSanService = new KhachSanServiceImpl();
	IDatPhongService datPhongService = new DatPhongServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		int idUser = (int) session.getAttribute("idUser");
		List<KhachSanModel> listKS = khachSanService.findByIdUser(idUser);
		req.setAttribute("listKS", listKS);
		req.getRequestDispatcher("/views/sheller/doanhThu.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idKSStr = req.getParameter("hotel");
		int idKS = Integer.parseInt(idKSStr);
		String ngayBatDauStr = req.getParameter("startDate");
		Date ngayBatDau = Date.valueOf(ngayBatDauStr);
		String ngayKetThucStr = req.getParameter("endDate");
		Date ngayKetThuc = Date.valueOf(ngayKetThucStr);
		List <DoanhThuModel> listDoanhThu = datPhongService.findAllDoanhThu(ngayBatDau, ngayKetThuc, idKS);
		
		int tongDatPhong = 0;
		int tongTienDP = 0;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (DoanhThuModel doanhThu : listDoanhThu) {
			tongDatPhong = tongDatPhong + doanhThu.getTongPhongDat();
			tongTienDP = tongTienDP + doanhThu.getTongTien();
			dataset.addValue(doanhThu.getTongTien(), "Doanh thu", doanhThu.getNgayDat());
		}
		req.setAttribute("tongdatphong", tongDatPhong);
		req.setAttribute("tongtiendp", tongTienDP);
		
		// Tạo biểu đồ dòng
        JFreeChart chart = ChartFactory.createLineChart(
                "Biểu đồ doanh thu",
                "Ngày",
                "Doanh thu (VND)",
                dataset,
                PlotOrientation.VERTICAL,
                false,                      // Legend
                true,                       // Tooltips
                false    
        );
        
        // Tuỳ chỉnh giao diện biểu đồ
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setOutlineVisible(false);

        // Tuỳ chỉnh trục
        Font axisFont = new Font("SansSerif", Font.BOLD, 12);
        plot.getDomainAxis().setTickLabelFont(axisFont); // Trục X
        plot.getDomainAxis().setLabelFont(new Font("SansSerif", Font.PLAIN, 14)); // Tiêu đề trục X
        plot.getRangeAxis().setTickLabelFont(axisFont); // Trục Y
        plot.getRangeAxis().setLabelFont(new Font("SansSerif", Font.PLAIN, 14)); // Tiêu đề trục Y

        // Tạo renderer và thêm bóng mờ
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelFont(new Font("SansSerif", Font.BOLD, 10));
        renderer.setDefaultItemLabelPaint(Color.BLUE);
        renderer.setSeriesPaint(0, new Color(54, 162, 235)); // Đường màu xanh dương
        renderer.setSeriesStroke(0, new BasicStroke(2.0f)); // Nét đậm hơn
        renderer.setSeriesShapesVisible(0, true); // Hiển thị điểm
        renderer.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6)); // Điểm hình tròn

        plot.setRenderer(renderer);

        // Xuất biểu đồ thành ảnh Base64
        String chartBase64 = null;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            ChartUtils.writeChartAsPNG(out, chart, 1000, 600); // Kích thước lớn hơn
            byte[] bytes = out.toByteArray();
            chartBase64 = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        KhachSanModel ks = khachSanService.findById(idKS);
        req.setAttribute("chartImage", chartBase64);
        req.setAttribute("tenks", ks.getTen());
        req.setAttribute("ngaybatdau", ngayBatDau);
        req.setAttribute("ngayketthuc", ngayKetThuc);
		System.out.println (idKS + " " + ngayBatDau + " " + ngayKetThuc);
		req.getRequestDispatcher("/views/sheller/doanhThu.jsp").forward(req, resp);
	}

}
