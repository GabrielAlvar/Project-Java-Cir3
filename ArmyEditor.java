import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class ArmyEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Armee army = null;

        while (true) {
            System.out.println("\nMenu principal :");
            System.out.println("1. Créer une armée");
            System.out.println("2. Gérer une armée");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choice) {
                case 1:
                    army = createArmy(scanner);
                    break;
                case 2:
                    if (army != null) {
                        manageArmy(army, scanner);
                    } else {
                        System.out.println("Aucune armée créée. Veuillez d'abord en créer une.");
                    }
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static Armee createArmy(Scanner scanner) {
        System.out.print("Nom de l'armée : ");
        String name = scanner.nextLine();
        System.out.print("Faction : ");
        String faction = scanner.nextLine();
        System.out.print("Points maximum : ");
        int maxPoints = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne
        return new Armee(name, faction, maxPoints);
    }

    private static void manageArmy(Armee army, Scanner scanner) {
        while (true) {
            System.out.println("\nGestion de l'armée : " + army.getName());
            System.out.println("1. Ajouter un groupe");
            System.out.println("2. Supprimer un groupe");
            System.out.println("3. Ajouter une unité à un groupe");
            System.out.println("4. Supprimer une unité d'un groupe");
            System.out.println("5. Afficher l'armée");
            System.out.println("6. Retour au menu principal");
            System.out.print("Votre choix : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choice) {
                case 1:
                    System.out.print("Nom du groupe : ");
                    String groupName = scanner.nextLine();
                    army.addGroup(new Group(groupName));
                    System.out.println("Groupe ajouté avec succès.");
                    break;
                case 2:
                    System.out.print("Index du groupe à supprimer : ");
                    int groupIndex = scanner.nextInt();
                    scanner.nextLine();
                    army.removeGroup(groupIndex);
                    System.out.println("Groupe supprimé.");
                    break;
                case 3:
                    System.out.print("Index du groupe : ");
                    groupIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (groupIndex >= 0 && groupIndex < army.getGroup().size()) {
                        addUnitToGroup(army.getGroup().get(groupIndex), scanner);
                    } else {
                        System.out.println("Index invalide.");
                    }
                    break;
                case 4:
                    System.out.print("Index du groupe : ");
                    groupIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (groupIndex >= 0 && groupIndex < army.getGroup().size()) {
                        System.out.print("Index de l'unité à supprimer : ");
                        int unitIndex = scanner.nextInt();
                        scanner.nextLine();
                        army.getGroup().get(groupIndex).removeUnit(unitIndex);
                        System.out.println("Unité supprimée.");
                    } else {
                        System.out.println("Index invalide.");
                    }
                    break;
                case 5:
                    army.print();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void addUnitToGroup(Group group, Scanner scanner) {
        System.out.println("Type d'unité : 1. Infanterie, 2. Véhicule");
        System.out.print("Votre choix : ");
        int unitType = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne

        System.out.print("Nom de l'unité : ");
        String unitName = scanner.nextLine();
        System.out.print("Coût de l'unité : ");
        int unitCost = scanner.nextInt();
        scanner.nextLine();

        if (unitType == 1) {
            System.out.print("Type d'infanterie (Soldat, Lourd, Spécial, Chef) : ");
            String infantryType = scanner.nextLine();
            group.addUnit(new Infantry(unitName, unitCost, infantryType));
        } else if (unitType == 2) {
            System.out.print("Type de véhicule (Transport ou Attaque) : ");
            String vehicleType = scanner.nextLine();
            int transportCapacity = 0;
            if (vehicleType.equalsIgnoreCase("Transport")) {
                System.out.print("Capacité de transport : ");
                transportCapacity = scanner.nextInt();
                scanner.nextLine();
            }
            group.addUnit(new Vehicule(unitName, unitCost, vehicleType, transportCapacity));
        } else {
            System.out.println("Type d'unité invalide.");
        }
    }
}
