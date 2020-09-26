
package hr.edunova.horvat.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 author Josip
 */

@Entity
@Table(name = "vozac")
public class Vozac extends Osoba{
  
    private Boolean verificiran;
    private Date datumRodjenja;
    
      @OneToMany(mappedBy = "vozac")
    private List<ZaduzenoVozilo> zaduzenaVozila = new ArrayList<>();

    public List<ZaduzenoVozilo> getZaduzenaVozila() {
        return zaduzenaVozila;
    }

    public void setZaduzenaVozila(List<ZaduzenoVozilo> zaduzenaVozila) {
        this.zaduzenaVozila = zaduzenaVozila;
    }
    
    public Boolean getVerificiran() {
        return verificiran;
    }

    public void setVerificiran(Boolean verificiran) {
        this.verificiran = verificiran;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }
}
