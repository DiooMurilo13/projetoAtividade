package projetoAtividade.bo;

import java.util.HashMap;

import projetoAtividade.bean.AtividadeBean;
import projetoAtividade.bean.AtividadePessoaPrestadorBean;
import projetoAtividade.bean.PessoaBean;

public class AtividadeBO {
	AtividadePessoaPrestadorBean ativPessoaBean = null;
	AtividadeBean ativBean = new AtividadeBean();
	HashMap<Integer, AtividadePessoaPrestadorBean> ativPessoaMap = new HashMap<Integer, AtividadePessoaPrestadorBean>();
	public HashMap<Integer, AtividadeBean> atividadeMap = new HashMap<Integer, AtividadeBean>();
	Integer chaveId = 0;
	Integer percentualTarefa = 0;
	Integer idAtivPesBean = 0;
	private PessoaBO pesBO;

	public void iniciar() {
		ativBean = new AtividadeBean();
	}

	public void informaDados(String nome, Integer pesRequisitanteId) {
		chaveId = chaveId + 1;
		ativBean.setId(chaveId);
		ativBean.setNomeTarefa(nome);
		ativBean.getPessoaRequisitante().setId(pesRequisitanteId);
	}

	public void carregar (Integer id) {
		ativBean = atividadeMap.get(id);
	}
	public void validarPrestador(Integer idPrestador, PessoaBO pessoaBO) {
		if(pessoaBO.pessoaMap.get(idPrestador).getTipo() == 1) {
			System.out.println("Voce nao pode informar um Requisitante!");
		}else {
			informaPessoaPrestador(idPrestador);
		}
	}

	public void informaPessoaPrestador(Integer id) {
		idAtivPesBean += 1;
		ativPessoaBean = new AtividadePessoaPrestadorBean();
		ativPessoaBean.setId(idAtivPesBean);
		ativPessoaBean.setAtividade(ativBean);
		ativPessoaBean.getPessoaPrestador().setId(id);
		ativPessoaBean.setPorcentagem(0);
	}

	public void informaPercentual(Integer idPrestador, Integer percentual) {
		for(Integer i : ativPessoaMap.keySet()) {
			AtividadePessoaPrestadorBean ativPessoaTempBean = ativPessoaMap.get(i);

			if(ativPessoaTempBean.getAtividade().getId() == ativBean.getId()
					&& ativPessoaTempBean.getPessoaPrestador().getId() == idPrestador) {
				idAtivPesBean = ativPessoaTempBean.getId();
				ativPessoaBean = ativPessoaTempBean;
				ativPessoaBean.setPorcentagem(percentual);
			}
		}
	}

	public void validarRequisitante(Integer idRequisitante, PessoaBO pessoaBO , String nome) {
		if(pessoaBO.pessoaMap.get(idRequisitante).getTipo() == 2) {
			System.out.println("Voce nao pode informar um Prestador");

		}else {
			informaDados(nome, idRequisitante);
		}
	}
	
	public void gravar() {
		atividadeMap.put(chaveId, ativBean);
		if(ativPessoaBean != null) {
			ativPessoaMap.put(idAtivPesBean, ativPessoaBean);
		}
	}
	
	public String getPrestadores(Integer idTarefa) {
		String prestadores = null;
		try {
			prestadores = "";
			for(Integer i : ativPessoaMap.keySet()) {
				AtividadePessoaPrestadorBean ativPesPrestBean = ativPessoaMap.get(i);
				
				if(ativPessoaBean.getAtividade().getId() == idTarefa) {
					PessoaBean pesPrestadorBean = pesBO.pessoaMap.get(ativPesPrestBean.getPessoaPrestador().getId());
					prestadores += pesPrestadorBean.getNome() + "[" + ativPesPrestBean.getPorcentagem() + "%]";
				}
			}

		} catch (Exception e) {
		}
		return prestadores;
	}
	
	public void setPessoaBO(PessoaBO pessoaBO) {
		this.pesBO = pessoaBO;
	}
}
