package application;
import java.util.ArrayList;
	

	interface MediaRentalInt {
	        //MediaRentalInt interface
		//The methods here don't have a body,the body is provided by the "implement class" which is here The MediaRental
		 void addCustomer(String name, String address,String ID, String number, String plan);
		 void addMovie(String title, int copiesAvailable,String code,String rating);
		 void addGame(String title, int copiesAvailable,String code,double weight);
		 void addAlbum(String title,int copiesAvailable,String code,String artist,String songs);
		 void setLimitedPlanLimit(int value);
		 String getAllCustomersInfo();
		 String getAllMediaInfo();
		 boolean addToCart(String Id,String code);
		 boolean removeFromCart(String customerName, String mediaTitle);
		 String processRequests();
		 boolean returnMedia(String customerID,String mediaCode);
		 ArrayList<String> searchMedia(String title,String rating, String artist,String songs);
		 
	}