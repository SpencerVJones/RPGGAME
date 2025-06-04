public class HealingPotion extends Item {
    public int AmountToHeal;

    // Getters
    public int getAmountToHeal() {
        return AmountToHeal;
    }

    // Setters
    public void setAmountToHeal(int amountToHeal) {
        AmountToHeal = amountToHeal;
    }

    // Constructor
    public HealingPotion(int ID, String Name, String NamePlural, int amountToHeal) {
        super(ID, Name, NamePlural);
        this.AmountToHeal = amountToHeal;
    }
}
