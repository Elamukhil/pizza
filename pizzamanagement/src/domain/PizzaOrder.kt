package domain

import java.time.LocalDateTime

class PizzaOrder(
        val time : LocalDateTime,
        val address : String,
        val pizzalist : List<Pizza> = listOf<Pizza>(),
        val cost : Double,
        val couponused : String,
        val discount : Double,
        val tax : Double
)