package controller;

import java.util.ArrayList;
import java.util.List;

import exception.DMLException;
import exception.SearchWrongException;
import model.dao.CustomerDAO;
import model.dao.CustomerDAOImpl;
import model.dto.MenuDTO;
import model.dto.OrderDetailDTO;
import view.FailView;
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
    * 메인 메뉴, 토핑 추가, 사이드 메뉴 선택 후 OrderDetailDTO orderDetail에 담는다.
    * */
	public static int orderDetailInsert() throws SearchWrongException {
		int result = 0;
		
		OrderDetailDTO orderDetail = new OrderDetailDTO();
		/*orderDetail.
		
		String sql = "select product_code, product_name, price, category from menu";
		
		CREATE TABLE Orders_detail (
				  detail_code VARCHAR2(20)  NOT NULL,
				  product_code VARCHAR2(20) REFERENCES Menu(product_code) NOT NULL,
				  order_count NUMBER NOT NULL,
				  order_price NUMBER NOT NULL,
				  order_code VARCHAR2(20) REFERENCES Orders(order_code) NOT NULL
				);


		
		while(menuList.size()) {
			BoardDTO dto = new BoardDTO(rs.getInt("BOARD_NO"), rs.getString("SUBJECT"), 
					rs.getString("WRITER"), rs.getString("CONTENT"), rs.getString("BOARD_DATE"));
			list.add(dto);
		}*/

        return result;
    }
}
