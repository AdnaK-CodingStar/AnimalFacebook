/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

import business.model.User;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AdnaK
 */
@Entity
@Table(name = "adoption_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdoptionRequest.findAll", query = "SELECT a FROM AdoptionRequest a"),
    @NamedQuery(name = "AdoptionRequest.findByUserIdRequest", query = "SELECT a FROM AdoptionRequest a WHERE a.adoptionRequestPK.userIdRequest = :userIdRequest"),
    @NamedQuery(name = "AdoptionRequest.findByPetId", query = "SELECT a FROM AdoptionRequest a WHERE a.adoptionRequestPK.petId = :petId"),
    @NamedQuery(name = "AdoptionRequest.findByRequestText", query = "SELECT a FROM AdoptionRequest a WHERE a.requestText = :requestText")})
public class AdoptionRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdoptionRequestPK adoptionRequestPK;
    @Basic(optional = false)
    @Column(name = "request_text")
    private String requestText;
    @JoinColumn(name = "pet_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pet pet;
    @JoinColumn(name = "user_id_request", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public AdoptionRequest() {
    }

    public AdoptionRequest(AdoptionRequestPK adoptionRequestPK) {
        this.adoptionRequestPK = adoptionRequestPK;
    }

    public AdoptionRequest(AdoptionRequestPK adoptionRequestPK, String requestText) {
        this.adoptionRequestPK = adoptionRequestPK;
        this.requestText = requestText;
    }

    public AdoptionRequest(int userIdRequest, int petId) {
        this.adoptionRequestPK = new AdoptionRequestPK(userIdRequest, petId);
    }

    public AdoptionRequestPK getAdoptionRequestPK() {
        return adoptionRequestPK;
    }

    public void setAdoptionRequestPK(AdoptionRequestPK adoptionRequestPK) {
        this.adoptionRequestPK = adoptionRequestPK;
    }

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adoptionRequestPK != null ? adoptionRequestPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdoptionRequest)) {
            return false;
        }
        AdoptionRequest other = (AdoptionRequest) object;
        if ((this.adoptionRequestPK == null && other.adoptionRequestPK != null) || (this.adoptionRequestPK != null && !this.adoptionRequestPK.equals(other.adoptionRequestPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AdoptionRequest[ adoptionRequestPK=" + adoptionRequestPK + " ]";
    }
    
}
