package br.edu.ifsul.cc.lpoo.cv.model;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Consulta.class)
public abstract class Consulta_ {

	public static volatile SingularAttribute<Consulta, String> observacao;
	public static volatile SingularAttribute<Consulta, Calendar> data;
	public static volatile SingularAttribute<Consulta, Calendar> data_retorno;
	public static volatile SingularAttribute<Consulta, Medico> medico;
	public static volatile SingularAttribute<Consulta, Float> valor;
	public static volatile ListAttribute<Consulta, Receita> receitas;
	public static volatile SingularAttribute<Consulta, Venda> vendas;
	public static volatile SingularAttribute<Consulta, Integer> id;

}

