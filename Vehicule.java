class Vehicle extends unite {
    private String vehicleType;
    private int transportCapacity;

    public Vehicle(String name, int cost, String vehicleType, int transportCapacity) {
        super(name, cost);
        this.vehicleType = vehicleType;
        this.transportCapacity = transportCapacity;
    }

    @Override
    public void print() {
        System.out.println("Véhicule - Type : " + vehicleType + " - Nom : " + getName() + " (" + getCost() + " pts, Capacité : " + transportCapacity + ")");
    }
}
