package model.dto;

public class OrderDTO {

	private String orderCode;
	private String paymentTime;
	private int totalAmount;
	
	public OrderDTO() {};
	public OrderDTO(String orderCode, String paymentTime, int totalAmount) {
		super();
		this.orderCode = orderCode;
		this.paymentTime = paymentTime;
		this.totalAmount = totalAmount;
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
		builder.append("OrderDTO [orderCode=");
		builder.append(orderCode);
		builder.append(", paymentTime=");
		builder.append(paymentTime);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append(", getOrderCode()=");
		builder.append(getOrderCode());
		builder.append(", getPaymentTime()=");
		builder.append(getPaymentTime());
		builder.append(", getTotalAmount()=");
		builder.append(getTotalAmount());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	

	
	
}