package br.sceweb.model;

public class Controle {
	EmpresaDAO empresaDAO;
	public Controle(){
		empresaDAO = new EmpresaDAO();
	}
    public String cadastrarEmpresa(String cnpj, String nomeDaEmpresa, String nomeFantasia, 
    		                       String endereco, String telefone){
    	String msg="";
    	Empresa empresa = new Empresa();
    	EmpresaDAO empresaDAO = new EmpresaDAO();
    	try {
			empresa.setCnpj(cnpj);
			empresa.setNomeDaEmpresa(nomeDaEmpresa);
			empresa.setNomeFantasia(nomeFantasia);
			empresa.setTelefone(telefone);
			empresaDAO.adiciona(empresa);
			msg = "cadastro realizado com sucesso";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			msg = e.getMessage();
		}
    	
    	return msg;
    }
    public String execluirEmpresa(String cnpj){
    	String msg="";
    	empresaDAO.exclui(cnpj);
    	
    	return msg;
    }
}
