package manm2dl

class Magasin {

    String name
    String address

    static constraints = {
        name blank: false
        address blank: false
    }
}
