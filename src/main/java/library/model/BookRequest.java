package library.model;

public class BookRequest {
	
	private String fullName;
	private String cat_desc;
	private String book_desc;
	private String message;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCat_desc() {
		return cat_desc;
	}
	public void setCat_desc(String cat_desc) {
		this.cat_desc = cat_desc;
	}
	public String getBook_desc() {
		return book_desc;
	}
	public void setBook_desc(String book_desc) {
		this.book_desc = book_desc;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
