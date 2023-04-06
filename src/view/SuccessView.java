package view;

import java.util.List;

import model.dto.MenuDTO;
import model.dto.OrderDTO;



public class SuccessView {
	
	/**
	 * select 된 메뉴 리스트 출력 
	 * */
	public static void selectMenuPrint(List<MenuDTO> list) {
		for(int i = 0, k = list.size(); i < k ; i++ ) {
			System.out.println((i+1) + ". " + list.get(i).getProductName()
					+ "("+ list.get(i).getPrice() +")" );
		}
		
	}
	
	/**
	 * 주문 리스트 출력
	 * */
	public static void selectorderPrint(List<OrderDTO> list) {
		for(OrderDTO order : list ) {
			System.out.println(order);
		}
	}
	
	/**
	 * 에러메세지 출력
	 * */
	public static void messagePrint(String message) {
		System.out.println(message);
	}




}
