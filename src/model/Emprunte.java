package model;

import java.util.Date;

public class Emprunte {
    private int assId;
    private int livId;
    private Date debut;
    private Date fin;

    public Emprunte(int assId, int livId, Date debut, Date fin) {
        this.assId = assId;
        this.livId = livId;
        this.debut = debut;
        this.fin = fin;
    }

    public int getAssId() {
        return assId;
    }

    public void setAssId(int assId) {
        this.assId = assId;
    }

    public int getLivId() {
        return livId;
    }

    public void setLivId(int livId) {
        this.livId = livId;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
}
