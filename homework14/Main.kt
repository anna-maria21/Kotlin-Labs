package homework14

fun main() {
    // створення екземпляру класу WorkWithFile, дані для обробки містяться в файлі test.txt
    val fileObj = WorkWithFile("test.txt")
    // читання даних з файлу
    fileObj.fileContent = fileObj.readFileContent()
    println(fileObj)

    // виконання завдання №1 - заміна однієї підстроки іншою
    fileObj.writeNewFileContent("before", "after")

    // виконання завдання №2 - введення назви .bak файлу з клавіатури, копіювання контенту в новий файл
    print("\nВведіть назву .bak файлу: ")
    var myBakFileName: String?
    do {
        myBakFileName = readLine()
    } while (myBakFileName.isNullOrEmpty())
    fileObj.copyContentToBakFile(myBakFileName)

    // виконання завдання №3 - розділення контенту файлу по строкам
    fileObj.splitContentIntoTwoFiles()

    // виконання завдання №4 - шифрування файлу
    fileObj.encryptFile()

    // виконання завдання №5 - розшифровування файлу
    fileObj.decryptFile()
}
