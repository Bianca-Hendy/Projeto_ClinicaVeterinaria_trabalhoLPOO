/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.cc.lpoo.cv;

import br.edu.ifsul.cc.lpoo.cv.gui.Funcionario.JPanelFuncionario;
import br.edu.ifsul.cc.lpoo.cv.gui.JFramePrincipal;
import br.edu.ifsul.cc.lpoo.cv.gui.JMenuBarHome;
import br.edu.ifsul.cc.lpoo.cv.gui.JPanelHome;
import br.edu.ifsul.cc.lpoo.cv.gui.Venda.JPanelVenda;
import br.edu.ifsul.cc.lpoo.cv.gui.autenticacao.JPanelAutenticacao;
import br.edu.ifsul.cc.lpoo.cv.model.Funcionario;
import br.edu.ifsul.cc.lpoo.cv.model.dao.PersistenciaJDBC;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author bianca.evangelista
 */
public class Controle {

    private PersistenciaJDBC conexaoJDBC;
    private JFramePrincipal frame;
    private JPanelAutenticacao pnlAutenticacao;
    private JMenuBarHome menuBar;
    private JPanelHome pnlHome;
    private JPanelFuncionario pnlFuncionario;
    private JPanelVenda pnlVenda;
    
    public Controle() {

    }

    public void initComponents() {
        frame = new JFramePrincipal(this);
        
        pnlAutenticacao = new JPanelAutenticacao(this);
        
        menuBar = new JMenuBarHome(this);
        
        pnlHome = new JPanelHome(this);
        
        pnlFuncionario = new JPanelFuncionario(this);
        
        pnlVenda = new JPanelVenda(this);
        
        frame.addTela(pnlAutenticacao, "tela_autenticacao");
        frame.addTela(pnlHome, "tela_home");
        frame.addTela(pnlFuncionario, "tela_funcionario");
        frame.addTela(pnlVenda, "tela_venda");
        
        frame.showTela("tela_autenticacao");
        
        frame.setVisible(true); //torna visivel o jframe
    }

    public boolean conectarBD() {
        conexaoJDBC = new PersistenciaJDBC();
        if (conexaoJDBC != null) {
            return conexaoJDBC.conexaoAberta();

        }
        return false;
    }

    public void fecharBD() {
        System.out.println("Fechando conexao com o Banco de Dados");
        conexaoJDBC.fecharConexao();
    }
    public void showTela(String nomeTela){
        if(nomeTela.equals("tela_funcionario")){
            pnlFuncionario.getTelaListagem().populaTable();
            
        }else if(nomeTela.equals("tela_venda")){
            pnlVenda.getTelaListagem().populaTable();
        }
        
        frame.showTela(nomeTela);
    }
    
    public void autenticar(String cpf, String numero_ctps) {
        try{
            Funcionario f = conexaoJDBC.doLogin(cpf, numero_ctps);
            if(f != null){
                JOptionPane.showMessageDialog(pnlAutenticacao, "Funcionario: "+f.getNome()+" autenticado!", "Autenticacao", JOptionPane.INFORMATION_MESSAGE);
                frame.setJMenuBar(menuBar); 
                frame.showTela("tela_home"); //muda a tela para o pnlHome.
                
                
            }else{
                JOptionPane.showMessageDialog(pnlAutenticacao, "Dados invalidos!!", "Autenticacao", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(pnlAutenticacao, "Erro ao executar a autenticacao no BD", "Autenticacao", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public PersistenciaJDBC getConexaoJDBC() {
        return conexaoJDBC;
    }
}
