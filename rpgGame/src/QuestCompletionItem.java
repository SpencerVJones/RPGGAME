public class QuestCompletionItem {
    public Item Details;
    public int Quantity;

    // Getters
    public Item getDetails() {return Details;}
    public int getQuantity() {return Quantity;}

    // Setters
    public void setDetails(Item details) {this.Details = details;}
    public void setQuantity(int quantity) {this.Quantity = quantity;}

    // Constructor
    public QuestCompletionItem(Item details, int quantity){
        this.Details = details;
        this.Quantity = quantity;
    }
}
