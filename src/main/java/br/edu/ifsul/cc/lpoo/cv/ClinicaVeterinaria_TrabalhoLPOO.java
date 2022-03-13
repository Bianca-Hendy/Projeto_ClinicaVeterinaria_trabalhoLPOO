/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.cc.lpoo.cv;

import javax.swing.JOptionPane;

/**
 *
 * @author bianca.evangelista
 */
public class ClinicaVeterinaria_TrabalhoLPOO {
    private Controle controle;
    public ClinicaVeterinaria_TrabalhoLPOO() {
        controle = new Controle();
        
        if(controle.conectarBD()){
            controle.initComponents();
            
        }else{
            JOptionPane.showMessageDialog(null, "Não conectou no Banco de Dados", "Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main (String [] args){
        new ClinicaVeterinaria_TrabalhoLPOO();
    }
}
