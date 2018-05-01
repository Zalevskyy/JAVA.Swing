/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationswing.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lv270669zia
 */
//@Entity
//@Table(name = "sagebooks")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Sagebooks.findAll", query = "SELECT s FROM Sagebooks s")
//    , @NamedQuery(name = "Sagebooks.findById", query = "SELECT s FROM Sagebooks s WHERE s.id = :id")
//    , @NamedQuery(name = "Sagebooks.findByIdBook", query = "SELECT s FROM Sagebooks s WHERE s.idBook = :idBook")
//    , @NamedQuery(name = "Sagebooks.findByIdSage", query = "SELECT s FROM Sagebooks s WHERE s.idSage = :idSage")})
public class Sagebooks implements Serializable {

//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "id")
    private Integer id;
//    @Basic(optional = false)
//    @Column(name = "idBook")
    private int idBook;
//    @Basic(optional = false)
//    @Column(name = "idSage")
    private int idSage;

    public Sagebooks() {
    }

    public Sagebooks(Integer idSage, Integer idBook) {
        this.idSage = idSage;
        this.idBook = idBook;
    }

    public Sagebooks(Integer id, int idBook, int idSage) {
        this.id = id;
        this.idBook = idBook;
        this.idSage = idSage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdSage() {
        return idSage;
    }

    public void setIdSage(int idSage) {
        this.idSage = idSage;
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
        if (!(object instanceof Sagebooks)) {
            return false;
        }
        Sagebooks other = (Sagebooks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplicationswing.Sagebooks[ id=" + id + " ]";
    }
    
}
