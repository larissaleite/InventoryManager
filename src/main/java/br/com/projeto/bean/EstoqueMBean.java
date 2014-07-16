package br.com.projeto.bean;

public class EstoqueMBean {

	/* SELECT r.mes, p.nome, p.preco, r.quantidade, v.quantidade FROM produto AS p INNER JOIN recebimento AS r ON p.id_produto = r.produto_id LEFT OUTER JOIN venda AS v ON p.id_produto = v.produto_id */
	/* OUTER JOIN porque faz com que mesmo os produtos que nao tiveram vendas sejam retornados, desde que tenham sido recebidos */
	/*UPDATE:
	 * SELECT r.mes, p.nome, p.preco, r.quantidade, SUM(v.quantidade) FROM produto AS p INNER JOIN recebimento AS r ON p.id_produto = r.produto_id LEFT OUTER JOIN venda AS v ON p.id_produto = v.produto_id GROUP BY r.mes, p.nome, p.preco, r.quantidade
	 * 
	 * para imprimir a soma quando houver mais de uma venda
	 * 
	 * (SELECT v.mes, SUM(v.quantidade) FROM venda AS v GROUP BY v.mes)
	 * 
	 * UPDATE:
	 * 
	 * SELECT v.mes, p.nome, p.preco, r.quantidade, SUM(v.quantidade) FROM produto AS p INNER JOIN recebimento AS r ON p.id_produto = r.produto_id LEFT OUTER JOIN venda AS v ON p.id_produto = v.produto_id GROUP BY v.mes, p.nome, p.preco, r.quantidade
	 * 
	 * o mes tem que ser o mes de VENDA para que seja somado diferentemente as vendas de cada mes
	 * 
	 * ---> Se houver mais de um recebimento E mais de uma venda do mesmo produto por mes?
	 * 
	 * 
	 */
}
