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
	static List<MenuDTO> menuList = new ArrayList<>();

   /**
    * @author 박예린
    * 
    * */
	public static void selectMainMenu() throws SearchWrongException {
        try {
        	SuccessView.selectMenuPrint(customerDAO.selectMainMenu());
	   } catch(SearchWrongException e) {
			   FailView.errorMessage(e.getMessage());
	   }
    }
	
	public static void selectTopping() throws SearchWrongException {
        try {
        	SuccessView.selectMenuPrint(customerDAO.selectTopping());

	   } catch(SearchWrongException e) {
			   FailView.errorMessage(e.getMessage());
	   }
    }
	
	public static void selectSideMenu() throws SearchWrongException {
        try {
        	SuccessView.selectMenuPrint(customerDAO.selectSide());
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
