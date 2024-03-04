open class Book {
    private var _title: String = ""
    private var _author: String = ""
    private var _price: Double = 0.0

    var title: String
        get() = _title
        set(value){ _title = value }

    private var author: String
        get() = _author
        set(value) { _author = value }

    private var price: Double
        get() = _price
        set(value){ _price = value}

    constructor(title: String, author: String, price: Double){
        this.title = title
        this.author = author;
        this.price = price;
    }

    open fun read(): Unit{
        println("Reading a book");
    }
}