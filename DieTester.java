public class DieTester{
    public static void main(String[] args){
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        
        /*
		
		System.out.println("die1 value: " + die1.getValue());
		System.out.println("die2 value: " + die2.getValue());

        if(die1.isEqual(die2)) System.out.println("equal");
        else System.out.println("Not equal");

        if(die1.lessThan(die2)) System.out.println("die1 < die2");
        else System.out.println("die1 > die2");

        if(die1.isEqual(die2)) System.out.println("0");
        else if(die1.lessThan(die2)) System.out.println("-1");
        else System.out.println("1");

        System.out.println("die1 value: " + die1.getValue() + " rolls: " + die1.getRolls());
        die1.roll();
        die1.roll();
        System.out.println("die1 value: " + die1.getValue() + " rolls: " + die1.getRolls());

        */

        Die dieLoaded = new Die(6, true, 4, 3);
        Die dieLoaded1 = new Die(6, true, 4, 1);
         Die dieLoaded2 = new Die(6, true, 4, 0);
        
        Die dieNormal = new Die(6);
      
        graph1D(10000, dieLoaded);
         graph1D(10000, dieLoaded1);
          graph1D(10000, dieLoaded2);
        graph1D(10000, dieNormal);

        //graph2D(10);
        //graph2D(100);
        //graph2D(1000);

        //graph3D(10);
        //graph3D(100);
        //graph3D(1000);

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
        int[] rolls = new int[12];
        for(int i = 0; i < rollAmount; i++){
            die1.roll();
            die2.roll();
            int sum = die1.getValue() + die2.getValue();
            rolls[sum-1]++;
        }
        for(int i = 0; i < rolls.length; i++){
            String complete;
            if(i < 9){
                complete = (i+1) + " |";
            } else complete = (i+1) + "|";
            double percentage = (double) rolls[i] / rollAmount * 10;
            //System.out.println("percentage: " + percentage);
            for(int j = 0; j < percentage; j++){
                complete += "X";
            }
            System.out.println(complete);
        }
        System.out.println();
    }

    public static void graph1D(int rollAmount, Die die1){
        int[] rolls = new int[6];
        for(int i = 0; i < rollAmount; i++){
            die1.roll();
            //System.out.println(die1.getValue());
            rolls[die1.getValue()-1]++; 
        }
        System.out.println("1: " + rolls[0] + ", 2: " + rolls[1] + ", 3: " + rolls[2] + ", 4: " + rolls[3] + ", 5: " + rolls[4] + ", 6: " + rolls[5]);

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

    //public static boolean isLoaded()
}