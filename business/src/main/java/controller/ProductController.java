package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.PageModel;
import entity.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;


@WebServlet(urlPatterns= {"/view/product"})
public class ProductController extends HttpServlet{
	
	ProductService ps = new ProductServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String operation = req.getParameter("operation");
		System.out.println(operation);
		if(operation != null && !operation.equals("")) {
			if(operation.equals("1")) {
				addProduct(req,resp);
				
			}else if(operation.equals("2")) {
				findAll(req,resp);
			}else if(operation.equals("3")) {
				updateProduct(req,resp);
			}else if(operation.equals("4")) {
				deleteProduct(req,resp);
			}else if(operation.equals("5")){
				findProductById(req,resp);
			}else if(operation.equals("6")) {
				findProductByPage(req, resp);
			}
		}else {}
		
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		
	}
	
	public void addProduct(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		Product product = new Product();
		
		String name = req.getParameter("pname");
		String detail = req.getParameter("pdetail");
		String image = req.getParameter("pimage");
		double price = 0.0;
		int stock = 0;
		boolean result = false;
		try {
			price = Double.parseDouble(req.getParameter("price"));
			stock = Integer.parseInt(req.getParameter("stock"));
			product.setName(name);
			product.setDetail(detail);
			product.setPrice(price);
			product.setImage(image);
			product.setStock(stock);
			result = addProduct(product);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(result) {
			System.out.println("��Ʒ��ӳɹ�");
			findProductByPage(req, resp);
		}else {
			System.out.println("��Ʒ���ʧ��");
			
		}
		
	}
	//���
	public boolean addProduct(Product product) {

		return ps.addProduct(product);
	}

	
	//��ѯ
	public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Product> products = ps.findAll();
		req.setAttribute("products", products);
		req.getRequestDispatcher("showproduct.jsp").forward(req, resp);
	}
	
	//��ҳ��ѯ
	public void findProductByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String pageNo = req.getParameter("pageNo");
		String pageSize = req.getParameter("pageSize");
		int _pageNo = 1;
		int _pageSize = 3;
		try {
			if(pageNo!=null) {
				_pageNo = Integer.parseInt(pageNo);
			}
			if(pageSize!= null) {
				_pageSize = Integer.parseInt(pageSize);
			}
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
			
		
		PageModel<Product> pageModel = ps.findProductByPage(_pageNo, _pageSize);
		
		req.setAttribute("pageModel", pageModel);
		req.getRequestDispatcher("showproductbypage.jsp").forward(req, resp);
	}
	
	
	private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
		
		String name = req.getParameter("pname");
		String detail = req.getParameter("pdetail");
		String image = req.getParameter("pimage");
		double price = 0.0;
		int stock = 0;
		int id = 0;
		boolean result = false;
		try {
			price = Double.parseDouble(req.getParameter("price"));
			stock = Integer.parseInt(req.getParameter("stock"));
			id =Integer.parseInt(req.getParameter("id"));
			product.setName(name);
			product.setDetail(detail);
			product.setPrice(price);
			product.setImage(image);
			product.setStock(stock);
			product.setId(id);
			
			result = updateProduct(product);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(result) {
			System.out.println("��Ʒ�޸ĳɹ�");
			findProductByPage(req, resp);
		}else {
			System.out.println("��Ʒ�޸�ʧ��");
		}
		
		
	}
	//�޸�
	public boolean updateProduct(Product product) {

		return ps.updateProduct(product);
	}
	
	
	//ɾ��
	public boolean deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result = false;
		Integer id = Integer.parseInt(req.getParameter("id"));
		result = ps.deleteProduct(id);
		if(result) {
			findProductByPage(req, resp);
		}else {
			System.out.println("ɾ��ʧ��");
		}
		return result;
		
	}

	
	
	
	//������Ʒid������Ʒ
	private void findProductById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		System.out.println(1);
		Product product = findProductById(id);
		System.out.println(product);
		if(product != null) {
			//��ѯ�ɹ�
			req.setAttribute("product", product);
			req.getRequestDispatcher("updateproduct.jsp").forward(req, resp);
		}else {
			System.out.println("��ѯʧ��");
		}
		
	}
	public Product findProductById(int id) {

		return ps.findProductById(id);
	}

}
