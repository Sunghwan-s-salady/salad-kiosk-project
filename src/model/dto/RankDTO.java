package model.dto;

public class RankDTO {
	private  int category;
	private  String product_name;
	private  int total_sales;
	private  int sales_rank;
	public RankDTO(int category, String product_name, int total_sales, int sales_rank) {
		super();
		this.category = category;
		this.product_name = product_name;
		this.total_sales = total_sales;
		this.sales_rank = sales_rank;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getTotal_sales() {
		return total_sales;
	}
	public void setTotal_sales(int total_sales) {
		this.total_sales = total_sales;
	}
	public int getSales_rank() {
		return sales_rank;
	}
	public void setSales_rank(int sales_rank) {
		this.sales_rank = sales_rank;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<성환's 샐러드> 주문내역 매출액이 높은 제품");
		builder.append(product_name);
		builder.append(", 총합 ");
		builder.append(total_sales);
		builder.append(", 제품순위 ");
		builder.append(sales_rank);
		builder.append("] \n");
		return builder.toString();
	}
	
	
}
