import java.util.ArrayList;

public class  Quest {
    public int ID;
    public String Name;
    public String Description;
    public int RewardExperiencePoints;
    public int RewardGold;

    public Item RewardItem;

    public ArrayList<QuestCompletionItem> QuestCompletionItems;

    // Getters
    public int getID() {return ID;}
    public String getName() {return Name;}
    public String getDescription() {return Description;}
    public int getRewardExperiencePoints() {return RewardExperiencePoints;}
    public int getRewardGold() {return RewardGold;}

    public Item getRewardItem() {return RewardItem;}

    public ArrayList<QuestCompletionItem> getQuestCompletionItems() {return QuestCompletionItems;}


    // Setters
    public void setID(int ID) {this.ID = ID;}
    public void setName(String Name) {this.Name = Name;}
    public void setDescription(String Description) {this.Description = Description;}
    public void setRewardExperiencePoints(int RewardGold) {this.RewardGold = RewardGold;}
    public void setRewardGold(int RewardGold) {this.RewardGold = RewardGold;}

    public void setRewardItem(Item RewardItem) { this.RewardItem = RewardItem; }

    public void setQuestCompletionItems() {this.QuestCompletionItems = new ArrayList<>();}

    // Constructor
    public Quest(int ID, String Name, String Description, int RewardExperiencePoints, int RewardGold, Item RewardItem) {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.RewardExperiencePoints = RewardExperiencePoints;
        this.RewardGold = RewardGold;

        this.RewardItem = RewardItem;

        QuestCompletionItems = new ArrayList<>();
    }
}
