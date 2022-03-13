package br.edu.ifsul.cc.lpoo.cv.gui;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author bianca.evangelista
 */
public class JMenuBarHome extends JMenuBar implements ActionListener{
    private JMenu menuArquivo; 
    private JMenuItem menuItemSair;
    
    private JMenu menuCadastro;
    private JMenuItem menuItemFuncionario;
    
    private JMenu menuVenda;
    private JMenuItem menuItemVenda;
    
    private Controle controle;
    
    public JMenuBarHome(Controle controle) {
        this.controle = controle;
         initComponents();
    }
    private void initComponents(){
        menuArquivo = new JMenu("Arquivo");
        menuItemSair = new JMenuItem ("Sair");
        menuItemSair.addActionListener(this);
        menuItemSair.setActionCommand("menu_sair");
        menuArquivo.add(menuItemSair);
        
        menuCadastro = new JMenu("Cadastros");
        menuItemFuncionario = new JMenuItem ("Funcionario");
        menuItemFuncionario.addActionListener(this);
        menuItemFuncionario.setActionCommand("menu_funcionario");
        menuItemVenda = new JMenuItem("Venda");
        menuItemVenda.addActionListener(this);
        menuItemVenda.setActionCommand("menu_venda");
        menuCadastro.add(menuItemFuncionario);
        menuCadastro.add(menuItemVenda);
        
        
        this.add(menuArquivo);
        this.add(menuCadastro);
       //this.add(menuVenda);
           
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals(menuItemSair.getActionCommand())) {
            int click = JOptionPane.showConfirmDialog(this, "Deseja realmente sair do sistema? ", "Sair", JOptionPane.YES_NO_OPTION);
            if (click == 0){
                
                controle.fecharBD();
                System.exit(0);
            }
            //se o user clicou em sair 
        }else if (ae.getActionCommand().equals(menuItemFuncionario.getActionCommand())) {
            
            //se o user clicou no menuItem usuario
            controle.showTela("tela_funcionario");
            
        }else if (ae.getActionCommand().equals(menuItemVenda.getActionCommand())){
            controle.showTela("tela_venda");
        }
    }
}
