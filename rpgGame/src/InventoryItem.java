ppublic class InventoryItem {
    public Item Details;
    public int Quantity;

    // Getters
    public Item getDetails() {
        return Details;
    }

    public int getQuantity() {
        return Quantity;
    }

    // Setters
    public void setDetails(Item details) {
        this.Details = details;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    // Constructor
    public InventoryItem(Item details, int Quantity) {
        this.Details = details;
        this.Quantity = Quantity;
    }
}
