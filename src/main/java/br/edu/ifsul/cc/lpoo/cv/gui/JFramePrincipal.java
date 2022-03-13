/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.cc.lpoo.cv.gui;


import br.edu.ifsul.cc.lpoo.cv.Controle;
import java.awt.CardLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author bianca.evangelista
 */
public class JFramePrincipal extends JFrame implements WindowListener{

    public Controle controle;
    public CardLayout cardLayout;
    public JPanel paineldeFundo;
    
    public JFramePrincipal(Controle controle) {
        this.controle = controle;
        initComponents();
    }
    
    private void initComponents(){
        this.setTitle("Clinica Veterinaria LPOO ");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //quando fechar o frame ... finaliza o projeto
        
        this.addWindowListener(this);
        
        cardLayout = new CardLayout();
        paineldeFundo = new JPanel();
        
       paineldeFundo.setLayout(cardLayout); //define o card para o paineldeFundo
       this.add(paineldeFundo);
    }
    
    public void addTela(JPanel p, String nome) {
        paineldeFundo.add(p, nome);
    } //recebe o painel

    public void showTela(String nome) {
        cardLayout.show(paineldeFundo, nome);
    } //caso queira mudar a carta que esta apresentando

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        System.out.println("Fechando... ");
        controle.fecharBD();
    }

    @Override
    public void windowClosed(WindowEvent we) {       
    }

    @Override
    public void windowIconified(WindowEvent we) {       
    }

    @Override
    public void windowDeiconified(WindowEvent we) {        
    }

    @Override
    public void windowActivated(WindowEvent we) {       
    }

    @Override
    public void windowDeactivated(WindowEvent we) {     
    }
    
}
