import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JLabel lblLevel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel lblHitPoints;
    private JLabel lblGold;
    private JLabel lblExperience;
    private JPanel mainPanel;
    private JButton btnUseWeapon;
    private JButton btnUsePotion;
    private JButton btnNorth	;
    private JButton btnEast;
    private JButton btnSouth;
    private JButton btnWest	;
    private JTextField rtbLocation;
    private JTextField rtbMessages;
    private JTable dgvInventory;
    private JTable dgvQuests;
    private JComboBox cboWeapons;
    private JComboBox cboPotions;

    private final Player player;

    public static void main(String[] args) {
        // Creating Player
        // Player player = new Player();
        // player.setCurrentHitPoints(10);
        // player.setMaximumHitPoints(10);
        // player.setGold(20);
        // player.setExperiencePoints(0);
        // player.setLevel(1);
        Player player = new Player(10, 10, 20, 0, 1);
        // TODO: Move to location
        // TODO: Add Inventory


        // Creating Location
        // Location location = new Location();
        // location.setID(1);
        // location.setName("Home");
        // location.setDescription("This is your house.");
        Location location = new Location(1, "Home", "This is your House");

        // Create the form and show it
        Main mainForm = new Main(player);
        JFrame frame = new JFrame("Player Info");
        frame.setContentPane(mainForm.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Main(Player player) {
        this.player = player;


//        rtbMessages.setText("");
//        rtbLocation.setText("");

        lblLevel.setText(String.valueOf(player.getLevel()));
        lblGold.setText(String.valueOf(player.getGold()));
        lblExperience.setText(String.valueOf(player.getExperiencePoints()));
        lblHitPoints.setText(String.valueOf(player.getCurrentHitPoints()));


        // Button Action Listeners
        btnNorth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move North Logic
                System.out.println("Moved North");
                // TODO: ADD MOVE TO FUNCTION HERE
            }
        });

        btnEast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move East Logic
                System.out.println("Moved East");
                // TODO: ADD MOVE TO FUNCTION HERE
            }
        });

        btnSouth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move South Logic
                System.out.println("Moved South");
                // TODO: ADD MOVE TO FUNCTION HERE
            }
        });



        btnWest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move West Logic
                System.out.println("Moved West");
                // TODO: ADD MOVE TO FUNCTION HERE
            }
        });



        btnUseWeapon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use Weapon logic
                System.out.println("Weapon used!");
            }
        });

        btnUsePotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use Potion logic
                System.out.println("Weapon used!");
            }
        });






    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    // Function that moves players
    public void MoveTo (Location newlocation) {
        // Check if location requires item
        if(newlocation.ItemRequiredToEnter != null) {
            // Check if player has required item
            boolean playerHasRequiredItem = false;
            for(InventoryItem ii: player.Inventory){
                if(ii.Details.ID == newlocation.ItemRequiredToEnter.ID) {
                    playerHasRequiredItem = true;
                    break;
                }
            }
            if(!playerHasRequiredItem) {
                // Display message stoping the move
                rtbMessages.setText("You must have a " + newlocation.ItemRequiredToEnter.Name + " to enter this location");
                return;
            }
        }

        // Update Players Location
        player.CurrentLocation = newlocation;

        // Show/Hide available movement buttons
        btnNorth.setVisible(newlocation.LocationToNorth !=null);
        btnEast.setVisible(newlocation.LocationToEast !=null);
        btnSouth.setVisible(newlocation.LocationToSouth !=null);
        btnWest.setVisible(newlocation.LocationToWest !=null);

        // Display current location name and description
        rtbLocation.setText(newlocation.Name + "\n" + newlocation.Description);

        // Completely heal player
        player.CurrentHitPoints = player.MaximumHitPoints;

        // Update Hit points on UI
        lblHitPoints.setText(String.valueOf(player.CurrentHitPoints));

        // Check if the location has a quest
        if(newlocation.QuestAvailableHere != null) {
            // See if the player has a quest and if is it completed
            boolean playerAlreadyHasQuest = false;
            boolean playerAlreadyCompletedQuest = false;

            for(PlayerQuest playerQuest: player.Quests) {
                if(playerQuest.Details.ID == newlocation.QuestAvailableHere.ID) {
                    playerAlreadyHasQuest = true;

                    if(playerQuest.IsCompleted){
                        playerAlreadyCompletedQuest = true;
                    }
                }
            }

            // See if the player already has a quest
            if(playerAlreadyHasQuest) {
                // If player has not already completed the quest
                if(!playerAlreadyCompletedQuest) {
                    // See if the player has all items needed to complete quest
                    boolean playerHasAllItemsToCompleteQuest = true;

                    for(QuestCompletionItem qci : newlocation.QuestAvailableHere.QuestCompletionItems) {
                        boolean foundItemInPlayersInventory = false;

                        // Check each item in the player's inventory to see if they have it and enough of it
                        for (InventoryItem ii: player.Inventory) {
                            // The player has this item in their inventory
                            if(ii.Details == qci.Details) {
                                foundItemInPlayersInventory = true;

                                if(ii.Quantity == qci.Quantity) {
                                    playerHasAllItemsToCompleteQuest = false;
                                    break;
                                }
                                break;
                            }
                        }


                        // If the required item wa not found set variable and stop looking
                        if(!foundItemInPlayersInventory) {
                            playerHasAllItemsToCompleteQuest = false;
                            break;
                        }
                    }

                    // Player has all items required to complete quest
                    if(playerHasAllItemsToCompleteQuest) {
                        // Display message
                        rtbMessages.setText("You complete the '" + newlocation.QuestAvailableHere.Name + "' quest.");

                        // Remove quests items from inventory
                        for(QuestCompletionItem qci : newlocation.QuestAvailableHere.QuestCompletionItems) {
                            for(InventoryItem ii: player.Inventory) {
                                if(ii.Details == qci.Details) {
                                    // Subtract quantity from players inventory that was needed to complete the quest
                                    ii.Quantity -= qci.Quantity;
                                    break;
                                }
                            }
                        }

                        // Give Quest Rewards
                        rtbMessages.setText("You receive: \n" +
                                newlocation.QuestAvailableHere.RewardExperiencePoints + " experience points\n"
                                + newlocation.QuestAvailableHere.getRewardGold() + " gold\n"
                                + newlocation.QuestAvailableHere.RewardItem.Name
                        );

                        player.ExperiencePoints += newlocation.QuestAvailableHere.RewardExperiencePoints;
                        player.Gold += newlocation.QuestAvailableHere.RewardGold;

                        // Add reward item to player inventory
                        boolean addedItemToPlayerInventory = false;

                        for(InventoryItem ii: player.Inventory) {
                            if(ii.Details.ID == newlocation.QuestAvailableHere.RewardItem.ID){
                                // They have item in inventory so increase quantity by 1
                                ii.Quantity++;
                                addedItemToPlayerInventory = true;
                                break;
                            }
                        }

                        // They didnt have the item, add it to their inventory with quality on 1
                        if(!addedItemToPlayerInventory) {
                            player.Inventory.add(new InventoryItem(newlocation.QuestAvailableHere.RewardItem, 1));
                        }

                        // Mark Quests as completed
                        // Find quests in players quest list
                        for(PlayerQuest pq: player.Quests) {
                            if(pq.Details.ID == newlocation.QuestAvailableHere.ID) {
                                // Mark as completed
                                pq.IsCompleted = true;
                                break;
                            }
                        }
                    }
                }
            }
            else {
                // The player does not already have the quest
                // Display Message
                rtbMessages.setText(
                        "You receive the " + newlocation.QuestAvailableHere.Name + " quest.\n"
                                + newlocation.QuestAvailableHere.Description + "\n"
                                + "To complete it, return with:"
                );

                for(QuestCompletionItem qci : newlocation.QuestAvailableHere.QuestCompletionItems) {
                    if(qci.Quantity == 1){
                        rtbMessages.setText(qci.Quantity + " " + qci.Details.Name);
                    }
                    else {
                        rtbMessages.setText(qci.Quantity + " " + qci.Details.NamePlural);
                    }
                }
                // Add quest to the players quest list
                player.Quests.add(new PlayerQuest(newlocation.QuestAvailableHere));
            }



        }


    }

}
