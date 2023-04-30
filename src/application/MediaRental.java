package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MediaRental implements MediaRentalInt {

	// Here because this class implements an interface,so we have to override all of
	// its methods.
	int limit;

	public MediaRental() {
	}

	protected ArrayList<Customer> customers = new ArrayList<>(); // we created an arraylist to store objects of type
			// Customer.
	

	public void addCustomer(String name, String address,String ID, String number, String plan) {
		
			customers.add(new Customer( name, address, ID,number, plan)); // Add new customer in the arraylist Customer.
	}
	

	public String customerinfo(String ID) {
		String info = "not found";
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
				info = customers.get(i).toString();
			}
		}
		return info;

	}

	public String mediainfo(String code) {
		String info = "not found";
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				info = medias.get(i).toString();
			}
		}
		return info;

	}


	public int CustomerID(String ID) {
		int flag = 0;
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
				flag = 1;
			}

		}
		return flag;
	}

	public String CustomerName(String ID) {
		String name = "not found";
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
				name = customers.get(i).getName();

			}
		}
		return name;
	}

	public String CustomerAddress(String ID) {
		String address = "not found";
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
				address = customers.get(i).getAddress();

			}
		}
		return address;
	}

	public String CustomerNumber(String ID) {
		String number = "not found";
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
				number = customers.get(i).getNumber();

			}
		}
		return number;
	}

	public void removeCustomer(String ID) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0)
				customers.remove(i);
		}
	}

	public String CustomerPlan(String ID) {
		String plan = "not found";
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
				plan = customers.get(i).getPlan();

			}
		}
		return plan;
	}

	public void UpdateName(String ID, String name) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
			customers.get(i).setName(name);
		}
	}
	}
	public void UpdateID(String ID, String ID2) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
			customers.get(i).setID(ID2);
			}
		}
	}

	public void UpdateAddress(String ID, String address) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
			customers.get(i).setAddress(address);
		    }
		}
	}

	public void UpdateMobileNum(String ID, String mo) {
		
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
			customers.get(i).setNumber(mo);
			}
		}
	}

	public void UpdatePlan(String ID, String plan) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
			customers.get(i).setPlan(plan);
			
			}
		}
	}

	protected ArrayList<Media> medias = new ArrayList<>(); // we created an arraylist to store objects of type Media.

	public void addMovie(String title, int copiesAvailable, String code, String rating) {

		medias.add(new Movie(code, title, copiesAvailable, rating));// Adds new movie in the arraylist MEDIAS

	}
	
	public void addGame(String title, int copiesAvailable,String code,double weight) {
		medias.add(new Game(code,copiesAvailable,title,weight)); // Adds new Game in the arraylist MEDIAS
	}

	public void addAlbum(String title, int copiesAvailable, String code, String artist, String songs) {
		medias.add(new Album(code, title, copiesAvailable, artist, songs)); // Adds new Album in the array MEDIAS

	}

	public int MediaCode(String code) {       //check if there's a media with this code
		int flag = 0;
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				flag = 1;
			}

		}
		return flag;
	}

	public String MediaType(String code) {
		String type = "";
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i) instanceof Movie) {
				if (medias.get(i).getCode().compareTo(code) == 0) {
					type = "Movie";
				}
			} else if (medias.get(i) instanceof Album) {
				if (medias.get(i).getCode().compareTo(code) == 0) {
					type = "Album";
				}
			} else
				type = "Game";
		}
		return type;
	}

	public String MediaName(String code) {
		String name = "";
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				name = medias.get(i).getTitle();

			}
		}
		return name;
	}

	public void UpdateMediaName(String code, String name) {
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				medias.get(i).setTitle(name);
			}
		}
	}

	public void UpdateMediacopies(String code, int num) {
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				medias.get(i).setNumberOfCopies(num);
			}
		}
	}

	public void UpdateMediaCode(String code, String code2) {
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				medias.get(i).setCode(code2);
			}
		}
	}

	public void UpdateRating(String code, String rating) {
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				((Movie) medias.get(i)).setRating(rating);

			}

		}
	}

	public void UpdateWeight(String code, double w) {
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				((Game) medias.get(i)).setWeight(w);

			}

		}
	}

	public void UpdateArtist(String code, String w) {
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				((Album) medias.get(i)).setArtist(w);

			}

		}
	}

	public void UpdateSongs(String code, String w) {
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				((Album) medias.get(i)).setSongs(w);
				;

			}

		}
	}

	public int MediaCopies(String code) {
		int copies=0;
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				copies = medias.get(i).getNumberOfCopies();

			}
		}
		return copies;
	}

	public void removeMedia(String code) {
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0)
				medias.remove(i);
		}
	}

	public String MediaRtaing(String code) {
		String rating = "";
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {

				rating = ((Movie) medias.get(i)).getRating();

			}
		}
		return rating;
	}

	public double MediaWeight(String code) {
		double w = 0;
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				w = ((Game) medias.get(i)).getWeight();

			}
		}
		return w;
	}

	public String MediaArtist(String code) {
		String w = "";
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				w = ((Album) medias.get(i)).getArtist();

			}
		}
		return w;
	}

	public String MediaSongs(String code) {
		String w = "";
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i).getCode().compareTo(code) == 0) {
				w = ((Album) medias.get(i)).getSongs();

			}
		}
		return w;
	}

	public void setLimitedPlanLimit(int value) {
		// This method set the number of media associated with the LIMITED plan
		this.limit = value;
	}

	public String getAllCustomersInfo() {
		
		// Returns information about the customers in the database(Array list customers)
		// The information is presented sorted by customer
		String Info="";
		Collections.sort(customers);
		for (int i = 0; i < customers.size(); i++) {
			Info = Info + customers.get(i).toString()+"\n";
			//Info = Info + customers.get(i).PrintForFile()+"\n";
		}
		return Info;
	}
	public String getAllCustomersInfo2() {
		
		// Returns information about the customers in the database(Array list customers)
		// The information is presented sorted by customer
		String Info="";
		Collections.sort(customers);
		for (int i = 0; i < customers.size(); i++) {
			//Info = Info + customers.get(i).toString()+"\n";
			Info = Info + customers.get(i).PrintForFile()+"\n";
		}
		return Info;
	}


	
	public String getAllMediaInfo() {
		// Returns information about all the media (movies, albums, and games) that are
		// part of the database. The information
		// is presented sorted by media title
		Collections.sort(medias);
		String Info = "";
		for (int i = 0; i < medias.size(); i++) {
			Info = Info + medias.get(i).toString()+"\n";
		}
		return Info;
	}
	
	public String getAllMediaInfo2() {
		// Returns information about all the media (movies, albums, and games) that are
		// part of the database. The information
		// is presented sorted by media title
		Collections.sort(medias);
		String Info = "";
		for (int i = 0; i < medias.size(); i++) {
			if (medias.get(i) instanceof Movie) {
			Info = Info + ((Movie)medias.get(i)).toString2()+"\n";
		}
			else if(medias.get(i) instanceof Game) {
				Info = Info + ((Game)medias.get(i)).toString2()+"\n";
				
			}
			else {
				Info = Info + ((Album)medias.get(i)).toString2()+"\n";
				
			}
				
		}
		return Info;
	}

	public boolean addToCart(String Id, String code) {
		// Adds the specified media title to the cart associated with a customer name
		
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(Id) == 0) {
				for (int j = 0; j < medias.size(); j++) {
					if ((medias.get(j).getCode().compareTo(code)) == 0) {
						customers.get(i).interested.add(medias.get(j).getTitle());
						
						
					}

				}
			} 
		}

		return false;

	}

	public boolean removeFromCart(String customerName, String mediaTitle) {
		// Removes the specified media title from the customer's cart
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getName().compareTo(customerName)==0) {
				customers.get(i).interested.remove(mediaTitle);
				return true;// returns true if the operation is successfully done
			}
		}
		return false;// returns false if removal failed for any reason (e.g., customerName not found)

	}

	public String processRequests() {
		int size;
		String process = "";

		/*
		 * This method will check the interested list of each customer.For each
		 * customer,the interested list will be checked and media will be added to the
		 * rented cart if the plan associated with the customer allows it, and if there
		 * is a copy of the media available. For UNLIMITED plans the media will be added
		 * to the rented cart automatically, but we have to check whether there are copies for
		 * this media. For LIMITED plans, the number of entries moved from the requests
		 * cart to the rented cart will depend on the number of currently rented media,
		 * and whether copies associated with the media are available
		 */

		Collections.sort(customers); // The customers will be processed in alphabetical order.
		for (int i = 0; i < customers.size(); i++) {
			if ((customers.get(i).getPlan().compareTo("Limited")) == 0) {
				size = customers.get(i).interested.size();
				for (int j = 0; j < size; j++) {
					for (int K = 0; K < medias.size(); K++) {
						if (medias.get(K).getTitle().compareTo(customers.get(i).interested.get(j)) == 0) {
							 int v=customers.get(i).rented.size();
								if (v < 2) {
									// check number of media in the rented array,the maximum media number is equal to
									// 2
									//customers.get(i).rented.add(customers.get(i).interested.get(j));
									int c = medias.get(K).getNumberOfCopies();
									if (c > 0) {
										medias.get(K).setNumberOfCopies(c - 1);
									customers.get(i).rented.add(customers.get(i).interested.get(j));
									process += "Sending " +  medias.get(K).getTitle()+ " to "
											+ customers.get(i).getName() + "";
								}
									}
							
						}}
					
				}
			} else if (customers.get(i).getPlan().compareTo("Unlimited") == 0) {
				size = customers.get(i).interested.size();
				for (int j = 0; j < size; j++) {
					for (int k = 0; k < medias.size(); k++) {
						if (medias.get(k).getTitle().compareTo(customers.get(i).interested.get(j)) == 0) {
							int c = medias.get(k).getNumberOfCopies();
							if (c > 0) {
								medias.get(k).setNumberOfCopies(c - 1);
								customers.get(i).rented.add(customers.get(i).interested.get(j));
								process += "Sending " + customers.get(i).interested.get(j) + " to "
										+ customers.get(i).getName() + "";
							}

						}
					}
				}
			}

		}
		return process;
	}
	
	
	
	public String CustomerRequested(String ID) {
		String request = "";
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
				for (int j = 0; j < customers.get(i).interested.size(); j++) {
				request = request+customers.get(i).interested.get(j)+ "\n";
				
				}
			}
		}
		return request;
	}
	
	public String CustomerRented(String ID) {
		String rented = "";
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
				for (int j = 0; j < customers.get(i).rented.size(); j++) {
				rented = rented +customers.get(i).rented.get(j)+"\n";
				}
		}
		}
		return rented;
	}
	public String CustomerRented2(String ID) {
		String rented = "";
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().compareTo(ID) == 0) {
				for (int k = 0; k < medias.size(); k++) {
			for(int j=0; j< customers.get(i).rented.size();j++ ) {
				if(medias.get(k).getTitle().compareTo(customers.get(i).rented.get(j))==0) {
				rented = rented +medias.get(k).toString() + "\n";}
			}}
		}}
		return rented;
	}



	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		boolean CheckTitle, Checkrating, Checkartist, Checksongs;
		ArrayList<String> SORTED = new ArrayList<>();
		/*
		 * Returns a SORTED ArrayList with media titles that satisfy the provided
		 * parameter values. If null is specified for a parameter, then that parameter
		 * should be ignore in the search.
		 */
		for (int i = 0; i < medias.size(); i++) {
			// We will check is this title exist in the MEDIAS array if it is true we will
			// add it to the SORTED array.
			CheckTitle = medias.get(i).getTitle().equals(title);
			if (CheckTitle == true) {
				SORTED.add(medias.get(i).getTitle());
			}

			if (medias.get(i) instanceof Movie) {
				/*
				 * We will check is this rating exist in the MEDIAS array if it is true we will
				 * add its Title to the SORTED array. here we used type casting so we can access
				 * the methods in the Movie class
				 */
				Movie m = (Movie) medias.get(i);
				Checkrating = m.getRating().equals(rating);
				if (Checkrating == true) {
					SORTED.add(medias.get(i).getTitle());
				}
			}
			if (medias.get(i) instanceof Album) {
				Album a = (Album) medias.get(i);
				Checkartist = a.getArtist().equals(artist);
				Checksongs = a.getSongs().equals(songs);
				String[] S = a.getSongs().split(",");
				for (int k = 0; k < S.length; k++) {
					if (S[k].compareTo(songs) == 0) {
						Checkartist = true;
					} else
						Checkartist = false;
				}
				if (Checkartist == true) {
					SORTED.add(medias.get(i).getTitle());
				}
				if (Checksongs == true) {
					SORTED.add(medias.get(i).getTitle());
				}
			} else if ((title.compareTo(null) == 0) && (rating.compareTo(null) == 0) && (artist.compareTo(null) == 0)
					&& (songs.compareTo(null) == 0)) {
				for (int j = 0; j < medias.size(); j++) {
					SORTED.add(medias.get(j).getTitle()); // Providing null for all parameters will return all media
															// titles.
				}
			}
		}
		for (int i = 0; i < SORTED.size(); i++) {
			if (SORTED.get(i) == SORTED.get(i + 1))
				SORTED.remove(i); // we will remove any duplicated media Title in the SORTED array
		}
		return SORTED;
	}
	
	@Override
	public boolean returnMedia(String customerID, String mediaCode) {
		/*
		 * if a customer wants to return a rented media,we will remove the item from the
		 * rented cart and adjust the number OF copies
		 */
	
		for (int i = 0; i < customers.size(); i++) {
			if ((customers.get(i).getID().compareTo(customerID))==0) {
				// First we will check if this mediaTitle exist in the rented cart
				for (int j = 0; j < medias.size(); j++) {
					if ((medias.get(j).getCode().compareTo(mediaCode)) == 0) {
						String x=medias.get(j).getTitle();
				        for (int k = 0; k < customers.get(i).rented.size(); k++) {
				          	
					if ((customers.get(i).rented.get(k).compareTo(x))==0) {
						// back ,so we increment number of copies by one
						customers.get(i).rented.remove(k);
								int c = medias.get(j).getNumberOfCopies();
								medias.get(j).setNumberOfCopies(c + 1);
						return true; // the operation is successfully done
							}
					}
				}}
			}
		}

		return false; // returns false if this Customer name not found in the array Customers

	}

	
	public void AddRented(String Id,String love) {
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getID().equals(Id)) {
				customers.get(i).rented.add(love);
				//customers.get(i).interested.add(love);
			}
		}
			
	}

}
