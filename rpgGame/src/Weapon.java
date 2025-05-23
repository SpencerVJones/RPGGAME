public class Weapon extends Item {
    public int MinimumDamage;
    public int MaximumDamage;


    // Constructor
    public Weapon(int id, String name, String pluralName, int minimumDamage, int maximumDamage) {
        super(id, name, pluralName);
        this.MinimumDamage = minimumDamage;
        this.MaximumDamage = maximumDamage;
    }


    // Getters
    public int getMinimumDamage() {return MinimumDamage;}
    public int getMaximumDamage() {return MaximumDamage;}

    // Setters
    public void setMinimumDamage(int MinimumDamage) {this.MinimumDamage = MinimumDamage;}
    public void setMaximumDamage(int MaximumDamage) {this.MaximumDamage = MaximumDamage;}
}
