import java.util.ArrayList;
import java.util.List;

class Armee {
    private String name;
    private String faction;
    private int maxPoints;
    private List<Group> groups;

    public Armee(String name, String faction, int maxPoints) {
        this.name = name;
        this.faction = faction;
        this.maxPoints = maxPoints;
        this.groups = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public List<Group> getGroup() {
        return groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void removeGroup(int index) {
        if (index >= 0 && index < groups.size()) {
            groups.remove(index);
        }
    }

    public int getTotalPoints() {
        return groups.stream().mapToInt(Group::getTotalPoints).sum();
    }

    public void print() {
        System.out.println("Armée : " + name);
        System.out.println("Faction : " + faction);
        System.out.println("Points max : " + maxPoints);
        System.out.println("Points utilisés : " + getTotalPoints());
        System.out.println("Groupes :");
        for (int i = 0; i < groups.size(); i++) {
            System.out.println("  Groupe " + i + ":");
            groups.get(i).print();
        }
    }
}
