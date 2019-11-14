package entidades;

public class Fornecedor {
	private int codigo;
	private String nome;
	private String telefone;
	private String cnpj;
	private String rua;
	private String bairro;
	private String cep;

	public Fornecedor() {}

	public Fornecedor(String nome, String telefone, String cnpj, String rua, String bairro, String cep) {
		this.nome = nome;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
