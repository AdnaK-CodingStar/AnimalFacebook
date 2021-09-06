/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author AdnaK
 */
@Embeddable
public class AdoptionRequestPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "user_id_request")
    private int userIdRequest;
    @Basic(optional = false)
    @Column(name = "pet_id")
    private int petId;

    public AdoptionRequestPK() {
    }

    public AdoptionRequestPK(int userIdRequest, int petId) {
        this.userIdRequest = userIdRequest;
        this.petId = petId;
    }

    public int getUserIdRequest() {
        return userIdRequest;
    }

    public void setUserIdRequest(int userIdRequest) {
        this.userIdRequest = userIdRequest;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userIdRequest;
        hash += (int) petId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdoptionRequestPK)) {
            return false;
        }
        AdoptionRequestPK other = (AdoptionRequestPK) object;
        if (this.userIdRequest != other.userIdRequest) {
            return false;
        }
        if (this.petId != other.petId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AdoptionRequestPK[ userIdRequest=" + userIdRequest + ", petId=" + petId + " ]";
    }
    
}
