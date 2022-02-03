/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.cc.lpoo.cv.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bianca.evangelista
 */
@Entity
@Table (name = "tb_consulta")
public class Consulta implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    @Column(nullable = false)
    private String observacao;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_retorno;
    
    @Column(nullable = false, precision = 2)
    private Float valor;
    
    @ManyToOne    
    @JoinColumn(name = "medico_nome", nullable = true)
    private Medico medico;
    
    @OneToMany(mappedBy = "consulta")
    private List<Receita> receitas;
    
    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda vendas;
    
    public Consulta() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    
    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

   

    /**
     * @return the valor
     */
    public Float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Float valor) {
        this.valor = valor;
    }

    /**
     * @return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * @return the vendas
     */
    public Venda getVendas() {
        return vendas;
    }

    /**
     * @param vendas the vendas to set
     */
    public void setVendas(Venda vendas) {
        this.vendas = vendas;
    }

    /**
     * @return the receitas
     */
    public List<Receita> getReceitas() {
        return receitas;
    }

    /**
     * @param receitas the receitas to set
     */
    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the data_retorno
     */
    public Date getData_retorno() {
        return data_retorno;
    }

    /**
     * @param data_retorno the data_retorno to set
     */
    public void setData_retorno(Date data_retorno) {
        this.data_retorno = data_retorno;
    }
    
    
    
}
