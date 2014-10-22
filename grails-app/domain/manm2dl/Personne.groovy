package manm2dl

class Personne {

    String lastName
    String firstName
    String address

    static constraints = {
        lastName blank: false
        firstName blank: false
    }
}
