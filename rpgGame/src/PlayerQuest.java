public class PlayerQuest {
    public Quest Details;
    public boolean IsCompleted;

    // Getters
    public Quest getDetails() {
        return Details;
    }

    public boolean IsCompleted() {
        return IsCompleted;
    }

    // Setters
    public void setDetails(Quest details) {
        this.Details = details;
    }

    public void setCompleted() {
        this.IsCompleted = false;
    }

    // Constructor
    public PlayerQuest(Quest details, boolean IsCompleted) {
        this.Details = details;
        this.IsCompleted = IsCompleted;
    }
}
