public class DieBag{
    private int max;
    private int amount;
    private Die[] die;

    public DieBag(int amount, int max){
        this.max = max;
        this.amount = amount;
        this.die = new Die[amount];
        makeDie();
    }

    private void makeDie(){
        for(int i = 0; i < amount; i++){
            die[i] = new Die(max);
        }
    }

    public void rollAll(){
        for(int i = 0; i < amount; i++){
            die[i].roll();
        }
    }

    public int getValue(){
        int sum = 0;
        for(int i = 0; i < amount; i++){
            sum += die[i].getValue();
        }
        return sum;
    }
}