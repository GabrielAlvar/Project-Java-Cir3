abstract class unite {
    private String name;
    private int cost;

    public unite(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public abstract void print();
}
