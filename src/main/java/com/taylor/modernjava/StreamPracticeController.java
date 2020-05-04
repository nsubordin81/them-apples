package com.taylor.modernjava;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

@Controller
public class StreamPracticeController {

    @GetMapping("/apples")
    @ResponseBody
    public List<Apple> getApples(@RequestParam Optional<Integer> weightAbove, @RequestParam Optional<String> color) {
        Long appleSeed = 1l;
       List<Apple> randomApples = RandomAppleList.newRandomApples(appleSeed);
       Predicate<Apple> byWeightIfWeight = weightAbove.map(this::byWeight).orElse((apple) -> true);
       Predicate<Apple> byColorIfColor = color.map(this::byColor).orElse((apple) -> true);
       return randomApples.stream()
               .filter(byWeightIfWeight)
               .filter(byColorIfColor)
                .collect(toList());
    }

    private Predicate<Apple> byWeight(int weight) {
        System.out.println("weight is" + weight);
        return (apple) -> apple.getWeight() > weight;
    }

    private Predicate<Apple> byColor(String color) {
        return (apple) -> apple.getAppleColor().toString().equals(color);
    }

}
