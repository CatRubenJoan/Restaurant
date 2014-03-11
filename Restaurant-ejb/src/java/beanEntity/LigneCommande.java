package beanEntity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int qte;
    private float prixHTLC;
    private String commentaire;
    @ManyToOne
    private Commande commande;
    @ManyToOne
    private Produit produit;

    public LigneCommande() {
    }

    public LigneCommande(int qte, String commentaire) {
        this.qte = qte;
        this.commentaire = commentaire;
    }

    public LigneCommande(int qte, float prixHTLC, String commentaire) {
        this.qte = qte;
        this.prixHTLC = prixHTLC;
        this.commentaire = commentaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public float getPrixHTLC() {
        return prixHTLC;
    }

    public void setPrixHTLC(float prixHTLC) {
        this.prixHTLC = prixHTLC;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "beanEntity.LigneCommande[ id=" + id + " ]";
    }
    
}
