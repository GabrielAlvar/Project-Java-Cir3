// classe unite
abstract class unite {
    private String name; // Nom de l'unité
    private int cost; // Coût de l'unité en points

    //constructeur pour initialiser les attributs de l'unité
    public unite(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    //obtenir le nom de l'unité
    public String getName() {
        return name;
    }

    //obtenir le coût de l'unité
    public int getCost() {
        return cost;
    }


    public abstract void print();
}
