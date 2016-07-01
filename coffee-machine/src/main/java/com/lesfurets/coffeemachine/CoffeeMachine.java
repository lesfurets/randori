package com.lesfurets.coffeemachine;

import com.lesfurets.coffeemachine.model.EDrink;

class CoffeeMachine {

    static String makeCoffee(EDrink drink, int sugar) {
        return drink.getCode() + ":" + (sugar > 0 ? sugar + ":0" : ":");
    }

}
