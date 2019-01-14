public class Die{
    private int value;
    private int rolls = 0;
    private int max;
    private boolean loaded;
    private int loadedNum;
    private int multiplier;
    
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
    }

    public void roll(){
        //System.out.println("loadedNum: " + loadedNum + ", max: " + max);
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

            //print array
            /*
            String complete = "";
            for(int i = 0; i < values.length; i++){
                complete += " " + values[i];
            }
            System.out.println(complete);
            */

            int index = (int) (Math.random() * (max+multiplier-1) );
            value = values[index];
            
        }
        //System.out.println("END ROLL");
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