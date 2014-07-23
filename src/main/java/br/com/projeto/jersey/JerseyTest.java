package br.com.projeto.jersey;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.projeto.modelo.Estoque;
import br.com.projeto.modelo.Mes;
import br.com.projeto.service.ServiceEstoque;
import br.com.projeto.spring.util.SpringUtils;
 
@Path("/hello")
public class JerseyTest {
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
	@Path("/vendasMensal") //ajeitar pra ser um metodo generico que recebe o tipo do grafico e redireciona pra o metodo q retorna os dados especificos pra o determinado grafico
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Integer> getData() {
		ServiceEstoque serviceEstoque = (ServiceEstoque) SpringUtils.getBean("serviceEstoque");
		ArrayList<Integer> quantVendas = (ArrayList<Integer>)serviceEstoque.recuperarQuantVendas();
		System.out.println("Lista retorno");
		for (Integer i : quantVendas) {
			System.out.println(i);
		}
		
		return quantVendas;
	}
	
	@GET
	@Path("/estoqueMes")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Estoque> getEstoqueMes() {
		ServiceEstoque serviceEstoque = (ServiceEstoque) SpringUtils.getBean("serviceEstoque");
		ArrayList<Estoque> estoqueMes = (ArrayList<Estoque>) serviceEstoque.recuperarEstoqueNoMes(Mes.JULHO);
		return estoqueMes;
	}
	
	@GET
	@Path("/lucroAnual")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Integer> getLucroAnual() {
		ServiceEstoque serviceEstoque = (ServiceEstoque) SpringUtils.getBean("serviceEstoque");
		ArrayList<Integer> lucro = (ArrayList<Integer>)serviceEstoque.lucroAnual();
		return lucro;
	}
	
	/* SELECT DISTINCT m.mes, COALESCE(v.venda_quantidade, 0) AS venda_quantidade FROM venda CROSS JOIN ( VALUES (0), (1),(2),(3),(4),(5),(6), (7), (8), (9), (10), (11) ) AS m(mes) 
LEFT OUTER JOIN ( SELECT mes, SUM(quantidade) AS venda_quantidade FROM venda GROUP BY mes ) AS v ON v.mes = m.mes 
ORDER BY m.mes */

}
