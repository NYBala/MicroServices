package com.cognizant.cde.learning.micro.service;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import java.util.Random;

public class SimpleService {

    public static final String SECRET_KEY = "tnazingoc";

    public String execute() {
        String encrypted = "Failed Encryption";
        try {
            String clear = generateCard();
            System.out.println("Clear Text: " + clear);
            encrypted = encryptLocal(clear);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decryptLocal(encrypted));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return encrypted;

    }

    private String generateCard() {
        String cardNum = "";
        for (int j = 0; j < new Random().nextInt(3) + 13; j++) {
            cardNum += new Random().nextInt(10);
        }
        return cardNum;
    }

    private String encryptLocal(String clear){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(SECRET_KEY);
        encryptor.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        encryptor.setIvGenerator(new RandomIvGenerator());
        String encrypted = encryptor.encrypt(clear);
        return encrypted;
    }


    private String decryptLocal(String encrypted) {
        String decrypted = "Decryption Failed";
        try {
            StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
            encryptor.setPassword(SECRET_KEY);
            encryptor.setAlgorithm("PBEWithHMACSHA512AndAES_256");
            encryptor.setIvGenerator(new RandomIvGenerator());
            decrypted = encryptor.decrypt(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return decrypted;
    }
}
