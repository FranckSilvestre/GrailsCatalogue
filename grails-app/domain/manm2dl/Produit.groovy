package manm2dl

class Produit {

    String name
    String description
    Float price

    static hasMany = [options: Option]

    static constraints = {
        name blank: false
        price min: 0f
        description nullable: true
    }

    /**
     * Calcule le prix total (avec options) du produit
     * @return
     */
    Float calculateTotalPrice() {
        def res = price
        options.each {
            res += it.price
        }
        res
    }

    String toString() {
        "$name ($price)"
    }

}