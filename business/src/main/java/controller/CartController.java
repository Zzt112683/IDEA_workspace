package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cart;
import entity.Product;
import service.CartService;
import service.ProductService;
import service.impl.CartServiceImpl;
import service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/view/cart"})
public class CartController extends HttpServlet{

	CartService cs = new CartServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String operation = req.getParameter("operation");
		System.out.println(operation);
		if(operation != null && !operation.equals("")) {
			if(operation.equals("1")) {
				addCart(req,resp);
			}else if(operation.equals("2")) {
				findCart(req, resp);
			}else if(operation.equals("3")) {
				updateCart(req, resp);
			}else if(operation.equals("4")) {
				deleteCart(req,resp);
			}else if(operation.equals("5")){
				findProductById_upd(req,resp);
			}else if(operation.equals("6")){
				findProductById(req,resp);//��ȡ��ӵ�id
			}
		}else {}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
	
	
	public void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cart cart = new Cart();
		Product product = new Product();
		int id = 0;
		int productnum = 0;
		boolean result = false;
		try {
			id =Integer.parseInt(req.getParameter("id"));
			productnum =Integer.parseInt(req.getParameter("pnum"));
			cart.setProductnum(productnum);
			product.setId(id);
			cart.setProduct(product);
			result = addCart(cart);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(result) {
			//��ӹ��ﳵ�ɹ�
			System.out.println("添加成功");
			findCart(req, resp);
		}else {
			System.out.println("添加失败");
		}
	}
	public boolean addCart(Cart cart) {

		return cs.addCart(cart);
	}

	//��ѯ���ﳵ
	public void findCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Cart> carts = cs.findCart();
		req.setAttribute("carts", carts);
		req.getRequestDispatcher("showcart.jsp").forward(req, resp);
		
	}


	public void updateCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cart cart = new Cart();
		Product product = new Product();
		int id = 0;
		int productnum = 0;
		boolean result = false;
		try {
			id =Integer.parseInt(req.getParameter("id"));
			productnum =Integer.parseInt(req.getParameter("pnum"));
			cart.setProductnum(productnum);
			product.setId(id);
			cart.setProduct(product);
			result = updateCart(cart);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(result) {
			//��ӹ��ﳵ�ɹ�
			System.out.println("更新成功");
			findCart(req, resp);
		}else {
			System.out.println("更新失败");
		}
		
		
	}
	public boolean updateCart(Cart cart) {

		return cs.updateCart(cart);
	}
	
	

	public boolean deleteCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result = false;
		Integer id = Integer.parseInt(req.getParameter("id"));
		result = cs.deleteCart(id);
		if(result) {
			System.out.println("删除成功");
			findCart(req, resp);
		}else {
			System.out.println("删除失败");
		}
		return result;
		
	}


	public int getOrderId() {

		return cs.getOrderId();
	}
	
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		return cs.updateCart(id,num);
	}

	public Cart getCartById(int id) {
		return cs.getCartById(id);

	}
	
	//������Ʒid������Ʒ      ��ӹ��ﳵ��
		private void findProductById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			Integer id = Integer.parseInt(req.getParameter("id"));
			System.out.println(1);
			Product product = findProductById(id);
			
			if(product != null) {
				//��ѯ�ɹ�
				req.setAttribute("product", product);
				req.getRequestDispatcher("addcart.jsp").forward(req, resp);
			}else {
				System.out.println("��ѯʧ��");
			}
			
		}
		
		public Product findProductById(int id) {
			ProductService ps = new ProductServiceImpl();
			return ps.findProductById(id);
		}

		//������Ʒid������Ʒ      �޸Ĺ��ﳵ��
		private void findProductById_upd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			Integer id = Integer.parseInt(req.getParameter("id"));
			
			Product product = findProductById_upd(id);
			System.out.println(product);
			if(product != null) {
				//��ѯ�ɹ�
				req.setAttribute("product", product);
				req.getRequestDispatcher("updatecart.jsp").forward(req, resp);
			}else {
				System.out.println("��ѯʧ��");
			}
			
		}
		
		public Product findProductById_upd(int id) {
			ProductService ps = new ProductServiceImpl();
			return ps.findProductById(id);
		}

}
