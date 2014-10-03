package manm2dl

class Option {

    String name
    Float price
    String description

    static constraints = {
        name blank: false, unique: true
        price nullable: false
        description nullable: true
    }
}
