package com.lesfurets.coffeemachine;

import com.lesfurets.coffeemachine.model.EDrink;

class CoffeeMachine {

    static String makeCoffee(EDrink drink, int nbSugar) {
        String output = drink.getCode();
        output += ":";
        if (nbSugar >= 1) {
            output += nbSugar;
        }
        output += ":";
        if (nbSugar >= 1) {
            output += "0";
        }
        return output;
    }
}
