package com.lesfurets.coffeemachine;

import com.lesfurets.coffeemachine.model.EDrink;

class CoffeeMachine {

    private EDrink drink;

    static String makeCoffee(EDrink drink, int sugar) {
        String output = drink.getCode();
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

    public EDrink getDrink() {
        return drink;
    }

    public void setDrink(EDrink drink) {
        this.drink = drink;
    }
}
