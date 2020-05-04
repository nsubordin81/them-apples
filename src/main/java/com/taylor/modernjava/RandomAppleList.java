package com.taylor.modernjava;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomAppleList {
    private List<Apple> randomAppleList;

    private RandomAppleList() throws IllegalAccessException {
        throw new IllegalAccessException("RandomAppleList cannot be instantiated");
    }

    private static List<Apple> makeRandomAppleList(Random rng) {
       return IntStream.range(0, 9).mapToObj(i -> makeRandomApple(rng)).collect(toList());
    }

    private static Apple makeRandomApple(Random rng) {
        Apple randomApple = new Apple("apple" + rng.nextInt());
        return randomApple.withAppleColor(AppleColor.values()[rng.nextInt(3)])
                .withWeight(rng.nextInt(10));
    }

    public static List<Apple> newRandomApples() {
        return newRandomApples(1L);
    }

    public static List<Apple> newRandomApples(Long providedSeed) {
        Random rng = new Random(providedSeed);
        return makeRandomAppleList(rng);
    }
}
