
//classe construtora que simula um processo
public class Processo{
	private String nome;
	private int tempo_execucao;
	private int executado;
	private int tempo_espera;
	private int prioridade;
	private int te;
	private boolean ultimo_exec;
	
	Processo(String nome, int execucao){
		this.nome = nome;
		this.tempo_execucao = execucao;
		this.executado = execucao;
		this.tempo_espera = 0;
		this.te = 0;
		this.prioridade = 0;
	}

	public int getExec(){
		return this.tempo_execucao;
	}
	
	public void setEspera(int espera){
		this.tempo_espera += espera;
	}
	
	public int getEspera(){
		return this.tempo_espera;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setPrioridade(int prio){
		this.prioridade = prio;
	}
	
	public int getPrioridade(){
		return this.prioridade;
	}
	
	public void Executado(){
		this.executado = this.executado -1;
	}
	
	public void Executado(int x){
		this.executado = this.executado - x;
	}
	
	public int getExecutado(){
		return this.executado;
	}
	
	public void setUltimo(boolean num){
		this.ultimo_exec = num;
	}
	
	public boolean getUltimo(){
		return this.ultimo_exec;
	}
	
	public boolean isUltimo(){
		if(this.getExecutado() == 0)
			return true;
		return false;
	}
	
	public void setTe(int te){
		this.te = te;
	}
	
	public int getTe(){
		return this.te;
	}
}

