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
import br.edu.univas.sistemadeviagem.model.Exception.CadastrarMotoristaException;
import br.edu.univas.sistemadeviagem.model.TO.CadastrarMotoristaTO;
import br.edu.univas.sistemadeviagem.view.Util.Frame;

public class CadastrarMotorista extends JFrame {

	private static final long serialVersionUID = 6310151249155187434L;

	private JPanel contentPane = null;
	//Declarações no corpo da classe
		JTextField textCod = new JTextField();
		JTextField textNome = new JTextField();
		JTextField textRG = new JTextField();
		JTextField textCNH = new JTextField();		
		JTextField textEndereco = new JTextField();
		JFormattedTextField JFormatTextFieldCpf =  new JFormattedTextField();		
		JFormattedTextField JFormatTextFieldTelefone = new JFormattedTextField();
		JRadioButton catARadioButton = new JRadioButton();
	    JRadioButton catBRadioButton = new JRadioButton();
	    JRadioButton catCRadioButton = new JRadioButton();
	    JRadioButton catDRadioButton = new JRadioButton();
	    JRadioButton catERadioButton = new JRadioButton();
	//Fim declarações
	
	public CadastrarMotorista(){
		
		this.setSize(470, 305);
		this.setTitle("Cadastro de Motorista");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(false);
		addComponents();
	}
	
	
	private void addComponents(){
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.LIGHT_GRAY);
		centerPanel.setPreferredSize(new Dimension(25, 0));
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		JLabel codMotorista = new JLabel();
		codMotorista.setText("Código:");
		centerPanel.add(codMotorista);
				
		textCod.setColumns(4);
		centerPanel.add(textCod);
		
		JButton f2 = new JButton();
		f2.setText("F2");
		f2.setPreferredSize(new Dimension(26, 20));
		centerPanel.add(f2);
		
		JLabel vazio = new JLabel();
		vazio.setText("                                                                         ");
		centerPanel.add(vazio);

		
		JLabel nomeMotorista = new JLabel();
		nomeMotorista.setBorder(new EmptyBorder(10, 0, 0, 0));
		nomeMotorista.setText("                        Nome:");
		centerPanel.add(nomeMotorista);
		
		JLabel cpfMotorista = new JLabel();
		cpfMotorista.setBorder(new EmptyBorder(10, 0, 0, 0));
		cpfMotorista.setText("                                                CPF:");
		centerPanel.add(cpfMotorista);
		
		textNome.setColumns(24);
		centerPanel.add(textNome);
		
		JFormatTextFieldCpf.setColumns(8);
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');
			mascaraCpf.install(JFormatTextFieldCpf);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		centerPanel.add(JFormatTextFieldCpf);
		
		JLabel rgMotorista = new JLabel();
		rgMotorista.setBorder(new EmptyBorder(10, 0, 0, 0));
		rgMotorista.setText("          RG:");
		centerPanel.add(rgMotorista);
		
		JLabel cnhMotorista = new JLabel();
		cnhMotorista.setBorder(new EmptyBorder(10, 0, 0, 0));
		cnhMotorista.setText("                                               Nº CNH:");
		centerPanel.add(cnhMotorista);
				
		textRG.setColumns(16);
		centerPanel.add(textRG);
		
		textCNH.setColumns(16);
		centerPanel.add(textCNH);
			
		JLabel telefoneMotorista = new JLabel();
		telefoneMotorista.setBorder(new EmptyBorder(10, 0, 0, 0));
		telefoneMotorista.setText("    Telefone:");
		centerPanel.add(telefoneMotorista);
		
		JLabel enderecoMotorista = new JLabel();
		enderecoMotorista.setBorder(new EmptyBorder(10, 0, 0, 0));
		enderecoMotorista.setText("                                     Endereço:"
				+ "                                    ");
		centerPanel.add(enderecoMotorista);
		
		JFormatTextFieldTelefone.setColumns(9);
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("(##) # ####-####");
			mascaraCpf.setPlaceholderCharacter('_');
			mascaraCpf.install(JFormatTextFieldTelefone);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		centerPanel.add(JFormatTextFieldTelefone);
		
//		textTelefone.setColumns(9);
//		centerPanel.add(textTelefone);
		
		textEndereco.setColumns(23);
		centerPanel.add(textEndereco);
		
		JLabel tipoCnhMotorista = new JLabel();
		tipoCnhMotorista.setText("                     Selecione a categoria da CNH:"
				+ "                      ");
		tipoCnhMotorista.setBorder(new EmptyBorder(10, 0, 0, 0));
		tipoCnhMotorista.setFont(new Font("Dialog", Font.CENTER_BASELINE, 14));
		centerPanel.add(tipoCnhMotorista);
		
		catARadioButton.setText("A");
		catARadioButton.setBackground(Color.lightGray);
		catARadioButton.setSelected(false);
		
		catBRadioButton.setText("B");
	    catBRadioButton.setBackground(Color.lightGray);
	   
	    catCRadioButton.setText("C");
	    catCRadioButton.setBackground(Color.lightGray);
	    
	    catDRadioButton.setText("D");
	    catDRadioButton.setBackground(Color.lightGray);
	    
	    catERadioButton.setText("E");
	    catERadioButton.setBackground(Color.lightGray);

	    ButtonGroup group = new ButtonGroup();
	    group.add(catARadioButton);
	    group.add(catBRadioButton);
	    group.add(catCRadioButton);
	    group.add(catDRadioButton);
	    group.add(catERadioButton);
	    
	    centerPanel.add(catARadioButton);
	    centerPanel.add(catBRadioButton);
	    centerPanel.add(catCRadioButton);
	    centerPanel.add(catDRadioButton);
	    centerPanel.add(catERadioButton);
		
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
		westPanel.add(excluir);
		
		JButton gravar = new JButton();
		gravar.setText("Gravar");
		gravar.setPreferredSize(new Dimension(70, 25));
		gravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gravarMotorista();				
			}

			private void gravarMotorista() {
				//Extraindo informações dos campos
				int codMotorista = Integer.valueOf(textCod.getText()); //Transformando String em Int
				String nome = textNome.getText();
				String cpf = JFormatTextFieldCpf.getText().replaceAll("\\D","");
				String rg = textRG.getText();
				String cnh = textCNH.getText();
				String telefone = JFormatTextFieldTelefone.getText().replaceAll("\\D","");
				String endereco = textEndereco.getText();
								
				//Montando TO
				CadastrarMotoristaTO motorista = new CadastrarMotoristaTO(codMotorista, nome, cpf, rg, cnh, telefone, endereco);
				
				//Inserindo usuario no banco de dados - Sem uso de controller.
				CadastrarMotoristaDAO dao = new CadastrarMotoristaDAO();
				try {
					dao.insertNewCadastrarMotorista(motorista);
				} catch (CadastrarMotoristaException e) {
					e.printStackTrace();
				} //Enviando to para o banco de dados.
				
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
		CadastrarMotorista tela = new CadastrarMotorista();
		tela.setVisible(true);
	}

}
