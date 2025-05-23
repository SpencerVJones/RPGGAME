import java.util.ArrayList;

public class Player extends LivingCreature{
    public int Gold;
    public int ExperiencePoints;
    public int Level;

    public ArrayList<InventoryItem> Inventory;
    public ArrayList<PlayerQuest> Quests;

    public Location CurrentLocation;


    // Getters
    public int getGold() {return Gold;}
    public int getExperiencePoints() {return ExperiencePoints;}
    public int getLevel() {return Level;}

    public ArrayList<InventoryItem> getInventory() {return Inventory;}
    public ArrayList<PlayerQuest> getQuests() {return Quests;}

    public Location getCurrentLocation() {return CurrentLocation;}

    // Setters
    public void setGold(int Gold) {this.Gold = Gold;}
    public void setExperiencePoints(int ExperiencePoints) {this.ExperiencePoints = ExperiencePoints;}
    public void setLevel(int Level) {this.Level = Level;}

    public void setInventory(ArrayList<InventoryItem> Inventory) {this.Inventory = Inventory;}
    public void setQuests(ArrayList<PlayerQuest> Quests) {this.Quests = Quests;}

    public void setCurrentLocation(Location CurrentLocation) {this.CurrentLocation = CurrentLocation;}

    // Constructor
    public Player(int CurrentHitPoints, int MaximumHitPoints, int Gold, int ExperiencePoints, int Level) {
        super(CurrentHitPoints, MaximumHitPoints);
        this.Gold = Gold;
        this.ExperiencePoints = ExperiencePoints;
        this.Level = Level;

        // ADD To Constructor
        Inventory = new ArrayList<>();
        Quests = new ArrayList<>();
    }
}
