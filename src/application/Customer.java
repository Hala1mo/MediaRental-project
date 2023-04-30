package application;


	import java.util.ArrayList;

	public class Customer implements Comparable<Customer> {
		// Defining the class's attributes
		protected String name;
		protected String address;
		protected String plan;
		protected String ID;
		protected String number;
		protected ArrayList<String> interested;
		protected ArrayList<String> rented;

		public Customer() {
		}

	

		public Customer( String name, String address, String ID,String number,String plan) { // constructor with parameters
			super();
			this.ID = ID;
			this.name = name;
			this.address = address;
			this.number = number;
			this.plan = plan;
			interested = new ArrayList<String>();
			rented = new ArrayList<String>();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		
		public String getPlan() {
			return plan;
		}

		public void setPlan(String plan) {
			this.plan = plan;
		}
		public String getID() {
			return ID;
		}



		public void setID(String iD) {
			ID = iD;
		}



		public String getNumber() {
			return number;
		}



		public void setNumber(String number) {
			this.number = number;
		}

		
		@Override
		public String toString() {
			return "name=" + name + ", address=" + address + ", plan=" + plan + ", ID=" + ID + ", number="
					+ number + ", interested=" + interested + ", rented=" + rented ;
		}


		public String PrintForFile() {
			return     name + ","  + address + "," + ID + "," + number + ","
					+ plan + "," +rented();
		}

		@Override
		public int compareTo(Customer o) {
			return (this.name).compareTo(o.name);
		}
		
		public String rented() {
			String x="";
			for(int i=0;i<rented.size();i++) {
				x=x+rented.get(i)+",";
				
			}
			return x;
					
		}

	}


