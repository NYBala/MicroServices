package com.cognizant.cde.learning.micro.data;

import java.util.Random;

public class CreditCardGenerator {

    public String generateCard() {
        String cardNum = "";
        for (int j = 0; j < new Random().nextInt(3) + 13; j++) {
            cardNum += new Random().nextInt(10);
            System.out.println(cardNum);
        }
        return cardNum;
    }

    public static void main(String[] args){
        System.out.println("Credit card generator...");
        CreditCardGenerator cg = new CreditCardGenerator();
        String cc = cg.generateCard();
        System.out.println("cc: "+ cc);
    }
}
