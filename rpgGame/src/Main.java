import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    private JPanel mainPanel;
    private JLabel levelLabel;
    private JLabel hitPointsLabel;
    private JLabel goldLabel;
    private JLabel experienceLabel;
    private JButton useWeaponButton;
    private JButton usePotionButton;
    private JButton northButton;
    private JButton eastButton;
    private JButton southButton;
    private JButton westButton;
    private JTextArea locationTextArea;
    private JTextArea messagesTextArea;
    private JTable inventoryTable;
    private JTable questsTable;
    private JComboBox weaponsComboBox;
    private JComboBox potionsComboBox;
    private JScrollPane messageScrollPane;
    private JScrollPane locationScrollPane;

    private Player player;
    private Monster currentMonster;

    public static void main(String[] args) {
        // Creating Player
        Player player = new Player(10, 10, 20, 0, 1);
        // Initialize world
        World world = new World();
        // Set starting location
        player.CurrentLocation = World.LocationByID(World.LOCATION_ID_HOME);
        // Add Inventory
        player.Inventory.add(new InventoryItem(World.ItemByID(World.ITEM_ID_RUSTY_SWORD), 1));
        // Creating Location
        Location location = new Location(1, "Home", "This is your House");


        // Create the form and show it
        Main mainForm = new Main(player);
        JFrame frame = new JFrame("Player Info");
        frame.setContentPane(mainForm.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

//        frame.setResizable(false); // Prevent resizing
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }


    // Refresh UI Methods
    private void updatePlayerStatsUI() {
        levelLabel.setText(String.valueOf(player.getLevel()));
        goldLabel.setText(String.valueOf(player.getGold()));
        experienceLabel.setText(String.valueOf(player.getExperiencePoints()));
        hitPointsLabel.setText(String.valueOf(player.getCurrentHitPoints()));
    }

    private void updateInventoryListInUI() {
        inventoryTable.setTableHeader(null);
        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Name", "Quantity"}
        ));

        javax.swing.table.DefaultTableModel inventoryModel =
                (javax.swing.table.DefaultTableModel) inventoryTable.getModel();

        for (InventoryItem inventoryItem : player.getInventory()) {
            if (inventoryItem.getQuantity() > 0) {
                inventoryModel.addRow(new Object[]{
                        inventoryItem.getDetails().getName(),
                        String.valueOf(inventoryItem.getQuantity())
                });
            }
        }
    }

    private void updateQuestListInUI() {
        questsTable.setTableHeader(null);
        questsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Name", "Done?"}
        ));

        javax.swing.table.DefaultTableModel questsModel =
                (javax.swing.table.DefaultTableModel) questsTable.getModel();

        for (PlayerQuest playerQuest : player.getQuests()) {
            questsModel.addRow(new Object[]{
                    playerQuest.getDetails().getName(),
                    String.valueOf(playerQuest.IsCompleted)
            });
        }
    }

    private void updateWeaponListInUI() {
        ArrayList<Weapon> weapons = new ArrayList<>();

        for (InventoryItem inventoryItem : player.getInventory()) {
            if (inventoryItem.getDetails() instanceof Weapon && inventoryItem.getQuantity() > 0) {
                weapons.add((Weapon) inventoryItem.getDetails());
            }
        }

        if (weapons.isEmpty()) {
            weaponsComboBox.setEnabled(false);
            useWeaponButton.setEnabled(false);
        } else {
            DefaultComboBoxModel<Weapon> model = new DefaultComboBoxModel<>();
            for (Weapon weapon : weapons) {
                model.addElement(weapon);
            }
            weaponsComboBox.setModel(model);
            weaponsComboBox.setSelectedIndex(0);
            weaponsComboBox.setEnabled(true);
            useWeaponButton.setEnabled(true);
        }
    }

    private void updatePotionListInUI() {
        ArrayList<HealingPotion> healingPotions = new ArrayList<>();

        for (InventoryItem inventoryItem : player.getInventory()) {
            if (inventoryItem.getDetails() instanceof HealingPotion && inventoryItem.getQuantity() > 0) {
                healingPotions.add((HealingPotion) inventoryItem.getDetails());
            }
        }

        if (healingPotions.isEmpty()) {
            potionsComboBox.setEnabled(false);
            usePotionButton.setEnabled(false);
        } else {
            DefaultComboBoxModel<HealingPotion> model = new DefaultComboBoxModel<>();
            for (HealingPotion potion : healingPotions) {
                model.addElement(potion);
            }
            potionsComboBox.setModel(model);
            potionsComboBox.setSelectedIndex(0);
            potionsComboBox.setEnabled(true);
            usePotionButton.setEnabled(true);
        }
    }


    public Main(Player player) {
        this.player = player;

        Dimension fixedSize = new Dimension(50, 50);
        messagesTextArea.setSize(fixedSize);
        messageScrollPane.setSize(fixedSize);
        locationTextArea.setSize(fixedSize);
        locationScrollPane.setSize(fixedSize);

        // Enable text wrapping in the text areas
        messagesTextArea.setLineWrap(true);
        messagesTextArea.setWrapStyleWord(true);

        locationTextArea.setLineWrap(true);
        locationTextArea.setWrapStyleWord(true);

        mainPanel.setSize(800, 600);
        updatePlayerStatsUI();

        // Button Action Listeners
        northButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoveTo(player.CurrentLocation.LocationToNorth);
            }
        });

        eastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoveTo(player.CurrentLocation.LocationToEast);
            }
        });

        southButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoveTo(player.CurrentLocation.LocationToSouth);
            }
        });

        westButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoveTo(player.CurrentLocation.LocationToWest);
            }
        });


        useWeaponButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get currently selected weapon
                Weapon currentWeapon = (Weapon) weaponsComboBox.getSelectedItem();

                // Determine amount of damage to do to the monster
                int damageToMonster = RandomNumberGenerator.NumberBetween(currentWeapon.MinimumDamage, currentWeapon.MaximumDamage);

                // Apply damage to monster's current hit points
                currentMonster.CurrentHitPoints -= damageToMonster;

                // Display Message
                messagesTextArea.append("You hit the " + currentMonster.Name + " for " + String.valueOf(damageToMonster) + " points.");

                // Check if the monster is dead
                if (currentMonster.CurrentHitPoints <= 0) {
                    // Monster is dead
                    messagesTextArea.append("You defeated the" + currentMonster.Name);

                    // Give player experience points for killing monster
                    player.ExperiencePoints += currentMonster.RewardExperiencePoints;
                    messagesTextArea.append("You receive " + currentMonster.RewardExperiencePoints + " experience points.");

                    // Give player gold for killing monster
                    player.Gold += currentMonster.RewardGold;
                    messagesTextArea.append("You receive " + currentMonster.RewardGold + " gold.");

                    // Get random loot items from the monster
                    ArrayList<InventoryItem> lootedItems = new ArrayList<InventoryItem>();

                    // Add items to the lootedItems list, comparing a random number to the drop percentage
                    for (LootItem lootItem : currentMonster.LootTable) {
                        if (RandomNumberGenerator.NumberBetween(1, 100) <= lootItem.getDropPercentage()) {
                            lootedItems.add(new InventoryItem(lootItem.getDetails(), 1));
                        }
                    }
                    // If no items were randomly selected, add the default loot item(s)
                    if (lootedItems.isEmpty()) {
                        for (LootItem lootItem : currentMonster.LootTable) {
                            {
                                if (lootItem.getIsDefaultItem()) {
                                    lootedItems.add(new InventoryItem(lootItem.getDetails(), 1));
                                }
                            }
                        }

                        // Add the looted items to the players inventory
                        for (InventoryItem inventoryItem : lootedItems) {
                            player.AddItemToInventory(inventoryItem.Details);
                            if (inventoryItem.Quantity == 1) {
                                messagesTextArea.append("You loot " + inventoryItem.Quantity + " " + inventoryItem.Details.Name);
                            } else {
                                messagesTextArea.append("You loot " + inventoryItem.Quantity + " " + inventoryItem.Details.NamePlural);
                            }
                        }
                    }
                    updatePlayerStatsUI();

                    // Move player to current location (heals player and creates new monster to fight_
                    MoveTo(player.getCurrentLocation());

                } else { // Monster is still alive
                    // Determine amount of damage monster does to the player
                    int damageToPlayer = RandomNumberGenerator.NumberBetween(0, currentMonster.MaximumDamage);

                    // Display Message
                    messagesTextArea.append("The " + currentMonster.Name + " did " + String.valueOf(damageToPlayer) + " points of damage.");

                    // Subtract damage from the player
                    player.CurrentHitPoints -= damageToPlayer;

                    // Refresh player data in UI
                    hitPointsLabel.setText(String.valueOf(player.getCurrentHitPoints()));

                    if (player.CurrentHitPoints <= 0) {
                        // Display message
                        messagesTextArea.append("The " + currentMonster.Name + " killed you.");

                        // Move player to "Home"
                        MoveTo(World.LocationByID(World.LOCATION_ID_HOME));
                    }
                }
            }
        });


        usePotionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get currently selected potion
                HealingPotion potion = (HealingPotion) potionsComboBox.getSelectedItem();

                // Add healing amount to players current hit points
                player.CurrentHitPoints = player.CurrentHitPoints + potion.AmountToHeal;

                // Current hit points cannot exceed players Max hit points
                if (player.CurrentHitPoints > player.MaximumHitPoints) {
                    player.CurrentHitPoints = player.MaximumHitPoints;
                }

                // Remove potion from players inventory
                for (InventoryItem ii : player.Inventory) {
                    if (ii.Details.ID == potion.ID) {
                        ii.Quantity++;
                        break;
                    }

                    // Display Message
                    messagesTextArea.append("You drink a " + potion.Name);

                    // Monster gets their turn to attack
                    // Determine amount of damage monster does to player
                    int damageToPlayer = RandomNumberGenerator.NumberBetween(1, currentMonster.getMaximumDamage());

                    // Display message
                    messagesTextArea.append("The " + currentMonster.Name + " did " + damageToPlayer + " points of damage.");

                    // Subtract damage from player
                    player.CurrentHitPoints -= damageToPlayer;

                    if (player.CurrentHitPoints <= 0) {
                        messagesTextArea.append("The " + currentMonster.Name + " killed you.");

                        // Move player to "Home"
                        MoveTo(World.LocationByID(World.LOCATION_ID_HOME));
                    }

                    // Refresh player data in UI
                    updateInventoryListInUI();
                    updateQuestListInUI();
                    updateWeaponListInUI();
                    updatePotionListInUI();
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    // Function that moves players
    public void MoveTo(Location newlocation) {
        // Check if location requires item
        if (!player.HasItemRequiredToEnter(newlocation)) {
            messagesTextArea.append("You must have a " + newlocation.ItemRequiredToEnter.Name + " to enter this location");
            return;
        }

        // Update Players Location
        player.CurrentLocation = newlocation;

        // Show/Hide available movement buttons
        northButton.setEnabled(newlocation.LocationToNorth != null);
        eastButton.setEnabled(newlocation.LocationToEast != null);
        southButton.setEnabled(newlocation.LocationToSouth != null);
        westButton.setEnabled(newlocation.LocationToWest != null);

        // Display current location name and description
        locationTextArea.append(newlocation.Name + "\n" + newlocation.Description);

        // Completely heal player
        player.CurrentHitPoints = player.MaximumHitPoints;

        // Update Hit points on UI
        updatePlayerStatsUI();

        // Check if the location has a quest
        if (newlocation.QuestAvailableHere != null) {
            // See if the player has a quest and if is it completed
            boolean playerAlreadyHasQuest = player.HasThisQuest(newlocation.QuestAvailableHere);
            boolean playerAlreadyCompletedQuest = player.CompletedThisQuest(newlocation.QuestAvailableHere);

            // See if player has quest already
            if (playerAlreadyHasQuest) {
                // if player has not completed the quest
                if (!playerAlreadyCompletedQuest) {
                    // See if the player has all required items to complete the quest
                    boolean playerHasAllItemsToCompleteQuest = player.HasAllQuestsCompletionItems(newlocation.QuestAvailableHere);

                    // The player has all items needed to complete the quest
                    if (playerHasAllItemsToCompleteQuest) {
                        // Display Message
                        messagesTextArea.append("You complete the '" + newlocation.QuestAvailableHere.Name + "' quest.");

                        // Remove quest items from inventory
                        player.RemoveQuestCompletionItem(newlocation.QuestAvailableHere);

                        // Give Quest rewards
                        messagesTextArea.append("You receive: \n" +
                                newlocation.QuestAvailableHere.RewardExperiencePoints + " experience points\n"
                                + newlocation.QuestAvailableHere.getRewardGold() + " gold\n"
                                + newlocation.QuestAvailableHere.RewardItem.Name
                        );

                        player.ExperiencePoints += newlocation.QuestAvailableHere.RewardExperiencePoints;
                        player.Gold += newlocation.QuestAvailableHere.RewardGold;

                        // Add the reward Item to players inventory
                        player.AddItemToInventory(newlocation.QuestAvailableHere.RewardItem);

                        // Mark quest as completed
                        player.MarkQuestCompleted(newlocation.QuestAvailableHere);
                    }
                }
            } else { // The player does not already have the quest
                // Display Message
                messagesTextArea.append(
                        "You receive the " + newlocation.QuestAvailableHere.Name + " quest.\n"
                                + newlocation.QuestAvailableHere.Description + "\n"
                                + "To complete it, return with:"
                );

                for (QuestCompletionItem qci : newlocation.QuestAvailableHere.QuestCompletionItems) {
                    if (qci.Quantity == 1) {
                        messagesTextArea.append(qci.Quantity + " " + qci.Details.Name);
                    } else {
                        messagesTextArea.append(qci.Quantity + " " + qci.Details.NamePlural);
                    }
                }

                // Add quest to the players quest list
                player.Quests.add(new PlayerQuest(newlocation.QuestAvailableHere, false));
            }
        }

        // Does the location have a monster
        if (newlocation.MonsterLivingHere != null) {
            messagesTextArea.append("You see a " + newlocation.MonsterLivingHere.Name);

            // Make a new monster
            Monster standardMonster = World.MonsterByID(newlocation.MonsterLivingHere.ID);

            currentMonster = new Monster(standardMonster.ID, standardMonster.Name, standardMonster.MaximumDamage,
                    standardMonster.RewardExperiencePoints, standardMonster.RewardGold, standardMonster.CurrentHitPoints, standardMonster.MaximumHitPoints);

            for (LootItem lootItem : standardMonster.LootTable) {
                currentMonster.LootTable.add(lootItem);
            }

            weaponsComboBox.setEnabled(true);
            potionsComboBox.setEnabled(true);
            useWeaponButton.setEnabled(true);
            usePotionButton.setEnabled(true);
        } else {
            currentMonster = null;
            weaponsComboBox.setEnabled(false);
            potionsComboBox.setEnabled(false);
            useWeaponButton.setEnabled(false);
            usePotionButton.setEnabled(false);
        }

        updateInventoryListInUI();
        updateQuestListInUI();
        updateWeaponListInUI();
        updatePotionListInUI();
    }
}
