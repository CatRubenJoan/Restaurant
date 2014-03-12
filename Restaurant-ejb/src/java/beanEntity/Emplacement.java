package beanEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Emplacement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private int capacite;
    private String codeIHM;
    @OneToMany(mappedBy = "table")
    private Collection<Commande> commandes;
    @ManyToOne
    private Serveur serveur;

    public Emplacement() {
        commandes = new ArrayList<>();
    }

    public Emplacement(int capacite, String codeIHM) {
        this.capacite = capacite;
        this.codeIHM = codeIHM;
    }

    public Emplacement(int numero, int capacite, String codeIHM) {
        this.numero = numero;
        this.capacite = capacite;
        this.codeIHM = codeIHM;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getCodeIHM() {
        return codeIHM;
    }

    public void setCodeIHM(String codeIHM) {
        this.codeIHM = codeIHM;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }

    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }
    
    @Override
    public String toString() {
        return "Table n°" + numero;
    }
}
