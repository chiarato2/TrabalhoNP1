import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//menu principal
public class Main extends JFrame{
	
	JButton Prioridade;
	JButton FCFS;
	JButton SJF;
	
	//criação do JFrame inicial
	Main(){
		Container painel = getContentPane();
		painel.setLayout(null);

		this.Prioridade = new JButton("Prioridade");
		this.FCFS = new JButton("Chegada");
		this.SJF = new JButton("Tamanho");

		painel.add(this.Prioridade);
		painel.add(this.FCFS);
		painel.add(this.SJF);

		this.Prioridade.setBounds(100,20,200,50);
		this.FCFS.setBounds(100,100,200,50);
		this.SJF.setBounds(100,180,200,50);

		setSize(420,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Prioridade_Click();
		FCFS_Click();
		SJF_Click();
	}
	
	//função para chamar a classe Prioridade
	private void Prioridade_Click(){
		Prioridade.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent evento) {
            	Prioridade prioridade = new Prioridade();	 
            }
       });
	}
	
	//função para chamar a classe FCFS
	private void FCFS_Click(){
		FCFS.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evento) {
            	FCFS fcfs = new FCFS();	 
            }
       });
	}
	
	//função para chamar a classe SJF
	private void SJF_Click(){
		SJF.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evento){
            	SJF sjf = new SJF();	 
            }
       });
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		
	}
}