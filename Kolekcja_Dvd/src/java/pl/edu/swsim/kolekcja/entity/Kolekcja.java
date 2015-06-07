/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.swsim.kolekcja.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Damian
 */
@Entity
@Table(name = "kolekcja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kolekcja.findAll", query = "SELECT k FROM Kolekcja k"),
    @NamedQuery(name = "Kolekcja.findById", query = "SELECT k FROM Kolekcja k WHERE k.id = :id"),
    @NamedQuery(name = "Kolekcja.findByTytul", query = "SELECT k FROM Kolekcja k WHERE k.tytul = :tytul"),
    @NamedQuery(name = "Kolekcja.findByGatunek", query = "SELECT k FROM Kolekcja k WHERE k.gatunek = :gatunek"),
    @NamedQuery(name = "Kolekcja.findByRok", query = "SELECT k FROM Kolekcja k WHERE k.rok = :rok")})
public class Kolekcja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tytul", nullable = false, length = 255)
    private String tytul;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "opis", nullable = false, length = 65535)
    private String opis;
    @Size(max = 150)
    @Column(name = "gatunek", length = 150)
    private String gatunek;
    @Column(name = "rok")
    @Temporal(TemporalType.DATE)
    private Date rok;

    public Kolekcja() {
    }

    public Kolekcja(Integer id) {
        this.id = id;
    }

    public Kolekcja(Integer id, String tytul, String opis) {
        this.id = id;
        this.tytul = tytul;
        this.opis = opis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public Date getRok() {
        return rok;
    }

    public void setRok(Date rok) {
        this.rok = rok;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kolekcja)) {
            return false;
        }
        Kolekcja other = (Kolekcja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.edu.swsim.kolekcja.entity.Kolekcja[ id=" + id + " ]";
    }
    
}
