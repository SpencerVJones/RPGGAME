public class Location {
    public int ID;
    public String Name;
    public String Description;

    public Item ItemRequiredToEnter;
    public Quest QuestAvailableHere;
    public Monster MonsterLivingHere;
    public Location LocationToNorth;
    public Location LocationToSouth;
    public Location LocationToEast;
    public Location LocationToWest;

    // Getters
    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public Item getItemRequiredToEnter() {
        return ItemRequiredToEnter;
    }

    public Quest getQuestAvailableHere() {
        return QuestAvailableHere;
    }

    public Monster getMonsterLivingHere() {
        return MonsterLivingHere;
    }

    public Location getLocationToNorth() {
        return LocationToNorth;
    }

    public Location getLocationToSouth() {
        return LocationToSouth;
    }

    public Location getLocationToEast() {
        return LocationToEast;
    }

    public Location getLocationToWest() {
        return LocationToWest;
    }

    // Setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setItemRequiredToEnter(Item itemRequiredToEnter) {
        this.ItemRequiredToEnter = itemRequiredToEnter;
    }

    public void setQuestAvailableHere(Quest questAvailableHere) {
        this.QuestAvailableHere = questAvailableHere;
    }

    public void setMonsterLivingHere(Monster monsterLivingHere) {
        this.MonsterLivingHere = monsterLivingHere;
    }

    public void setLocationToNorth(Location locationToNorth) {
        this.LocationToNorth = locationToNorth;
    }

    public void setLocationToSouth(Location locationToSouth) {
        this.LocationToSouth = locationToSouth;
    }

    public void setLocationToEast(Location locationToEast) {
        this.LocationToEast = locationToEast;
    }

    public void setLocationToWest(Location locationToWest) {
        this.LocationToWest = locationToWest;
    }


    // Constructor with 3 parameters
    public Location(int id, String name, String description) {
        this.ID = id;
        this.Name = name;
        this.Description = description;
    }

    // Constructor with 4 parameters
    public Location(int id, String name, String description, Item itemRequiredToEnter) {
        this.ID = id;
        this.Name = name;
        this.Description = description;
        this.ItemRequiredToEnter = itemRequiredToEnter;
    }
}
