/**
 * @author      Uddam Bhathal <Uddam.Bhathal@student.tdsb.on.ca>
 * @version     1
 * @since       1
 */
//imports
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
public class PokemonGoMain {
    //throwing exceptions for reading file & animated Ascii Art
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner in = new Scanner(System.in);
        //creating Pokemon objects with specific attributes including healthLeft, healthTotal, type, and name.
        Pokemon p1 = new Pokemon(200, 200, "Electric", "Pikachu");
        Pokemon p2 = new Pokemon(150, 150, "Fire", "Charmander");
        Pokemon p3 = new Pokemon(225, 225, "Water", "Squirtle");
        Pokemon p4 = new Pokemon(200, 200, "Ground", "Diglett");
        Pokemon p5 = new Pokemon(275, 275, "Grass", "Venusaur");
        Pokemon p6 = new Pokemon(300, 300, "Fire", "Charizard");
        //adding three Pokemon to each player in the Player1 class
        Player1 player1 = new Player1(p1, p2, p3);
        Player1 player2 = new Player1(p4, p5, p6);
        //printing ascii art
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tP\tO\tK\tE\tM\tO\tN\t\tG\tO\n"+AsciiArt.pokemonSign());
        //setting round to 1, current player1's Pokemon choice to choice1_ and current player2's Pokemon choice to choice2_
        int round = 1;
        Pokemon choice1_;
        Pokemon choice2_;
        //setting both players' dodges to false
        boolean dodge1 = false;
        boolean dodge2 = false;
        //setting both player's number of dodges and number of heals to 1
        int timesHealed1 = 1;
        int timesHealed2 = 1;
        int timesDodged1 = 1;
        int timesDodged2 = 1;
        //printing rules
        System.out.println("RULES WIN DUELS!\n" +
                "1. This is a two player, turn-based game. Remember to choose one ACTIVE pokemon per player.\n"+
                "2. Healing is allowed for a maximum of two VALID heals per round per pokemon (only if pokemon\n"+
                "health is above 0 and below max health). Once a player attempts to heal their pokemon, the turn\n"+
                "is given to the other player regardless of the healing outcome. Just a way to spice things up!\n" +
                "There are a maximum of two heals per pokemon per round. Any unused heals will not be carried over\n" +
                "to the next round.\n"+
                "3. Dodging is allowed; however, if you decide to dodge, it will only dodge the FIRST next ATTACK\n"+
                "only-ie-if both players dodge 5 times consecutively, only two dodges will be accounted for\n"+
                "(1 for each player). In addition, each pokemon receives a total of 2 dodges per round that are reset\n"+
                "to a maximum of 2 dodges as unused dodges will not be carried over to the next round. Your turn will\n"+
                "not be revoked if the player tries dodging with no dodges remaining.\n"+
                "4. If a pokemon has fainted, please select another ACTIVE pokemon; your selections will be numbered\n"+
                "from 1-3 and this order will stay the same throughout the game.\n"+
                "5. Certain pokemon attacks work better against pokemon of certain \"types\"...\n"+
                "6. Finally, have fun and find out which pokemon awaits you!\n");
        System.out.println(AsciiArt.player1AsciiArt()+"\nPlayer 1: Choose your pokemon!\n(1) Pikachu; (2) Charmander; (3) Squirtle\n");
            //setting a loop to match the player1's choice with their desired Pokemon
            while(true) {
                int choice = in.nextInt();
                if (choice == 1) {
                    choice1_ = player1.getPokemon1();
                    break;
                } else if (choice == 2) {
                    choice1_ = player1.getPokemon2();
                    break;
                } else if (choice == 3) {
                    choice1_ = player1.getPokemon3();
                    break;
                } else { //error checking
                    System.out.println("Error, please enter a valid result...Please choose a pokemon from 1-3 (inclusive) based on the options.");
                }
            }
        System.out.println(AsciiArt.pikachuAnimation()+AsciiArt.player2AsciiArt()+"\nPlayer 2: Choose your pokemon!\n(1) Diglett; (2) Venusaur; (3) Charizard\n");
            //setting a loop to match the player2's choice with their desired Pokemon
        while(true){
            int choice2 = in.nextInt();
            if (choice2 == 1) {
                choice2_ = player2.getPokemon1();
                break;
            }
            else if (choice2 == 2) {
                choice2_ = player2.getPokemon2();
                break;
            }
            else if (choice2 == 3) {
                choice2_ = player2.getPokemon3();
                break;
            }
            else{ //error checking
                System.out.println("Error, please enter a valid result...Please choose a pokemon from 1-3 (inclusive) based on the options.");
            }
        }
        //printing player1's Pokemon choice vs player2's Pokemon choice
        System.out.println(choice1_ + " vs " + choice2_ + "!");
        //setting a loop to repeat forever with exceptions inside the loop
        while(true){
                //if statement to ensure that all commands will follow as long as player1's current Pokemon does not have 0hp
                if(choice1_.getHealthLeft()==0){
                    //if statement to ensure that if all three Pokemon from either player 1 or player 2 have 0 hp, the game ends
                    if((player1.getPokemon1().getHealthLeft()==0&&player1.getPokemon2().getHealthLeft()==0&&player1.getPokemon3().getHealthLeft()==0)||(player2.getPokemon1().getHealthLeft()==0&&player2.getPokemon2().getHealthLeft()==0&&player2.getPokemon3().getHealthLeft()==0)){
                        break;
                    }
                    //incrementing the round by 1 and resetting number of dodges and heals for both player1 and player2
                    round++;
                    timesHealed1=1;
                    timesHealed2=1;
                    timesDodged1=1;
                    timesDodged2=1;
                    //printing the round
                    System.out.println("Round "+round+"\n");
                    //printing the loading bars based on how far the rounds have progressed
                    if(round==2){
                        System.out.println(AsciiArt.loadingBar1());
                    }
                    else if (round==3){
                        System.out.println(AsciiArt.loadingBar2());
                    }
                    else if (round==4){
                        System.out.println(AsciiArt.loadingBar3());
                    }
                    else if (round==5){
                        System.out.println(AsciiArt.loadingBar4());
                    }
                    //setting an ArrayList to display player1's Pokemon still alive and removing those with 0hp
                    ArrayList<String>pokemon1 = new ArrayList<>();
                    pokemon1.add(player1.getPokemon1().getName());
                    pokemon1.add(player1.getPokemon2().getName());
                    pokemon1.add(player1.getPokemon3().getName());
                    if(player1.getPokemon1().getHealthLeft()==0){
                        pokemon1.remove(player1.getPokemon1().getName());
                    }
                    if(player1.getPokemon2().getHealthLeft()==0){
                        pokemon1.remove(player1.getPokemon2().getName());
                    }
                    if(player1.getPokemon3().getHealthLeft()==0){
                        pokemon1.remove(player1.getPokemon3().getName());
                    }
                    //Asking player1 to choose one Pokemon
                    System.out.println("Player 1: Choose your pokemon!\n(1); (2); (3) -ie-If (1) has fainted please choose (2) or (3) "+pokemon1);
                    int choice = in.nextInt();
                    //while loop repeats until the player chooses a valid Pokemon
                    while(true){
                        //setting player1's current Pokemon based on player1's choice and displaying the Pokemon's ascii art
                        if (choice == 1&&player1.getPokemon1().getHealthLeft()!=0) {
                            choice1_ = player1.getPokemon1();
                            System.out.println(AsciiArt.pikachuAnimation()+AsciiArt.pikachu());
                            break;
                        }
                        else if (choice == 2&&player1.getPokemon2().getHealthLeft()!=0) {
                            choice1_ = player1.getPokemon2();
                            System.out.println(AsciiArt.pikachuAnimation()+AsciiArt.charmander());
                            break;
                        }
                        else if (choice == 3&&player1.getPokemon3().getHealthLeft()!=0) {
                            choice1_ = player1.getPokemon3();
                            System.out.println(AsciiArt.pikachuAnimation()+AsciiArt.squirtle());
                            break;
                        }
                        //Error checking for when player1 enters a Pokemon that has fainted
                        else if((choice==1&&player1.getPokemon1().getHealthLeft()==0)||(choice==2&&player1.getPokemon2().getHealthLeft()==0)||(choice==3&&player1.getPokemon3().getHealthLeft()==0)){
                            System.out.println(AsciiArt.death()+"\nError!\nUnfortunately, this pokemon has fainted... Please choose an active pokemon!\n");
                            System.out.println("Player 1: Choose your pokemon!\n(1); (2); (3) -ie-If (1) has fainted please choose (2) or (3) "+pokemon1);
                            choice = in.nextInt();
                        }
                        //Error checking for when player1 enters an integer that does not correspond to any options given
                        else{
                            System.out.println("Error, please enter a valid result...If pokemon(1) has fainted, enter (2) or (3)");
                            choice = in.nextInt();
                        }
                    }
                    //setting an ArrayList to display player2's Pokemon still alive and removing those with 0hp
                    ArrayList<String>pokemon2 = new ArrayList<>();
                    pokemon2.add(player2.getPokemon1().getName());
                    pokemon2.add(player2.getPokemon2().getName());
                    pokemon2.add(player2.getPokemon3().getName());
                    if(player2.getPokemon1().getHealthLeft()==0){
                        pokemon2.remove(player2.getPokemon1().getName());
                    }
                    if(player2.getPokemon2().getHealthLeft()==0){
                        pokemon2.remove(player2.getPokemon2().getName());
                    }
                    if(player2.getPokemon3().getHealthLeft()==0){
                        pokemon2.remove(player2.getPokemon3().getName());
                    }
                    //Asking player2 to choose one Pokemon
                    System.out.println("Player 2: Choose your pokemon!\n(1); (2); (3) -ie-If (1) has fainted please choose (2) or (3) "+pokemon2);
                    int choice2 = in.nextInt();
                    //setting player2's current Pokemon based on player2's choice and displaying the Pokemon's ascii art, then their information
                    while(true){
                        if (choice2 == 1&&player2.getPokemon1().getHealthLeft()!=0) {
                            choice2_ = player2.getPokemon1();
                            System.out.println(AsciiArt.pikachuAnimation()+AsciiArt.diglett());
                            System.out.println(choice1_ + " vs " + choice2_ + "!");
                            break;
                        }
                        else if (choice2 == 2&&player2.getPokemon2().getHealthLeft()!=0) {
                            choice2_ = player2.getPokemon2();
                            System.out.println(AsciiArt.pikachuAnimation()+AsciiArt.venusaur());
                            System.out.println(choice1_ + " vs " + choice2_ + "!");
                            break;
                        }
                        else if (choice2 == 3&&player2.getPokemon3().getHealthLeft()!=0) {
                            choice2_ = player2.getPokemon3();
                            System.out.println(AsciiArt.pikachuAnimation()+AsciiArt.charizard());
                            System.out.println(choice1_ + " vs " + choice2_ + "!");
                            break;
                        }
                        //Error checking for when player2 enters a fainted Pokemon
                        else if((choice2==1&&player2.getPokemon1().getHealthLeft()==0)||(choice2==2&&player2.getPokemon2().getHealthLeft()==0)||(choice2==3&&player2.getPokemon3().getHealthLeft()==0)){
                            System.out.println(AsciiArt.death()+"\nError!\nUnfortunately, this pokemon has fainted... Please choose an active pokemon!\n");
                            System.out.println("Player 2: Choose your pokemon!\n(1); (2); (3) -ie-If (1) has fainted please choose (2) or (3) "+pokemon2);
                            choice2 = in.nextInt();
                        }
                        //Error checking for when player2 enters an integer that does not correspond to any options given
                        else{
                            System.out.println("Error, please enter a valid result...If pokemon(1) has fainted, enter (2) or (3)");
                            choice2 = in.nextInt();
                        }
                    }
                }
            //if statement to ensure that all commands will follow as long as player2's current Pokemon does not have 0hp
            if(choice2_.getHealthLeft()==0){
                //if statement to ensure that if all three Pokemon from either player 1 or player 2 have 0 hp, the game ends
                if((player1.getPokemon1().getHealthLeft()==0&&player1.getPokemon2().getHealthLeft()==0&&player1.getPokemon3().getHealthLeft()==0)||(player2.getPokemon1().getHealthLeft()==0&&player2.getPokemon2().getHealthLeft()==0&&player2.getPokemon3().getHealthLeft()==0)){
                    break;
                }
                //incrementing the round by 1 and resetting number of dodges and heals for both player1 and player2
                round++;
                timesHealed1=1;
                timesHealed2=1;
                timesDodged1=1;
                timesDodged2=1;
                //printing the loading bars based on how far the rounds have progressed
                if(round==2){
                    System.out.println(AsciiArt.loadingBar1());
                }
                else if (round==3){
                    System.out.println(AsciiArt.loadingBar2());
                }
                else if (round==4){
                    System.out.println(AsciiArt.loadingBar3());
                }
                else if (round==5){
                    System.out.println(AsciiArt.loadingBar4());
                }
                System.out.println("Round "+round+"\n");
                //setting an ArrayList to display player1's Pokemon still alive and removing those with 0hp
                ArrayList<String>pokemon1 = new ArrayList<>();
                pokemon1.add(player1.getPokemon1().getName());
                pokemon1.add(player1.getPokemon2().getName());
                pokemon1.add(player1.getPokemon3().getName());
                if(player1.getPokemon1().getHealthLeft()==0){
                    pokemon1.remove(player1.getPokemon1().getName());
                }
                if(player1.getPokemon2().getHealthLeft()==0){
                    pokemon1.remove(player1.getPokemon2().getName());
                }
                if(player1.getPokemon3().getHealthLeft()==0){
                    pokemon1.remove(player1.getPokemon3().getName());
                }
                //Asking player2 to choose one Pokemon
                System.out.println("Player 1: Choose your pokemon!\n(1); (2); (3) -ie-If (1) has fainted please choose (2) or (3) "+pokemon1);
                int choice = in.nextInt();
                //setting player1's current Pokemon based on player1's choice and displaying the Pokemon's ascii art, then their information
                while(true){
                    if (choice == 1&&player1.getPokemon1().getHealthLeft()!=0) {
                        choice1_ = player1.getPokemon1();
                        System.out.println(AsciiArt.pikachuAnimation()+AsciiArt.pikachu());
                        break;
                    }
                    else if (choice == 2&&player1.getPokemon2().getHealthLeft()!=0) {
                        choice1_ = player1.getPokemon2();
                        System.out.println(AsciiArt.pikachuAnimation()+AsciiArt.charmander());
                        break;
                    }
                    else if (choice == 3&&player1.getPokemon3().getHealthLeft()!=0) {
                        choice1_ = player1.getPokemon3();
                        System.out.println(AsciiArt.pikachuAnimation()+AsciiArt.squirtle());
                        break;
                    }
                    // Error checking for when player1 enters a fainted Pokemon
                    else if((choice==1&&player1.getPokemon1().getHealthLeft()==0)||(choice==2&&player1.getPokemon2().getHealthLeft()==0)||(choice==3&&player1.getPokemon3().getHealthLeft()==0)){
                        System.out.println(AsciiArt.death()+"\nError!\nUnfortunately, this pokemon has fainted... Please choose an active pokemon!\n");
                        System.out.println("Player 1: Choose your pokemon!\n(1); (2); (3) -ie-If (1) has fainted please choose (2) or (3) "+pokemon1);
                        choice = in.nextInt();
                    }
                    //Error checking for when player1 enters an integer that does not correspond to any options given
                    else{
                        System.out.println("Error, please enter a valid result...If pokemon(1) has fainted, enter (2) or (3)");
                        choice = in.nextInt();
                    }
                }
                //setting an ArrayList to display player2's Pokemon still alive and removing those with 0hp
                ArrayList<String>pokemon2 = new ArrayList<>();
                pokemon2.add(player2.getPokemon1().getName());
                pokemon2.add(player2.getPokemon2().getName());
                pokemon2.add(player2.getPokemon3().getName());
                if(player2.getPokemon1().getHealthLeft()==0){
                    pokemon2.remove(player2.getPokemon1().getName());
                }
                if(player2.getPokemon2().getHealthLeft()==0){
                    pokemon2.remove(player2.getPokemon2().getName());
                }
                if(player2.getPokemon3().getHealthLeft()==0){
                    pokemon2.remove(player2.getPokemon3().getName());
                }
                //Asking player2 to choose one Pokemon
                System.out.println("Player 2: Choose your pokemon!\n(1); (2); (3) -ie-If (1) has fainted please choose (2) or (3) "+pokemon2);
                int choice2 = in.nextInt();
                //setting player2's current Pokemon based on player1's choice and displaying the Pokemon's ascii art, then their information
                while(true){
                    if (choice2 == 1&&player2.getPokemon1().getHealthLeft()!=0) {
                        choice2_ = player2.getPokemon1();
                        System.out.println(AsciiArt.pikachuAnimation()+AsciiArt.diglett());
                        System.out.println(choice1_ + " vs " + choice2_ + "!");
                        break;
                    }
                    else if (choice2 == 2&&player2.getPokemon2().getHealthLeft()!=0) {
                        choice2_ = player2.getPokemon2();
                        System.out.println(AsciiArt.pikachuAnimation()+AsciiArt.venusaur());
                        System.out.println(choice1_ + " vs " + choice2_ + "!");
                        break;
                    }
                    else if (choice2 == 3&&player2.getPokemon3().getHealthLeft()!=0) {
                        choice2_ = player2.getPokemon3();
                        System.out.println(AsciiArt.pikachuAnimation()+AsciiArt.charizard());
                        System.out.println(choice1_ + " vs " + choice2_ + "!");
                        break;
                    }
                    // Error checking for when player2 enters a fainted Pokemon
                    else if((choice2==1&&player2.getPokemon1().getHealthLeft()==0)||(choice2==2&&player2.getPokemon2().getHealthLeft()==0)||(choice2==3&&player2.getPokemon3().getHealthLeft()==0)){
                        System.out.println(AsciiArt.death()+"\nError!\nUnfortunately, this pokemon has fainted... Please choose an active pokemon!\n");
                        System.out.println("Player 2: Choose your pokemon!\n(1); (2); (3) -ie-If (1) has fainted please choose (2) or (3) "+pokemon2);
                        choice2 = in.nextInt();
                    }
                    // Error checking for when player2 enters an integer that does not correspond to any options given
                    else{
                        System.out.println("Error, please enter a valid result...If pokemon(1) has fainted, enter (2) or (3)");
                        choice2 = in.nextInt();
                    }
                }
            }
                // if statement ensures that player1 chooses Pokemon1 and Pokemon1 does not have 0 hp
                if (choice1_ == player1.getPokemon1()&&choice1_.getHealthLeft()!=0) {
                    //while loop repeats forever with certain exceptions within the loop
                    while(true){
                        //asking player1 for their Pokemon1 choice
                        System.out.println("Player 1: It's your turn!");
                        System.out.println("Attack: (1) Thunderbolt (Electric); (2) Quick Attack (Normal); (3) Iron Tail (Normal); (4) Tackle (Normal)\nUtilities: (5) Dodge (6) Heal");
                        int attack = in.nextInt();
                        //if attack equals 5 and number of dodges used is less than or equal to 2, then this Pokemon will dodge the next attack
                        if(attack==5&&timesDodged1<=2){
                            dodge1 = true;
                            timesDodged1++;
                            break;
                        }
                        //if the opponent's Pokemon is a Ground type, then this Pokemon will perform a weaker attack
                        else if((attack==1||attack==2||attack==3||attack==4)&&choice2_.getType().equals("Ground")){
                            //if player2 has dodged before player1's turn, then this attack does no damage
                            if(dodge2){
                                Pokemon.dodgeAttack2(choice1_, choice2_);
                                dodge2=false;
                            }
                            //the resistive attack will be printed on the screen and the winner method will be called and checked to see if player1 is the winner
                            else{
                                System.out.println(AsciiArt.pikachuAttack());
                                int damage = choice1_.resistiveAttack();
                                choice2_.hpDecrease(damage);
                                System.out.println(choice1_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_ + "\nThat was not too effective!");
                                Player1.checkWinner(choice1_,choice2_);
                            }
                            break;
                        }
                        //if player1 tries to heal, then the number of heals will increase by 1 and ascii art of the healing effect will be printed
                        else if(attack == 6){
                            if(timesHealed1<=2&&choice1_.getHealthLeft()<choice1_.getHealthTotal()) {
                                timesHealed1++;
                                choice1_.healPokemon();
                                System.out.println(AsciiArt.healingPotion());
                                System.out.println("It's time to heal! \n" + choice1_ + "\n" + choice2_);
                            }
                            //if player1 tries to use more than 2 heals in this round, then their turn will end
                            else{
                                System.out.println("Your healing has ran out! But your luck hasn't :) Your turn is now gone...hehe");
                            }
                            break;
                        }
                        //if player2's Pokemon is of type Water and player1 uses an electric attack, then player2's Pokemon will take more damage
                        else if (choice2_.getType().equals("Water")&&attack==1) {
                            if(dodge2){
                                Pokemon.dodgeAttack2(choice1_, choice2_);
                                dodge2=false;
                            }
                            else{
                                System.out.println(AsciiArt.pikachuAttack());
                                int damage = choice1_.ultimate();
                                choice2_.hpDecrease(damage);
                                System.out.println(choice1_.getName()+"performed "+damage+"damage!\n"+choice1_ + "\n" + choice2_ + "\nThat was really effective!");
                                Player1.checkWinner(choice1_,choice2_);
                            }
                            break;
                        }
                        //A normal attack is used if none of the conditions above are met
                        else if(attack==1||attack==2||attack==3||attack==4) {
                            if(dodge2){
                                Pokemon.dodgeAttack2(choice1_, choice2_);
                                dodge2=false;
                            }
                            else{
                                System.out.println(AsciiArt.pikachuAttack());
                                int damage = choice1_.normalAttack();
                                choice2_.hpDecrease(damage);
                                System.out.println(choice1_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_);
                                Player1.checkWinner(choice1_,choice2_);
                            }
                            break;
                        }
                        //if player1 tries to use more than 2 dodges in a round, then this error statement will be printed
                        else if(timesDodged1>2){
                            System.out.println("No more dodges remaining, but keep fighting! Don't worry it's still your turn :)");
                        }
                        //if player1 types in a number not listed as one of the options given, then this error statement will be printed
                        else{
                            System.out.println("Error, please enter a valid result...Please enter an attack between 1-4 (inclusive) or a utility between 5-6 (inclusive)");
                        }
                    }
                    }
                    //if player1 chooses pokemon2 and pokemon2 does not have 0hp
                    else if (choice1_ == player1.getPokemon2()&&choice1_.getHealthLeft()!=0) {
                        //while loop repeats forever util certain exceptions in this loop are met (break statements)
                        while (true) {
                            //taking in user input
                            System.out.println("Player 1: It's your turn!");
                            System.out.println("Attack: (1) Flamethrower (Fire); (2) Flame Burst (Fire); (3) Burst Charge (Fire); (4) Scratch (Normal)\nUtilities: (5) Dodge (6) Heal");
                            int attack = in.nextInt();
                            //if attack equals 5 and number of dodges used is less than or equal to 2, then this Pokemon will dodge the next attack
                            if (attack == 5&&timesDodged1<=2) {
                                dodge1 = true;
                                timesDodged1++;
                                break;
                            }
                            //if player2's current Pokemon is of type Water, then there will be a resistive attack
                            else if((attack==1||attack==2||attack==3||attack==4)&&choice2_.getType().equals("Water")){
                                if(dodge2){
                                    Pokemon.dodgeAttack2(choice1_, choice2_);
                                    dodge2=false;
                                }
                                else{
                                    System.out.println(AsciiArt.charmanderAttack());
                                    int damage = choice1_.resistiveAttack();
                                    choice2_.hpDecrease(damage);
                                    System.out.println(choice1_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_ + "\nThat was not too effective!");
                                    Player1.checkWinner(choice1_,choice2_);
                                }
                                break;
                            }
                            //if player1 decides to heal their Pokemon then, the times healed will increment by 1 and the healing function will be called
                            else if(attack == 6){
                                if(timesHealed1<=2&&choice1_.getHealthLeft()<choice1_.getHealthTotal()) {
                                    timesHealed1++;
                                    choice1_.healPokemon();
                                    System.out.println(AsciiArt.healingPotion());
                                    System.out.println("It's time to heal! \n" + choice1_ + "\n" + choice2_);
                                }
                                //if player1 tries to heal more than twice, then this error will be printed
                                else{
                                    System.out.println("Your healing has ran out! But your luck hasn't :) Your turn is now gone...hehe");
                                }
                                break;
                            }
                            //if player2's current Pokemon is of type Grass, then more damage occurs
                            else if (choice2_.getType().equals("Grass") && (attack == 1 || attack == 2|| attack == 3)) {
                                if (dodge2) {
                                    Pokemon.dodgeAttack2(choice1_, choice2_);
                                    dodge2 = false;
                                }
                                else {
                                    System.out.println(AsciiArt.charmanderAttack());
                                    int damage = choice1_.ultimate();
                                    choice2_.hpDecrease(damage);
                                    System.out.println(choice1_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_ + "\nThat was really effective!");
                                    Player1.checkWinner(choice1_, choice2_);
                                }
                                break;
                            }
                            //if none of the conditions above are met, then a normal attack occurs
                            else if(attack==1||attack==2||attack==3||attack==4) {
                                if (dodge2) {
                                    Pokemon.dodgeAttack2(choice1_, choice2_);
                                    dodge2 = false;
                                }
                                else {
                                    System.out.println(AsciiArt.charmanderAttack());
                                    int damage = choice1_.normalAttack();
                                    choice2_.hpDecrease(damage);
                                    System.out.println(choice1_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_);
                                    Player1.checkWinner(choice1_, choice2_);
                                }
                                break;
                            }
                            //if player1 tries dodging more than twice, then this error statement is printed
                            else if(timesDodged1>2){
                                System.out.println("No more dodges remaining, but keep fighting! Don't worry it's still your turn :)");
                            }
                            //if player1 enters a number that is not given as an option, then this error statement is printed
                            else{
                                System.out.println("Error, please enter a valid result...Please enter an attack between 1-4 (inclusive) or a utility between 5-6 (inclusive)");
                            }
                        }
                }
                    //if player1 chooses pokemon3 and pokemon3 does not have 0hp
                    else if (choice1_ == player1.getPokemon3()&&choice1_.getHealthLeft()!=0) {
                        //while loop repeats forever util certain exceptions in this loop are met (break statements)
                        while(true){
                            //taking in user input
                            System.out.println("Player 1: It's your turn!");
                            System.out.println("Attack: (1) Tackle (Normal); (2) Water Pulse (Water); (3) Aqua Jet (Water); (4) Bubble (Water)\nUtilities: (5) Dodge (6) Heal");
                            int attack = in.nextInt();
                            //if attack equals 5 and number of dodges used is less than or equal to 2, then this Pokemon will dodge the next attack
                            if(attack==5&&timesDodged1<=2){
                                dodge1 = true;
                                timesDodged1++;
                                break;
                            }
                            //if player2's current Pokemon is of type Electric or Grass, then there will be a resistive attack
                            else if((attack==1||attack==2||attack==3||attack==4)&&(choice2_.getType().equals("Electric")||choice2_.getType().equals("Grass"))){
                                if(dodge2){
                                    Pokemon.dodgeAttack2(choice1_, choice2_);
                                    dodge2=false;
                                }
                                else{
                                    System.out.println(AsciiArt.squirtleAttack());
                                    int damage = choice1_.resistiveAttack();
                                    choice2_.hpDecrease(damage);
                                    System.out.println(choice1_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_ + "\nThat was not too effective!");
                                    Player1.checkWinner(choice1_,choice2_);
                                }
                                break;
                            }
                            //if player1 decides to heal their Pokemon then, the times healed will increment by 1 and the healing function will be called
                            else if(attack == 6){
                                if(timesHealed1<=2&&choice1_.getHealthLeft()<choice1_.getHealthTotal()) {
                                    timesHealed1++;
                                    choice1_.healPokemon();
                                    System.out.println(AsciiArt.healingPotion());
                                    System.out.println("It's time to heal! \n" + choice1_ + "\n" + choice2_);
                                }
                                //if player1 tries to heal more than twice, then this error will be printed
                                else{
                                    System.out.println("Your healing has ran out! But your luck hasn't :) Your turn is now gone...hehe");
                                }
                                break;
                            }
                            //if player2's current Pokemon is of type Fire and Ground, then more damage occurs
                            else if (choice2_.getType().equals("Fire")&&(attack==2||attack==3||attack==4)||choice2_.getType().equals("Ground")&&(attack==2||attack==3||attack==4)) {
                                if(dodge2){
                                    Pokemon.dodgeAttack2(choice1_, choice2_);
                                    dodge2=false;
                                }
                                else{
                                    System.out.println(AsciiArt.squirtleAttack());
                                    int damage = choice1_.ultimate();
                                    choice2_.hpDecrease(damage);
                                    System.out.println(choice1_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_ + "\nThat was really effective!");
                                    Player1.checkWinner(choice1_,choice2_);
                                }
                                break;
                            }
                            //if none of the conditions above are met, then a normal attack occurs
                            else if(attack==1||attack==2||attack==3||attack==4) {
                                if(dodge2){
                                    Pokemon.dodgeAttack2(choice1_, choice2_);
                                    dodge2=false;
                                }
                                else{
                                    System.out.println(AsciiArt.squirtleAttack());
                                    int damage = choice1_.normalAttack();
                                    choice2_.hpDecrease(damage);
                                    System.out.println(choice1_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_);
                                    Player1.checkWinner(choice1_,choice2_);
                                }
                                break;
                            }
                            //if player1 tries dodging more than twice, then this error statement is printed
                            else if(timesDodged1>2){
                                System.out.println("No more dodges remaining, but keep fighting! Don't worry it's still your turn :)");
                            }
                            //if player1 enters a number that is not given as an option, then this error statement is printed
                            else{
                                System.out.println("Error, please enter a valid result...Please enter an attack between 1-4 (inclusive) or a utility between 5-6 (inclusive)");
                            }
                        }
                }
                //if statement ensures that player2 chooses Pokemon1 and Pokemon1 does not have 0 hp
                if(choice2_==player2.getPokemon1()&&choice2_.getHealthLeft()!=0) {
                    //while loop repeats forever util certain exceptions in this loop are met (break statements)
                    while(true){
                        //taking in user input
                        System.out.println("Player 2: It's your turn!");
                        System.out.println("Attack: (1) Scratch (Normal); (2) Rock Tomb (Ground); (3) Mud Bomb (Ground)\nUtilities: (5) Dodge (6) Heal");
                        int attack = in.nextInt();
                        //if attack equals 5 and number of dodges used is less than or equal to 2, then this Pokemon will dodge the next attack
                        if(attack==5&&timesDodged2<=2){
                            dodge2 = true;
                            timesDodged2++;
                            break;
                        }
                        //if player1's current Pokemon is of type Water, then there will be a resistive attack
                        else if((attack==1||attack==2||attack==3)&&choice1_.getType().equals("Water")){
                            if(dodge1) {
                                Pokemon.dodgeAttack1(choice1_, choice2_);
                                dodge1=false;
                            }
                            else{
                                System.out.println(AsciiArt.diglettAttack());
                                int damage = choice2_.resistiveAttack();
                                choice1_.hpDecrease(damage);
                                System.out.println(choice2_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_ + "\nThat was not too effective!");
                                Player1.checkWinner(choice1_,choice2_);
                            }
                            break;
                        }
                        //if player2 decides to heal their Pokemon then, the times healed will increment by 1 and the healing function will be called
                        else if(attack == 6){
                            if(timesHealed2<=2&&choice2_.getHealthLeft()<choice2_.getHealthTotal()) {
                                timesHealed2++;
                                choice2_.healPokemon();
                                System.out.println(AsciiArt.healingPotion());
                                System.out.println("It's time to heal! \n" + choice1_ + "\n" + choice2_);
                            }
                            //if player2 tries to heal more than twice, then this error will be printed
                            else{
                                System.out.println("Your healing has ran out! But your luck hasn't :) Your turn is now gone...hehe");
                            }
                            break;
                        }
                        //if player1's current Pokemon is of type Electric, then more damage occurs
                        else if (choice1_.getType().equals("Electric") && (attack == 2 || attack == 3)) {
                            if(dodge1) {
                                Pokemon.dodgeAttack1(choice1_, choice2_);
                                dodge1=false;
                            }
                            else {
                                System.out.println(AsciiArt.diglettAttack());
                                int damage = choice2_.ultimate();
                                choice1_.hpDecrease(damage);
                                System.out.println(choice2_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_ + "\nThat was really effective!");
                                Player1.checkWinner(choice1_, choice2_);
                            }
                            break;
                        }
                        //if none of the conditions above are met, then a normal attack occurs
                        else if(attack==1||attack==2||attack==3) {
                            if(dodge1) {
                                Pokemon.dodgeAttack1(choice1_, choice2_);
                                dodge1=false;
                            }
                            else {
                                System.out.println(AsciiArt.diglettAttack());
                                int damage = choice2_.normalAttack();
                                choice1_.hpDecrease(damage);
                                System.out.println(choice2_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_);
                                Player1.checkWinner(choice1_, choice2_);
                            }
                            break;
                        }
                        //if player2 tries dodging more than twice, then this error statement is printed
                        else if(timesDodged2>2){
                            System.out.println("No more dodges remaining, but keep fighting! Don't worry it's still your turn :)");
                        }
                        //if player2 enters a number that is not given as an option, then this error statement is printed
                        else{
                            System.out.println("Error, please enter a valid result...Please enter an attack between 1-3 (inclusive) or a utility between 5-6 (inclusive)");
                        }
                    }
                }
                //if statement ensures that player2 chooses Pokemon2 and Pokemon2 does not have 0 hp
                else if(choice2_==player2.getPokemon2()&&choice2_.getHealthLeft()!=0){
                    //while loop repeats forever util certain exceptions in this loop are met (break statements)
                    while(true){
                        //taking in user input
                        System.out.println("Player 2: It's your turn!");
                        System.out.println("Attack: (1) Sludge Bomb (Normal); (2) Vine Whip (Grass); (3) Solar Beam (Grass)\nUtilities: (5) Dodge (6) Heal");
                        int attack = in.nextInt();
                        //if attack equals 5 and number of dodges used is less than or equal to 2, then this Pokemon will dodge the next attack
                        if(attack==5&&timesDodged2<=2){
                            dodge2 = true;
                            timesDodged2++;
                            break;
                        }
                        //if player1's current Pokemon is of type Fire, then there will be a resistive attack
                        else if((attack==1||attack==2||attack==3)&&choice1_.getType().equals("Fire")){
                            if(dodge1) {
                                Pokemon.dodgeAttack1(choice1_, choice2_);
                                dodge1=false;
                            }
                            else{
                                System.out.println(AsciiArt.charizardAttack());
                                int damage = choice2_.resistiveAttack();
                                choice1_.hpDecrease(damage);
                                System.out.println(choice2_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_ + "\nThat was not too effective!");
                                Player1.checkWinner(choice1_,choice2_);
                            }
                            break;
                        }
                        //if player2 decides to heal their Pokemon then, the times healed will increment by 1 and the healing function will be called
                        else if(attack == 6){
                            if(timesHealed2<=2&&choice2_.getHealthLeft()<choice2_.getHealthTotal()) {
                                timesHealed2++;
                                choice2_.healPokemon();
                                System.out.println(AsciiArt.healingPotion());
                                System.out.println("It's time to heal! \n" + choice1_ + "\n" + choice2_);
                            }
                            //if player2 tries to heal more than twice, then this error will be printed
                            else{
                                System.out.println("Your healing has ran out! But your luck hasn't :) Your turn is now gone...hehe");
                            }
                            break;
                        }
                        //if player1's current Pokemon is of type Water, then more damage occurs
                        else if (choice1_.getType().equals("Water") && (attack == 2 || attack == 3)) {
                            if(dodge1) {
                                Pokemon.dodgeAttack1(choice1_, choice2_);
                                dodge1=false;
                            }
                            else{
                                System.out.println(AsciiArt.venusaurAttack());
                                int damage = choice2_.ultimate();
                                choice1_.hpDecrease(damage);
                                System.out.println(choice2_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_ + "\nThat was really effective!");
                                Player1.checkWinner(choice1_, choice2_);
                            }
                            break;
                        }
                        //if none of the conditions above are met, then a normal attack occurs
                        else if(attack==1||attack==2||attack==3){
                            if(dodge1) {
                                Pokemon.dodgeAttack1(choice1_, choice2_);
                                dodge1=false;
                            }
                            else{
                                System.out.println(AsciiArt.venusaurAttack());
                                int damage = choice2_.normalAttack();
                                choice1_.hpDecrease(damage);
                                System.out.println(choice2_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_);
                                Player1.checkWinner(choice1_, choice2_);
                            }
                            break;
                        }
                        //if player2 tries dodging more than twice, then this error statement is printed
                        else if(timesDodged2>2){
                            System.out.println("No more dodges remaining, but keep fighting! Don't worry it's still your turn :)");
                        }
                        //if player2 enters a number that is not given as an option, then this error statement is printed
                        else{
                            System.out.println("Error, please enter a valid result...Please enter an attack between 1-3 (inclusive) or a utility between 5-6 (inclusive)");
                        }
                    }
                }
                //if statement ensures that player2 chooses Pokemon3 and Pokemon3 does not have 0 hp
                else if(choice2_==player2.getPokemon3()&&choice2_.getHealthLeft()!=0){
                    //while loop repeats forever util certain exceptions in this loop are met (break statements)
                    while(true){
                        //taking in user input
                        System.out.println("Player 2: It's your turn!");
                        System.out.println("Attack: (1) Air Slash (Normal); (2) Fire Spin (Fire); (3) Blast Burn (Fire)\nUtilities: (5) Dodge (6) Heal");
                        int attack = in.nextInt();
                        //if attack equals 5 and number of dodges used is less than or equal to 2, then this Pokemon will dodge the next attack
                        if(attack==5&&timesDodged2<=2){
                            dodge2 = true;
                            timesDodged2++;
                            break;
                        }
                        //if player1's current Pokemon is of type Water, then there will be a resistive attack
                        else if((attack==1||attack==2||attack==3)&&choice1_.getType().equals("Water")){
                            if(dodge1) {
                                Pokemon.dodgeAttack1(choice1_, choice2_);
                                dodge1=false;
                            }
                            else{
                                System.out.println(AsciiArt.venusaurAttack());
                                int damage = choice2_.resistiveAttack();
                                choice1_.hpDecrease(damage);
                                System.out.println(choice2_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_ + "\nThat was not too effective!");
                                Player1.checkWinner(choice1_,choice2_);
                            }
                            break;
                        }
                        //if player2 decides to heal their Pokemon then, the times healed will increment by 1 and the healing function will be called
                        else if(attack == 6){
                            if(timesHealed2<=2&&choice2_.getHealthLeft()<choice2_.getHealthTotal()) {
                                timesHealed2++;
                                choice2_.healPokemon();
                                System.out.println(AsciiArt.healingPotion());
                                System.out.println("It's time to heal! \n" + choice1_ + "\n" + choice2_);
                            }
                            //if player2 tries to heal more than twice, then this error will be printed
                            else{
                                System.out.println("Your healing has ran out! But your luck hasn't :) Your turn is now gone...hehe");
                            }
                            break;
                        }
                        //if player1's current Pokemon is of type Grass, then more damage occurs
                        else if (choice1_.getType().equals("Grass") && (attack == 2 || attack == 3)) {
                            if(dodge1) {
                                Pokemon.dodgeAttack1(choice1_, choice2_);
                                dodge1=false;
                            }
                            else{
                                System.out.println(AsciiArt.charizardAttack());
                                int damage = choice2_.ultimate();
                                choice1_.hpDecrease(damage);
                                System.out.println(choice2_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_ + "\nThat was really effective!");
                                Player1.checkWinner(choice1_, choice2_);
                            }
                            break;
                        }
                        //if none of the conditions above are met, then a normal attack occurs
                        else if(attack==1||attack==2||attack==3) {
                            if(dodge1) {
                                Pokemon.dodgeAttack1(choice1_, choice2_);
                                dodge1=false;
                            }
                            else{
                                System.out.println(AsciiArt.charizardAttack());
                                int damage = choice2_.normalAttack();
                                choice1_.hpDecrease(damage);
                                System.out.println(choice2_.getName()+" performed "+damage+" damage!\n"+choice1_ + "\n" + choice2_);
                                Player1.checkWinner(choice1_, choice2_);
                            }
                            break;
                        }
                        //if player2 tries dodging more than twice, then this error statement is printed
                        else if(timesDodged2>2){
                            System.out.println("No more dodges remaining, but keep fighting! Don't worry it's still your turn :)");
                        }
                        //if player2 enters a number that is not given as an option, then this error statement is printed
                        else{
                            System.out.println("Error, please enter a valid result...Please enter an attack between 1-3 (inclusive) or a utility between 5-6 (inclusive)");
                        }
                    }
                }
        }
        //final ascii art is printed
        System.out.println(AsciiArt.ending()+"\n"+AsciiArt.loadingBar5()+"\nWell Played! Now go save humanity :)");
    }
}