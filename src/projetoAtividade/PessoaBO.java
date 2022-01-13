package projetoAtividade;

import java.util.HashMap;

public class PessoaBO {
	PessoaBean pessoaBean = new PessoaBean();
	AtividadeBean ativBean = new AtividadeBean();
	HashMap<Integer,PessoaBean> pessoaMap = new HashMap<Integer,PessoaBean>();
	Integer idPessoaBean = 0;
	
	
	public void iniciar() {
		pessoaBean = new PessoaBean();	
	}
	
	public void informaDados(String nome, Integer idade, String email, String cidade, Integer Tipo, String bairro, String nomeRua, Integer numeroCasa) {
		idPessoaBean = idPessoaBean + 1;
		pessoaBean.setId(idPessoaBean);
		pessoaBean.setNome(nome);
		pessoaBean.setIdade(idade);
		pessoaBean.setEmail(email);
		pessoaBean.setCidade(cidade);
		pessoaBean.setTipo(Tipo);	
		pessoaBean.setBairro(bairro);
		pessoaBean.setNomeRua(nomeRua);
		pessoaBean.setNumeroCasa(numeroCasa);
	}
	
	public void gravarDados() {
		pessoaMap.put(idPessoaBean, pessoaBean);
	}

}
