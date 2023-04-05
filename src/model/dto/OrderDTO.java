package model.dto;

public class OrderDTO {

	private String orderCode;
	private String paymentTime;
	private int totalAmount;
	private String eatHow;
	

	public OrderDTO(String orderCode, String paymentTime, int totalAmount, String eatHow) {
		super();
		this.orderCode = orderCode;
		this.paymentTime = paymentTime;
		this.totalAmount = totalAmount;
		this.eatHow = eatHow;
	}
	

	public String getEatHow() {
		return eatHow;
	}
	public void setEatHow(String eatHow) {
		this.eatHow = eatHow;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<성환's 샐러드> 주문내역 [주문코드=");
		builder.append(orderCode);
		builder.append(", 주문시간=");
		builder.append(paymentTime);
		builder.append(", 주문총액=");
		builder.append(totalAmount);
		builder.append("]");
		return builder.toString();
	}
	

	
	
}