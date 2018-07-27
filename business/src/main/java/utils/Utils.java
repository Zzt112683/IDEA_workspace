package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entity.Cart;
import entity.UserOrderItem;

public class Utils {

	public static int inputSZ(String msg) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(msg);
		return scanner.nextInt();
	}

	public static String input(String msg) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(msg);
		return scanner.next();
	}
	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		return dateFormat.format(date);
	}

	/*
	 * �����ﳵ��Ϣʵ����ת��Ϊ������ϸʵ����
	 */
	public static UserOrderItem convertToOrderItem(int id, long order_no, Cart cart) {
		UserOrderItem uorderItem = new UserOrderItem();
		uorderItem.setId(id);

		uorderItem.setOrder_no(order_no);
		uorderItem.setProduct_id(cart.getProduct().getId());// ��Ʒid
		uorderItem.setProduct_name(cart.getProduct().getName());
		uorderItem.setProduct_image(cart.getProduct().getImage());
		uorderItem.setCurrent_unit_price(cart.getProduct().getPrice());// ��Ʒ�۸�
		uorderItem.setQuantity(cart.getProductnum()); // ��Ʒ����������
		uorderItem.setTotal_price(cart.getProduct().getPrice() * cart.getProductnum());
		uorderItem.setCreate_time(System.currentTimeMillis());

		return uorderItem;

	}

}
