package presentation

import data.addNewOrder
import data.getAllOrders
import domain.Pizza
import domain.PizzaOrder
import domain.TaxAndCouponCalculator
import java.time.LocalDateTime
import domain.Base
import domain.Toppings
import domain.Size
fun main(args: Array<String>) {
    println("------------------------------------")
    println("domain.Pizza Order Program!")
    println("------------------------------------")
    while (true) {
        println("Choose from the menu\n1.Order pizza\n2.View previous orders\n3.Quit")
        val input = Integer.valueOf(readLine())
        val pizzatemp: MutableList<Pizza> = mutableListOf<Pizza>()
        if (input == 1) {
            println("Enter the total pizzas you would like to order: ")
            val totalPizzas = Integer.valueOf(readLine())
            println("Enter your address")
            val address = readLine()!!
            val currenttime = LocalDateTime.now()
            for (i in 1..totalPizzas) {

                println("Enter the presentation.size of the pizza \nLarge: Rs.150 \nMedium: Rs.120 \nSmall: Rs.100")
                val pizzasize: String = readLine()!!
                println(
                    "Enter the presentation.base of the pizza\n" +
                            "Hand_tossed: + 0\n" +
                            "Wheat_thin_crust: + Rs. 20\n" +
                            "Cheese_burst: + Rs. 40 "
                )

                val pizzaBase: String = readLine()!!

                println(
                    "Enter the presentation.toppings separated by comma: \nAdd Toppings (Non-veg):\n" +
                            "Bbq_chicken : + Rs. 50\n" +
                            "Spicy_chicken: + Rs.60\n" +
                            "Tikka_chicken: + Rs.40\n" +
                            "\n" +
                            "Add Toppings (Veg):\n" +
                            "Olives: + Rs. 30\n" +
                            "Onions: + Rs. 20\n" +
                            "Baby_corn: + Rs. 40"
                )
                val totalToppings = readLine()!!
                val toppingtemp: List<String> = totalToppings.split(",")
                val toppingslist = mutableListOf<Toppings>()
                for (i in toppingtemp)
                    toppingslist.add(Toppings.valueOf(i))

                println("Do you need extra cheese\nYes\nNo")
                val cheese: String = readLine()!!
                val cheeseopt: Boolean = if (cheese=="Yes") true else false
                val cost = TaxAndCouponCalculator.calculatePizzaCost(
                    Size.valueOf(pizzasize),
                    Base.valueOf(pizzaBase),
                    toppingslist,
                    cheeseopt
                )
                val pizza = Pizza(Size.valueOf(pizzasize), Base.valueOf(pizzaBase), toppingslist, cheeseopt, cost)

                pizzatemp.add(pizza)


            }
            val (totalcost, couponused, tax, discount) = TaxAndCouponCalculator.calculateTaxandCoupon(pizzatemp)
            val order = PizzaOrder(currenttime, address, pizzatemp, totalcost, couponused,discount,tax)
            Printer.printOrderSummary(order)
            addNewOrder(order)
        }
        if (input == 2) {
            Printer.printpreviousorder(getAllOrders())
        }
        if (input == 3)
            break

    }
}







