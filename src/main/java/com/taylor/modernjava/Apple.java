package com.taylor.modernjava;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Apple {
    @NonNull
    private String id;
    @With
    private AppleColor appleColor;
    @With
    private int weight;
}
