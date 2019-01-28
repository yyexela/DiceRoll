public class Die{
    private int value;
    private int rolls = 0;
    private int max;
    private boolean loaded;
    private int loadedNum;
    private int multiplier;

    //Random object
    //private Random random;
    
    public Die(int max){
        this.max = max;
        this.loaded = false;
        roll();
    }

    public Die(int max, int loadedNum, int multiplier){
        this.max = max;
        this.loaded = true;
        this.multiplier = multiplier;
        this.loadedNum = loadedNum;
        roll();
        //Random seed
        //this.random = new Random();
    }

    //Math.random
    public void roll(){
        if(!loaded){
            value = (int) (Math.random() * (max) ) + 1;
            rolls++;
        } else {
            int[] values = new int[max -1 + multiplier];
            for (int num = 1, index = 0; index < values.length; index++, num++){
                if(num <= max){
                    if(num == loadedNum){
                        num++;
                    }
                    values[index] = num;
                } else {
                    values[index] = loadedNum;
                }   
            }

            int index = (int) (Math.random() * (max+multiplier-1) );
            value = values[index];
            
        }
    }

/*
    //Random();
    public void roll(){
        if(!loaded){
            value = random.nextInt(max) + 1;
            rolls++;
        } else {
            int[] values = new int[max -1 + multiplier];
            for (int num = 1, index = 0; index < values.length; index++, num++){
                if(num <= max){
                    if(num == loadedNum){
                        num++;
                    }
                    values[index] = num;
                } else {
                    values[index] = loadedNum;
                }   
            }

            int index = random.nextInt(max+multiplier-1) + 1;
            value = values[index];
            
        }
    }
*/

    public int getValue(){
        return value;
    }

    public int getRolls(){
        return rolls;
    }

    public int getMax(){
        return max;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setLoaded(boolean value){
        loaded = value;
    }

    public void setLoadedNum(int loadedNum){
        this.loadedNum = loadedNum;
    }

    public void setMultiplier(int multiplier){
        this.multiplier = multiplier;
    }

    public boolean isEqual(Die die2){
        if(value == die2.getValue()) return true;
        return false;
    }

    public boolean lessThan(Die die2){
        if(value < die2.getValue()) return true;
        return false;
    }
}