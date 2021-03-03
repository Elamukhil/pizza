package domain
class Pizza(val size: Size, val base: Base, val toppings: List<Toppings> = listOf(), val cheese:Boolean, val cost:Double)