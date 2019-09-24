import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
}

private fun performPurchase(price: Double){
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)

    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    require(remainingBalance >= 0) { "Not enough funds" }
    //when printing to the console, remainingBalance is formatted to two decimals 4.19
    //however, remainingBalance still has the floating point value
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance(){
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value.toLowerCase()) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

private fun performPour(name: String, numPints: Int){
    var dragonsBreathCask = 5.0 //gallons
    println("The Tavern Master pours $numPints pint(s) of $name")
    var pintsLeft = (dragonsBreathCask - (numPints * .125)) / .125
    println("${pintsLeft.toInt()} pints left of $name.")
}

private fun placeOrder(menuData: String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    try {
        performPurchase(price.toDouble())
        val message = "Madrigal buys a $name ($type) for $price"
        println(message)
        performPour(name, 1)

        val phrase = if (name == "Dragon's Breath") {
            "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name")}"
        } else {
            "Madrigal says: Thanks for the $name"
        }
        println(phrase)
    } catch (e: IllegalArgumentException) {
        println("Madrigal does not have enough funds for this purchase.")
    }
}

