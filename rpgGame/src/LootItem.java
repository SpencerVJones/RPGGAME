public class LootItem {
    private Item Details;
    private int DropPercentage;
    private boolean IsDefaultItem;

    // Constructor
    public LootItem(Item details, int dropPercentage, boolean isDefaultItem) {
        this.Details = details;
        this.DropPercentage = dropPercentage;
        this.IsDefaultItem = isDefaultItem;
    }

    // Getters
    public Item getDetails() { return Details; }
    public int getDropPercentage() { return DropPercentage; }
    public boolean getIsDefaultItem() { return IsDefaultItem; }

    // Setters
    public void setDetails(Item details) { this.Details = details; }
    public void setDropPercentage(int dropPercentage) { this.DropPercentage = dropPercentage; }
    public void setIsDefaultItem(boolean isDefaultItem) { this.IsDefaultItem = isDefaultItem; }
}
