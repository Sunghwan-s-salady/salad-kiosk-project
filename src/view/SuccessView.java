package view;

import java.util.List;

import model.dto.MenuDTO;
import model.dto.OrderDTO;
import model.dto.RankDTO;



public class SuccessView {
	
	/**
	 * @author 조성환
	 * select 된 메뉴 리스트 출력 
	 * */
	public static void selectMenuPrint(List<MenuDTO> list) {
		for(int i = 0, k = list.size(); i < k ; i++ ) {
			System.out.println((i+1) + ". " + list.get(i).getProductName()
					+ "("+ list.get(i).getPrice() +")" );
		}
		
	}
	
	/**
	 * @author 조성환
	 * 분류별 가장 매출이 높은 메뉴 출력
	 * */
	public static void selectRankPrint(List<RankDTO> list) {
		for(int i = 0, k = list.size(); i < k ; i++ ) {
			System.out.println((i+1) + ". " + list.get(i).getProduct_name()
					+ "(매출총액"+ list.get(i).getTotal_sales() + ", 매출순위" + list.get(i).getSales_rank()  + ")");
		}
		
	}
	
	
	/**
	 * @author 조성환
	 * 주문 리스트 출력
	 * */
	public static void selectorderPrint(List<OrderDTO> list) {
		for(OrderDTO order : list ) {
			System.out.println(order);
		}
	}
	
	/**
	 * @author 조성환
	 * 에러메세지 출력
	 * */
	public static void messagePrint(String message) {
		System.out.println(message);
	}




}
