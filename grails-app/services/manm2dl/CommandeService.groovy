package manm2dl

import grails.transaction.Transactional

@Transactional
class CommandeService {

    /**
     * Crée une commande pour une personne
     * @param client le client
     * @return la commande créée
     */
    Commande createNewCommandeForClientInMagasin(Personne client,Magasin magasin) {
        Commande commande = new Commande(client: client, magasin: magasin)
        commande.dateCreated = new Date()
        commande.save(failOnError: true)
        commande
    }

    /**
     * Ajoute un produit sur une commande en précisant le nombre d'exemplaires
     * @param produit le produit à ajouter
     * @param nbProduits le nombre d'exemplaires
     * @return la commande modifiée
     */
    Commande addProduitToCommande(Produit produit, Commande commande, Integer nbProduits = 1) {
        commande.magasin.takeProduit(produit,nbProduits)
        commande.addProduit(produit,nbProduits)
    }

}
