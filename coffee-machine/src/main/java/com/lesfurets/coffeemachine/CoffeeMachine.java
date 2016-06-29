package com.lesfurets.coffeemachine;

import com.lesfurets.coffeemachine.model.EDrink;

class CoffeeMachine {

    static String makeCoffee(EDrink drink, int nbSugar) {
        String sugar = nbSugar == 0 ? "" : String.valueOf(nbSugar);
        String stick = nbSugar == 0 ? "" : "0";
        return drink.getCode() + ":" + sugar + ":" + stick;
    }
}
