//dlasse infanterie, héritée de la classe abstraite 'unite'
class Infantry extends unite {
    private String type; // Type de l'infanterie (Soldat, Lourd, Spécial, Chef, etc.)

    //constructeur pour initialiser l'infanterie avec un nom, un coût et un type
    public Infantry(String name, int cost, String type) {
        super(name, cost); // Appel au constructeur de la classe 'unite' pour initialiser le nom et le coût
        this.type = type; // Initialisation du type d'infanterie
    }


    @Override
    public void print() {
        // Affichage des détails de l'infanterie (type, nom et coût)
        System.out.println("Infanterie - Type : " + type + " - Nom : " + getName() + " (" + getCost() + " pts)");
    }
}
