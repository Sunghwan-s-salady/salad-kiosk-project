package model.dto;

public class OrderDetailDTO {

	private String detailCode;
	private String productCode;
	private int orderCount;
	private int orderPrice;
	private String orderCode;

	
	public OrderDetailDTO() {};
	public OrderDetailDTO(String detailCode, String productCode, int orderCount, int orderPrice, String orderCode) {
		super();
		this.detailCode = detailCode;
		this.productCode = productCode;
		this.orderCount = orderCount;
		this.orderPrice = orderPrice;
		this.orderCode = orderCode;
	}
	public String getDetailCode() {
		return detailCode;
	}
	public void setDetailCode(String detailCode) {
		this.detailCode = detailCode;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetailDTO [detailCode=");
		builder.append(detailCode);
		builder.append(", productCode=");
		builder.append(productCode);
		builder.append(", orderCount=");
		builder.append(orderCount);
		builder.append(", orderPrice=");
		builder.append(orderPrice);
		builder.append(", orderCode=");
		builder.append(orderCode);
		builder.append(", getDetailCode()=");
		builder.append(getDetailCode());
		builder.append(", getProductCode()=");
		builder.append(getProductCode());
		builder.append(", getOrderCount()=");
		builder.append(getOrderCount());
		builder.append(", getOrderPrice()=");
		builder.append(getOrderPrice());
		builder.append(", getOrderCode()=");
		builder.append(getOrderCode());
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
