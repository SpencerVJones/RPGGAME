public class NumberAssigner {
    static int NextNumber = 0;
    
    public static int GetNextNumber() {
        NextNumber++;
        return NextNumber;
    }
}



