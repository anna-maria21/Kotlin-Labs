import kotlin.streams.toList

/**
 * A class that provides some manipulation with strings
 * such as counting a number of words and numbers,
 * deleting any symbols if they are not a letters (or spaces),
 * deleting multiple spaces,
 * deleting all words, which starts with non-capitalize letter.
 *
 * @property myString is a string entered by user
 * @property myStringLength is a length of entered string
 * @property myStringWordArray is an array of words
 * which consists in entered string
 *
 */

class WorkWithString(userInput: String) {
    var myString: String = userInput
    var myStringLength: Int
    var myStringWordArray: List<String>

    /**
     * Fill the object fields after its creation
     */
    init {
        this.myStringLength = userInput.length
        this.myStringWordArray = this.getStringWithSingleSpaces().split(" ")
    }


    /**
     * Override method for printing information about entered string
     * @return Result String with some information about string: the value and length
     */
    override fun toString(): String {
        return "Введений рядок: \"$myString\", його довжина = $myStringLength"
    }

    /**
     * Method that counts amount of numbers in the string
     * A number is any signed or unsigned integer or float written after a comma or period
     * @return an amount of numbers in the string, type - Int
     */
    fun numberCounter(): Int {
        return myStringWordArray.stream()
            .filter { w -> w.matches("[+-]?[0-9]+([.,][0-9]+)?".toRegex()) }
            .count()
            .toInt()
    }

    /**
     * A method that deletes all redundant symbols except letters
     * @return a new string made up of only the letters of the input string
     */
    fun deleteAllSymbols(): String {
        return myString.chars()
            .mapToObj { c -> c.toChar() }
            .filter(Char::isLetter)
            .toList()
            .joinToString("")
    }

    /**
     * A method that composes a string with replaced all multiple spaces with a single space
     * @return A new string with a single space between each word
     */
    fun getStringWithSingleSpaces(): String {
        return myString.replace("( )+".toRegex(), " ")
    }


    /**
     * A method that removes words from a string that do not begin with an uppercase letter
     * @return new string made up of only capitalized words
     */
    fun getCapitalizedWords(): String {
        return myStringWordArray.stream()
            .filter { s -> Character.isUpperCase(s.toCharArray()[0]) }
            .toList()
            .joinToString(" ")
    }


}