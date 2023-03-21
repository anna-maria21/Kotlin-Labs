package lab12

/**
 * A class that provides some checking operations with entered symbol
 * @property myChar is a string entered by user
 */
class WorkWithChar(userInput: String) {
    var myChar: Char = userInput[0]

    /**
     * Override method for printing information about entered string
     * @return Result String with some information about string: the value and length
     */
    override fun toString(): String {
        return "Введений символ: \"$myChar\""
    }

    /**
     * Is digit method checks if entered symbol is digit i.e. is a value from 0 to 9
     *
     * @return true if the symbol is a digit, in other way - false
     */
    fun isDigit(): Boolean {
        return Character.isDigit(myChar)
    }

    /**
     * Is lower case latin letter method checks if entered symbol is lower case latin letter
     * i.e. is a value from 'a' to 'z'
     *
     * @param myLowerCaseChar an optional parameter representing the character on which the method works
     * by default current object value of myChar field is taken
     * @return true if the symbol is a lower case latin letter, in other way - false
     */
    fun isLowerCaseLatinLetter(myLowerCaseChar: Char = myChar): Boolean {
        val intRepresentationOfMyChar = myLowerCaseChar.code
        return intRepresentationOfMyChar in 97..122
    }

    /**
     * Is latin letter method checks if entered symbol is latin letter
     * i.e. is a value from 'a' to 'z' or from 'A' to 'Z'
     *
     * @return true if the symbol is a latin letter, in other way - false
     */
    fun isLatinLetter(): Boolean {
        return isLowerCaseLatinLetter(myChar.lowercaseChar())
    }

}