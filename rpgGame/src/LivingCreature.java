public class LivingCreature {
    public int CurrentHitPoints;
    public int MaximumHitPoints;

    // Getters
    public int getCurrentHitPoints() {return CurrentHitPoints;}
    public int getMaximumHitPoints() {return MaximumHitPoints;}

    // Setters
    public void setCurrentHitPoints(int CurrentHitPoints) {this.CurrentHitPoints = CurrentHitPoints;}
    public void setMaximumHitPoints(int MaximumHitPoints) {this.MaximumHitPoints = MaximumHitPoints;}

    // Constructor
    public LivingCreature(int CurrentHitPoints, int MaximumHitPoints) {
        this.CurrentHitPoints = CurrentHitPoints;
        this.MaximumHitPoints = MaximumHitPoints;
    }
}
