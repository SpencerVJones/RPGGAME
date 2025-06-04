import java.util.ArrayList;

public class Player extends LivingCreature {
    public int Gold;
    public int ExperiencePoints;
    public int Level;

    public ArrayList<InventoryItem> Inventory;
    public ArrayList<PlayerQuest> Quests;
    public Location CurrentLocation;

    // Getters
    public int getGold() {
        return Gold;
    }

    public int getExperiencePoints() {
        return ExperiencePoints;
    }

    public int getLevel() {
        return Level;
    }

    public ArrayList<InventoryItem> getInventory() {
        return Inventory;
    }

    public ArrayList<PlayerQuest> getQuests() {
        return Quests;
    }

    public Location getCurrentLocation() {
        return CurrentLocation;
    }

    // Setters
    public void setGold(int Gold) {
        this.Gold = Gold;
    }

    public void setExperiencePoints(int ExperiencePoints) {
        this.ExperiencePoints = ExperiencePoints;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public void setInventory(ArrayList<InventoryItem> Inventory) {
        this.Inventory = Inventory;
    }

    public void setQuests(ArrayList<PlayerQuest> Quests) {
        this.Quests = Quests;
    }

    public void setCurrentLocation(Location CurrentLocation) {
        this.CurrentLocation = CurrentLocation;
    }

    // Constructor
    public Player(int CurrentHitPoints, int MaximumHitPoints, int Gold, int ExperiencePoints, int Level) {
        super(CurrentHitPoints, MaximumHitPoints);
        this.Gold = Gold;
        this.ExperiencePoints = ExperiencePoints;
        this.Level = Level;
        Inventory = new ArrayList<>();
        Quests = new ArrayList<>();
    }

    public boolean HasItemRequiredToEnter(Location location) {
        if (location.ItemRequiredToEnter == null) {
            // No item required for loctaion
            return true;
        }

        // See if player has item in inventory
        for (InventoryItem ii : Inventory) {
            if (ii.Details.ID == location.ItemRequiredToEnter.ID) {
                // Found the item
                return true;
            }
        }
        // Didnt find required item
        return false;
    }

    public boolean HasThisQuest(Quest quest) {
        for (PlayerQuest playerQuest : Quests) {
            if (playerQuest.Details.ID == quest.ID) {
                return true;
            }
        }
        return false;
    }

    public boolean CompletedThisQuest(Quest quest) {
        for (PlayerQuest playerQuest : Quests) {
            if (playerQuest.Details.ID == quest.ID) {
                return playerQuest.IsCompleted;
            }
        }
        return false;
    }

    public boolean HasAllQuestsCompletionItems(Quest quest) {
        // Check if player has all items needed to complete quest here
        for (QuestCompletionItem qci : quest.QuestCompletionItems) {
            boolean foundItemInPlayersInventory = false;

            // Check each item in players inventory to see if they have it and enough of it
            for (InventoryItem ii : Inventory) {
                if (ii.Details.ID == qci.Details.ID) { // Player has item in inventory
                    foundItemInPlayersInventory = true;

                    if (ii.Quantity < qci.Quantity) { // Player does not have enough
                        return false;
                    }
                }
            }

            // Player does not have any of this quest completion item in inventory
            if (!foundItemInPlayersInventory) {
                return false;
            }
        }

        // The player has all required items and enogh
        return true;
    }

    public void RemoveQuestCompletionItem(Quest quest) {
        for (QuestCompletionItem qci : quest.QuestCompletionItems) {
            for (InventoryItem ii : Inventory) {
                if (ii.Details.ID == qci.Details.ID) {
                    // Subtract quantity from players inventory that was needed
                    ii.Quantity -= qci.Quantity;
                    break;
                }
            }
        }
    }

    public void AddItemToInventory(Item itemToAdd) {
        for (InventoryItem ii : Inventory) {
            if (ii.Details.ID == itemToAdd.ID) {
                // Player has item in inventory, so increase it by one
                ii.Quantity++;
                return;
            }
        }

        // Player didn't have the item, so add it with a quantity of 1
        Inventory.add(new InventoryItem(itemToAdd, 1));
    }

    public void MarkQuestCompleted(Quest quest) {
        // find quest in players quest list
        for (PlayerQuest pq : Quests) {
            if (pq.Details.ID == quest.ID) {
                // Mark as completed
                pq.IsCompleted = true;
                return;
            }
        }
    }
}
