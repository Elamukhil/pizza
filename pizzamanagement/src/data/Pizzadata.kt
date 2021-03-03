package data
import domain.PizzaOrder
private val pizzas = mutableListOf<PizzaOrder>()

fun addNewOrder(pizzatemp : PizzaOrder)
{
    pizzas.add(pizzatemp)
}
fun getAllOrders(): MutableList<PizzaOrder> {
    return pizzas
}


