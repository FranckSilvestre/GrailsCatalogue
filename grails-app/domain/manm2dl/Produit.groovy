package manm2dl

class Produit {

    String name
    String description
    Float price

    static hasMany = [options:Option]

    static constraints = {
        description nullable: true
        name blank: false
        price min: 0f
    }

}