package library.model;

public class Book {
	
	private int bid;
	private int cid;
	private String book_desc;
	private int quantity;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getBook_desc() {
		return book_desc;
	}
	public void setBook_desc(String book_desc) {
		this.book_desc = book_desc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
