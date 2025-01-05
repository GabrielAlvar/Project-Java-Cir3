// Classe qui représente une unité de véhicule, héritée de la classe abstraite 'unite'
class Vehicule extends unite {
    private String vehicleType; // Type de véhicule (Transport ou Attaque)
    private int transportCapacity; // Capacité de transport du véhicule (pertinent pour les véhicules de type Transport)

    // Constructeur de vehicule
    public Vehicule(String name, int cost, String vehicleType, int transportCapacity) {
        super(name, cost); // Appel au constructeur de la classe 'unite' pour initialiser le nom et le coût
        this.vehicleType = vehicleType; // Initialisation du type de véhicule
        this.transportCapacity = transportCapacity; // Initialisation de la capacité de transport
    }


    @Override
    public void print() {
        // Affichage des détails du véhicule (type, nom, coût et capacité de transport)
        System.out.println("Véhicule - Type : " + vehicleType + " - Nom : " + getName() + " (" + getCost() + " pts, Capacité : " + transportCapacity + ")");
    }
}
