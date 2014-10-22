package manm2dl

class ProduitInMagasin {

    Produit produit
    Magasin magasin
    Integer nbProduits

    static constraints = {
        nbProduits min: 0
    }
}
