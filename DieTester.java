public class DieTester{
    public static void main(String[] args){
        //testMakeDieGetValue();
        //testTwoDieEqualities();
        //testGraph1DNormal();
        //testGraph1DLoaded();
        //testGraph2D();
        //testGraph3D();
        //testDieLoaded();
        //testDieBag();
        //testSumOfFive();
        testDieBagPatterns();

        /**Two ways to implement the game where you roll five die:
        1.) Write a function that rolls the die 5 times and sums them together to return a 
        single integer, which is the sum
        2.) Write a new class that contains 5 die of a given max value, and rolling it
        returns the sum of the 5 die
        */
    }

    public static void testDieBagPatterns(){
        System.out.println("Making 5 die with a max of 6");
        DieBag dieBag = new DieBag(5, 6);
        System.out.println(dieBag);
        //dieBag.twoOfAKind();
        dieBag.threeOfAKind();
    }

    public static void testSumOfFive(){
        System.out.println("Making 1 die with a max of 6");
        Die die1 = new Die(6);
        int sum = 0;
        for(int i = 0; i < 5; i++){
            die1.roll();
            sum += die1.getValue();
        }
        System.out.println("Sum of 5 rolls: " + sum);
    }

    public static void testDieBag(){
        System.out.println("Making 5 die with a max of 6");
        DieBag dieBag = new DieBag(5, 6);
        System.out.println("Sum of 5 die: " + dieBag.getValue());
    }

    public static void testDieLoaded(){
        System.out.println("Making loaded die, 4 x2");
        Die die1 = new Die(6, 4, 2);
        if(isLoaded(die1)) System.out.println("Die IS loaded");
        else System.out.println("Die is NOT loaded");

        System.out.println("Making normal die");
        die1 = new Die(6);
        if(isLoaded(die1)) System.out.println("Die IS loaded");
        else System.out.println("Die is NOT loaded");
    }

    public static void testGraph1DLoaded(){
        System.out.println("Making 6 sided die, loaded x2 for getting a 4");
        Die dieLoaded = new Die(6, 4, 2);
        graph1D(10, dieLoaded);
        graph1D(100, dieLoaded);
        graph1D(1000, dieLoaded);
        graph1D(10000, dieLoaded);
    }

    public static void testGraph1DNormal(){
        System.out.println("Making 6 sided die");
        Die dieNormal = new Die(6);
        graph1D(10, dieNormal);
        graph1D(100, dieNormal);
        graph1D(1000, dieNormal);
        graph1D(10000, dieNormal);
    }

    public static void testGraph2D(){
        System.out.println("Making 2x 6 sided die");
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        graph2D(10, die1, die2);
        graph2D(100, die1, die2);
        graph2D(1000, die1, die2);
        graph2D(10000, die1, die2);
    }

    public static void testGraph3D(){
        System.out.println("Making 3x 6 sided die");
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        Die die3 = new Die(6);
        graph3D(10, die1, die2, die3);
        graph3D(100, die1, die2, die3);
        graph3D(1000, die1, die2, die3);
        graph3D(10000, die1, die2, die3);
    }

    public static void testTwoDieEqualities(){
        System.out.println("Making 2 die");
        Die die1 = new Die(6);
        Die die2 = new Die(6);
		
		System.out.println("die1 value: " + die1.getValue());
		System.out.println("die2 value: " + die2.getValue());

        if(die1.isEqual(die2)) System.out.println("equal");
        else System.out.println("Not equal");

        if(die1.lessThan(die2)) System.out.println("die1 < die2");
        else System.out.println("die1 > die2");
        
        System.out.println("0: equal, -1: die1 < die2, 1: di1 > die2");
        if(die1.isEqual(die2)) System.out.println("0");
        else if(die1.lessThan(die2)) System.out.println("-1");
        else System.out.println("1");

        System.out.println("die1 value: " + die1.getValue() + " rolls: " + die1.getRolls());
        die1.roll();
        die1.roll();
        System.out.println("die1 value: " + die1.getValue() + " rolls: " + die1.getRolls());
    }

    public static void testMakeDieGetValue(){
        System.out.println("Making 2 die");
        Die die1 = new Die(6);
        Die die2 = new Die(6);
		
		System.out.println("die1 value: " + die1.getValue());
		System.out.println("die2 value: " + die2.getValue());
    }

    public static void graph3D(int rollAmount, Die die1, Die die2, Die die3){
        int[] rolls = new int[die1.getMax() + die2.getMax() + die3.getMax()];
        for(int i = 0; i < rollAmount; i++){
            die1.roll();
            die2.roll();
            die3.roll();
            int sum = die1.getValue() + die2.getValue() + die3.getValue();
            rolls[sum-1]++;
        }
        printRolls(rolls);
        for(int i = 0; i < rolls.length; i++){
            String complete;
            if(i < 9){
                complete = (i+1) + " |";
            } else complete = (i+1) + "|";
            double percentage = (double) rolls[i] / rollAmount * 100;
            //System.out.println("percentage: " + percentage);
            for(int j = 0; j < percentage; j++){
                complete += "X";
            }
            System.out.println(complete);
        }
        System.out.println();
    }

    public static void graph2D(int rollAmount, Die die1, Die die2){
        int[] rolls = new int[die1.getMax() + die2.getMax()];
        for(int i = 0; i < rollAmount; i++){
            die1.roll();
            die2.roll();
            int sum = die1.getValue() + die2.getValue();
            rolls[sum-1]++;
        }
        printRolls(rolls);
        for(int i = 0; i < rolls.length; i++){
            String complete;
            if(i < 9){
                complete = (i+1) + " |";
            } else complete = (i+1) + "|";
            double percentage = (double) rolls[i] / rollAmount * 50;
            //System.out.println("percentage: " + percentage);
            for(int j = 0; j < percentage; j++){
                complete += "X";
            }
            System.out.println(complete);
        }
        System.out.println();
    }

    public static void graph1D(int rollAmount, Die die1){
        int[] rolls = new int[die1.getMax()];
        for(int i = 0; i < rollAmount; i++){
            die1.roll();
            //System.out.println(die1.getValue());
            rolls[die1.getValue()-1]++;
        }

        printRolls(rolls);

        for(int i = 0; i < rolls.length; i++){
            String complete = (i+1) + "|";
            double percentage = (double) rolls[i] / rollAmount * 20;
            //System.out.println("percentage: " + percentage);
            for(int j = 0; j < percentage; j++){
                complete += "X";
            }
            System.out.println(complete);
        }
    }

    public static void printRolls(int[] rolls){
        String complete = "";
        int sum = 0;
        for(int i = 0; i < rolls.length-1; i++){
            complete = complete + "" + (i+1) + ": " + rolls[i] + ", ";
            sum += rolls[i];
        }
        sum += rolls[rolls.length-1];
        complete += rolls.length + ": " + rolls[rolls.length-1] + " Total: " + sum;
        System.out.println(complete);
    }

    public static boolean isLoaded(Die die1){
        int rolling = 10000;
        //Roll the die X amount of times and send those variables to the rolls array
        int[] rolls = new int[die1.getMax()];
        for(int i = 0; i < rolling; i++){
            die1.roll();
            //System.out.println(die1.getValue());
            rolls[die1.getValue()-1]++;
        }

        //Calculate the percentage of rolls each index in the array has
        System.out.println("1: " + rolls[0] + ", 2: " + rolls[1] + ", 3: " + rolls[2] + ", 4: " + rolls[3] + ", 5: " + rolls[4] + ", 6: " + rolls[5]);
        double[] percentage = new double[rolls.length];
        for(int i = 0; i < percentage.length; i++){
            percentage[i] = (0.0 + rolls[i]) / rolling;
        }

        double truePercentage = 1.0/die1.getMax();
        double errorBound = 0.05;

        for (int i = 0; i < percentage.length; i++){
            System.out.println("True: " + truePercentage + ", Real: " + percentage[i]);
            if(Math.abs(percentage[i] - truePercentage) > errorBound) return true;
        }

        return false;
    }
}