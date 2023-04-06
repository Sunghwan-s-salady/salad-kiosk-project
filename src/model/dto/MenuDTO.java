package model.dto;

public class MenuDTO {

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}



	private String productCode;
	private String productName;
	private int price;
	private int category;
	private int count; 
	
	public MenuDTO() {};
	
	public MenuDTO(String productCode, String productName, int price, int category, int count) {
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.count = count;
	}
	public MenuDTO( String productName, int price, int category) {
	
		this.productName = productName;
		this.price = price;
		this.category = category;

	}
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
		builder.append(", count=");
		builder.append(count);
		builder.append("]");
		return builder.toString();
	}
	
	
}
