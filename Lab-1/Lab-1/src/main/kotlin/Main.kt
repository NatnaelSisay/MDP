fun main(args: Array<String>) {
//        QUESTION 3
    val q3 = Question3()
    println(q3.getFirstLas(1234))
//
    var numbers = arrayOf(1, 2, 3, 4);
    println(q3.findOddSums(numbers));
//
    q3.getWeightInPlanets()

//    QUESTION 4
    val book1 = Book("Introduction To Kotlin", "Not Me", 1.00)
    val kindleBook = EBook("Introduction to New thing", "Another One", 1.00, "Kindle")
    book1.read()
    println(book1.title)
}