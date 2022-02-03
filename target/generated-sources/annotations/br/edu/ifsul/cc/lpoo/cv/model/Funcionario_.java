package br.edu.ifsul.cc.lpoo.cv.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Funcionario.class)
public abstract class Funcionario_ extends br.edu.ifsul.cc.lpoo.cv.model.Pessoa_ {

	public static volatile SingularAttribute<Funcionario, String> numero_pis;
	public static volatile SingularAttribute<Funcionario, Cargo> cargo;
	public static volatile SingularAttribute<Funcionario, String> numero_ctps;

}

