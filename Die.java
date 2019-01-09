public class Die{
    private int value;
    private int rolls = 0;
    private int max;
    private boolean loaded;
    private int loadedNum;
    private int multiplier;
    
    public Die(int max){
        this.max = max;
        roll();
    }

    public Die(int max, boolean loaded, int loadedNum, int multiplier){
        this.max = max;
        this.loaded = loaded;
        this.multiplier = multiplier;
        this.loadedNum = loadedNum;
        roll();
    }

    public void roll(){
        value = (int) (Math.random() * (max) ) + 1;
        rolls++;
        if(loaded){
            double ogProb = 1.0/max;
            double otherProb = 1.0/(max-1.0+multiplier);
            double loadedProb = 1.0-(max-1.0)*otherProb;
            double rand = (Math.random())+otherProb;
            double whole = rand/otherProb;
            if (whole >= max){
                value = loadedNum;
            }
            else {
                value = (int) whole;
            }
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