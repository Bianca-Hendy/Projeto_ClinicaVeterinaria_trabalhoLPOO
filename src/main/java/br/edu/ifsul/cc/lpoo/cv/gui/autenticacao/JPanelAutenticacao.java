/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.cc.lpoo.cv.gui.autenticacao;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author bianca.evangelista
 */
public class JPanelAutenticacao extends JPanel implements ActionListener{

    private Controle controle;
    private GridBagLayout gridLayout;
    private GridBagConstraints posicionador;
    
     private JLabel lblCPF;
    private JLabel lblNumero_ctps;
    private JTextField txfCPF; //campo para cpf
    private JPasswordField psfNumero_ctps; // campo para senha
    private JButton btnLogar;
    
    public JPanelAutenticacao(Controle controle) {
        this.controle = controle;
        initComponents();
    }
    
    private void initComponents(){
        gridLayout = new GridBagLayout();//inicializando o gerenciador de layout
        this.setLayout(gridLayout);//definie o gerenciador para este painel.
        
        lblCPF = new JLabel("CPF: ");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0;//policao da linha (vertical)
        posicionador.gridx = 0;// posição da coluna (horizontal)
        this.add(lblCPF, posicionador);//o add adiciona o rotulo no painel
        
        txfCPF = new JTextField(10);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        this.add(txfCPF, posicionador);//o add adiciona o rotulo no painel        
        
        lblNumero_ctps = new JLabel("Senha: ");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 1;//policao da linha (vertical)
        posicionador.gridx = 0;// posição da coluna (horizontal)
        this.add(lblNumero_ctps, posicionador);//o add adiciona o rotulo no painel
        
        psfNumero_ctps = new JPasswordField(10);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 1;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        this.add(psfNumero_ctps, posicionador);//o add adiciona o rotulo no painel  

        btnLogar = new JButton("Autenticar");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 2;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        btnLogar.addActionListener(this);//registrar o botão no Listener
        btnLogar.setActionCommand("comando_autenticar");
        this.add(btnLogar, posicionador);//o add adiciona o rotulo no painel

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals(btnLogar.getActionCommand()))
        {
            //trim tira os espaços em branco
            //cpf tem que ser maior que 11 caracteres
            //senha tem que ser maior que 3 caracteres
            if(txfCPF.getText().trim().length() == 11 && new String (psfNumero_ctps.getPassword()).trim().length() > 3){
                    controle.autenticar(txfCPF.getText().trim(), new String (psfNumero_ctps.getPassword()).trim());
            }else{
                JOptionPane.showMessageDialog(this, "Informe os dados CPF e senha", "Autenticacao", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
