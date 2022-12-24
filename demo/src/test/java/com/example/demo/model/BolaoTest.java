package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class BolaoTest {
    

    @Test
    void shouldReturnABolaoWith6NumbersBetween0And60() {

        // Given...
        var bolao = new Bolao();

        // when
        List<String> bolaoNumbers = bolao.withRandomNumbers();

        // Then
        bolaoNumbers
            .stream() // Make sure that every number is between 1 and 60
            .mapToInt(Integer::valueOf)
            .forEach(number -> assertTrue(number >= 1 && number <= 60));

        assertEquals(6, bolaoNumbers.size());

    }

    @Test
    void aMapOfDesiredBolaosShouldAlwaysHaveAtLeastOneBolao() {

        // Given
        var bolao = new Bolao();
        int desiredBolaos = 3;
        // When
        Map<Integer, List<String>> mapOfBolaos = bolao.genarateMapWithADesiredNumberOfBolaos(desiredBolaos);
        // Then
        boolean notLessThenOneBolao = mapOfBolaos.size() >= 1;
        assertTrue(notLessThenOneBolao);
        
        mapOfBolaos
            .forEach((numberOfBolao, numbers) -> System.out.println(numberOfBolao + "° Bolâo: " + numbers));

    }


}
