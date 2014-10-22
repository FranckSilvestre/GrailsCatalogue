package manm2dl

class ProduitInCommande {

    Produit produit
    Commande commande
    Integer nbProduits

    static constraints = {
        nbProduits min: 1
    }
}
