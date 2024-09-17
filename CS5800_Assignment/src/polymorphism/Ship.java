package polymorphism;

public class Ship {
    String shipName;
    String yearShipWasBuilt;

    public Ship()
    {

    }
    public Ship(String shipName, String yearShipWasBuilt) {
        this.shipName = shipName;
        this.yearShipWasBuilt = yearShipWasBuilt;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getYearShipWasBuilt() {
        return yearShipWasBuilt;
    }

    public void setYearShipWasBuilt(String yearShipWasBuilt) {
        this.yearShipWasBuilt = yearShipWasBuilt;
    }

    public void display()
    {
        System.out.println("Print details from Parent Class: Ship");
        System.out.println("shipName=\t"+shipName+"\n"+"yearShipWasBuilt=\t"+yearShipWasBuilt);
    }
}