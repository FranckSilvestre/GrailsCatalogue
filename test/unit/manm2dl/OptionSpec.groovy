package manm2dl

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

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

    @Unroll
    void "test des contraintes sur option valide (nom : #aName)"() {

        given: "une option valide"
        option.name = aName
        option.description = aDescription
        option.price = aPrice

        when: "on déclenche la validation de l'option"
        def res = option.validate()

        then: "l'option n'a pas d'erreur de validation"
        res == true
        !option.hasErrors()

        where:
        aName  | aDescription       | aPrice
        "toto" | null               | 0.5
        "titi" | ""                 | 12
        "tutu" | "un desc non vide" | 3.8

    }

    @Unroll
    void "test des contraintes sur option non valide (nom : #aDescription)"() {

        given: "une option non valide"
        option.name = aName
        option.description = aDescription
        option.price = aPrice

        when: "on déclenche la validation de l'option"
        def res = option.validate()

        then: "l'option a des erreurs de validation"
        res == false
        option.hasErrors()

        where:
        aName  | aDescription | aPrice
        null   | "opt 1"      | 0.5
        ""     | "opt 2"      | 12
        "tutu" | "opt 3"      | null
        "tutu" | "opt 4"      | -3
    }
}
