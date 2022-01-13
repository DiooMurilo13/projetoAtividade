package projetoAtividade;

import java.util.Scanner;

public class ScreenView {
	public static void main(String[] args) {
		AtividadeBO atividadeBO = new AtividadeBO();
		PessoaBO pessoaBO = new PessoaBO();
		atividadeBO.setPessoaBO(pessoaBO);
		Scanner sc = new Scanner (System.in);
		String menu;
		String nomeTarefa;

		do {
			mostraListaTarefa(atividadeBO, pessoaBO);

			System.out.println("----------------");
			System.out.println("A-Cadastrar pessoa");
			System.out.println("B-Adicionar tarefa");
			System.out.println("C-Vincular o prestador a tarefa");
			System.out.println("D-Informar o percentual de uma tarefa");
			System.out.println("Digite uma opção");

			menu = sc.next();
			if(menu.equalsIgnoreCase("A")) {
				for(Integer i : pessoaBO.pessoaMap.keySet()) {
					if(pessoaBO.pessoaMap.get(i).getTipo() == 1) {
						System.out.println(pessoaBO.pessoaMap.get(i).getId() + "-" + pessoaBO.pessoaMap.get(i).getNome() + "-" + pessoaBO.pessoaMap.get(i).getIdade() + "-" + pessoaBO.pessoaMap.get(i).getEmail() + "-" + pessoaBO.pessoaMap.get(i).getCidade() + "-" + pessoaBO.pessoaMap.get(i).getBairro() +"-" + pessoaBO.pessoaMap.get(i).getNomeRua() + "-" + pessoaBO.pessoaMap.get(i).getNumeroCasa() + "-" + "Requisitante");
					}else if(pessoaBO.pessoaMap.get(i).getTipo() == 2) {
						System.out.println(pessoaBO.pessoaMap.get(i).getId() + "-" + pessoaBO.pessoaMap.get(i).getNome() + "-" + pessoaBO.pessoaMap.get(i).getIdade() + "-" + pessoaBO.pessoaMap.get(i).getEmail() + "-" + pessoaBO.pessoaMap.get(i).getCidade() + "-" + pessoaBO.pessoaMap.get(i).getBairro() +"-" + pessoaBO.pessoaMap.get(i).getNomeRua() + "-" + pessoaBO.pessoaMap.get(i).getNumeroCasa() + "-" + "Prestador");
					}
				}
				pessoaBO.iniciar();
				System.out.println("=======DADOS=======");
				System.out.println("Digite o nome");
				String nomePessoa = sc.next();
				System.out.println("Digite a idade");
				Integer idadePessoa = sc.nextInt();
				System.out.println("Digite o email");
				String emailPessoa = sc.next();
				System.out.println("Digite a sua cidade");
				String cidade = sc.next();
				System.out.println("Digite seu bairro");
				String error2 = sc.nextLine();
				String bairro = sc.nextLine();
				System.out.println("Digite o nome da rua");
				String nomeRua = sc.nextLine();
				System.out.println("Digite numero da casa");
				Integer numeroCasa = sc.nextInt();

				System.out.println("1-Requisitante");
				System.out.println("2-Prestador");
				System.out.println("Digite o tipo de pessoa");

				Integer tipoPessoa = sc.nextInt();


				pessoaBO.informaDados(nomePessoa, idadePessoa, emailPessoa, cidade, tipoPessoa, bairro, nomeRua, numeroCasa);
				pessoaBO.gravarDados();
				System.out.println("Informaçoes gravadas!");
				menu = "sim";

			}else if(menu.equalsIgnoreCase("B")) {
				System.out.println("Digite o nome da tarefa");
				atividadeBO.iniciar();
				String erro = sc.nextLine();
				String tarefaNome = sc.nextLine();
				System.out.println("Digite o numero do requisitante");
				Integer idRequisitante = sc.nextInt();
				atividadeBO.validarRequisitante(idRequisitante, pessoaBO, tarefaNome);
				atividadeBO.gravar();
				System.out.println("<Voltar para o inicio?>");
				menu = sc.next();

			}else if(menu.equalsIgnoreCase("C")) {
				System.out.println("Digite o numero da tarefa");
				Integer idTarefa = sc.nextInt();
				System.out.println("Digite o numero do prestador");
				Integer idPrestador = sc.nextInt();
				System.out.println("Digite o percentual");
				Integer percentual = sc.nextInt();
				atividadeBO.carregar(idTarefa);
				atividadeBO.validarPrestador(idPrestador, pessoaBO);
				atividadeBO.gravar();
				System.out.println("<Voltar ao inicio?>");
				menu = sc.next();

			}else if (menu.equalsIgnoreCase("D")) {
				System.out.println("Digite o numero da tarefa");
				Integer idTarefa = sc.nextInt();
				System.out.println("Digite o numero do prestador");
				Integer idPrestador = sc.nextInt();
				System.out.println("Digite o percentual");
				Integer percentual = sc.nextInt();
				atividadeBO.carregar(idTarefa);
				atividadeBO.informaPercentual(idPrestador, percentual);
				atividadeBO.gravar();
				System.out.println(idPrestador + " " + percentual);
				System.out.println("<Voltar ao inicio?>");
				menu =sc.next();
			}
		}while(menu.equalsIgnoreCase("sim"));
	}
	private static void mostraListaTarefa(AtividadeBO ativBO, PessoaBO pesBO) {
		for(Integer i : ativBO.atividadeMap.keySet()) {
			PessoaBean pesRequisiBean = pesBO.pessoaMap.get(ativBO.atividadeMap.get(i).getPessoaRequisitante().getId());
			String prestadores = ativBO.getPrestadores(i);
			if(prestadores == null) {
				System.out.println(ativBO.atividadeMap.get(i).getId() + "-" + pesRequisiBean.getNome() + "-" + ativBO.atividadeMap.get(i).getNomeTarefa());
			}else {
				System.out.println(ativBO.atividadeMap.get(i).getId() + "-" + pesRequisiBean.getNome() + "-" + ativBO.atividadeMap.get(i).getNomeTarefa() + "-" + prestadores);
			}
		}		
	}
}
