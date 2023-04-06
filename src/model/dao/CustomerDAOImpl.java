package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import common.DBManager;
import model.dto.MenuDTO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;

/**
 * @author 박예린
 * 고객과 관련된 기능을 처리할 때 필요한 JDBC method가 있다.
 * CustomerDAO interface를 상속받는다.
 */
public class CustomerDAOImpl implements CustomerDAO {

	private static CustomerDAOImpl instance = new CustomerDAOImpl();

	private CustomerDAOImpl() {	}

	public static CustomerDAOImpl getInstance() {
		return instance;
	}

	/**
	 * @author 박예린
	 * @return List<MenuDTO>
	 * 고객이 선택한 메인 메뉴를 menuList에 담는다.
	 */
	@Override
	public List<MenuDTO> selectMainMenu() {
		List<MenuDTO> menuList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "select product_code, product_name, price, category from menu where category = 1";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				MenuDTO menuDTO = new MenuDTO();
				menuDTO.setProductCode(rset.getString("product_code"));
				menuDTO.setProductName(rset.getString("product_name"));
				menuDTO.setPrice(rset.getInt("price"));
				menuDTO.setCategory(rset.getInt("category"));

				menuList.add(menuDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, pstmt, rset);
		}

		return menuList;
	}

	/**
	 * @author 박예린
	 * @return List<MenuDTO>
	 * 고객이 선택한 토핑을 menuList에 담는다.
	 */
	@Override
	public List<MenuDTO> selectTopping() {
		List<MenuDTO> menuList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "select product_code, product_name, price, category from menu where category = 2 ";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				MenuDTO menuDTO = new MenuDTO();
				menuDTO.setProductCode(rset.getString("product_code"));
				menuDTO.setProductName(rset.getString("product_name"));
				menuDTO.setPrice(rset.getInt("price"));
				menuDTO.setCategory(rset.getInt("category"));

				menuList.add(menuDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, pstmt, rset);
		}

		return menuList;
	}

	/**
	 * @author 박예린
	 * @return List<MenuDTO>
	 * 고객이 선택한 사이드 메뉴를 menuList에 담는다.
	 */
	@Override
	public List<MenuDTO> selectSide() {
		List<MenuDTO> menuList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "select product_code, product_name, price, category from menu where category = 3";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				MenuDTO menuDTO = new MenuDTO();
				menuDTO.setProductCode(rset.getString("product_code"));
				menuDTO.setProductName(rset.getString("product_name"));
				menuDTO.setPrice(rset.getInt("price"));
				menuDTO.setCategory(rset.getInt("category"));

				menuList.add(menuDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, pstmt, rset);
		}
		return menuList;
	}

	/**
	 * @author 박예린
	 * @param orders
	 * @return result
	 * 주문 코드는 sequence, 결제 시간은 현재 시간으로 설정한다.
	 * query문의 성공 여부는 result로 return한다.
	 */
	@Override
	public int insertOrdersList(OrderDTO orders) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into orders (order_code, payment_time, total_amount, eat_how) values (order_seq.nextval, to_char(sysdate, 'RRRR-MM-DD HH24:MI:SS'), ?, ?)";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, orders.getTotalAmount());		
			pstmt.setString(2, orders.getEatHow());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, pstmt);
		}

		return result;
	}

	/**
	 * @author 박예린
	 * @return result
	 * 주문 상세 코드는 sequence, 주문 코드는 주문 테이블에서 값을 받아온다.
	 * query문의 성공 여부는 result로 return한다.
	 */
	@Override
	public int insertDetailList(OrderDetailDTO orderDetail) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "INSERT INTO Orders_detail (detail_code, product_code, order_count, order_price, order_code) "
				+ "VALUES (detail_seq.nextval, ?, ?, ?, (select order_code from orders where payment_time = (select max(payment_time) from orders)))";

		String productCode = orderDetail.getProductCode();
		int orderCount = orderDetail.getOrderCount();
		int orderPrice = orderDetail.getOrderPrice();

		try {

			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, productCode);
			pstmt.setInt(2, orderCount);
			pstmt.setInt(3, orderPrice);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, pstmt);
		}
		return result;
	}

}
