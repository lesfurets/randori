package com.lesfurets.coffeemachine;

import com.lesfurets.coffeemachine.model.EDrink;

class CoffeeMachine {

    static String makeCoffee(EDrink drink, int nbSugar) {
        String output = drink.getCode();
        output += ":";
        String sugar = nbSugar == 0 ? "" : String.valueOf(nbSugar);
        output += sugar;
        output += ":";
        String stick = nbSugar == 0 ? "" : "0";
        output += stick;
        return output;
    }
}
