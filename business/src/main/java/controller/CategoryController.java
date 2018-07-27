package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Category;
import entity.PageModel;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/view/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CategoryService cs = new CategoryServiceImpl();
    
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		String operation = req.getParameter("operation");
		System.out.println(operation);
		if(operation != null && !operation.equals("")) {
			if(operation.equals("1")) {
				addCategory(req,resp);
			}else if(operation.equals("2")) {
				findCategory(req, resp);
			}else if(operation.equals("3")) {
				updateCategory(req, resp);
			}else if(operation.equals("4")) {
				deleteCategory(req,resp);
			}else if(operation.equals("5")){
				findCategoryById(req,resp);
			}else if(operation.equals("6")){
				findCategoryByPage(req,resp);
			}
		}else {}
	
	}		
	
		

		// TODO Auto-generated method stub
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
public void addCategory(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		Category category = new Category();
		
		
		String name = req.getParameter("cname");
		
		int parent_id = 0;
		int status = 0;
		int sort_order = 0;
		boolean result = false;
		try {
			parent_id = Integer.parseInt(req.getParameter("pt_id"));
			status = Integer.parseInt(req.getParameter("status"));
			sort_order = Integer.parseInt(req.getParameter("st_od"));		
					
			category.setName(name);
			category.setParent_id(parent_id);
			category.setStatus(status);
			category.setSort_order(sort_order);
			
			result = addCategory(category);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(result) {
			System.out.println("��Ʒ��ӳɹ�");
			findCategory(req, resp);
		}else {
			System.out.println("��Ʒ���ʧ��");
			
		}
		
	}
	//���
	public boolean addCategory(Category category) {

		return cs.addCategory(category);
	}
	
public void findCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Category> categorys = cs.findCategory();
		req.setAttribute("categorys", categorys);
		req.getRequestDispatcher("showcategory.jsp").forward(req, resp);
	}
	
	//ɾ��
	public boolean deleteCategory(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		boolean result = false;
		int id = Integer.parseInt(req.getParameter("id"));
		result = cs.deleteCategory(id);
		if(result) {
			System.out.println("ɾ���ɹ�");
			findCategory(req, resp);
		}else {
			
		}
		
		return result;
		
	}
	
	//�޸�
	private void updateCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Category category = new Category();
		
		String name = req.getParameter("cname");
		int parent_id = 0;
		int status = 0;
		int sort_order = 0;
		int id = 0;
		
		boolean result = false;
		try {
			parent_id = Integer.parseInt(req.getParameter("pt_id"));
			status = Integer.parseInt(req.getParameter("status"));
			sort_order = Integer.parseInt(req.getParameter("st_od"));
			id = Integer.parseInt(req.getParameter("id"));
			category.setName(name);
			category.setParent_id(parent_id);
			category.setStatus(status);
			category.setSort_order(sort_order);
			category.setId(id);

			result = updateCategory(category);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(result) {
			System.out.println("�޸ĳɹ�");
			findCategory(req,resp);
		}else {
			System.out.println("�޸�ʧ��");
		}
	}
	
	public boolean updateCategory(Category category) {
		
		return cs.updateCategory(category);
	}
	
	
	//����id�鿴��Ʒ
	private void findCategoryById(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Category category = findCategoryById(id);
		if(category != null) {
			req.setAttribute("category", category);
			req.getRequestDispatcher("updatecategory.jsp").forward(req, resp);
		}else {
			System.out.println("��ѯʧ��");
		}	
	}

	public Category findCategoryById(int id) {
		return cs.findCategoryById(id);
		
	}
	
	
	//��ҳ��ѯ
	public void findCategoryByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
		
			
		
		PageModel<Category> pageModel = cs.findCatrgoryByPage(_pageNo, _pageSize);
		
		req.setAttribute("pageModel", pageModel);
		req.getRequestDispatcher("showcategorybypage.jsp").forward(req, resp);
	}
	
	

}
