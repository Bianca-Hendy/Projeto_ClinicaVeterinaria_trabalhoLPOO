package br.edu.ifsul.cc.lpoo.cv.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, TipoProduto> tp_produto;
	public static volatile SingularAttribute<Produto, Float> valor;
	public static volatile SingularAttribute<Produto, Venda> vendas;
	public static volatile SingularAttribute<Produto, Receita> receitas;
	public static volatile SingularAttribute<Produto, String> nome;
	public static volatile SingularAttribute<Produto, Integer> id;
	public static volatile SingularAttribute<Produto, Fornecedor> fornecedor;
	public static volatile SingularAttribute<Produto, Float> quantidade;

}

