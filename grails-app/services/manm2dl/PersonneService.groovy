package manm2dl

import grails.transaction.Transactional

@Transactional
class PersonneService {

    /**
     * Create a new personne
     * @param firstname
     * @param lastname
     * @param address
     * @return the created personne with errors if save failed
     */
    Personne createPersonne(String firstname, String lastname, String address) {
        Personne personne = new Personne(
                firstName: firstname,
                lastName: lastname,
                address: address
        )
        personne.save()
        personne
    }
}
