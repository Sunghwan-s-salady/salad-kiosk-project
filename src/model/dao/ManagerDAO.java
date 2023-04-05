package model.dao;

import java.util.List;

import model.dto.MenuDTO;
import model.dto.OrderDTO;

public interface ManagerDAO {
	
	List<OrderDTO> selectOrderAll();
	
	List<MenuDTO>  selectMenuAll();
	
	int insertMenu(MenuDTO menuDTO);
	
	int deleteMenu(String productCode);
	
	int updateMenu(MenuDTO menuDTO);
	
	MenuDTO selectMenuOne(String productcode);
}
