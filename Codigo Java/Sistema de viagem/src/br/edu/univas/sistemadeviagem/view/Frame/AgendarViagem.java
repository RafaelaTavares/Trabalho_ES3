package br.edu.univas.sistemadeviagem.view.Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import br.edu.univas.sistemadeviagem.model.DAO.AgendarViagemDAO;
import br.edu.univas.sistemadeviagem.model.Exception.AgendarViagemException;
import br.edu.univas.sistemadeviagem.model.TO.AgendarViagemTO;
import br.edu.univas.sistemadeviagem.view.Util.Frame;

public class AgendarViagem extends JFrame{

	private static final long serialVersionUID = 5989131292707356488L;
	
	private JPanel contentPane = null;
	//Declarações no corpo da classe
		JLabel status = new JLabel();
		JTextField textCod = new JTextField();			
		JTextField textEndereco = new JTextField();
		JTextField textRua = new JTextField();
		JTextField textNumero = new JTextField();
		JTextField textCep = new JTextField();
		JTextField textComplemento = new JTextField();
		JTextField textCidade = new JTextField();
		JTextField textValorViagem = new JTextField();
		JTextField textQuantPass = new JTextField();
		JTextField textCodResp = new JTextField();
		JTextField textValorPass = new JTextField();
		JRadioButton agendadaRadioButton = new JRadioButton();
	    JRadioButton canceladaRadioButton = new JRadioButton();
	    JRadioButton realizadaRadioButton = new JRadioButton();
//	    JFormattedTextField dateSaidaTextField = new JFormattedTextField();
//		JFormattedTextField dateRetornoTextField = new JFormattedTextField();
		JFormattedTextField horaSaidaTextField = new JFormattedTextField();
		JFormattedTextField horaRetornoTextField = new JFormattedTextField();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	//Fim declarações	
	
	public AgendarViagem(){
		this.setSize(470, 470);
		this.setTitle("Agendar Viagem");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	//	setResizable(false);
		addComponents();
	}
	
	public void addComponents(){
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.LIGHT_GRAY);
		centerPanel.setPreferredSize(new Dimension(25, 0));
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		JLabel codVeiculo = new JLabel();
		codVeiculo.setText("Código:");
		centerPanel.add(codVeiculo);
				
		textCod.setColumns(4);
		centerPanel.add(textCod);
		
		JButton f2 = new JButton();
		f2.setText("F2");
		f2.setPreferredSize(new Dimension(26, 20));
		centerPanel.add(f2);
		
		JLabel vazio = new JLabel();
		vazio.setText("                                                                         ");
		vazio.setBorder(new EmptyBorder(-10, 0, 30, 0));
		centerPanel.add(vazio);
		
		JLabel dadosViagem = new JLabel();
		dadosViagem.setText("DADOS DA VIAGEM                                              ");
		dadosViagem.setBorder(new EmptyBorder(0, 0, 0, 130));
		dadosViagem.setFont(new Font("Arial", Font.BOLD, 11));
		dadosViagem.setForeground(Color.GRAY);
		centerPanel.add(dadosViagem);
		
		JLabel testLinha = new JLabel();
		testLinha.setText("______________________________________________________");
		testLinha.setForeground(Color.GRAY);
		testLinha.setBorder(new EmptyBorder(-13, 0, 10, 0));
		centerPanel.add(testLinha);
		
		JLabel dataSaida = new JLabel();
		dataSaida.setText("Data Saída:");
		centerPanel.add(dataSaida);
		
		JDateChooser calSaida = new JDateChooser();
		centerPanel.add(calSaida);
		
		JLabel dataRetorno = new JLabel();
		dataRetorno.setText("Data Retorno:");
		centerPanel.add(dataRetorno);
		
		JDateChooser calRetorno = new JDateChooser();
		centerPanel.add(calRetorno);
		
		JLabel hrSaida = new JLabel();
		hrSaida.setText("Hora Saída:");
		hrSaida.setBorder(new EmptyBorder(10,0, 10, 0));
		centerPanel.add(hrSaida);
		
		DateFormat formatHoraSaida = new SimpleDateFormat("HH:mm:ss");
	    horaSaidaTextField.setColumns(6);
	    try {
			MaskFormatter mascaraHora = new MaskFormatter("## : ## : ## ");
			mascaraHora.setPlaceholderCharacter('_');
			mascaraHora.install(horaSaidaTextField);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    centerPanel.add(horaSaidaTextField);
		
		JLabel hrRetorno = new JLabel();
		hrRetorno.setText("Hora Retorno:");
		hrRetorno.setBorder(new EmptyBorder(10, 30, 10, 0));
		centerPanel.add(hrRetorno);
	    
	    DateFormat formatHoraRetorno = new SimpleDateFormat("HH:mm:ss");
	    
	    //TODO RETIRAR
//	    formatHoraRetorno.getNumberFormat().
	    
	    horaRetornoTextField.setColumns(6);
	    try {
			MaskFormatter mascaraHora = new MaskFormatter("## : ## : ## ");
			mascaraHora.setPlaceholderCharacter('_');
			mascaraHora.install(horaRetornoTextField);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    centerPanel.add(horaRetornoTextField);
			    
	    JLabel quantPassViagem = new JLabel();
		quantPassViagem.setText("Quantidade de Passageiros:");
		quantPassViagem.setBorder(new EmptyBorder(0, 0, 10, 0));
		centerPanel.add(quantPassViagem);
		
		JLabel codClienteResp = new JLabel();
		codClienteResp.setText("    Cod. Cliente Responsável:");
		codClienteResp.setBorder(new EmptyBorder(0, 0, 10, 0));
		centerPanel.add(codClienteResp);
		
		textQuantPass.setColumns(15);
		centerPanel.add(textQuantPass);
		
		textCodResp.setColumns(15);
		centerPanel.add(textCodResp);
		
		JLabel valorViagem = new JLabel();
		valorViagem.setText("Valor Total:");
		valorViagem.setBorder(new EmptyBorder(10, 0, 10, 0));
		centerPanel.add(valorViagem);
		
		textValorViagem.setColumns(5);
		centerPanel.add(textValorViagem);					
			
		JLabel valorPassagem = new JLabel();
		valorPassagem.setText("Valor Passagem:");
		valorPassagem.setBorder(new EmptyBorder(10, 0, 10, 0));
		centerPanel.add(valorPassagem);
		
		textValorPass.setColumns(5);
		centerPanel.add(textValorPass);		
		
		JLabel dadosEndereco = new JLabel();
		dadosEndereco.setText("DADOS DO ENDEREÇO                                              ");
		dadosEndereco.setBorder(new EmptyBorder(10, 0, 0, 115));
		dadosEndereco.setFont(new Font("Arial", Font.BOLD, 11));
		dadosEndereco.setForeground(Color.GRAY);
		centerPanel.add(dadosEndereco);
		
		JLabel testLinha2 = new JLabel();
		testLinha2.setText("______________________________________________________");
		testLinha2.setForeground(Color.GRAY);
		testLinha2.setBorder(new EmptyBorder(-13, 0, 0, 0));
		centerPanel.add(testLinha2);		
		
		JLabel rua = new JLabel();
		rua.setText("Av/Rua:");
		rua.setBorder(new EmptyBorder(10,0, 10, 0));
		centerPanel.add(rua);
		
		textRua.setColumns(20);
		centerPanel.add(textRua);
		
		JLabel numero = new JLabel();
		numero.setText("Nº:");
		numero.setBorder(new EmptyBorder(10,0, 10, 0));
		centerPanel.add(numero);
		
		textNumero.setColumns(3);
		centerPanel.add(textNumero);
		
		JLabel cep = new JLabel();
		cep.setText("     CEP:");
		cep.setBorder(new EmptyBorder(10,0, 10, 0));
		centerPanel.add(cep);
		
		textCep.setColumns(6);
		centerPanel.add(textCep);
		
		JLabel cidade = new JLabel();
		cidade.setText("Cidade:");
		cidade.setBorder(new EmptyBorder(10,0, 10, 0));
		centerPanel.add(cidade);
		
		textCidade.setColumns(13);
		centerPanel.add(textCidade);
		
		JLabel dadosStatus = new JLabel();
		dadosStatus.setText("STATUS                                              ");
		dadosStatus.setBorder(new EmptyBorder(0, 0, 0, 185));
		dadosStatus.setFont(new Font("Arial", Font.BOLD, 11));
		dadosStatus.setForeground(Color.GRAY);
		centerPanel.add(dadosStatus);
		
		JLabel testLinha3 = new JLabel();
		testLinha3.setText("______________________________________________________");
		testLinha3.setForeground(Color.GRAY);
		testLinha3.setBorder(new EmptyBorder(-13, 0, 0, 0));
		centerPanel.add(testLinha3);
		
		
		status.setText("                     Selecione o status da viagem:"
				+ "                      ");
		status.setFont(new Font("Dialog", Font.CENTER_BASELINE, 14));
		centerPanel.add(status);
	
		
		agendadaRadioButton.setText("Agendada");
		agendadaRadioButton.setBackground(Color.lightGray);
		
		canceladaRadioButton.setText("Cancelada");
	    canceladaRadioButton.setBackground(Color.lightGray);
	    
	    realizadaRadioButton.setText("Realizada");
	    realizadaRadioButton.setBackground(Color.lightGray);
	    
	    ButtonGroup group = new ButtonGroup();
	    group.add(agendadaRadioButton);
	    group.add(canceladaRadioButton);
	    group.add(realizadaRadioButton);
	    
	    centerPanel.add(agendadaRadioButton);
	    centerPanel.add(canceladaRadioButton);
	    centerPanel.add(realizadaRadioButton);
		
		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.DARK_GRAY);
		westPanel.setPreferredSize(new Dimension(80,0));
		westPanel.setBorder(new EmptyBorder(120, 0, 0, 0));
		contentPane.add(westPanel, BorderLayout.WEST);
		
		JButton incluir = new JButton();
		incluir.setText("Incluir");
		incluir.setPreferredSize(new Dimension(70, 25));
		westPanel.add(incluir);
		
		JButton alterar = new JButton();
		alterar.setText("Alterar");
		alterar.setPreferredSize(new Dimension(70, 25));
		westPanel.add(alterar);
		
		JButton excluir = new JButton();
		excluir.setText("Excluir");
		excluir.setPreferredSize(new Dimension(70, 25));
		westPanel.add(excluir);
		
		JButton gravar = new JButton();
		gravar.setText("Gravar");
		gravar.setPreferredSize(new Dimension(70, 25));
		gravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gravarAgendarViagem();
			}

			private void gravarAgendarViagem() {
				//TODO retirar
				System.out.println( formatHoraRetorno   );
				
				//Extraindo informações dos campos
				int codViagem = Integer.valueOf(textCod.getText()); //Transformando String em Int
				String endereco = textEndereco.getText();
				int quantPassageiro = Integer.valueOf(textQuantPass.getText()); //Transformando String em Int
				Date horaSaida = Date.valueOf(horaSaidaTextField.getText().replaceAll("\\D",""));
				Date horaRetorno  = Date.valueOf(horaRetornoTextField.getText().replaceAll("\\D",""));
				float valorViagem = Float.valueOf(textValorViagem.getText()); //Transformando String em Float
				int statusViagem = 0;
				if (agendadaRadioButton.isSelected()){
					statusViagem = 1;
				}
				
				if(canceladaRadioButton.isSelected()){
					statusViagem = 2;
				}
				
				if(realizadaRadioButton.isSelected()){
					statusViagem = 3;
				}
				
				//Montando TO
				AgendarViagemTO viagem = new AgendarViagemTO(codViagem, endereco, quantPassageiro, calSaida, calRetorno, horaSaida, horaRetorno, statusViagem, valorViagem);
				
				//Inserindo usuario no banco de dados - Sem uso de controller.
				AgendarViagemDAO dao = new AgendarViagemDAO();				
					try {
						dao.insertNewAgendarViagem(viagem);
					} catch (AgendarViagemException e) {
						e.printStackTrace();
					}//Enviando to para o banco de dados.
					
				if(statusViagem ==1){	
					JOptionPane.showMessageDialog(null, "Viagem agendada com sucesso!");
				}
				
				if(statusViagem == 2){
					JOptionPane.showMessageDialog(null, "Viagem cancelada com sucesso!");
				}
				
				if(statusViagem == 3){
					JOptionPane.showMessageDialog(null, "Viagem realizada com sucesso!");
				}	
					
			}

			private JDateChooser Timestamp(long time) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		westPanel.add(gravar);
		
		JButton cancelar = new JButton();
		cancelar.setText("Cancelar");
		cancelar.setPreferredSize(new Dimension(70, 25));
		westPanel.add(cancelar);
	}
		
	public static void main(String[] args){
		Frame.setlookAndFeel(Frame.ACRYL);
		AgendarViagem tela = new AgendarViagem();
		tela.setVisible(true);
	}
}
