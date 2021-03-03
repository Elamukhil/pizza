package data
import domain.PizzaOrder
object PizzaData {
    private val pizzas = mutableListOf<PizzaOrder>()
    fun addNewOrder(pizzatemp: PizzaOrder) {
        pizzas.add(pizzatemp)
    }

    fun getAllOrders(): List<PizzaOrder> {
        return pizzas
    }
}


