class EBook: Book {
    private var fileType: String;

    constructor(title: String, author: String, price: Double, fileType: String) : super(title, author, price) {
        this.fileType = fileType;
    }

    override fun read(){
        println("Reading from Electronic Device");
    }
}