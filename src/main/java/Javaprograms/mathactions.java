package Javaprograms;

import java.util.Scanner;

public class mathactions {

    public void add(){

        Scanner number = new Scanner (System.in);

        int firstnumber = number.nextInt();
        int secondnumber = number.nextInt();

        int sum = firstnumber+secondnumber;

        System.out.println("Sum of two numbers"+sum);

    }

    public void mutp() {

        Scanner number = new Scanner(System.in);

        float fm1 = number.nextFloat();
        float fm2 = number.nextFloat();

        float fm = fm1 * fm2;

        System.out.println("multiply of two numbers" + fm);

    }

    public void characvalidation() {

        Scanner number = new Scanner(System.in);

        String character = number.toString();

        if(character=="a" || character=="e"|| character=="i"|| character=="o"){
            System.out.println("Vowels"+character);}

            else {
            System.out.println("Consonant"+character);}


    }

    public static void main (String args[]){
        mathactions ops =new mathactions();
        ops.add();
        ops.mutp();
        ops.characvalidation();

    }



}
