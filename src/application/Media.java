package application;


public abstract class Media implements Comparable<Media> {
	protected String title;
	protected int NumberOfCopies;
	protected String code;

	public Media(String title, int numberOfCopies, String code) {
		super();
		this.title = title;
		NumberOfCopies = numberOfCopies;
		this.code = code;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public int getNumberOfCopies() {
		return NumberOfCopies;
	}


	public void setNumberOfCopies(int NumberOfCopies) {
		this.NumberOfCopies = NumberOfCopies;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int compareTo(Media o) {
		return (this.getTitle()).compareTo(o.getTitle());
	}
}


