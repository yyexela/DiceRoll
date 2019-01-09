public class Die{
    private int value;
    private int rolls = 0;
    private int max;
    private boolean loaded;
    private int loadedNum;
    private double loadedProb;
    
    public Die(int max){
        this.max = max;
        roll();
    }

    public Die(int max, boolean loaded, int loadedNum, double loadedProb){
        this.max = max;
        this.loaded = loaded;
        this.loadedProb = loadedProb;
        this.loadedNum = loadedNum;
        roll();
    }

    public void roll(){
        value = (int) (Math.random() * (max) ) + 1;
        rolls++;
        if(loaded){
            int num = (int) (Math.random() * (max) ) + 1;
            if(num <= (max * (loadedProb))) value = loadedNum;
        }
    }

    public int getValue(){
        return value;
    }

    public int getRolls(){
        return rolls;
    }

    public int getMax(){
        return max;
    }

    public void setLoaded(boolean value){
        loaded = value;
    }

    public void setLoadedNum(int loadedNum){
        this.loadedNum = loadedNum;
    }

    public void setLoadedProb(double loadedProb){
        this.loadedProb = loadedProb;
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