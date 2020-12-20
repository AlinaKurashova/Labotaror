package laba6

import java.util.Scanner;

public class Building {
		public Building(){}

		public <Home> void print(Home[] buildings){
        for(Home building: buildings){
            System.out.println(building);
        }
    }
	public void Building() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter name of the street: ");
		String N = sc.nextLine(); 
		System.out.printf("In the street %s 5 buildings located", N);
	}

public class Generic<Building>{

    private Building address;
    private String type;

    Generic(String type, Building address){
        this.address = address;
        this.type = type;
    }
}

    public void getInfo() {
    	System.out.printf("Building type is %s. Building located in %s\n",type, address);
    	}
public class Program {

	 public static void main (String[] args) {

		 	Generic<String> property1 = new Generic<String>("Zavtra", "Lenina");
		 	property1.getInfo();
		 	Generic<String> property2 = new Generic<String>("Vedomosti", "Semashko");
		 	property2.getInfo();
		 	Generic<String> property3 = new Generic<String>("Izvestia", "Lermontova");
		 	property3.getInfo();
		 	Building building = new Building();
		 	building.Building();
	  }
    }

