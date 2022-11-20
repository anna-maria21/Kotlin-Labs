fun main() {

    print("Введіть рядок: ")
    val userInput = readLine()
    val myObj = userInput?.let { WorkWithString(it) }

    println(myObj)
    println("\n\tКількість слів: ${myObj!!.myStringWordArray.size - myObj.numberCounter()}")
    println("\tКількість чисел: ${myObj.numberCounter()}")
    println("\tСтрічка без цифр і символів: ${myObj.deleteAllSymbols()}")
    println("\tСтрічка без множинних проміжків: ${myObj.getStringWithSingleSpaces()}")
    println("\tСтрічка без cлів, що починаються з маленької літери: ${myObj.getCapitalizedWords()}")
}

