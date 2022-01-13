package projetoAtividade;

public class AtividadeBean {
		private String nomeTarefa;
		private Integer id;
		private Integer porcentagem;
		private PessoaBean pessoaRequisitante;
		
		public String getNomeTarefa() {
			return nomeTarefa;
		}
		public void setNomeTarefa(String nomeTarefa) {
			this.nomeTarefa = nomeTarefa;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getPorcentagem() {
			return porcentagem;
		}
		public void setPorcentagem(Integer porcentagem) {
			this.porcentagem = porcentagem;
		}
		public PessoaBean getPessoaRequisitante() {
			if(pessoaRequisitante == null) pessoaRequisitante = new PessoaBean();
			return pessoaRequisitante;
		}
		public void setPessoaRequisitante(PessoaBean pessoaRequisitante) {
			this.pessoaRequisitante = pessoaRequisitante;
		}
}
