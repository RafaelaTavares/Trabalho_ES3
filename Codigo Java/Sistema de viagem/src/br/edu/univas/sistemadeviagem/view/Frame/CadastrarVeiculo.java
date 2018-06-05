package br.edu.univas.sistemadeviagem.view.Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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

import br.edu.univas.sistemadeviagem.model.DAO.CadastrarMotoristaDAO;
import br.edu.univas.sistemadeviagem.model.DAO.CadastrarVeiculoDAO;
import br.edu.univas.sistemadeviagem.model.Exception.CadastrarMotoristaException;
import br.edu.univas.sistemadeviagem.model.Exception.CadastrarVeiculoExeption;
import br.edu.univas.sistemadeviagem.model.TO.CadastrarMotoristaTO;
import br.edu.univas.sistemadeviagem.model.TO.CadastrarVeiculoTO;
import br.edu.univas.sistemadeviagem.view.Util.Frame;

public class CadastrarVeiculo extends Frame {

	private static final long serialVersionUID = 2290132802087387747L;
	
	private JPanel contentPane = null;
	//Declara��es no corpo da classe
			JTextField textCod = new JTextField();
		//	JTextField textPlaca = new JTextField();
			JTextField textUF = new JTextField();
			JTextField textAno = new JTextField();
			JTextField textMarca = new JTextField();			
			JTextField textPassageiro = new JTextField();
			JLabel tipoCombVeiculo = new JLabel();
			JRadioButton diselRadioButton = new JRadioButton();
		    JRadioButton etanolRadioButton = new JRadioButton();
		    JRadioButton gasolinaRadioButton = new JRadioButton();
		    JFormattedTextField JFormatTextFieldPlaca = new JFormattedTextField();
		//Fim declara��es
	
	
	public CadastrarVeiculo(){
		this.setSize(470, 305);
		this.setTitle("Cadastro de Ve�culo");
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
		
		JLabel codMotorista = new JLabel();
		codMotorista.setText("C�digo:");
		centerPanel.add(codMotorista);
				
		textCod.setColumns(4);
		centerPanel.add(textCod);
		
		JButton f2 = new JButton();
		f2.setText("F2");
		f2.setPreferredSize(new Dimension(26, 20));
		centerPanel.add(f2);
		
		JLabel vazio = new JLabel();
		vazio.setText("                                                                          ");
		centerPanel.add(vazio);
		
		JLabel placaVeiculo = new JLabel();
		placaVeiculo.setBorder(new EmptyBorder(10, 50, 0, 0));
		placaVeiculo.setText("Placa: ");
		//placaVeiculo.setFont(new Font("Dialog", Font.PLAIN, 14));
		centerPanel.add(placaVeiculo);
		
		JLabel ufVeiculo = new JLabel();
		ufVeiculo.setBorder(new EmptyBorder(10, 40, 0, 60));
		ufVeiculo.setText("                          UF: ");
		centerPanel.add(ufVeiculo);			
				
//		textPlaca.setColumns(12);
//		centerPanel.add(textPlaca);
		
		JFormatTextFieldPlaca.setColumns(12);
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("UUU-####");
		//	mascaraCpf.setPlaceholderCharacter('_');
			mascaraCpf.install(JFormatTextFieldPlaca);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		centerPanel.add(JFormatTextFieldPlaca);
		
		textUF.setColumns(12);
		try {
			MaskFormatter mascaraUf = new MaskFormatter("UU");
			mascaraUf.setPlaceholderCharacter('_');
			//mascaraUf.install(textUF);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		centerPanel.add(textUF);
		
		JLabel anoVeiculo = new JLabel();
		anoVeiculo.setBorder(new EmptyBorder(10, 40, 0, 0));
		anoVeiculo.setText("         Ano: ");
		centerPanel.add(anoVeiculo);
		
		JLabel marcaVeiculo = new JLabel();
		marcaVeiculo.setBorder(new EmptyBorder(10, 80, 0, 60));
		marcaVeiculo.setText("     Marca: ");
		centerPanel.add(marcaVeiculo);
		
		textAno.setColumns(12);
		centerPanel.add(textAno);
		
		textMarca.setColumns(12);
		centerPanel.add(textMarca);
				
		JLabel quantPassVeiculo = new JLabel();
		quantPassVeiculo.setBorder(new EmptyBorder(10, 0, 0, 10));
		quantPassVeiculo.setText("                                                         Quantidade de Passageiros: "
				+ "                                                       ");
		centerPanel.add(quantPassVeiculo);
		
		textPassageiro.setColumns(24);
		centerPanel.add(textPassageiro);
		
		tipoCombVeiculo.setBorder(new EmptyBorder(10, 10, 0, 10));
		tipoCombVeiculo.setText("                       Selecione o tipo de combust�vel: "
				+ "                     ");
		tipoCombVeiculo.setFont(new Font("Dialog", Font.CENTER_BASELINE, 14));
		centerPanel.add(tipoCombVeiculo);
		
		diselRadioButton.setText("Disel");
		diselRadioButton.setBackground(Color.lightGray);
		diselRadioButton.setSelected(false);
		
		etanolRadioButton.setText("Etanol");
	    etanolRadioButton.setBackground(Color.lightGray);
	    
	    gasolinaRadioButton.setText("Gasolina");
	    gasolinaRadioButton.setBackground(Color.lightGray);

	    ButtonGroup group = new ButtonGroup();
	    group.add(diselRadioButton);
	    group.add(etanolRadioButton);
	    group.add(gasolinaRadioButton);
	    
	    centerPanel.add(diselRadioButton);
	    centerPanel.add(etanolRadioButton);
	    centerPanel.add(gasolinaRadioButton);
		
//		JLabel labelPeriodOfTheDay = new JLabel();
//		labelPeriodOfTheDay.setText("Selecione um per�odo: ");
//		centerPanel.add(labelPeriodOfTheDay);
		
//		JComboBox<String> courseComboBox = new JComboBox<>();
//		courseComboBox.addItem("1 - Gasolina");
//		courseComboBox.addItem("2 - Etanol");
//		courseComboBox.addItem("3 - Disel");
//		
//		courseComboBox.setPreferredSize(new Dimension(130, 20));		
//		centerPanel.add(courseComboBox);
		
	    JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.DARK_GRAY);
		westPanel.setPreferredSize(new Dimension(80,0));
		westPanel.setBorder(new EmptyBorder(50, 0, 0, 0));
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
		excluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				excluirAgendarViagem();
				
			}

			private void excluirAgendarViagem() {
				//Extraindo informa��es dos campos
					int codVeiculo = Integer.valueOf(textCod.getText()); //Transformando String em Int
					String placa = JFormatTextFieldPlaca.getText().replaceAll("\\D","");
					String marca = textMarca.getText();
					String uf = textUF.getText();
					int ano = Integer.valueOf(textAno.getText()); //Transformando String em Int
					int quantPassageiro = Integer.valueOf(textPassageiro.getText()); //Transformando String em Int
					int tipoComb = 0;
					if(diselRadioButton.isSelected()){
						tipoComb = 1;
					}
					if(etanolRadioButton.isSelected()){
						tipoComb = 2;
					}
					if(gasolinaRadioButton.isSelected()){
						tipoComb = 3;
					}
					
				//Montando TO
					CadastrarVeiculoTO veiculo = new CadastrarVeiculoTO(codVeiculo, placa, marca, uf, ano, tipoComb, quantPassageiro);
				
				//Inserindo usuario no banco de dados - Sem uso de controller.
					CadastrarVeiculoDAO dao = new CadastrarVeiculoDAO();
							try {
								dao.deleteCadastrarVeiculo(codigo);
							} catch (CadastrarVeiculoExeption e) {
								e.printStackTrace();
							}
			}
		});
		westPanel.add(excluir);
		
		JButton gravar = new JButton();
		gravar.setText("Gravar");
		gravar.setPreferredSize(new Dimension(70, 25));
		gravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gravarVeiculo();
				
			}

			private void gravarVeiculo() {
				//Extraindo informa��es dos campos
				int codVeiculo = Integer.valueOf(textCod.getText()); //Transformando String em Int
				String placa = JFormatTextFieldPlaca.getText().replaceAll("\\D","");
				String marca = textMarca.getText();
				String uf = textUF.getText();
				int ano = Integer.valueOf(textAno.getText()); //Transformando String em Int
				int quantPassageiro = Integer.valueOf(textPassageiro.getText()); //Transformando String em Int
				int tipoComb = 0;
				if(diselRadioButton.isSelected()){
					tipoComb = 1;
				}
				if(etanolRadioButton.isSelected()){
					tipoComb = 2;
				}
				if(gasolinaRadioButton.isSelected()){
					tipoComb = 3;
				}
								
				//Montando TO
				CadastrarVeiculoTO veiculo = new CadastrarVeiculoTO(codVeiculo, placa, marca, uf, ano, tipoComb, quantPassageiro);
	
				//Inserindo usuario no banco de dados - Sem uso de controller.
				CadastrarVeiculoDAO dao = new CadastrarVeiculoDAO();
				try {
						dao.insertNewCadastrarVeiculo(veiculo);
					} catch (CadastrarMotoristaException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//Enviando to para o banco de dados.			
				
				JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!");					
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
		CadastrarVeiculo tela = new CadastrarVeiculo();
		tela.setVisible(true);
	}

}
