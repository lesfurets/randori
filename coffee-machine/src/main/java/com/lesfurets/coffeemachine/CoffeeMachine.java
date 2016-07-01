package com.lesfurets.coffeemachine;

import com.lesfurets.coffeemachine.model.EDrink;

class CoffeeMachine {

    private static final String SEPARATOR = ":";
    private static final String STICK = ":0";

    static String makeCoffee(EDrink drink, int sugar) {
        return drink.getCode() + SEPARATOR + (sugar > 0 ? sugar + STICK : SEPARATOR);
    }

}
