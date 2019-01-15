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

    public String toString(){
        String complete = "";
        for(int i = 0; i < die.length; i++){
            complete += "Die" + (i+1) + ": " + die[i].getValue() + "   ";
        }
        return complete;
    }

    private void makeDie(){
        for(int i = 0; i < amount; i++){
            die[i] = new Die(max);
        }
    }

    public void setValue(int index, int value){
        die[index-1].setValue(value);
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

    public int getDieValue(int index){
        if(index <= die.length && index >= 1){
            return die[index-1].getValue();
        } else {
            System.out.println("Invalid index");
            return -1;
        }
    }

    public Die[] getDieArray(){
        return die;
    }

    public boolean twoPairs(){
        for(int i = 0; i < die.length; i++){
              for(int j = i+1; j < die.length; j++){
                    if(die[i].getValue() == die[j].getValue()){
                        System.out.println("2 of a kind");
                        System.out.println("Die" + (i+1) + ": " + die[i].getValue() + ", " + "Die" + (j+1) + ": " + die[j].getValue());
                        //Check other values for a pair
                        for(int l = 0; l < die.length; l++){
                            for(int m = l+1; m < die.length; m++){
                                if(l!=i && m!=i && l!=j && m!=j){
                                    System.out.println("l: " + l + ", m: " + m);
                                    if(die[l].getValue() == die[m].getValue()){
                                        System.out.println("2 of a kind:");
                                        System.out.println("Die" + (l+1) + ": " + die[l].getValue() + ", " + "Die" + (m+1) + ": " + die[m].getValue());
                                        return true;
                                    }
                                }
                            }
                        }
              }
            }
        }
        return false;
    }

    public boolean fullHouse(){
        //Finds 3 of a kind first
        for(int i = 0; i < die.length; i++){
            for(int j = i+1; j < die.length; j++){
                for(int k = j+1; k < die.length; k++){
                    if(die[i].getValue() == die[j].getValue() && die[j].getValue() == die[k].getValue()){
                        System.out.println("3 of a kind:");
                        System.out.println("Die" + (i+1) + ": " + die[i].getValue() + ", " + "Die" + (j+1) + ": " + die[j].getValue()
                                             + ", " + "Die" + (k+1) + ": " + die[k].getValue());
                        //Check other values for a pair
                        for(int l = 0; l < die.length; l++){
                            for(int m = l+1; m < die.length; m++){
                                if(l!=i && m!=i && l!=j && m!=j && l!=k && m!=k){
                                    System.out.println("l: " + l + ", m: " + m);
                                    if(die[l].getValue() == die[m].getValue()){
                                        System.out.println("2 of a kind:");
                                        System.out.println("Die" + (l+1) + ": " + die[l].getValue() + ", " + "Die" + (m+1) + ": " + die[m].getValue());
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }



    public boolean twoOfAKind(){
        boolean hasTwoOfAKind = false;
        for(int i = 0; i < die.length; i++){
            for(int j = i+1; j < die.length; j++){
                if(die[i].getValue() == die[j].getValue()){
                    System.out.println("2 of a kind:");
                    System.out.println("Die" + (i+1) + ": " + die[i].getValue() + ", " + "Die" + (j+1) + ": " + die[j].getValue());
                    hasTwoOfAKind = true;
                }
            }
        }
        if(!hasTwoOfAKind) System.out.println("No 2 of a kind");
        return hasTwoOfAKind;
    }

    public boolean threeOfAKind(){
        boolean hasThreeOfAKind = false;
        for(int i = 0; i < die.length; i++){
            for(int j = i+1; j < die.length; j++){
                for(int k = j+1; k < die.length; k++){
                    if(die[i].getValue() == die[j].getValue() && die[j].getValue() == die[k].getValue()){
                        System.out.println("3 of a kind:");
                        System.out.println("Die" + (i+1) + ": " + die[i].getValue() + ", " + "Die" + (j+1) + ": " + die[j].getValue()
                                             + ", " + "Die" + (k+1) + ": " + die[k].getValue());
                        hasThreeOfAKind = true;
                    }
                }
            }
        }
        if(!hasThreeOfAKind) System.out.println("No 3 of a kind");
        return hasThreeOfAKind;
    }
}