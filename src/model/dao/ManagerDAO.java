package model.dao;

import java.util.List;

import model.dto.MenuDTO;
import model.dto.OrderDTO;
import model.dto.RankDTO;

public interface ManagerDAO {
	/**
	 * @author 서은효
	 * @return List<OrderDTO>
	 * 관리자에서 모든 주문 조회하기 
	 * **/
	List<OrderDTO> selectOrderAll();
	
	
	/**
	 * @author 서은효
	 * @return List<MenuDTO>
	 * 관리자에서 모든 메뉴 조회하기 
	 * **/
	List<MenuDTO>  selectMenuAll();
	
	
	/**
	 * @author 서은효
	 * @return int
	 * 관리자에서 메뉴 추가하기 
	 * **/
	int insertMenu(MenuDTO menuDTO);
	
	
	
	/**
	 * @author 서은효
	 * @return int
	 * 관리자에서 메뉴 삭제하기 
	 * **/
	int deleteMenu(String productName);
	
	
	
	
	/**
	 * @author 서은효
	 * @return int 
	 * 관리자에서 메뉴 수정하기 
	 * @param menuDTO, updateMenu( 어떤 컬럼을 수정할 것인가?) 
	 * **/
	int updateMenu(String name, String updateMenu,String updateContent);
	
	
	
	/**
	 * @author 서은효
	 * @return MenuDTO
	 * @param String productcode
	 * 관리자에서 product_code로 특정 주문 조회하기 
	 * **/
	MenuDTO selectMenuOne(String productcode);

	
	/***
	 * @author 서은효
	 * @return List<RankDTO>
	 * @param int category 
	 * 주문 테이블을 참조해 제품 코드 별 판매 총액을 구한다. 
	 * 판매 총액 별로 순위를 매겨 그에 해당하는 제품 명을 select
	 */
	List<RankDTO> RankMenu(int category);
	
}
