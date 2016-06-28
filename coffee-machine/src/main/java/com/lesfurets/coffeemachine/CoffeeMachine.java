package com.lesfurets.coffeemachine;

import com.lesfurets.coffeemachine.model.EDrink;

class CoffeeMachine {

    static String makeCoffee(EDrink drink, int nbSugar) {
        String output = drink.getCode();
        output += ":";
        output += nbSugar >= 1 ? nbSugar : "";
        output += ":";
        output += nbSugar >= 1 ? "0" : "";
        return output;
    }
}
