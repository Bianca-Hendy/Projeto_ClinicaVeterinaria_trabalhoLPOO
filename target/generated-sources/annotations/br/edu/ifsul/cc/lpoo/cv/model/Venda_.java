package br.edu.ifsul.cc.lpoo.cv.model;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Venda.class)
public abstract class Venda_ {

	public static volatile SingularAttribute<Venda, Float> valor_total;
	public static volatile SingularAttribute<Venda, Cliente> cliente;
	public static volatile SingularAttribute<Venda, String> observacao;
	public static volatile SingularAttribute<Venda, Calendar> data;
	public static volatile ListAttribute<Venda, Produto> produtos;
	public static volatile ListAttribute<Venda, Consulta> consultas;
	public static volatile SingularAttribute<Venda, Integer> id;
	public static volatile SingularAttribute<Venda, Funcionario> funcionario;
	public static volatile SingularAttribute<Venda, Pagamento> pagamento;

}

