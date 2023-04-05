package model.dto;

public class MenuDTO {

	private String productCode;
	private String productName;
	private int price;
	private int category;
	
	public MenuDTO() {};
	public MenuDTO(String productCode, String productName, int price, int category) {
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.category = category;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuDTO [productCode=");
		builder.append(productCode);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", price=");
		builder.append(price);
		builder.append(", category=");
		builder.append(category);
		builder.append(", getProductCode()=");
		builder.append(getProductCode());
		builder.append(", getProductName()=");
		builder.append(getProductName());
		builder.append(", getPrice()=");
		builder.append(getPrice());
		builder.append(", getCategory()=");
		builder.append(getCategory());
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
