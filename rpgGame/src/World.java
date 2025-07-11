import java.util.ArrayList;

public class World {
    public static ArrayList<Item> Items = new ArrayList<Item>();
    public static ArrayList<Monster> Monsters = new ArrayList<Monster>();
    public static ArrayList<Quest> Quests = new ArrayList<Quest>();
    public static ArrayList<Location> Locations = new ArrayList<Location>();

    public static final int ITEM_ID_RUSTY_SWORD = 1;
    public final int ITEM_ID_RAT_TAIL = 2;
    public final int ITEM_ID_PIECE_OF_FUR = 3;
    public final int ITEM_ID_SNAKE_FANG = 4;
    public final int ITEM_ID_SNAKESKIN = 5;
    public final int ITEM_ID_CLUB = 6;
    public final int ITEM_ID_HEALING_POTION = 7;
    public final int ITEM_ID_SPIDER_FANG = 8;
    public final int ITEM_ID_SPIDER_SILK = 9;
    public final int ITEM_ID_ADVENTURER_PASS = 10;
    public static final int ITEM_ID_FLAMING_SWORD = 11;
    public static final int ITEM_ID_ICE_DAGGER = 12;
    public static final int ITEM_ID_MANA_POTION = 13;
    public static final int ITEM_ID_STRENGTH_ELIXIR = 14;
    public static final int ITEM_ID_GOBLIN_EAR = 15;
    public static final int ITEM_ID_ICE_CORE = 16;


    public final int MONSTER_ID_RAT = 1;
    public final int MONSTER_ID_SNAKE = 2;
    public final int MONSTER_ID_GIANT_SPIDER = 3;
    public static final int MONSTER_ID_GOBLIN = 4;
    public static final int MONSTER_ID_ICE_GOLEM = 5;


    public final int QUEST_ID_CLEAR_ALCHEMIST_GARDEN = 1;
    public final int QUEST_ID_CLEAR_FARMERS_FIELD = 2;
    public static final int QUEST_ID_CLEAR_GOBLIN_CAMP = 3;


    public static final int LOCATION_ID_HOME = 1;
    public final int LOCATION_ID_TOWN_SQUARE = 2;
    public final int LOCATION_ID_GUARD_POST = 3;
    public final int LOCATION_ID_ALCHEMIST_HUT = 4;
    public final int LOCATION_ID_ALCHEMISTS_GARDEN = 5;
    public final int LOCATION_ID_FARMHOUSE = 6;
    public final int LOCATION_ID_FARM_FIELD = 7;
    public final int LOCATION_ID_BRIDGE = 8;
    public final int LOCATION_ID_SPIDER_FIELD = 9;
    public static final int LOCATION_ID_MYSTIC_CAVE = 10;
    public static final int LOCATION_ID_FROZEN_LAKE = 11;
    public static final int LOCATION_ID_GOBLIN_CAMP = 12;


    public World() {
        PopulateItems();
        PopulateMonsters();
        PopulateQuests();
        PopulateLocations();
    }

    public void PopulateItems() {
        Items.add(new Weapon(ITEM_ID_RUSTY_SWORD, "Rusty sword", "Rusty swords", 0, 5));
        Items.add(new Item(ITEM_ID_RAT_TAIL, "Rat tail", "Rat tails"));
        Items.add(new Item(ITEM_ID_PIECE_OF_FUR, "Piece of fur", "Pieces of fur"));
        Items.add(new Item(ITEM_ID_SNAKE_FANG, "Snake fang", "Snake fangs"));
        Items.add(new Item(ITEM_ID_SNAKESKIN, "Snakeskin", "Snakeskin's"));
        Items.add(new Weapon(ITEM_ID_CLUB, "Club", "Clubs", 3, 10));
        Items.add(new HealingPotion(ITEM_ID_HEALING_POTION, "Healing potion", "Healing potions", 5));
        Items.add(new Item(ITEM_ID_SPIDER_FANG, "Spider fang", "Spider fangs"));
        Items.add(new Item(ITEM_ID_SPIDER_SILK, "Spider silk", "Spider silks"));
        Items.add(new Item(ITEM_ID_ADVENTURER_PASS, "Adventurer pass", "Adventurer passes"));
        Items.add(new Weapon(ITEM_ID_FLAMING_SWORD, "Flaming Sword", "Flaming Swords", 5, 15));
        Items.add(new Weapon(ITEM_ID_ICE_DAGGER, "Ice Dagger", "Ice Daggers", 3, 10));
        Items.add(new HealingPotion(ITEM_ID_MANA_POTION, "Mana Potion", "Mana Potions", 10));
        Items.add(new HealingPotion(ITEM_ID_STRENGTH_ELIXIR, "Strength Elixir", "Strength Elixirs", 15));
        Items.add(new Item(ITEM_ID_GOBLIN_EAR, "Goblin Ear", "Goblin Ears"));
        Items.add(new Item(ITEM_ID_ICE_CORE, "Ice Core", "Ice Cores"));

    }

    public void PopulateMonsters() {
        Monster rat = new Monster(MONSTER_ID_RAT, "Rat", 5, 3, 10, 3, 3);
        rat.LootTable.add(new LootItem(ItemByID(ITEM_ID_RAT_TAIL), 75, false));
        rat.LootTable.add(new LootItem(ItemByID(ITEM_ID_PIECE_OF_FUR), 75, true));

        Monster snake = new Monster(MONSTER_ID_SNAKE, "Snake", 5, 3, 10, 3, 3);
        snake.LootTable.add(new LootItem(ItemByID(ITEM_ID_SNAKE_FANG), 75, false));
        snake.LootTable.add(new LootItem(ItemByID(ITEM_ID_SNAKESKIN), 75, true));

        Monster giantSpider = new Monster(MONSTER_ID_GIANT_SPIDER, "Giant spider", 20, 5, 40, 10, 10);
        giantSpider.LootTable.add(new LootItem(ItemByID(ITEM_ID_SPIDER_FANG), 75, true));
        giantSpider.LootTable.add(new LootItem(ItemByID(ITEM_ID_SPIDER_SILK), 25, false));

        Monster goblin = new Monster(MONSTER_ID_GOBLIN, "Goblin", 10, 4, 15, 5, 5);
        goblin.LootTable.add(new LootItem(ItemByID(ITEM_ID_GOBLIN_EAR), 75, true));
        goblin.LootTable.add(new LootItem(ItemByID(ITEM_ID_ICE_DAGGER), 15, false));

        Monster iceGolem = new Monster(MONSTER_ID_ICE_GOLEM, "Ice Golem", 30, 8, 50, 15, 15);
        iceGolem.LootTable.add(new LootItem(ItemByID(ITEM_ID_ICE_CORE), 50, true));
        iceGolem.LootTable.add(new LootItem(ItemByID(ITEM_ID_MANA_POTION), 25, false));

        Monsters.add(rat);
        Monsters.add(snake);
        Monsters.add(giantSpider);
        Monsters.add(goblin);
        Monsters.add(iceGolem);
    }

    public void PopulateQuests() {
        Quest clearAlchemistGarden = new Quest(
                QUEST_ID_CLEAR_ALCHEMIST_GARDEN,
                "Clear the alchemist's garden",
                "Kill rats in the alchemist's garden and bring back 3 rat tails. You will receive a healing potion and 10 gold pieces.",
                20,
                10,
                ItemByID(ITEM_ID_HEALING_POTION));
        clearAlchemistGarden.QuestCompletionItems.add(new QuestCompletionItem(ItemByID(ITEM_ID_RAT_TAIL), 3));
        clearAlchemistGarden.RewardItem = ItemByID(ITEM_ID_HEALING_POTION);

        Quest clearFarmersField = new Quest(
                QUEST_ID_CLEAR_FARMERS_FIELD,
                "Clear the farmer's field",
                "Kill snakes in the farmer's field and bring back 3 snake fangs. You will receive an adventurer's pass and 20 gold pieces.",
                20,
                20,
                ItemByID(ITEM_ID_SNAKE_FANG));
        clearFarmersField.QuestCompletionItems.add(new QuestCompletionItem(ItemByID(ITEM_ID_SNAKE_FANG), 3));
        clearFarmersField.RewardItem = ItemByID(ITEM_ID_ADVENTURER_PASS);


        Quest clearGoblinCamp = new Quest(
                QUEST_ID_CLEAR_GOBLIN_CAMP,
                "Clear the Goblin Camp",
                "Defeat the goblins and return with 3 goblin ears. You'll earn a Flaming Sword and 30 gold.",
                30,
                30,
                ItemByID(ITEM_ID_FLAMING_SWORD));
        clearGoblinCamp.QuestCompletionItems.add(new QuestCompletionItem(ItemByID(ITEM_ID_GOBLIN_EAR), 3));
        clearGoblinCamp.RewardItem = ItemByID(ITEM_ID_FLAMING_SWORD);

        Quests.add(clearAlchemistGarden);
        Quests.add(clearFarmersField);
        Quests.add(clearGoblinCamp);
    }

    public void PopulateLocations() {
// Create each location
        Location home = new Location(
                LOCATION_ID_HOME,
                "Home",
                "Your house. You really need to clean up the place.");
        Location townSquare = new Location(
                LOCATION_ID_TOWN_SQUARE,
                "Town square",
                "You see a fountain.");
        Location alchemistHut = new Location(
                LOCATION_ID_ALCHEMIST_HUT,
                "Alchemist's hut",
                "There are many strange plants on the shelves.");
        Location mysticCave = new Location(LOCATION_ID_MYSTIC_CAVE, "Mystic Cave", "A dark cave filled with echoes.");
        Location frozenLake = new Location(LOCATION_ID_FROZEN_LAKE, "Frozen Lake", "A shimmering frozen lake. It's eerily silent.");
        frozenLake.MonsterLivingHere = MonsterByID(MONSTER_ID_ICE_GOLEM);

        Location goblinCamp = new Location(LOCATION_ID_GOBLIN_CAMP, "Goblin Camp", "A messy camp littered with goblin gear.");
        goblinCamp.MonsterLivingHere = MonsterByID(MONSTER_ID_GOBLIN);
        goblinCamp.QuestAvailableHere = QuestByID(QUEST_ID_CLEAR_GOBLIN_CAMP);


        alchemistHut.QuestAvailableHere = QuestByID(QUEST_ID_CLEAR_ALCHEMIST_GARDEN);

        Location alchemistsGarden = new Location(LOCATION_ID_ALCHEMISTS_GARDEN, "Alchemist's garden", "Many plants are growing here.");
        alchemistsGarden.MonsterLivingHere = MonsterByID(MONSTER_ID_RAT);

        Location farmhouse = new Location(LOCATION_ID_FARMHOUSE, "Farmhouse", "There is a small farmhouse, with a farmer in front.");
        farmhouse.QuestAvailableHere = QuestByID(QUEST_ID_CLEAR_FARMERS_FIELD);

        Location farmersField = new Location(LOCATION_ID_FARM_FIELD, "Farmer's field", "You see rows of vegetables growing here.");
        farmersField.MonsterLivingHere = MonsterByID(MONSTER_ID_SNAKE);

        Location guardPost = new Location(LOCATION_ID_GUARD_POST, "Guard post", "There is a large, tough-looking guard here.", ItemByID(ITEM_ID_ADVENTURER_PASS));

        Location bridge = new Location(LOCATION_ID_BRIDGE, "Bridge", "A stone bridge crosses a wide river.");

        Location spiderField = new Location(LOCATION_ID_SPIDER_FIELD, "Forest", "You see spider webs covering covering the trees in this forest.");
        spiderField.MonsterLivingHere = MonsterByID(MONSTER_ID_GIANT_SPIDER);

        // Link the locations together
        home.LocationToNorth = townSquare;

        townSquare.LocationToNorth = alchemistHut;
        townSquare.LocationToSouth = home;
        townSquare.LocationToEast = guardPost;
        townSquare.LocationToWest = farmhouse;

        farmhouse.LocationToEast = townSquare;
        farmhouse.LocationToWest = farmersField;

        farmersField.LocationToEast = farmhouse;

        alchemistHut.LocationToSouth = townSquare;
        alchemistHut.LocationToNorth = alchemistsGarden;

        alchemistsGarden.LocationToSouth = alchemistHut;

        guardPost.LocationToEast = bridge;
        guardPost.LocationToWest = townSquare;

        bridge.LocationToWest = guardPost;
        bridge.LocationToEast = spiderField;

        spiderField.LocationToWest = bridge;

        bridge.LocationToNorth = mysticCave;
        mysticCave.LocationToSouth = bridge;

        mysticCave.LocationToEast = frozenLake;
        frozenLake.LocationToWest = mysticCave;

        frozenLake.LocationToNorth = goblinCamp;
        goblinCamp.LocationToSouth = frozenLake;


        // Add the locations to the static list
        Locations.add(home);
        Locations.add(townSquare);
        Locations.add(guardPost);
        Locations.add(alchemistHut);
        Locations.add(alchemistsGarden);
        Locations.add(farmhouse);
        Locations.add(farmersField);
        Locations.add(bridge);
        Locations.add(spiderField);
        Locations.add(mysticCave);
        Locations.add(frozenLake);
        Locations.add(goblinCamp);
    }

    public static Item ItemByID(int id) {
        for (Item item : Items) {
            if (item.ID == id) {
                return item;
            }
        }
        return null;
    }

    public static Monster MonsterByID(int id) {
        for (Monster monster : Monsters) {
            if (monster.ID == id) {
                return monster;
            }
        }
        return null;
    }

    public static Quest QuestByID(int id) {
        for (Quest quest : Quests) {
            if (quest.ID == id) {
                return quest;
            }
        }
        return null;
    }


    public static Location LocationByID(int id) {
        for (Location location : Locations) {
            if (location.getID() == id) {
                return location;
            }
        }
        return null;
    }
}
