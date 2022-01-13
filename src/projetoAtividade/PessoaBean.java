package projetoAtividade;

public class PessoaBean {
private	Integer id;
private String nome;
private Integer idade;
private String email;
private String endereco;
private Integer tipo;
private String cidade;
private String bairro;
private String nomeRua;
private Integer numeroCasa;

public String getCidade() {
	return cidade;
}
public void setCidade(String cidade) {
	this.cidade = cidade;
}
public Integer getTipo() {
	return tipo;
}
public void setTipo(Integer tipo) {
	this.tipo = tipo;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getIdade() {
	return idade;
}
public void setIdade(Integer idade) {
	this.idade = idade;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getBairro() {
	return bairro;
}
public void setBairro(String bairro) {
	this.bairro = bairro;
}
public String getNomeRua() {
	return nomeRua;
}
public void setNomeRua(String nomeRua) {
	this.nomeRua = nomeRua;
}
public Integer getNumeroCasa() {
	return numeroCasa;
}
public void setNumeroCasa(Integer numeroCasa) {
	this.numeroCasa = numeroCasa;
}
}
