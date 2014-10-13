package manm2dl

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Produit)
@Mock([Produit,Option])
class ProduitSpec extends Specification {

    Produit produit

    def setup() {
        produit = new Produit()
    }

    def cleanup() {
    }

    @Unroll
    void "test des contraintes sur produit valide (nom : #aName)"() {

        given: "un produit valide"
        produit.name = aName
        produit.description = aDescription
        produit.price = aPrice

        when: "on déclenche la validation du produit"
        def res = produit.validate()

        then: "le produit n'a pas d'erreur de validation"
        res == true
        !produit.hasErrors()

        where:
        aName  | aDescription       | aPrice
        "toto" | null               | 0.5
        "titi" | ""                 | 12
        "tutu" | "un desc non vide" | 3.8

    }

    @Unroll
    void "test des contraintes sur produit non valide (nom : #aDescription)"() {

        given: "un produit non valide"
        produit.name = aName
        produit.description = aDescription
        produit.price = aPrice

        when: "on déclenche la validation du produit"
        def res = produit.validate()

        then: "le produit a des erreurs de validation"
        res == false
        produit.hasErrors()

        where:
        aName  | aDescription | aPrice
        null   | "prod 1"      | 0.5
        ""     | "prod 2"      | 12
        "tutu" | "prod 3"      | null
        "tutu" | "prod 4"      | -3
    }

    void "test calcule du prix total d'un produit sans option" () {

        given: "un produit sans option"
        produit.name = "p1"
        produit.price = 12.5

        expect: "le calcule du prix total retourne le prix du produit"
        produit.calculateTotalPrice() == produit.price

    }
    void "test calcule du prix total d'un produit avec option" () {
        given: "un produit avec au moins une option"
        produit.name = "p1"
        produit.price = 12.5
        Option option = Mock(Option) {
            getPrice() >> 5
        }
        produit.addToOptions(option)

        expect: "le calcul du prix total retourne le prix du produit + ceux des options"
        produit.calculateTotalPrice() == produit.price + option.price
    }

}
