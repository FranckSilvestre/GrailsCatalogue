package manm2dl

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(CommandeService)
class CommandeServiceSpec extends Specification {

    CommandeService commandeService

    def setup() {
        commandeService = new CommandeService()
    }

    void "la creation d'une commande valide crée une commande ayant un id et horodatée "() {
        given:"un client et un magasin"
        Personne client = Mock(Personne)
        Magasin magasin = Mock(Magasin)

        when:"une commande est créée"
        Commande commande = commandeService.createNewCommandeForClientInMagasin(client, magasin)

        then:"la commande est horodatée"
        commande.id
        commande.dateCreated
    }

    void "la creation d'une commande  avec un client null ou un magasin null déclenche une exception "() {
        given:"un client et un magasin"
        Personne client = Mock(Personne)
        Magasin magasin = Mock(Magasin)

        when:"une commande est créée sans client"
        commandeService.createNewCommandeForClientInMagasin(null, magasin)

        then:"une exception est lancée"
        thrown(Exception)

        when: "une commande est crée sans magasin"
        commandeService.createNewCommandeForClientInMagasin(client, null)

        then:"une exception est levée"
        thrown(Exception)
    }

    void "l'ajout d'un produit à une commande réduit le stock du magasin"() {

        given: "une commande"
        def magasin = Mock(Magasin)
        def commande = Mock(Commande)
        def produit = Mock(Produit)

        when:"on ajoute n exemplaires d'un produit"
        commandeService.addProduitToCommande(produit, commande, 2)

        then:"on sort 2 exemplaires du produit dans le magasin"
        1 * magasin.takeProduit(produit,2)

        and:"la commande récupère 2 exemplaires du produit"
        1 * commande.addProduit(produit,2)

    }

}
