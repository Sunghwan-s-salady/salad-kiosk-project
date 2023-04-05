package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import exception.DMLException;
import exception.SearchWrongException;
import model.dto.MenuDTO;
import model.dto.OrderDTO;

public class ManagerDAOImpl implements ManagerDAO {
	
	private static ManagerDAOImpl instance = new ManagerDAOImpl();
	
	private ManagerDAOImpl() {}
	public static ManagerDAO getInstance() {
		return instance;
	}
	
	
	/**
	 * @author 서은효
	 * @return List<OrderDTO>
	 * 관리자에서 모든 주문 조회하기 
	 * **/
	@Override
	public List<OrderDTO> selectOrderAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<OrderDTO> list = new ArrayList<>();
		
		String sql = "select order_code, payment_time, total_amount, eat_how from orders";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				OrderDTO orderDTO = new OrderDTO(
						rs.getString("order_code"),
						rs.getString("payment_time"),
						rs.getInt("total_amount"),
						rs.getString("eat_how"));
		
				list.add(orderDTO);
			}
			
		}catch(SQLException e ) {
			//삭제 
			e.printStackTrace();
			throw new SearchWrongException("(관리자) 주문 전체 검색 오류 ");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return list;
	}

	
	/**
	 * @author 서은효
	 * @return List<MenuDTO>
	 * 관리자에서 모든 메뉴 조회하기 
	 * **/
	@Override
	public List<MenuDTO> selectMenuAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<MenuDTO> list = new ArrayList<>();
		
		String sql = "select * from menu";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				MenuDTO menuDTO = new MenuDTO(
						rs.getString("product_Code"),
						rs.getString("product_Name"),
						rs.getInt("price"),
						rs.getInt("category"));
				
				list.add(menuDTO);
			}
			
		}catch(SQLException e ) {
			//삭제 
			e.printStackTrace();
			throw new SearchWrongException("(관리자) 메뉴 전체 검색 오류 ");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return list;
	}

	
	/**
	 * @author 서은효
	 * @return int
	 * 관리자에서 메뉴 추가하기 
	 * **/
	@Override
	public int insertMenu(MenuDTO menuDTO) {
		Connection con = null;
		PreparedStatement ps = null;
		int result  = 0;

		String sql = "insert into Menu (product_code, product_name, price, category) values("+
		"'" + menuDTO.getProductCode()+"'"+","+
		"'" +menuDTO.getProductName()+"',"+
		menuDTO.getPrice()+","+
		menuDTO.getCategory()+")";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
	
		}catch(SQLException e ) {
			//삭제 
			e.printStackTrace();
			throw new DMLException("(관리자) 메뉴 삽입 오류 ");
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
		
	}

	/**
	 * @author 서은효
	 * @return int
	 * 관리자에서 메뉴 삭제하기 
	 * **/
	@Override
	public int deleteMenu(String productName) {
		Connection con = null;
		PreparedStatement ps = null;
		int result  = 0;

		String sql = "delete from Menu where product_name =" + "'" + productName + "'";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
	
		}catch(SQLException e ) {
			//삭제 
			e.printStackTrace();
			throw new DMLException("(관리자) 메뉴 삭제 오류 ");
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
	}

	
	/**
	 * @author 서은효
	 * @return int 
	 * 관리자에서 메뉴 수정하기 
	 * @param menuDTO, updateMenu( 어떤 컬럼을 수정할 것인가?) 
	 * **/
	@Override
	public int updateMenu(String name, String updateMenu, String updateContent) {
		

		String sql = null;
		Connection con = null;
		PreparedStatement ps = null;
		int result  = 0;

		try {
			
			if( updateMenu.equals("이름"))
				sql = "update Menu set product_name = " + "'" + updateContent + "'"
				+ " where product_name = "+ "'" + name + "'";
			else if(updateMenu.equals("가격"))
				sql = "update Menu set price = " + updateContent 
				+ " where product_name = "+ "'" + name + "'";
			else if(updateMenu.equals("분류"))
				sql = "update Menu set category = "+ updateContent 
						+ " where product_name = "+ "'" + name + "'";
			else throw new DMLException("이름 똑바로 입력해 ");

			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
	
		}catch(SQLException e ) {
			//삭제 
			e.printStackTrace();
			throw new DMLException("(관리자) 메뉴 수정 오류 ");
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;

	}

	/**
	 * @author 서은효
	 * @return MenuDTO
	 * 관리자에서 product_code로 특정 주문 조회하기 
	 * **/
	@Override
	public MenuDTO selectMenuOne(String productcode) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MenuDTO menuDTO = null;

		String sql = "select product_code, product_name, price, category from menu where product_code= "+"'"+productcode+"'";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			if(rs.next()) {
				menuDTO = new MenuDTO(
						rs.getString("product_code"),
						rs.getString("product_name"),
						rs.getInt("price"),
						rs.getInt("category"));		
			}
			
		}catch(SQLException e ) {
			//삭제 
			e.printStackTrace();
			throw new SearchWrongException("(관리자) 특정 주문 검색 오류 ");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return menuDTO;
	}

}
