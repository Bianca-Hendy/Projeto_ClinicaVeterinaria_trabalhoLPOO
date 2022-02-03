package br.edu.ifsul.cc.lpoo.cv.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Receita.class)
public abstract class Receita_ {

	public static volatile SingularAttribute<Receita, String> orientacao;
	public static volatile ListAttribute<Receita, Produto> produtos;
	public static volatile SingularAttribute<Receita, Integer> id;
	public static volatile SingularAttribute<Receita, Consulta> consulta;

}

