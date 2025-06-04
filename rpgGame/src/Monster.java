import java.util.ArrayList;

public class Monster extends LivingCreature {
    public int ID;
    public String Name;
    public int MaximumDamage;
    public int RewardExperiencePoints;
    public int RewardGold;
    public ArrayList<LootItem> LootTable;

    // Getters
    public int getID() {
        return ID;
    }

    public int getMaximumDamage() {
        return MaximumDamage;
    }

    public int getRewardExperiencePoints() {
        return RewardExperiencePoints;
    }

    public int getRewardGold() {
        return RewardGold;
    }

    public ArrayList<LootItem> getLootTable() {
        return LootTable;
    }

    // Setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setMaximumDamage(int MaximumDamage) {
        this.MaximumDamage = MaximumDamage;
    }

    public void setRewardExperiencePoints(int RewardExperiencePoints) {
        this.RewardExperiencePoints = RewardExperiencePoints;
    }

    public void setRewardGold(int RewardGold) {
        this.RewardGold = RewardGold;
    }

    public void setLootTable(ArrayList<LootItem> LootTable) {
        this.LootTable = LootTable;
    }

    // Constructor
    public Monster(int ID, String Name, int MaximumHitPoints, int CurrentHitPoints, int MaximumDamage, int RewardExperiencePoints, int RewardGold) {
        super(CurrentHitPoints, MaximumHitPoints);
        this.ID = ID;
        this.Name = Name;
        this.MaximumDamage = MaximumDamage;
        this.RewardExperiencePoints = RewardExperiencePoints;
        this.RewardGold = RewardGold;
        LootTable = new ArrayList<>();
    }
}
