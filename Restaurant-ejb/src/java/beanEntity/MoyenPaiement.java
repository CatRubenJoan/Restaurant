package beanEntity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MoyenPaiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String codePaiement;
    private String typePaiement;

    public MoyenPaiement() {
    }

    public MoyenPaiement(String codePaiement, String typePaiement) {
        this.codePaiement = codePaiement;
        this.typePaiement = typePaiement;
    }

    
       public String getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }
       
    
    public String getCodePaiement() {
        return codePaiement;
    }

    public void setCodePaiement(String codePaiement) {
        this.codePaiement = codePaiement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codePaiement != null ? codePaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoyenPaiement)) {
            return false;
        }
        MoyenPaiement other = (MoyenPaiement) object;
        if ((this.codePaiement == null && other.codePaiement != null) || (this.codePaiement != null && !this.codePaiement.equals(other.codePaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codePaiement: " + codePaiement;
    }


}
