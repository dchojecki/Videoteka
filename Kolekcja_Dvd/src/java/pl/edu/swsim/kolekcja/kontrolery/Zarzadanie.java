/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.swsim.kolekcja.kontrolery;

import java.util.List;
import javafx.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import pl.edu.swsim.kolekcja.config.DBManager;
import pl.edu.swsim.kolekcja.entity.Kolekcja;

public class Zarzadanie {

    private Kolekcja kolekcja = new Kolekcja();

    public Zarzadanie() {
    }

    public Kolekcja getKolekcja() {
        return kolekcja;
    }

    public void setKoleckcja(Kolekcja Kolekcja) {
        this.kolekcja = kolekcja;
    }

    public String dodaj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        kolekcja.setId(null);
        em.persist(kolekcja);
        em.getTransaction().commit();
        this.dodajInformacje("Dodano płytę!");
        em.close();
        this.kolekcja = new Kolekcja();
        return null;
    }

    public List<Kolekcja> getLista() {
        EntityManager em = DBManager.getManager().createEntityManager();
        List list = em.createNamedQuery("Kolekcja.findAll").getResultList();
        em.close();
        return list;
    }

    public void DvdListener(ActionEvent ae) {
        String ids = FacesContext.getCurrentInstance().getExternalContext().
                getRequestParameterMap().get("kolekcjaID");
        int id = Integer.parseInt(ids);
        this.kolekcja.setId(id);
    }

    public String zaladujDoEdycji() {
        EntityManager em = DBManager.getManager().createEntityManager();
        this.kolekcja = em.find(Kolekcja.class, kolekcja.getId());
        em.close();
        return "/edytujkolekcje.xhtml";
    }

    public String usun() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        this.kolekcja = em.find(Kolekcja.class, kolekcja.getId());
        em.remove(this.kolekcja);
        this.kolekcja = new Kolekcja();
        em.getTransaction().commit();
        em.close();
        this.dodajInformacje("Usunieto płytę");
        return null;
    }

    public String edytuj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        em.merge(kolekcja);
        em.getTransaction().commit();
        em.close();
        this.dodajInformacje("Zmieniono dane płyty!");
        this.kolekcja = new Kolekcja();
        return "/pokazprzychodnie.xhtml";
    }

    public void dodajInformacje(String s) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
    }
}
