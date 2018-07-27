package data;

import java.util.ArrayList;
import java.util.List;


import entity.*;

public class Data {

	public static List<Account> accs = new ArrayList<Account>();
	public static List<Product> products = new ArrayList<Product>();
	public static List<Cart> carts = new ArrayList<Cart>();

	/*
	 * ������������
	 */
	public static List<UserOrder> orders = new ArrayList<UserOrder>();

	/*
	 * ����������ϸ����
	 */
	public static List<UserOrderItem> orderItems = new ArrayList<UserOrderItem>();

	public Data() {
		Account acc = new Account(1, "admin", "admin");
		accs.add(acc);
	}
}
