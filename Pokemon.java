/**
 * @author      Uddam Bhathal <Uddamsingh14@gmail.com>
 * @version     1
 * @since       1
 */
public class Pokemon {
    //instance variables
    private int healthTotal;
    private int healthLeft;
    private String type;
    private String name;

    //default constructor storing default values for instance variables
    public Pokemon(){
        healthLeft = 0;
        healthTotal = 1;
        type = "";
        name = "";
    }

    //parameterized constructor storing inputted values of healthLeft, healthTotal, type, and name
    public Pokemon(int healthLeft, int healthTotal, String type, String name){
        this.healthLeft = healthLeft;
        this.healthTotal = healthTotal;
        this.type = type;
        this.name = name;
    }
    //Mutator method for storing the user's set value to healthTotal
    public void setHealthTotal(int healthTotal){
        this.healthTotal = healthTotal;
    }
    //Accessor method for accessing healthTotal value
    public int getHealthTotal(){
        return healthTotal;
    }
    public void setHealthLeft(int healthLeft){
        this.healthLeft = healthLeft;
    }
    public int getHealthLeft(){
        return healthLeft;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    //Void method for healing Pokemon at a random value between the difference of healthTotal and healthLeft
    public void healPokemon(){
        if(healthLeft<healthTotal) {
            healthLeft += (int) Math.floor(Math.random() * (healthTotal-healthLeft) + 1);
        }
    }
    //Void method for decreasing the Pokemon's health by a certain amount based on the set parameter
    public void hpDecrease(int damageTaken){
        //setting healthLeft to 0 if the damage taken is greater than the previous remaining health of the Pokemon
        if(healthLeft-damageTaken<=0){
            healthLeft = 0;
        }
        else{
            healthLeft-=damageTaken;
        }
    }
    //normalAttack returns a random value between 40 and 50 which acts as the damageTaken
    public int normalAttack(){
        return (int)Math.floor(Math.random()*(50-41)+40);
    }
    //resistiveAttack returns a random value between 20 and 30 which acts as the damageTaken
    public int resistiveAttack(){
        return (int)Math.floor(Math.random()*(30-21)+20);
    }
    //ultimate returns a random value between 70 and 100 which acts as the damageTaken
    public int ultimate(){
        return (int)Math.floor(Math.random()*(100-71)+70);
    }
    //Void method that decreases the second Pokemon's health by 0 and returns the second Pokemon's name and both Pokemon statistics
    public static void dodgeAttack2(Pokemon choice1_, Pokemon choice2_){
        choice2_.hpDecrease(0);
        System.out.println(choice2_.getName()+" dodged the attack nicely!"+"\n"+choice1_ + "\n" + choice2_);
    }
    //Void method that decreases the first Pokemon's health by 0 and returns the first Pokemon's name and both Pokemon statistics
    public static void dodgeAttack1(Pokemon choice1_, Pokemon choice2_){
        choice1_.hpDecrease(0);
        System.out.println(choice1_.getName()+" dodged the attack nicely!"+"\n"+choice1_ + "\n" + choice2_);
    }
    //toString method returns Pokemon name, type, healthLeft, and healthTotal
    public String toString(){
        return name +" "+type+"\t "+healthLeft+"/"+healthTotal+" hp";
    }
}
