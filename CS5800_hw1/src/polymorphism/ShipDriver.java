package polymorphism;

public class ShipDriver {

	   public static void main(String[] args) {

	        Ship[] ship = new Ship[3];

	        ship[0] = new Ship("Fishing Ship","1998");
	        ship[1] = new CruiseShip("Titanic Ship","2010",30);
	        ship[2] = new CargoShip("Los Angeles Carrier","1990",1000);

	        for( Ship s: ship)
	        {
	            s.display();
	            System.out.println("---------------------------------------------------------------");
	        }
	    }

}
