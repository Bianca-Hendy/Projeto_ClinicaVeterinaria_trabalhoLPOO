package br.edu.ifsul.cc.lpoo.cv.model;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Agenda.class)
public abstract class Agenda_ {

	public static volatile SingularAttribute<Agenda, Calendar> data_inicio;
	public static volatile SingularAttribute<Agenda, Calendar> data_fim;
	public static volatile SingularAttribute<Agenda, String> observacao;
	public static volatile SingularAttribute<Agenda, TipoProduto> tp_produto;
	public static volatile SingularAttribute<Agenda, Medico> medico;
	public static volatile SingularAttribute<Agenda, Integer> id;
	public static volatile SingularAttribute<Agenda, Funcionario> funcionario;

}

