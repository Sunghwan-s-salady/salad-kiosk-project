package model.dao;

import java.util.List;

import model.dto.MenuDTO;

public interface ManagerDAO {
	
	List<MenuDTO> selectOrder( );
	
	List<MenuDTO>  selectMenuAll();
	
	int insertMenu(MenuDTO menuDTO);
	
	int deleteMenu(String productCode);
	
	int updateMenu(MenuDTO menuDTO);
	
	int selectMenuOne(int menuNumber);
}
