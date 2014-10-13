package manm2dl

class Option {

    String name
    Float price
    String description

    Produit produit

    static belongsTo = [produit:Produit]

    static constraints = {
        name blank: false, unique: true
        price nullable: false, min: 0f
        description nullable: true
    }

    String toString() {
        "$name ($price)"
    }
}
