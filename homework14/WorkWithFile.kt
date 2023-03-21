package homework14

import java.io.File
import java.io.FileWriter
import java.lang.StringBuilder

/**
 * Work with file class provides some methods for working with file - reading, writing,
 * creating new files, replacing a part of content
 *
 * @property fileName is the name of the file with the contents of which the class works
 * @property fileContent is the string representation of the content of current file
 */
class WorkWithFile(var fileName: String) {
    var fileContent: String = ""

    /**
     * Reads file content
     *
     * @param fileName an optional parameter representing the name of the file from which the content will be read
     * @return string representation of the current file content
     */
    fun readFileContent(fileName: String = this.fileName):String {
        return File(fileName).readText(Charsets.UTF_8)
    }

    private fun writeToFile(name:String = fileName, content:String = fileContent) {
        File(name).writeText(content)
    }

    /**
     * Replaces the substring of the file with the given string by using a private method and overwrites the current file
     *
     * @param oldChar is the substring being replaced
     * @param newChar is the substring to replace with
     */
    fun writeNewFileContent(oldChar: String, newChar: String) {
        fileContent = replaceSomeString(oldChar, newChar)
        writeToFile()
    }

    private fun replaceSomeString(oldChar: String, newChar: String):String {
        return fileContent.replace(oldChar, newChar)
    }

    /**
     * Creates a new .bak file with given name and copies content to it
     *
     * @param myBakFileName is the name of the .bak file to be created
     */
    fun copyContentToBakFile(myBakFileName: String) {
        writeToFile("$myBakFileName.bak")
    }

    /**
     * Creates two new files, writes even lines of the current file to one of them, and odd lines to the other
     *
     */
    fun splitContentIntoTwoFiles() {
        val fileLinesList = fileContent.split("\n")

        File("odd-lines.txt").delete()
        File("even-lines.txt").delete()

        fileLinesList.withIndex().forEach { (index, str) ->
            if (index % 2 != 0) {
                FileWriter("odd-lines.txt", true).use { it.write(str) }
            } else {
                FileWriter("even-lines.txt", true).use { it.write(str) }
            }
        }
    }

    /**
     * Encrypts file using bitwise left shift by 1, creates a new file and writes encrypted string there
     *
     */
    fun encryptFile() {
        val encryptedContent = StringBuilder()
        for (ch in fileContent.toCharArray()) {
            encryptedContent.append(ch.toInt().shl(1).toChar())
        }
        writeToFile("encrypted-content.txt", encryptedContent.toString())
    }

    /**
     * Decrypts file using bitwise right shift by 1, creates a new file and writes decrypted string there
     *
     */
    fun decryptFile() {
        val decryptedContent = StringBuilder()
        for (ch in readFileContent("encrypted-content.txt").toCharArray()) {
            decryptedContent.append(ch.toInt().shr(1).toChar())
        }
        writeToFile("decrypted-content.txt", decryptedContent.toString())
    }

    /**
     * Override method for printing information about current object
     * @return Result String with some information about file: the name and its content
     */
    override fun toString(): String {
        return "File: '$fileName'\nContent:\n$fileContent"
    }

}