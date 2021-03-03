package presentation

import domain.PizzaOrder

object Printer {
    fun printOrderSummary(pizza: PizzaOrder) {
        for (pizza in pizza.pizzalist) {
            if (pizza.cheese)
                println("Ordered a " + pizza.size + " pizza[" + pizza.base + "] with " + pizza.toppings + " with extra cheese [Rs." + pizza.cost + "]")
            else {
                println("Ordered a " + pizza.size + " pizza with " + pizza.toppings + "[Rs." + pizza.cost + "]")
            }
        }
        println("Time ${pizza.time}")
        println(pizza.couponused)
        println("Discount : ${pizza.discount}")
        println("Tax 12% =${pizza.tax}")
        println("Total Bill : ${pizza.cost}")
    }

    fun printpreviousorder(pizzas: List<PizzaOrder>) {
        var count = 1
        for (pizza in pizzas) {
            println("Order #$count :")
            printOrderSummary(pizza)
            count += 1
        }
    }
}