package model.dao;

import java.util.List;

import model.dto.MenuDTO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;

public interface CustomerDAO {
	List<MenuDTO> selectMainMenu();

	List<MenuDTO> selectTopping();

	List<MenuDTO> selectSide();

	int insertOrdersList(OrderDTO orders);

	int insertDetailList(OrderDetailDTO orderdetail);
}
