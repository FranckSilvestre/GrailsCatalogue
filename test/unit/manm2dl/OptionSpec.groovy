package manm2dl

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Option)
class OptionSpec extends Specification {

    Option option

    def setup() {
        option = new Option()
    }

    def cleanup() {
    }

    void "test sur les contraintes d'une option valide"() {
        given: "une option"
        option.name = aName
        option.price = aPrice
        option.description = aDescription

        when: "l'option est validée"
        def valid = option.validate()

        then: "les vérifications de contraintes sont appliquées correctement"
        valid == etatAttendu

        where:
        aName  | aPrice | aDescription | etatAttendu
        ""     | 12     | "une desc"   | false
        null   | 12     | "une desc"   | false
        "good" | 12.5   | null         | true
        "opt"  | null   | "a desc"     | false


    }
}
