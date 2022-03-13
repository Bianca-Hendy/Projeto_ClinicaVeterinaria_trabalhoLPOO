/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.cc.lpoo.cv.gui;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author bianca.evangelista
 */
public class JPanelHome extends JPanel{
    private JLabel lblMensagem;
    private JLabel lblData;
    private JLabel lblImagem;
    private BorderLayout layoutGeo;
    
    private Controle controle;
    public JPanelHome(Controle controle) {
        
        this.controle = controle;
        initComponents();
    }
    private void initComponents(){
         layoutGeo = new BorderLayout();
         this.setLayout(layoutGeo); //seta o gerenciador de layout para o painel
         
         lblMensagem = new JLabel("Clinica Veterinaria");
         lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
         this.add(lblMensagem, BorderLayout.NORTH); //msg tela de entrada ficara no norte
         
         lblImagem = new JLabel(new ImageIcon(JPanelHome.class.getResource("/images/logo_clinicaV.png")));
         this.add(lblImagem, BorderLayout.CENTER);
         
         Calendar c = Calendar.getInstance();
         SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
         
         lblData = new JLabel(df.format(c.getTime()));
         lblData.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblData.setHorizontalAlignment(SwingConstants.CENTER);
         this.add(lblData, BorderLayout.SOUTH); //adiciona o rotulo na parte inferior deste painel.   
    }
    
    
}
