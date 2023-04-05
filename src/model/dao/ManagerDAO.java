package model.dao;

import java.util.List;

import model.dto.MenuDTO;
import model.dto.OrderDTO;

public interface ManagerDAO {
	
	List<OrderDTO> selectOrderAll();
	
	List<MenuDTO>  selectMenuAll();
	
	int insertMenu(MenuDTO menuDTO);
	
	int deleteMenu(String productName);
	
	int updateMenu(String name, String updateMenu,String updateContent);
	
	MenuDTO selectMenuOne(String productcode);
}
