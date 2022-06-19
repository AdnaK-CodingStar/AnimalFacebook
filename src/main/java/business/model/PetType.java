/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AdnaK
 */
@Entity
@Table(name = "pet_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PetType.findAll", query = "SELECT p FROM PetType p"),
    @NamedQuery(name = "PetType.findById", query = "SELECT p FROM PetType p WHERE p.id = :id"),
    @NamedQuery(name = "PetType.findByPetTypeName", query = "SELECT p FROM PetType p WHERE p.petTypeName = :petTypeName")})
public class PetType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "pet_type_name")
    private String petTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "petTypeId")
    private List<Pet> petList;

    public PetType() {
    }

    public PetType(Integer id) {
        this.id = id;
    }

    public PetType(Integer id, String petTypeName) {
        this.id = id;
        this.petTypeName = petTypeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPetTypeName() {
        return petTypeName;
    }

    public void setPetTypeName(String petTypeName) {
        this.petTypeName = petTypeName;
    }

    @XmlTransient
    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
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
        if (!(object instanceof PetType)) {
            return false;
        }
        PetType other = (PetType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PetType[ id=" + id + " ]";
    }
    
}
