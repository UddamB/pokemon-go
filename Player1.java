/**
 * @author      Uddam Bhathal <Uddamsingh14@gmail.com>
 * @version     1
 * @since       1
 */
public class Player1 {
    //instance variables
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;

    //default constructor creates three new Pokemon with default values for each player
    public Player1(){
        pokemon1 = new Pokemon();
        pokemon2 = new Pokemon();
        pokemon3 = new Pokemon();
    }
    //parameterized constructor stores three different inputted Pokemon
    public Player1(Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3){
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
    }
    //Mutator method for storing the user's set Pokemon to pokemon1
    public void setPokemon1(Pokemon pokemon1){
        this.pokemon1 = pokemon1;
    }
    //Accessor method for accessing pokemon1
    public Pokemon getPokemon1(){
        return pokemon1;
    }
    public void setPokemon2(Pokemon pokemon2){
        this.pokemon2 = pokemon2;
    }
    public Pokemon getPokemon2(){
        return pokemon2;
    }
    public void setPokemon3(Pokemon pokemon3){
        this.pokemon3 = pokemon3;
    }
    public Pokemon getPokemon3() {
        return pokemon3;
    }
    //Void method for checking the winner between the two remaining Pokemon and returns the winner Pokemon
    public static void checkWinner(Pokemon choice1_, Pokemon choice2_){
        if (choice1_.getHealthLeft() == 0) {
            System.out.println("Player 2 is the WINNER!");
        }
        else if(choice2_.getHealthLeft() == 0) {
            System.out.println("Player 1 is the WINNER!");
        }
    }
}
