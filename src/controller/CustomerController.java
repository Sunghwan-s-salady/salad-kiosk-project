package controller;

import java.util.ArrayList;
import java.util.List;

import exception.SearchWrongException;
import model.dao.CustomerDAO;
import model.dao.CustomerDAOImpl;
import model.dto.MenuDTO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;
import view.FailView;
import view.MenuView;
import view.SuccessView;

public class CustomerController {	
	static CustomerDAO customerDAO = CustomerDAOImpl.getInstance();
	public static List<MenuDTO> menuList = new ArrayList<>();
	public static List<MenuDTO> mainList = new ArrayList<>();
	public static List<MenuDTO> toppList = new ArrayList<>();
	public static List<MenuDTO> sideList = new ArrayList<>();
	/**
	 * @author 박예린
	 * 메인 메뉴를 선택하는 controller이다.
	 * DAO를 통해 처리한 후 view로 보여준다.
	 */
	public static void selectMainMenu() throws SearchWrongException {
        try {
        	mainList = customerDAO.selectMainMenu();
        	SuccessView.selectMenuPrint(mainList);
	   } catch(SearchWrongException e) {
			   FailView.errorMessage(e.getMessage());
	   }
    }
	/**
	 * @author 박예린
	 * 토핑을 선택하는 controller이다.
	 * DAO를 통해 처리한 후 view로 보여준다.
	 */
	public static void selectTopping() throws SearchWrongException {
        try {
        	toppList = customerDAO.selectTopping();
        	SuccessView.selectMenuPrint(toppList);

	   } catch(SearchWrongException e) {
			   FailView.errorMessage(e.getMessage());
	   }
    }
	/**
	 * @author 박예린
	 * 사이드 메뉴를 선택하는 controller이다.
	 * DAO를 통해 처리한 후 view로 보여준다.
	 */
	public static void selectSideMenu() throws SearchWrongException {
        try {
        	sideList = customerDAO.selectSide();
        	SuccessView.selectMenuPrint(sideList);
	   } catch(SearchWrongException e) {
			   FailView.errorMessage(e.getMessage());
	   }
    }
	/**
	 * @author 박예린
	 * @return result
	 * 메인 메뉴, 토핑 추가, 사이드 메뉴 선택 후 OrderDTO에 담는다.
	 * view에서 TOTAL_AMOUNT, EAT_HOW를 받아오고, 나머지는 DAO에서 처리한다.
	 * DAO 처리 성공 여부를 result로 리턴한다.
	 */
	public static int insertOrdersList() throws SearchWrongException {
		OrderDTO order = new OrderDTO(MenuView.cost, MenuView.place);
		int result = customerDAO.insertOrdersList(order);

        return result;
    }
	
	/**
	 * @author 박예린
	 * @return result
	 * view에서 purchase_List를 받아와서 상품 코드와 수량을 OrderDetailDTO에 담는다.
	 * view에서 TOTAL_AMOUNT를 받아와서 OrderDetailDTO에 담는다. 나머지는 DAO에서 처리한다.
	 * DAO 처리 성공 여부를 result로 리턴한다.
	 */
	public static int orderDetailInsert() throws SearchWrongException {
		int result = 0;
		MenuDTO menuDTO = new MenuDTO();
		
		for(MenuDTO me : MenuView.purchase_List) {
			OrderDetailDTO orderDetail = new OrderDetailDTO(me.getProductCode(), menuDTO.getCount(), MenuView.cost);
			result = customerDAO.insertDetailList(orderDetail);
		}
		
        return result;
    }
}
