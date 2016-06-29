package com.lesfurets.coffeemachine;

import com.lesfurets.coffeemachine.model.EDrink;

class CoffeeMachine {

    static String makeCoffee(EDrink drink, int sugar) {
        String output = "";
        switch (drink) {
            case COFFEE:
                output += EDrink.COFFEE.getCode();
                break;
            case TEA:
                output += EDrink.TEA.getCode();
                break;
            case CHOCOLATE:
                output += EDrink.CHOCOLATE.getCode();
                break;
        }
        output += ":";
        if (sugar >= 1) {
            output += sugar;
        }
        output += ":";
        if (sugar >= 1) {
            output += "0";
        }
        return output;
    }

}
