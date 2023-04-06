package model.dao;

import java.util.List;

import model.dto.MenuDTO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;

public interface CustomerDAO {
	/**
	 * @author 박예린
	 * 메뉴 테이블의 메인 메뉴를 조회한다.
	 * select product_code, product_name, price, category from menu where category = 1
	 * */
	List<MenuDTO> selectMainMenu();
	/**
	 * @author 박예린
	 * 메뉴 테이블의 토핑을 조회한다.
	 * select product_code, product_name, price, category from menu where category = 2
	 * */
	List<MenuDTO> selectTopping();
	/**
	 * @author 박예린
	 * 메뉴 테이블의 사이드 메뉴를 조회한다.
	 * select product_code, product_name, price, category from menu where category = 3
	 * */
	List<MenuDTO> selectSide();
	/**
	 * @author 박예린
	 * 주문 정보를 주문 테이블에 등록한다.
	 * insert into orders (order_code, payment_time, total_amount, eat_how)
	 * values (order_seq.nextval, to_char(sysdate, 'RRRR-MM-DD HH24:MI:SS'), ?, ?)
	 * */
	int insertOrdersList(OrderDTO orders);
	/**
	 * @author 박예린
	 * 주문 상세 정보를 주문 상세 테이블에 등록한다.
	 * INSERT INTO Orders_detail (detail_code, product_code, order_count, order_price, order_code)
	 * VALUES (detail_seq.nextval, ?, ?, ?, (select order_code from orders where payment_time = (select max(payment_time) from orders)))
	 * */
	int insertDetailList(OrderDetailDTO orderdetail);
}
