package domain
object TaxAndCouponCalculator {
    private var count = 0
    fun calculatePizzaCost(size: Size, base: Base, toppingslist: MutableList<Toppings>, cheese: Boolean): Double {
        var totalOrderCost = 0.0
        totalOrderCost += when (size) {
            Size.LARGE -> 150.0
            Size.MEDIUM -> 120.0
            Size.SMALL -> 100.0
        }
        totalOrderCost += when (base) {
            Base.HAND_TOSSED -> 0.0
            Base.WHEAT_THIN_CRUST -> 20.0
            Base.CHEESE_BURST -> 40.0
        }
        for (topping in toppingslist) {
            totalOrderCost += when (topping) {
                Toppings.BBQ_CHICKEN -> 50.0
                Toppings.SPICY_CHICKEN -> 60.0
                Toppings.TIKKA_CHICKEN -> 40.0
                Toppings.OLIVES -> 30.0
                Toppings.ONIONS -> 20.0
                Toppings.BABY_CORN -> 40.0
            }
        }
        if (cheese)
            totalOrderCost += 20.0
        return totalOrderCost
    }

    fun calculateTaxandCoupon(pizzas: MutableList<Pizza>): Receipt {

        var totalbill = 0.0
        var couponused = "Coupon not used"
        var discount = 0.0
        for (pizza in pizzas) {
            totalbill += pizza.cost
            if (pizza.size == Size.valueOf("MEDIUM"))
                count += 1

        }
        if (count % 2 == 0 && count != 0) {
            couponused = "Todays offer applied : Medium pizza each of Rs.100"
            totalbill = totalbill - (count * 20.0)
            discount = 40.0
        } else {
            println("Do you want to apply coupon")
            val coupon: String = readLine()!!
            if (coupon == "Yes") {
                println(
                    "10% off upto Rs.30 on Rs 200 and above, if the code “ZOHO” used.\n" +
                            "20% off upto Rs. 100 on Rs. 400 and above, if the code “JUMBO” used"
                )

                println("Enter the couponcode")
                val couponcode: String = readLine()!!
                if (couponcode == "ZOHO" && totalbill >= 200) {
                    val zohocoupon: Double = (10.0 / 100) * totalbill
                    if (zohocoupon >= 30.0) {
                        totalbill -= 30
                        discount = 30.0
                    } else {
                        totalbill -= zohocoupon
                        discount = zohocoupon
                    }
                    couponused = "ZOHO COUPON"

                } else if (couponcode == "JUMBO" && totalbill >= 400) {
                    val jumbocoupon: Double = (20.0 / 100) * totalbill
                    if (jumbocoupon >= 100.0) {
                        totalbill -= 100
                        discount = 100.0
                    } else {
                        totalbill -= jumbocoupon
                        discount = jumbocoupon
                    }
                    couponused = "JUMBO COUPON"
                } else {
                    println("Coupon not valid")
                }
            } else {
                couponused = "Coupon not used"
            }

        }
        val tax: Double = (12.0 / 100) * totalbill
        totalbill += tax
        return Receipt(totalbill, couponused, tax, discount)
    }
}