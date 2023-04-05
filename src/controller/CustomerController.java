package controller;

import java.util.ArrayList;
import java.util.List;

import exception.DMLException;
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
    * 
    * */
	public static void selectMainMenu() throws SearchWrongException {
        try {
        	mainList = customerDAO.selectMainMenu();
        	SuccessView.selectMenuPrint(mainList);
	   } catch(SearchWrongException e) {
			   FailView.errorMessage(e.getMessage());
	   }
    }
	
	public static void selectTopping() throws SearchWrongException {
        try {
        	toppList = customerDAO.selectTopping();
        	SuccessView.selectMenuPrint(toppList);

	   } catch(SearchWrongException e) {
			   FailView.errorMessage(e.getMessage());
	   }
    }
	
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
    * 메인 메뉴, 토핑 추가, 사이드 메뉴 선택 후 결제 전 고객의 주문 내역을 보여준다.
    * */
	
	/**
    * @author 박예린
    * 메인 메뉴, 토핑 추가, 사이드 메뉴 선택 후 OrderDTO에 담는다.
    * insertOrdersList
    * */
	public static int insertOrdersList() throws SearchWrongException {
		int result = 0;
		
		MenuDTO menuDTO = new MenuDTO();
		// 이 놈 안에 MenuDTO가 있어 => 이거로  OrderDetailDTO를 만들어 
		
		
		OrderDTO order = new OrderDTO(MenuView.cost, MenuView.place);
		customerDAO.insertOrdersList(order);

        return result;
    }
	
	/**
    * @author 박예린
    * 메인 메뉴, 토핑 추가, 사이드 메뉴 선택 후 OrderDetailDTO orderDetail에 담는다.
    * insertDetailList
    * */
	public static int orderDetailInsert() throws SearchWrongException {
		int result = 0;
		
		MenuDTO menuDTO = new MenuDTO();
		// 이 놈 안에 MenuDTO가 있어 => 이거로  OrderDetailDTO를 만들어 
		
		for(MenuDTO me : MenuView.purchase_List) {
			OrderDetailDTO orderDetail = new OrderDetailDTO(me.getProductCode(), menuDTO.getCount(), MenuView.cost); // orderCount 수정해야함
			// 만든 거를 insert
			customerDAO.insertDetailList(orderDetail);
		}

        return result;
    }
}
