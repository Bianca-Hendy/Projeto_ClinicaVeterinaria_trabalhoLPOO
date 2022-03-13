/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.cc.lpoo.cv.gui.Venda;

import br.edu.ifsul.cc.lpoo.cv.Controle;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author bianca.evangelista
 */
public class JPanelVenda extends JPanel{

    /**
     * @return the telaListagem
     */
    public JPanelListagemV getTelaListagem() {
        return telaListagem;
    }
     private Controle controle;
    private CardLayout layoutCard;
    
    private JPanelListagemV telaListagem;
    private JPanelEdicaoV telaEdicao;
    
    public JPanelVenda(Controle controle) {
        
        this.controle = controle;
        initComponents();
    }
    private void initComponents(){
        layoutCard = new CardLayout();
        this.setLayout(layoutCard);
        
        telaListagem = new JPanelListagemV(this, getControle());
        telaEdicao = new JPanelEdicaoV(this, getControle());
        
        this.add(getTelaListagem(), "tela_listagem"); //adiciona as caartas ao baralho
        this.add(telaEdicao, "tela_edicao");
        
        layoutCard.show(this, "tela_listagem");  //mostra por padrao a listagem
    }
    
     public void showTela(String nomeTela){
        if(nomeTela.equals("tela_listagem")){
            telaListagem.populaTable();
        } 
        
        layoutCard.show(this, nomeTela);
    }

    /**
     * @return the controle
     */
    public Controle getControle() {
        return controle;
    }
     
     
}
