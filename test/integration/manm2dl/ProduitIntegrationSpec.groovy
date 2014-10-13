package manm2dl



import spock.lang.*

/**
 *
 */
class ProduitIntegrationSpec extends Specification {

    Produit produit
    Option option

    void "test de la suppression en cascade"() {

        given: "un produit avec au moins une option"
        produit = new Produit(name: "p1",price: 12.5)
        option = new Option(name: "o1", price: 5)
        produit.addToOptions(option)
        produit.save(failOnError: true, flush: true)

        when:"le produit est supprimé"
        produit.delete(flush: true)

        then:"le produit est supprimé de la base"
        Produit.get(produit.id) == null

        and:"les options sont aussi supprimées"
        Option.get(option.id) == null
    }
}
