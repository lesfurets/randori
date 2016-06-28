package com.lesfurets.coffeemachine;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.lesfurets.coffeemachine.model.EDrink;

public class CoffeeMachineTest {
    @Test
    public void tea_with_1_sugar_should_return_T_1_0() throws Exception {
        Assertions.assertThat(CoffeeMachine.makeCoffee(EDrink.TEA, 1)).isEqualTo("T:1:0");
    }

    @Test
    public void chocolate_with_no_sugar_should_return_H_0() throws Exception {
        Assertions.assertThat(CoffeeMachine.makeCoffee(EDrink.CHOCOLATE, 0)).isEqualTo("H::");
    }

    @Test
    public void coffee_with_2_sugar_should_return_C_2_0() throws Exception {
        Assertions.assertThat(CoffeeMachine.makeCoffee(EDrink.COFFEE, 2)).isEqualTo("C:2:0");
    }
}
