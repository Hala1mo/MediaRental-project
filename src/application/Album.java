package application;


public class Album extends Media {

	// The album class extends media class,so the title and number of copies
	// inherited from the Media class
	// Defining the class's attributes
	String artist;
	String songs;

	public Album(String code,String title, int NumberOfCopies, String artist, String songs) { // constructor with parameters
		super(title, NumberOfCopies,code);
		this.artist = artist;
		this.songs = songs;
		// TODO Auto-generated constructor stub
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Album:artist=" + artist + ", songs=" + songs + ", title=" + title + ", NumberOfCopies="
				+ NumberOfCopies + ", code=" + code ;
	}
	public String toString2() { //this to string to print in the file
		return "Album" +"," +title + "," + NumberOfCopies + "," + code + "," + artist + "," + songs  ;
	}

	
}


