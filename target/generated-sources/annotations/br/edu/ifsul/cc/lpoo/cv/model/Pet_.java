package br.edu.ifsul.cc.lpoo.cv.model;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pet.class)
public abstract class Pet_ {

	public static volatile SingularAttribute<Pet, Cliente> cliente;
	public static volatile SingularAttribute<Pet, String> observacao;
	public static volatile SingularAttribute<Pet, Calendar> data_nascimento;
	public static volatile SingularAttribute<Pet, Raca> raca;
	public static volatile SingularAttribute<Pet, String> nome;
	public static volatile SingularAttribute<Pet, String> id;

}

