package com.lesfurets.coffeemachine;

import static com.lesfurets.coffeemachine.CoffeeMachine.makeCoffee;
import static com.lesfurets.coffeemachine.model.EDrink.CHOCOLATE;
import static com.lesfurets.coffeemachine.model.EDrink.COFFEE;
import static com.lesfurets.coffeemachine.model.EDrink.TEA;
import static org.assertj.core.api.StrictAssertions.assertThat;

import org.junit.Test;

public class CoffeeMachineTest {
    @Test
    public void tea_with_1_sugar_should_return_T_1_0() {
        assertThat(makeCoffee(TEA, 1)).isEqualTo("T:1:0");
    }

    @Test
    public void chocolate_with_no_sugar_should_return_H_0() {
        assertThat(makeCoffee(CHOCOLATE, 0)).isEqualTo("H::");
    }

    @Test
    public void coffee_with_2_sugar_should_return_C_2_0() {
        assertThat(makeCoffee(COFFEE, 2)).isEqualTo("C:2:0");
    }
}
