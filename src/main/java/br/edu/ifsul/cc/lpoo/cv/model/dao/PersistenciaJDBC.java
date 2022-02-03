/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.cc.lpoo.cv.model.dao;

import br.edu.ifsul.cc.lpoo.cv.model.Consulta;
import br.edu.ifsul.cc.lpoo.cv.model.Pagamento;
import br.edu.ifsul.cc.lpoo.cv.model.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bianca.evangelista
 */
public class PersistenciaJDBC implements InterfacePersistencia {

    private final String DRIVER = "org.postgresql.Driver";
    private final String USER = "postgres";
    private final String SENHA = "1234";
    public static final String URL = "jdbc:postgresql://localhost:5432/db_projeto_ClinicaVeterinaria_TrabalhoLPOO";
    private Connection con = null;

    public PersistenciaJDBC() {

        try {

            Class.forName(DRIVER); //carregamento do driver postgresql em tempo de execução
            System.out.println("Tentando estabelecer conexao JDBC com : " + URL);
            this.con = (Connection) DriverManager.getConnection(URL, USER, SENHA);

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public Boolean conexaoAberta() {
        try {
            if (con != null) {
                return !con.isClosed();//verifica se a conexao está aberta
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void fecharConexao() {
        try {
            this.con.close();//fecha a conexao.
            System.out.println("Fechou conexao JDBC");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        if (c == Venda.class) {
            Venda venda = null;

            PreparedStatement ps = this.con.prepareStatement("select v.id, v.observacao, v.valor_total,v.data, v.pagamento from tb_venda v where id = ? ");
            ps.setInt(1, Integer.parseInt(id.toString()));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setObservacao(rs.getString("observacao"));
                venda.setValor_total(rs.getFloat("valor_total"));
                venda.setData(rs.getDate("data"));
                venda.setPagamento(Pagamento.getPagamento(rs.getString("pagamento")));
                ps.close();

                //
                ps = this.con.prepareStatement("select con.id, con.data, con.observacao, con.data_retorno, con.valor "
                    + "from tb_venda_consulta cons, tb_consulta con "
                    + "where cons.consulta_id=con.id and cons.venda_id = ?");
                ps.setInt(1, venda.getId());
                rs = ps.executeQuery();
                while (rs.next()) {

                    Consulta con = new Consulta();
                    con.setId(rs.getInt("id"));
                    con.setData(rs.getDate("data"));
                    con.setObservacao(rs.getString("observacao"));
                    con.setData_retorno(rs.getDate("data_retorno"));
                    con.setValor(rs.getFloat("valor"));

                    venda.setConsulta(con);

                }
                rs.close();
                ps.close();
            }
            return venda;
        } else if (c == Consulta.class) {
            PreparedStatement ps = this.con.prepareStatement("select c.id, c.data, c.observacao, c.data_retorno, c.valor"
                                                                + "from tb_consulta where id= ?");
                ps.setInt(1, Integer.parseInt(id.toString()));
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                   Consulta con = new Consulta();
                    con.setId(rs.getInt("id"));
                    con.setData(rs.getDate("data"));
                    con.setObservacao(rs.getString("observacao"));
                    con.setData_retorno(rs.getDate("data_retorno"));
                    con.setValor(rs.getFloat("valor"));
                    
                    return con;
                }
        }
        return null;
    }

    @Override
    public void persist(Object o) throws Exception {
        if (o instanceof Venda) {
            Venda venda = (Venda) o;

            if (venda.getId() == null) {
                PreparedStatement ps = this.con.prepareStatement("insert into tb_venda (id, observacao, valor_total,data,pagamento)"
                        + " values (nextval('seq_venda_id'),?,?,?,?)");
                ps.setString(1, venda.getObservacao());
                ps.setFloat(2, venda.getValor_total());
                ps.setDate(3, (Date) venda.getData());
                ps.setString(4, venda.getPagamento().toString());
                //ps.execute();

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    venda.setId(rs.getInt("id"));
                    if (venda.getConsultas() != null && venda.getConsultas().size() > 0) {

                        for (Consulta c : venda.getConsultas()) {
                            ps = this.con.prepareStatement("insert into tb_venda_consulta (venda_id, consulta_id) values (?,?)");
                            ps.setInt(1, venda.getId());
                            ps.setInt(2, c.getId());

                            ps.execute();
                        }
                    }
                }
                rs.close();
                ps.close();
            } else {
                PreparedStatement ps = this.con.prepareStatement("update tb_venda set observacao = ?, valor_total = ?, data = ?, pagamento = ? where id = ?");

                ps.setString(1, venda.getObservacao());
                ps.setFloat(2, venda.getValor_total());
                ps.setDate(3, (Date) venda.getData());
                ps.setString(4, venda.getPagamento().toString());

                ps = this.con.prepareStatement("delete from tb_venda_consulta where venda_id");
                ps.setInt(1, venda.getId());
                ps.execute();

                if (venda.getConsultas() != null && venda.getConsultas().size() > 0) {
                    for (Consulta c : venda.getConsultas()) {
                        ps = this.con.prepareStatement("insert into tb_venda_consulta (venda_id, consulta_id) values (?,?)");
                        ps.setInt(1, venda.getId());
                        ps.setInt(2, c.getId());

                        ps.execute();
                    }
                    ps.close();
                }

            }
        } else if (o instanceof Consulta) {
            Consulta c = (Consulta) o;
            if (c.getId() == null) {
                PreparedStatement ps = this.con.prepareStatement("insert into tb_consulta (id, data, observacao,data_retorno, valor)"
                        + " values (nextval('seq_venda_id'),?,?,?,?)");
                ps.setDate(1, (Date) c.getData());
                ps.setString(2, c.getObservacao());
                ps.setDate(3, (Date) c.getData_retorno());
                ps.setFloat(4, c.getValor());

                ps.execute();
                ps.close();
            } else {
                PreparedStatement ps = this.con.prepareStatement("update tb_consulta set data = ?, observacao = ?, data_retorno = ?, valor = ?"
                        + " where id = ?");
                ps.setDate(1, (Date) c.getData());
                ps.setString(2, c.getObservacao());
                ps.setDate(3, (Date) c.getData_retorno());
                ps.setFloat(4, c.getValor());
                ps.execute();

            }
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        if (o instanceof Venda) {
            Venda venda = (Venda) o;

            //deletar a tabela relacionada venda_consulta
            PreparedStatement ps = this.con.prepareStatement("delete from tb_venda_consulta where venda_id = ?");
            ps.setInt(1, venda.getId());
            ps.execute();

            ps = this.con.prepareStatement("delete from tb_venda where id = ?");
            ps.setInt(1, venda.getId());
            ps.execute();

            ps.close();
        } else if (o instanceof Consulta) {
            Consulta c = (Consulta) o;
            PreparedStatement ps = this.con.prepareStatement("delete from tb_consulta where id = ?");
            ps.setInt(1, c.getId());
            ps.execute();
        }
    }

    public List<Venda> getVendas() throws Exception {
        
        List<Venda> lista = null;
        
         // executar um select em tb_venda
        PreparedStatement ps1 = this.con.prepareStatement("select v.id, v.observacao, v.valor_total,v.data, v.pagamento"
                                                            + "from tb_venda v "+
                                                                " order by v.id asc ");
        ResultSet rs1 = ps1.executeQuery();

        lista = new ArrayList();
        
        while (rs1.next()) {
            Venda venda = new Venda();
            venda.setId(rs1.getInt("id"));
            venda.setObservacao(rs1.getString("observacao"));
            venda.setValor_total(rs1.getFloat("valor_total"));
            venda.setData(rs1.getDate("data"));
            venda.setPagamento(Pagamento.getPagamento(rs1.getString("pagamento")));
           
            //
            PreparedStatement ps2 = this.con.prepareStatement("select con.id, con.data, con.observacao, con.data_retorno, con.valor "
                    + "from tb_venda_consulta cons, tb_consulta con "
                    + "where cons.consulta_id=con.id and cons.venda_id = ?");
            ps2.setInt(1, venda.getId());
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {

                Consulta con = new Consulta();
                con.setId(rs2.getInt("id"));
                con.setData(rs2.getDate("data"));
                con.setObservacao(rs2.getString("observacao"));
                con.setData_retorno(rs2.getDate("data_retorno"));
                con.setValor(rs2.getFloat("valor"));

                venda.setConsulta(con);

            }
            rs2.close();
            ps2.close();

            lista.add(venda);
        }
        rs1.close();
        ps1.close();
        
        return lista;
    }

}
