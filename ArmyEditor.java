import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ArmyEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //scanner pour lire les entrées de l'utilisateur
        Armee army = null; // Initialisation de l'armée (initialement null)


        while (true) {
            //affichage du menu principal
            System.out.println("\nMenu principal :");
            System.out.println("1. Créer une armée");
            System.out.println("2. Gérer une armée");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");
            int choice = scanner.nextInt(); //lecture du choix de l'utilisateur
            scanner.nextLine();

            // Traitement du choix de l'utilisateur
            switch (choice) {
                case 1:
                    army = createArmy(scanner); // Création d'une nouvelle armée
                    break;
                case 2:
                    // Gestion de l'armée existante
                    if (army != null) {
                        manageArmy(army, scanner); // Gestion de l'armée
                    } else {
                        System.out.println("Aucune armée créée. Veuillez d'abord en créer une.");
                    }
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    System.exit(0); //sortie du programme
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    //méthode pour créer une armée
    private static Armee createArmy(Scanner scanner) {
        System.out.print("Nom de l'armée : ");
        String name = scanner.nextLine(); //lecture du nom de l'armée
        System.out.print("Faction : ");
        String faction = scanner.nextLine(); //lecture de la faction
        System.out.print("Points maximum : ");
        int maxPoints = scanner.nextInt(); //lecture des points maximum
        scanner.nextLine();
        return new Armee(name, faction, maxPoints); //création de l'armée
    }

    //méthode pour gérer une armée existante
    private static void manageArmy(Armee army, Scanner scanner) {
        //afficher le menu de gestion de l'armée
        while (true) {
            System.out.println("\nGestion de l'armée : " + army.getName());
            System.out.println("1. Ajouter un groupe");
            System.out.println("2. Supprimer un groupe");
            System.out.println("3. Ajouter une unité à un groupe");
            System.out.println("4. Supprimer une unité d'un groupe");
            System.out.println("5. Afficher l'armée");
            System.out.println("6. Retour au menu principal");
            System.out.print("Votre choix : ");
            int choice = scanner.nextInt();  //choix de l'utilisateur
            scanner.nextLine();

            //on exécute le programme en fonction du choix de l'utilisateur
            switch (choice) {
                case 1: //nom du groupe
                    System.out.print("Nom du groupe : ");
                    String groupName = scanner.nextLine(); // Lecture du nom du groupe
                    army.addGroup(new Group(groupName)); // Ajout du groupe à l'armée
                    System.out.println("Groupe ajouté avec succès.");
                    break;
                case 2:  //suppirmer
                    System.out.print("Index du groupe à supprimer : ");
                    int groupIndex = scanner.nextInt(); // Lecture de l'index du groupe à supprimer
                    scanner.nextLine();
                    army.removeGroup(groupIndex); // Suppression du groupe
                    System.out.println("Groupe supprimé.");
                    break;
                case 3:
                    //ajouter une unité à un groupe
                    System.out.print("Index du groupe : ");
                    groupIndex = scanner.nextInt(); // Lecture de l'index du groupe
                    scanner.nextLine();
                    if (groupIndex >= 0 && groupIndex < army.getGroup().size()) {
                        addUnitToGroup(army, army.getGroup().get(groupIndex), scanner);// Ajout de l'unité
                    } else {
                        System.out.println("Index invalide.");
                    }
                    break;
                case 4:
                    //supprimer une unité d'un groupe
                    System.out.print("Index du groupe : ");
                    groupIndex = scanner.nextInt(); // Lecture de l'index du groupe
                    scanner.nextLine();
                    if (groupIndex >= 0 && groupIndex < army.getGroup().size()) {
                        System.out.print("Index de l'unité à supprimer : ");
                        int unitIndex = scanner.nextInt(); // Lecture de l'index de l'unité
                        scanner.nextLine();
                        army.getGroup().get(groupIndex).removeUnit(unitIndex); // Suppression de l'unité
                        System.out.println("Unité supprimée.");
                    } else {
                        System.out.println("Index invalide.");
                    }
                    break;
                case 5:
                    army.print(); //affichage de l'armée
                    break;
                case 6:
                    return; //retour
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    //méthode pour ajouter une unité à un groupe
    private static void addUnitToGroup(Armee army, Group group, Scanner scanner) {
        // Choix du type d'unité
        System.out.println("Type d'unité : 1. Infanterie, 2. Véhicule");
        System.out.print("Votre choix : ");
        int unitType = scanner.nextInt(); // Lecture du type d'unité
        scanner.nextLine(); // Consomme la nouvelle ligne

        //lecture du nom et du coût de l'unité
        System.out.print("Nom de l'unité : ");
        String unitName = scanner.nextLine();
        System.out.print("Coût de l'unité : ");
        int unitCost = scanner.nextInt();
        scanner.nextLine();
        if(army.getMaxPoints() <= army.getTotalPoints() + unitCost) {
            System.out.println("Cout d'unité invalide");
        }
        else{

            //ajout de l'unité en fonction du type choisi
            if (unitType == 1) {
                System.out.print("Type d'infanterie (Soldat, Lourd, Spécial, Chef) : ");
                String infantryType = scanner.nextLine(); // Lecture du type d'infanterie
                group.addUnit(new Infantry(unitName, unitCost, infantryType)); // Ajout de l'unité d'infanterie
            }
            else if (unitType == 2) {
                System.out.print("Type de véhicule (Transport ou Attaque) : ");
                String vehicleType = scanner.nextLine(); // Lecture du type de véhicule
                int transportCapacity = 0;
                // Si c'est un véhicule de transport, on demande la capacité
                if (vehicleType.equalsIgnoreCase("Transport")) {
                    System.out.print("Capacité de transport : ");
                    transportCapacity = scanner.nextInt();
                    scanner.nextLine();
                }
                group.addUnit(new Vehicule(unitName, unitCost, vehicleType, transportCapacity)); // Ajout du véhicule
            }
            else {
                System.out.println("Type d'unité invalide.");
                if (unitType == 1) {
                    System.out.print("Type d'infanterie (Soldat, Lourd, Spécial, Chef) : ");
                    String infantryType = scanner.nextLine();
                    group.addUnit(new Infantry(unitName, unitCost, infantryType));
                }
                else if (unitType == 2) {
                    System.out.print("Type de véhicule (Transport ou Attaque) : ");
                    String vehicleType = scanner.nextLine();
                    int transportCapacity = 0;
                    if (vehicleType.equalsIgnoreCase("Transport")) {
                        System.out.print("Capacité de transport : ");
                        transportCapacity = scanner.nextInt();
                        scanner.nextLine();
                    }
                    group.addUnit(new Vehicule(unitName, unitCost, vehicleType, transportCapacity));
                }
                else {
                    System.out.println("Type d'unité invalide.");
                }
            }
        }
    }
}
