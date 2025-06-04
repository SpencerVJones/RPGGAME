public class Item {
    public int ID;
    public String Name;
    public String NamePlural;


    public Item(int ID, String Name, String NamePlural) {
        this.ID = ID;
        this.Name = Name;
        this.NamePlural = NamePlural;
    }

    // Getters
    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getNamePlural() {
        return NamePlural;
    }

    // Setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNamePlural(String namePlural) {
        NamePlural = namePlural;
    }
}
