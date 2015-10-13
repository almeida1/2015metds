package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

public class UC01CadastrarEmpresa {
    static EmpresaDAO empresaDAO;
    static Empresa empresa;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		//89.424.232/0001-80
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	/**
	 * obj - verificar o comportamento do sistema na inclus�o de uma empresa com sucesso
	 */
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		empresaDAO.exclui("89424232000180");
		assertEquals(1,empresaDAO.adiciona(empresa));
		empresaDAO.exclui("89424232000180");
	}
	/**
	 * CT02UC01A1Cadastra_cnpj_ja_cadastrado
	 * obj - verificar o comportamento do sistema na inclus�o de um cnpj ja cadastrado
	 */
	@Test(expected = RuntimeException.class)
	public void CT02UC01A1Cadastra_cnpj_ja_cadastrado() {
		empresaDAO.adiciona(empresa);
		assertEquals(0,empresaDAO.adiciona(empresa));
	}
	/**
	 * obj - verificar o comportamento do sistema na consulta de todas as empresas 
	 */
	@Test(expected = RuntimeException.class)
	public void CT03UC01A1Cadastra_cnpj_ja_cadastrado() {
		empresaDAO.adiciona(empresa);
		assertEquals(0,empresaDAO.adiciona(empresa));
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}

	

}
