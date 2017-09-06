package model;

public class Produto {
	String nome;
	private int codigo;
	private int id;
	private String descricao;
	private float duracao;
	
	public Produto() {
		super();
	}
	
	public Produto(int id, String nome, String descricao, int codigo, float duracao){
		this.nome = nome;
		this.codigo = codigo;
		this.id = id;
		this.descricao = descricao;
		this.duracao = duracao;
	}
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", codigo=" + codigo + ", id=" + id + ", descricao=" + descricao + ", duracao="
				+ duracao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + Float.floatToIntBits(duracao);
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (Float.floatToIntBits(duracao) != Float.floatToIntBits(other.duracao))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public float getDuracao() {
		return duracao;
	}

	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}
}
