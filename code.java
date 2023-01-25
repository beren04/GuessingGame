package first;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class sayitahmin {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(100);

        Scanner input = new Scanner(System.in);
        int right = 0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isLose = false;

        while(right<5){
            System.out.println("Guess the secret number:");
            selected = input.nextInt();

            if(selected<0 || selected>99){
                System.out.println("Enter a number between 0-100!");
                if(isLose){
                    right++;
                    System.out.println("You enter a not valid number for so long.\n Remaining:"+(5-right));
                }else{
                    isLose=true;
                    System.out.println("If you enter a not valid number for one more time, your remaining will be decreased");
                }
                continue;
            }

            if (number==selected){
                System.out.println("Congrats! You guessed the secret number!!!\nSecret number is:"+number);
                isWin = true;
                break;
            }
            else{
                System.out.println(selected+"isn't the secret number.");
                if(selected<number){
                    System.out.println(selected+"is larger than the secret number.");
                }else{
                    System.out.println(selected+"is smaller than the secret number.");
                }
                wrong[right]=selected;
                right++;
                System.out.println("Remaining:"+(5-right));
            }
        }
        if(!isWin){
            System.out.println("You lose!");
            if(!isLose){
                System.out.println("Your Guesses:"+ Arrays.toString(wrong));
            }
        }
    }

}
