package view;

import java.util.List;

import model.dto.MenuDTO;
import model.dto.OrderDTO;



public class SuccessView {
	public static void selectMenuPrint(List<MenuDTO> list) {
		for(int i = 0, k = list.size(); i < k ; i++ ) {
			System.out.println((i+1) + ". " + list.get(i).getProductName()
					+ "("+ list.get(i).getPrice() +")" );
		}
		
	}

	public static void selectorderPrint(List<OrderDTO> list) {
		for(OrderDTO order : list ) {
			System.out.println(order);
		}
	}
	
	public static void messagePrint(String message) {
		System.out.println(message);
	}




}
