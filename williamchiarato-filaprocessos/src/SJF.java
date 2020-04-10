import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//modelo SJF que simula os processos por tamanho
public class SJF extends JFrame{
	
	private Processo fila[];
	private int quant, soma = 0, soma1 = 0;
	private double tempo_medio, t_resposta_medio;
    Container painel;
    JButton botao;
    TextField quantidade;
    List processo, execucao, espera, resposta;
    JLabel l_quant, l_processo, l_tempoExecucao, l_espera, l_resposta, l_tMedio, l_respostaM;
    
    //painel
	SJF(){
		this.painel = getContentPane();
		this.painel.setLayout(null);
		this.botao = new JButton("Calcular");
		this.quantidade = new TextField();
		this.l_quant = new JLabel("Quantidade de processos");
		this.painel.add(botao);
		this.painel.add(quantidade);
		this.painel.add(l_quant);
		this.botao.setBounds(150,50,200,50);
		this.quantidade.setBounds(10,50,50,25);
		this.l_quant.setBounds(10,20,150,25);
		setTitle("Tamanho - SJF");
		setSize(450,450);
		setVisible(true);
		calcular();
	}
	
	//calcula e modifica o painel para mostrar o resultado
	private void calcular(){
       botao.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent evento) {
                   botao.setVisible(false);
                   quant = Integer.parseInt(quantidade.getText());
                   fila = new Processo[quant];
                   processo = new List(quant);
                   execucao = new List(quant);
                   espera = new List(quant);
                   resposta = new List(quant);
                   l_processo = new JLabel("Processo");
                   l_tempoExecucao = new JLabel("Tempo Execução");
                   l_espera = new JLabel("Espera");
                   l_resposta = new JLabel("Resposta");
                                      
                   for(int x = 0; x < quant; x++){
                	   int exec = Integer.parseInt(JOptionPane.showInputDialog("Tempo de execução do Processo " + x));
                	   fila[x] = new Processo("P" + x, exec);
                   }
                   
                   ordenar();
                   calculaEspera();
                   painel.add(processo);
                   painel.add(execucao);
                   painel.add(espera);
                   painel.add(resposta);
                   painel.add(l_processo);
                   painel.add(l_tempoExecucao);
                   painel.add(l_espera);
                   painel.add(l_resposta);
                   processo.setBounds(10,200,50,(quant*20));
                   execucao.setBounds(100,200,50,(quant*20));
                   espera.setBounds(190,200,50,(quant*20));
                   resposta.setBounds(280,200,50,(quant*20));
                   l_processo.setBounds(10,180,60,25);
                   l_tempoExecucao.setBounds(100,180,50,25);
                   l_espera.setBounds(190,180,50,25);
                   l_resposta.setBounds(280,180,70,25);
                   Resultado();
                   
            }
       });
	}
	
	//calcula o tempo de espera
	private void calculaEspera(){
		this.fila[0].setEspera(0);
		for(int x = 1; x < this.quant; x++){
			this.fila[x].setEspera(this.fila[x - 1].getExec()+this.fila[x - 1].getEspera());
		}
	}
	
	//ordena da maneira correta de acordo com o tamanho
	public void ordenar(){
		for(int x = 0; x < this.quant; x++){
			for(int y = 0; y <= x; y++){
				if(this.fila[x].getExec() < this.fila[y].getExec()){
					Processo aux = this.fila[x];
					this.fila[x] = this.fila[y];
					this.fila[y] = aux;
				}
			}
		}
	}
	
	//mostra o resultado
	public void Resultado(){
		for(int x = 0; x < this.quant; x++){
			this.processo.add(this.fila[x].getNome());
			this.execucao.add(""+this.fila[x].getExec());
			this.espera.add(""+this.fila[x].getEspera());
			this.resposta.add(""+(this.fila[x].getExec()+this.fila[x].getEspera()));
			this.soma+= this.fila[x].getEspera();
			this.soma1 = this.fila[x].getExec()+this.fila[x].getEspera();
		}
		
		this.tempo_medio = (double) this.soma / this.quant;
		this.t_resposta_medio = (double) this.soma1 / this.quant;
		this.l_tMedio = new JLabel(String.format("Tempo de espera media: %.2f",this.tempo_medio));
		this.l_respostaM = new JLabel(String.format("Tempo de resposta medio: %.2f",this.t_resposta_medio));
		this.painel.add(this.l_tMedio);
		this.painel.add(this.l_respostaM);
		this.l_tMedio.setBounds(10, 300, 210, 30);
		this.l_respostaM.setBounds(10, 330, 210, 30);
		
	}
}
