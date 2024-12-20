public class Armee {
    private String nom;
    private String faction;
    private Integer nbMaxPointsArmee;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public Integer getNbMaxPointsArmee() {
        return nbMaxPointsArmee;
    }

    public void setNbMaxPointsArmee(Integer nbMaxPointsArmee) {
        this.nbMaxPointsArmee = nbMaxPointsArmee;
    }

    public Armee(String nom, String faction, Integer nbMaxPointsArmee) {
        this.nom = nom;
        this.faction = faction;
        this.nbMaxPointsArmee = nbMaxPointsArmee;
    }
}
