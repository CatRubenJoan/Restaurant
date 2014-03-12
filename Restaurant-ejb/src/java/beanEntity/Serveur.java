package beanEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Serveur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String codeIHM;
    @Column(nullable = false)
    private String nom;    
    @OneToMany(mappedBy = "serveur")
    private Collection<Emplacement> tables;
    
    public Serveur() {
        tables = new ArrayList<>();
    }

    public Serveur(String codeIHM, String nom) {
        this();
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

    public Collection<Emplacement> getTables() {
        return tables;
    }

    public void setTables(Collection<Emplacement> tables) {
        for (Emplacement table : tables) {
            this.tables.add(table);
        }
//        this.tables = tables;
    }

    @Override
    public String toString() {
        return nom + " (" + codeIHM + ")";
    }
    
}
