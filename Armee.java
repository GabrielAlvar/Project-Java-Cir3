import java.util.ArrayList;
import java.util.List;
//création de la classe Armee
class Armee {
    private String name; // Nom de l'armée
    private String faction; // Faction à laquelle appartient l'armée
    private int maxPoints; // Nombre de points maximum pour l'armée
    private List<Group> groups; // Liste des groupes d'unités dans l'armée

    //initialisation des attributs de l'armée
    public Armee(String name, String faction, int maxPoints) {
        this.name = name;
        this.faction = faction;
        this.maxPoints = maxPoints;
        this.groups = new ArrayList<>(); // Initialisation de la liste des groupes
    }

    //  obtenir le nom de l'armée
    public String getName() {
        return name;
    }

    //  obtenir la liste des groupes de l'armée
    public List<Group> getGroup() {
        return groups;
    }

    //méthode pour ajouter un groupe à l'armée
    public void addGroup(Group group) {
        if (getTotalPoints() + group.getTotalPoints() <= maxPoints) {
            groups.add(group);
        } else {
            System.out.println("Impossible d'ajouter ce groupe. Points maximum dépassés !");
        }
    }

    //méthode pour supprimer un groupe à partir de son index
    public void removeGroup(int index) {
        if (index >= 0 && index < groups.size()) {
            groups.remove(index); // Supprimer le groupe à l'index spécifié
        }
    }

    //méthode pour calculer le total des points utilisés par l'armée
    public int getTotalPoints() {
        // Utilise la méthode getTotalPoints() de chaque groupe pour calculer le total des points
        return groups.stream().mapToInt(Group::getTotalPoints).sum();
    }

    //méthode pour afficher les informations de l'armée
    public void print() {
        System.out.println("Armée : " + name); // Affichage du nom de l'armée
        System.out.println("Faction : " + faction); // Affichage de la faction
        System.out.println("Points max : " + maxPoints); // Affichage des points maximum
        System.out.println("Points utilisés : " + getTotalPoints()); // Affichage des points utilisés
        System.out.println("Groupes :");

        //affichage des informations de chaque groupe de l'armée
        for (int i = 0; i < groups.size(); i++) {
            System.out.println("  Groupe " + i + ":");
            groups.get(i).print(); // Affichage des détails de chaque groupe
        }
    }
}
