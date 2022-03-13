/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.cc.lpoo.cv.gui.Funcionario;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author bianca.evangelista
 */
public class JPanelFuncionario extends JPanel {

    /**
     * @return the telaListagem
     */
    public JPanelListagem getTelaListagem() {
        return telaListagem;
    }
    private Controle controle;
    private CardLayout layoutCard;
    
    private JPanelListagem telaListagem;
    private JPanelEdicao telaEdicao;
    
    public JPanelFuncionario(Controle controle) {
        
        this.controle = controle;
        initComponents();
    }
    private void initComponents(){
        layoutCard = new CardLayout();
        this.setLayout(layoutCard);
        
        telaListagem = new JPanelListagem(this, getControle());
        telaEdicao = new JPanelEdicao(this, getControle());
        
        this.add(getTelaListagem(), "tela_listagem"); //adiciona as caartas ao baralho
        this.add(telaEdicao, "tela_edicao");
        
        layoutCard.show(this, "tela_listagem");  //mostra por padrao a listagem
    }
    public void showTela(String nomeTela){
        layoutCard.show(this, nomeTela);
    }

    /**
     * @return the controle
     */
    public Controle getControle() {
        return controle;
    }
     
}
