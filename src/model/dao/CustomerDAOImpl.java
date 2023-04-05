package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import model.dto.MenuDTO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;

public class CustomerDAOImpl implements CustomerDAO {
	List<MenuDTO> menuList = new ArrayList<>();
	
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	private CustomerDAOImpl() {}
	public static CustomerDAOImpl getInstance() {
		return instance;
	}

	/**
	 * @author ifiam
	 * 고객이 선택한 메인 메뉴를 menuList에 담는다.
	 * */
	@Override
	public List<MenuDTO> selectMainMenu() {		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "select product_code, product_name, price, category from menu";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);			
			rset = pstmt.executeQuery();
			
			while( rset.next() ) {
				MenuDTO menuDTO = new MenuDTO();
				menuDTO.setProductCode(rset.getString("product_code"));
				menuDTO.setProductName(sql);
				menuDTO.setPrice(rset.getInt("price"));
				menuDTO.setCategory(rset.getInt("category"));
				
				menuList.add(menuDTO);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection( con, pstmt ,rset);
		}
		
		return menuList;
	}

	/**
	 * 작성자 : 
	 * 고객이 선택한 토핑을 menuList에 담는다.
	 * */
	@Override
	public List<MenuDTO> selectTopping() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "select product_code, product_name, price, category from menu";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);			
			rset = pstmt.executeQuery();
			
			while( rset.next() ) {
				MenuDTO menuDTO = new MenuDTO();
				menuDTO.setProductCode(rset.getString("product_code"));
				menuDTO.setProductName(sql);
				menuDTO.setPrice(rset.getInt("price"));
				menuDTO.setCategory(rset.getInt("category"));
				
				menuList.add(menuDTO);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection( con, pstmt ,rset);
		}
		
		return menuList;
	}

	/**
	 * 작성자 : 
	 * 고객이 선택한 사이드 메뉴를 menuList에 담는다.
	 * */
	@Override
	public List<MenuDTO> selectSide() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "select product_code, product_name, price, category from menu";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);			
			rset = pstmt.executeQuery();
			
			while( rset.next() ) {
				MenuDTO menuDTO = new MenuDTO();
				menuDTO.setProductCode(rset.getString("product_code"));
				menuDTO.setProductName(sql);
				menuDTO.setPrice(rset.getInt("price"));
				menuDTO.setCategory(rset.getInt("category"));
				
				menuList.add(menuDTO);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection( con, pstmt ,rset);
		}
		return menuList;
	}

	/**
	 * 작성자 : 
	 * 주문 정보를 order table에 insert한다.
	 * */
	@Override
	public int insertOrdersList(List<OrderDTO> orders) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into orders (order_code, payment_time, total_amount) values (order_seq.nextval, sysdate, ?)";
		
		int totalAmount = 0; // 수정 필요
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(3, totalAmount);
			
			result = pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection( con, pstmt);
		}
		return result;
	}
	
	/**
	 * 작성자 : 
	 * 고객이 주문한 메뉴를 order_detail table에 insert한다.
	 * */
	@Override
	public int insertDetailList(OrderDetailDTO orderdetail) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into order_detail (detail_code, product_code, order_count, order_price, order_code) values (detail_seq.nextval, ?, ?, ?, ?)";
		
		String detailCode = "example001"; // 수정 필요
		String productCode = "example001"; // 수정 필요
		int orderCount = 0; // 수정 필요
		int orderPrice = 0; // 수정 필요
		String orderCode = "example001"; // 수정 필요
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, detailCode);
			pstmt.setString(2, productCode);
			pstmt.setInt(3, orderCount);
			pstmt.setInt(4, orderPrice);
			pstmt.setString(5, orderCode);
			
			result = pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection( con, pstmt);
		}
		return result;
	}

}
