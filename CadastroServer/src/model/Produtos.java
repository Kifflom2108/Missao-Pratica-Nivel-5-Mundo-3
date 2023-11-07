/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author felip
 */
@Entity
@Table(name = "Produtos")
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findByIdProdutos", query = "SELECT p FROM Produtos p WHERE p.idProdutos = :idProdutos"),
    @NamedQuery(name = "Produtos.findByNomeProdutos", query = "SELECT p FROM Produtos p WHERE p.nomeProdutos = :nomeProdutos"),
    @NamedQuery(name = "Produtos.findByQuantidadeProdutos", query = "SELECT p FROM Produtos p WHERE p.quantidadeProdutos = :quantidadeProdutos"),
    @NamedQuery(name = "Produtos.findByPre\u00e7oProdutos", query = "SELECT p FROM Produtos p WHERE p.pre\u00e7oProdutos = :pre\u00e7oProdutos")})
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProdutos")
    private Integer idProdutos;
    @Column(name = "NomeProdutos")
    private String nomeProdutos;
    @Column(name = "QuantidadeProdutos")
    private Integer quantidadeProdutos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Pre\u00e7oProdutos")
    private BigDecimal preçoProdutos;
    @OneToMany(mappedBy = "produtoID")
    private Collection<Movimentos> movimentosCollection;

    public Produtos() {
    }

    public Produtos(Integer idProdutos) {
        this.idProdutos = idProdutos;
    }

    public Integer getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(Integer idProdutos) {
        this.idProdutos = idProdutos;
    }

    public String getNomeProdutos() {
        return nomeProdutos;
    }

    public void setNomeProdutos(String nomeProdutos) {
        this.nomeProdutos = nomeProdutos;
    }

    public Integer getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(Integer quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public BigDecimal getPreçoProdutos() {
        return preçoProdutos;
    }

    public void setPreçoProdutos(BigDecimal preçoProdutos) {
        this.preçoProdutos = preçoProdutos;
    }

    public Collection<Movimentos> getMovimentosCollection() {
        return movimentosCollection;
    }

    public void setMovimentosCollection(Collection<Movimentos> movimentosCollection) {
        this.movimentosCollection = movimentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdutos != null ? idProdutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.idProdutos == null && other.idProdutos != null) || (this.idProdutos != null && !this.idProdutos.equals(other.idProdutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produtos[ idProdutos=" + idProdutos + " ]";
    }
    
}
