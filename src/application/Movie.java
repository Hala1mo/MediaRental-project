package application;

public class Movie extends Media {
	// The Movie class extends media class,so the title and number of copies
	// inherited from the Media class
	// Defining the class's attributes
	String rating;

	public Movie(String code,String title, int NumberOfCopies, String rating) { // constructor with parameters
		super(title, NumberOfCopies,code);
		this.rating=rating;
		// TODO Auto-generated constructor stub
       }

	public void setRating(String rating) throws IllegalArgumentException { // declare exception
		if ((rating.compareTo("HR") == 0) || (rating.compareTo("DR") == 0) || (rating.compareTo("AC") == 0))
			this.rating = rating;
		else
			throw new IllegalArgumentException("error enter HR or DR or AC"); // throw exception

	}

	public String getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "Movie: rating=" + rating + ", title=" + title + ", NumberOfCopies=" + NumberOfCopies + ", code=" + code
				;
	}

	public String toString2() {
		return  "Movie"+ ","  +title+ "," +  NumberOfCopies + "," +code + "," + rating
				;
	}
}


