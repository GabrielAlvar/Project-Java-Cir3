import java.util.ArrayList;
import java.util.List;

class Group {
    private String name;
    private List<unite> units;

    public Group(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    public void addUnit(unite unit) {
        units.add(unit);
    }

    public void removeUnit(int index) {
        if (index >= 0 && index < units.size()) {
            units.remove(index);
        }
    }

    public int getTotalPoints() {
        return units.stream().mapToInt(unite::getCost).sum();
    }

    public void print() {
        System.out.println("    Nom du groupe : " + name);
        System.out.println("    Points totaux : " + getTotalPoints());
        for (int i = 0; i < units.size(); i++) {
            System.out.print("      Unité " + i + ": ");
            units.get(i).print();
        }
    }
}
