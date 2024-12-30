class Infantry extends unite {
    private String type;

    public Infantry(String name, int cost, String type) {
        super(name, cost);
        this.type = type;
    }

    @Override
    public void print() {
        System.out.println("Infanterie - Type : " + type + " - Nom : " + getName() + " (" + getCost() + " pts)");
    }
}
