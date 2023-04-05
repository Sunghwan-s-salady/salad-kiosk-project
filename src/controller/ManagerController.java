package controller;

import java.util.List;

import exception.DMLException;
import exception.SearchWrongException;
import model.dao.ManagerDAO;
import model.dao.ManagerDAOImpl;
import model.dto.MenuDTO;
import model.dto.OrderDTO;
import view.FailView;
import view.SuccessView;

public class ManagerController {


	private static ManagerDAO manager = ManagerDAOImpl.getInstance();

	/**
	 * @author 서은효 
	 * @return List<MenuDTO>
	 * 관리자에서 모든 메뉴를 조회한다.
	 * 메뉴가 없을 일은 없다.  
	 */
	public static void selectMenuAl1() {
		
		List<MenuDTO> menuList = manager.selectMenuAll();
		SuccessView.selectMenuPrint(menuList);
	}
	
	/**
	 * @author 서은효 
	 * @return List<OrderDTO>
	 * 관리자에서 모든 주문을 조회한다.
	 * - 주문이 없을 수도 있음   
	 */
	public static void selectOrderAll() {
		
		try{
			List<OrderDTO> orderList = manager.selectOrderAll();
			SuccessView.selectorderPrint(orderList);
		}catch(SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * @author 서은효 
	 * @return int 
	 * 관리자에서 메뉴를 삽입   
	 */
	public static void menuInsert(MenuDTO menu) {
		try {
			int result = manager.insertMenu(menu);
			if(result == 1)
				SuccessView.messagePrint("메뉴가 삽입되었습니다.");
		}catch(DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * @author 서은효 
	 * @return int 
	 * 관리자에서 메뉴를 삭제   
	 */
	public static void menuDelete(String productCode) {
		try {
			int result = manager.deleteMenu(productCode);
			if(result == 1) 
				SuccessView.messagePrint("메뉴가 성공적으로 삭제되었습니다.");
			
		}catch(DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * @author 서은효 
	 * @return int 
	 * 관리자에서 메뉴를 수정 
	 */
	public static void menuUpdate(MenuDTO menu) {
		try {
			int result = manager.updateMenu(menu);
			if(result == 1) {
				SuccessView.messagePrint("메뉴가 성공적으로 수정되었습니다.");
			}
		}catch(DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	
//	/**
//	 * @author 서은효 
//	 * @return MenuDTO
//	 * 관리자에서 productCode로 특정 메뉴를 조회한다. 
//	 * - productCode가 잘못되거나 productCode에 해당하는 주문이 없을 수 있음
//	 * - 주문이 없을 수도 있음   
//	 */
//	public static void selectMenuOne() {
//		//MenuDTO selectMenuOne(String productcode);
//		try {
//			
//		}catch(SearchWrongException e) {
//			
//		}
//		
//	}
	

	
	
}
