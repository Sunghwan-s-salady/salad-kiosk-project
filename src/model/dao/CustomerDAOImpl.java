package model.dao;

import java.util.List;

import model.dto.MenuDTO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<MenuDTO> selectMainMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuDTO> selectTopping() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuDTO> selectSide() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> orders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOrdersList(List<OrderDTO> orders) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertDetailList(OrderDetailDTO orderdetail) {
		// TODO Auto-generated method stub
		return 0;
	}

}
