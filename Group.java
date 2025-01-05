import java.util.ArrayList;
import java.util.List;

class Group {
    private String name; //nom du groupe d'unités
    private List<unite> units; //liste des unités appartenant au groupe

    //constructeur pour initialiser le groupe avec un nom
    public Group(String name) {
        this.name = name;
        this.units = new ArrayList<>(); // Initialisation de la liste des unités
    }

    //méthode pour ajouter une unité au groupe
    public void addUnit(unite unit) {
        units.add(unit); //ajoute l'unité à la liste des unités
    }

    //méthode pour supprimer une unité du groupe à partir de son index
    public void removeUnit(int index) {
        if (index >= 0 && index < units.size()) {
            units.remove(index); //supprime l'unité à l'index spécifié
        }
    }
    // methode pour calculer le nombre de point total
    public int getTotalPoints() {
        //utilise la méthode 'getCost()' de chaque unité pour calculer le total des points
        return units.stream().mapToInt(unite::getCost).sum();
    }

    // méthode pour afficher le groupe
    public void print() {
        //affiche le nom du groupe et les points totaux utilisés par les unités du groupe
        System.out.println("    Nom du groupe : " + name);
        System.out.println("    Points totaux : " + getTotalPoints());

        //affiche les détails de chaque unité du groupe
        for (int i = 0; i < units.size(); i++) {
            System.out.print("      Unité " + i + ": ");
            units.get(i).print(); // affiche
        }
    }
}
