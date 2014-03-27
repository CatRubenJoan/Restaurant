package beanEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TVA implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private float taux;
    @OneToMany(mappedBy = "vat")
    private Collection<LigneCommande> ligneCommande;

    public TVA() {
        ligneCommande = new ArrayList();
    }

    public TVA(float taux) {
        this.taux = taux;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

    public Collection<LigneCommande> getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(Collection<LigneCommande> ligneCommande) {
        this.ligneCommande = ligneCommande;
    }

    @Override
    public String toString() {
        return "TVA "+taux;
    }
    
}
