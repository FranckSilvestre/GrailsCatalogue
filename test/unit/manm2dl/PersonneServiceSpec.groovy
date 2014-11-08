package manm2dl

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PersonneService)
@Mock(Personne)
class PersonneServiceSpec extends Specification {

    PersonneService personneService

    def setup() {
        personneService = new PersonneService()
        // Workaround for GRAILS-10538
        personneService.transactionManager = Mock(PlatformTransactionManager) { getTransaction(_) >> Mock(TransactionStatus) }

    }

    def cleanup() {
    }

    void "test creation of a personne"() {

        given:"data from a user"
        def fn = 'John'
        def ln = 'Doo'
        def ad = 'somewhere'

        when: "the creation of a personne is triggered"
        def personne = personneService.createPersonne(fn, ln, ad)

        then: "the created personne has its properties set"
        personne.firstName == fn
        personne.lastName == ln
        personne.address == ad
        personne.id

    }
}
