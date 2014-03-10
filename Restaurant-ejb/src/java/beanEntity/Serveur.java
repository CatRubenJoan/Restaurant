package beanEntity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Serveur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String codeIHM;
    @Column(nullable = false)
    private String nom;    

    public Serveur() {
    }

    public Serveur(String codeIHM, String nom) {
        this.codeIHM = codeIHM;
        this.nom = nom;
    }

    public String getCodeIHM() {
        return codeIHM;
    }

    public void setCodeIHM(String codeIHM) {
        this.codeIHM = codeIHM;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom + " (" + codeIHM + ")";
    }
    
}
