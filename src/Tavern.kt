fun main() {
    /* Safe call operator ?. used before calling capitalize to make sure readline() doesn't return a null
    if a null is returned, capitalize() is skipped */
//   var beverage = readLine()?.capitalize()

    /* Safe call used with let function. This allows you to declare variable(s) how you want.
    * In this case if the value returned was not "", you can then capitalize. If it was blank or "", a
    * fallback value is used. Because of only one parameter, it keyword can be used.
    * In this case it is a String returned by readline(), if it's not null. */
    /*var beverage = readLine()?.let {
        if(it.isNotBlank()){
            it.capitalize()
        } else {
            "Buttered Ale"
        }
    }*/

    /* non-null assertion operator !!. (double-bang)
    * This tells the compiler to run the code, even if there is a null and a
    * null pointer exception can be thrown. The double-bang will call on capitalize() whether the
    * value returned from readline() is a null or not.*/
    //var beverage = readLine()!!.capitalize()

    /* Third option for checking nulls...use if else branch*/
    var beverage = readLine()
    if(beverage != null){
        beverage = beverage.capitalize()
    } else {
        println("I can't do that without crashing - beverage was null")
    }

    /* null coalescing operator ?: If what's on the left is null then do what is on the right
    * String shown here for beverageServed for clarity because whichever side of the operator is used,
    * it will be a non-nullable String, unlike with beverage. String not required of course because of type inference*/
    val beverageServed: String = beverage ?: "Buttered Ale"
    println(beverageServed)

    //beverage = null
    //println(beverage)
}