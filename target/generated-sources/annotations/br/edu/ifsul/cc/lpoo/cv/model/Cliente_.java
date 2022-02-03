package br.edu.ifsul.cc.lpoo.cv.model;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ extends br.edu.ifsul.cc.lpoo.cv.model.Pessoa_ {

	public static volatile ListAttribute<Cliente, Pet> pets;
	public static volatile SingularAttribute<Cliente, Calendar> data_ultima_visita;

}

