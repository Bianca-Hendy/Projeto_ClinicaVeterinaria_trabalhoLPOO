/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.cc.lpoo.cv.test;

import br.edu.ifsul.cc.lpoo.cv.model.Consulta;
import br.edu.ifsul.cc.lpoo.cv.model.Pagamento;
import br.edu.ifsul.cc.lpoo.cv.model.Venda;
import br.edu.ifsul.cc.lpoo.cv.model.dao.PersistenciaJDBC;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author bianca.evangelista
 */
public class TestePersistenciaJDBC {

    //@Test
    public void testarConexao() throws Exception {

        PersistenciaJDBC persistencia = new PersistenciaJDBC();

        if (persistencia.conexaoAberta()) {

            System.out.println("Conexao com o BD aberta utilizando JDBC");
            persistencia.fecharConexao();

        } else {
            System.out.println("Não abriu conexao via JDBC");
        }

    }
   
    //@Test
    public void testaPersistenciaConsulta() throws Exception {

        PersistenciaJDBC persistencia = new PersistenciaJDBC();

        if (persistencia.conexaoAberta()) {
            Consulta c = (Consulta) persistencia.find(Consulta.class, new Integer(2));
            
            if (c == null) {
                System.out.println("Não encontrou a venda com id = 1");

                c = new Consulta();
                c.setObservacao("testar amanha novamente");
                c.setData(Date.valueOf(LocalDate.parse("2020-04-21")));
                c.setData_retorno(Date.valueOf(LocalDate.parse("2020-07-21")));
                c.setValor(Float.parseFloat("250"));
                persistencia.persist(c);
                
                System.out.println("Deu certo");
            }else{
                System.out.println("num foi ");
            }
        }
        else {
            System.out.println("Não abriu conexao via JDBC");
        }

    }
    
    @Test
    public void testePersistenciaVenda()throws Exception{
        PersistenciaJDBC persistencia = new PersistenciaJDBC();
        
        if(persistencia.conexaoAberta()){
            System.out.println("Conexao ok");
            
            List<Venda> venda = persistencia.getVendas();
            
            if(venda != null && !venda.isEmpty()){
                for (Venda ven : venda){
                    System.out.println("Venda encontrada: "+ven.getId()+ "Observacoes da venda: "+ven.getObservacao());
                        if(ven.getConsultas() != null && !ven.getConsultas().isEmpty()){
                            for(Consulta con : ven.getConsultas()){
                                System.out.println("Consulta: "+con.getId());
                            }
                        }
                        persistencia.remover(venda);
                        
                }
            }else{
                Venda v = new Venda();
                v.setObservacao("Consulta o medico responsavel");
                
                Consulta con1 = (Consulta) persistencia.find(Consulta.class, new Integer(1));
                Consulta con2 = (Consulta) persistencia.find(Consulta.class, new Integer(2));
                
                v.setConsulta(con1);
                v.setConsulta(con2);
                
                persistencia.persist(v);
            }
            
            persistencia.fecharConexao();
        }else{
            System.out.println("Nao conseguiu essa bagassa!!");
        }
    }
}
