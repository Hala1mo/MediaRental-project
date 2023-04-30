package application;


public class Game extends Media {
	// The Game class extends media class,so the title and number of copies
	// inherited from the Media class
	// Defining the class's attributes
	double weight;
	

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Game(String code,int NumberOfCopies, String title, double weight) { // constructor with parameters
		super(title, NumberOfCopies,code);
		this.weight = weight;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Game :weight=" + weight + ", title=" + title + ", NumberOfCopies=" + NumberOfCopies + ", code=" + code
				;
	}
	
	public String toString2() {
		return  "Game" +"," +title  + ","+ NumberOfCopies + "," + code + "," +weight  ;
	}
	
}

