package polymorphism;

public class CargoShip extends Ship{
    int shipCapacity;

    public CargoShip(int shipCapacity) {
        this.shipCapacity = shipCapacity;
    }

    public CargoShip(String shipName, String yearShipWasBuilt, int shipCapacity) {
        super(shipName, yearShipWasBuilt);
        this.shipCapacity = shipCapacity;
    }

    public int getShipCapacity() {
        return shipCapacity;
    }

    public void setShipCapacity(int shipCapacity) {
        this.shipCapacity = shipCapacity;
    }

    public void display()
    {
        System.out.println("Print details from Child Class: CargoShip");
        System.out.println("shipName=\t"+shipName+"\n"+"shipCapacity=\t"+shipCapacity);
    }
}