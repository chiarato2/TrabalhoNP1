import java.awt.Container;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

//modelo FCFS que simula os processos por chegada
public class FCFS extends JFrame{
	
	public Processo fila[];
	public int quant, soma = 0, soma1 = 0;
	public double tempo_medio, t_resposta_medio;
	Container painel;
	JButton botao;
	TextField quantidade;
	JLabel l_quant, l_processo, l_tempoExecucao,l_espera, l_tempo_medio, l_resposta, l_resposta_media;
	List processo, execucao, espera, resposta;
	
	//painel
	FCFS(){
		this.painel = getContentPane();
		this.painel.setLayout(null);
		this.botao = new JButton("Calcular");
		this.quantidade = new TextField();
		this.l_quant = new JLabel("Quantidade de Processos");
		this.painel.add(botao);
		this.painel.add(quantidade);
		this.painel.add(l_quant);
		this.botao.setBounds(150,50,200,50);
		this.quantidade.setBounds(10,50,50,25);
		this.l_quant.setBounds(10,20,150,25);
		setTitle("Chegada - FCFS");
		setSize(450, 450);
		setVisible(true);
		calcular();
	}
	
	//calcula e modifica o painel para mostrar o resultado
	public void calcular() {
		botao.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent evento) {
            	botao.setVisible(false);
            	quant = Integer.parseInt(quantidade.getText());
            	processo = new List(quant,false);
            	execucao = new List(quant,false);
            	espera = new List(quant,false);
            	resposta = new List(quant,false);
            	l_processo = new JLabel("Processos");
            	l_tempoExecucao = new JLabel("Tempo Execução");
            	l_espera = new JLabel("Espera");
            	l_resposta = new JLabel("Resposta");
            	fila = new Processo[quant];
            	
            	for(int x = 0; x < quant; x++){
             	   int exec = Integer.parseInt(JOptionPane.showInputDialog("Tempo de execução do Processo " + x));
             	   fila[x] = new Processo("P" + x, exec);
                }
            	
            	calculaEspera();
            	painel.add(processo);
                painel.add(execucao);
                painel.add(espera);
                painel.add(resposta);
                painel.add(l_processo);
                painel.add(l_tempoExecucao);
                painel.add(l_espera);
                painel.add(l_resposta);
                processo.setBounds(10,200,50,(quant * 20));
                execucao.setBounds(100,200,50,(quant * 20));
                espera.setBounds(190,200,50,(quant * 20));
                resposta.setBounds(280,200,50,(quant * 20));
                l_processo.setBounds(10,180,60,25);
                l_tempoExecucao.setBounds(100,180,50,25);
                l_espera.setBounds(190,180,50,25);
                l_resposta.setBounds(280,180,70,25);
                Resultado();
            }
		}
	  );
	}
	
	//calcula o tempo de espera
	private void calculaEspera(){
		this.fila[0].setEspera(0);
		for(int x = 1; x < this.quant; x++){
			this.fila[x].setEspera(this.fila[x - 1].getExec() + this.fila[x - 1].getEspera());
		}
	}
	
	//mostra o resultado
	private void Resultado() {
		for(int x = 0; x < this.quant; x++){
			this.processo.add(this.fila[x].getNome());
			this.execucao.add(""+this.fila[x].getExec());
			this.espera.add(""+this.fila[x].getEspera());
			this.soma1 += this.fila[x].getExec() + this.fila[x].getEspera();
			this.resposta.add(""+(this.fila[x].getExec()+this.fila[x].getEspera()));
			this.soma+= this.fila[x].getEspera();
		}
		
		this.tempo_medio = (double)this.soma / this.quant;
		this.l_tempo_medio = new JLabel("Tempo Medio de espera: " + this.tempo_medio);
		this.painel.add(this.l_tempo_medio);
		this.l_tempo_medio.setBounds(10, 300, 210, 30);
		this.t_resposta_medio =(double) this.soma1 / this.quant;
		this.l_resposta_media = new JLabel("Tempo de resposta Medio: " + this.t_resposta_medio);
		this.painel.add(this.l_resposta_media);
		this.l_resposta_media.setBounds(10, 330, 210, 30);
	}
}

