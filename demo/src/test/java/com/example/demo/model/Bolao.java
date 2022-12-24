package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bolao {

    private List<String> bolaoNumbers;
    private Map<Integer, List<String>> mapOfBolaos;

    public List<String> withRandomNumbers() {

        bolaoNumbers = new ArrayList<>();

        for (int index = 0; index < 6; index++) {
            bolaoNumbers.add(randomNumberBetween1And60());
        }

        return bolaoNumbers;
    }

    public Map<Integer, List<String>> genarateMapWithADesiredNumberOfBolaos(int numberOfDesiredBolaos) {
        var bolao = new Bolao();
        mapOfBolaos = new HashMap<>();

        for (int i = 0; i < numberOfDesiredBolaos; i++) {

            List<String> numbersOfBolao = bolao.withRandomNumbers();
            int numberOfCurrentBolao = i+1;

            mapOfBolaos.put(numberOfCurrentBolao, numbersOfBolao);
        
        }

        return mapOfBolaos;

    }

    public void printBolaoFromAMapOfBolao(int numberOfBolao) {
        System.out.println(numberOfBolao + "° Bolão: " + this.mapOfBolaos.get(numberOfBolao));
    }

    private String randomNumberBetween1And60()  {

        int randomNumber = 0;

        do { // assuring that the number is never gonna be equal to 0
            randomNumber = (int) Math.floor(Math.random() * 60);
        } while (randomNumber <= 1);

        String numberToBeFormated = String.valueOf(randomNumber);
        boolean mustPadWithZero = numberToBeFormated.length() == 1;

        return mustPadWithZero ? "0" + numberToBeFormated : numberToBeFormated;
        
    }

}
