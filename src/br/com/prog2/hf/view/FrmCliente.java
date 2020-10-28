package br.com.prog2.hf.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.prog2.hf.controller.ClienteController;
import br.com.prog2.hf.model.Cliente;
import br.com.prog2.hf.util.Util;

@SuppressWarnings("serial")
public class FrmCliente extends JFrame {

	private JPanel contentPane;
	private JTable tblConsulta;
	private MaskFormatter mascaraData = null;
	private JTextField txtCod;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtNome;
	private JTextField txtCEP;
	private JTextField txtRG;
	private JLabel lblCdigo;
	private JLabel lblNome;
	private JLabel lblRg;
	private JLabel lblBairro;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JLabel lblCep;
	private JLabel lblDataDeNascimento;
	private JFormattedTextField txtDataNasc;
	private JButton btnInserir;
	private JButton btnAlterar;
	private JButton btnLimpar;
	private JButton btnPesquisar;
	private JButton btnExcluir;
	private JButton btnSair;
	private JComboBox<String> cbxEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setTitle("Cadastro de Empregados");
					frame.pack();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 623, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 596, Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)));

		lblCdigo = new JLabel("Código:");

		lblNome = new JLabel("Nome:");

		lblRg = new JLabel("RG:");

		lblBairro = new JLabel("Bairro:");

		lblEstado = new JLabel("Estado:");

		lblCidade = new JLabel("Cidade:");

		lblCep = new JLabel("CEP:");

		lblDataDeNascimento = new JLabel("Data de Nascimento:");

		cbxEstado = new JComboBox<String>();
		cbxEstado.setModel(new DefaultComboBoxModel<String>(
				new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		txtDataNasc = new JFormattedTextField(mascaraData);

		JLabel lblDdmmmmmm = new JLabel("dd/mm/mmmm");
		lblDdmmmmmm.setForeground(Color.RED);

		JLabel lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setForeground(Color.BLUE);

		txtCod = new JTextField();
		txtCod.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);

		txtNome = new JTextField();
		txtNome.setColumns(10);

		txtCEP = new JTextField();
		txtCEP.setColumns(10);

		txtRG = new JTextField();
		txtRG.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addComponent(lblDataDeNascimento)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtDataNasc, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDdmmmmmm).addGap(298))
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup().addGap(9).addComponent(lblMensagem)
								.addPreferredGap(ComponentPlacement.RELATED, 296, Short.MAX_VALUE).addComponent(lblCep)
								.addPreferredGap(
										ComponentPlacement.RELATED)
								.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel
												.createSequentialGroup().addComponent(lblCdigo)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txtCod,
														GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup().addGap(1).addGroup(gl_panel
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup().addComponent(lblNome)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 290,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel.createSequentialGroup().addComponent(lblRg)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtRG,
																GroupLayout.PREFERRED_SIZE, 168,
																GroupLayout.PREFERRED_SIZE)))))
								.addGap(12)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblEstado)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(cbxEstado,
														GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_panel.createSequentialGroup().addComponent(lblCidade)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtCidade))
												.addGroup(gl_panel.createSequentialGroup().addComponent(lblBairro)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 158,
																GroupLayout.PREFERRED_SIZE))))))
						.addGap(148)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblCdigo)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNome)
										.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBairro).addComponent(txtBairro, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup().addGap(10)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCidade).addComponent(txtCidade, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(4)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(7)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblRg)
												.addComponent(txtRG, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(19)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblDataDeNascimento)
												.addComponent(txtDataNasc, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblDdmmmmmm)))
								.addGroup(gl_panel.createSequentialGroup().addGap(4).addGroup(
										gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblEstado)
												.addComponent(cbxEstado, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblCep)
												.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(15))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblMensagem).addGap(9)))));
		panel.setLayout(gl_panel);

		btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = new Cliente();
				ClienteController cc = new ClienteController();
				cli.setCodCliente(txtCod.getText());
				cli.setNome(txtNome.getText());
				cli.setRg(txtRG.getText());
				cli.setBairro(txtBairro.getText());
				cli.setCidade(txtCidade.getText());
				cli.setEstado(cbxEstado.getSelectedItem().toString());
				cli.setCep(txtCEP.getText());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataNasc.getText());
				cli.setDataNasc(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
				if (cc.pesquisarPorCliente(cli.getCodCliente()) != null) {
					JOptionPane.showMessageDialog(null, "Cliente já existente", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {					
					lblMensagem.setText(cc.inserir(cli));/* Mesmo teste na Classe 'teste' */
				}
				mostrarDados();
			}
		});

		btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = new Cliente();
				ClienteController cc = new ClienteController();
				cli.setCodCliente(txtCod.getText());
				cli.setNome(txtNome.getText());
				cli.setRg(txtRG.getText());
				cli.setBairro(txtBairro.getText());
				cli.setCidade(txtCidade.getText());
				cli.setEstado(cbxEstado.getSelectedItem().toString());
				cli.setCep(txtCEP.getText());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataNasc.getText());
				cli.setDataNasc(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
				lblMensagem.setText(cc.alterar(cli));/* Mesmo teste na Classe 'teste' */
				mostrarDados();
			}
		});

		btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente c = new Cliente();
				ClienteController cc = new ClienteController();
				c.setCodCliente(txtCod.getText());
				c.setNome(txtNome.getText());
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse cliente: " + txtNome.getText() + "?",
						"Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

				if (JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(cc.excluir(c));
				}
				mostrarDados();
			}
		});

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarDados();
			}
		});

		btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCod.setText("");
				txtNome.setText("");
				txtRG.setText("");
				txtDataNasc.setText("");
				txtCidade.setText("");
				txtBairro.setText("");
				txtCEP.setText("");
				lblMensagem.setText("Mensagem:");
				DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
				for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
					tbm.removeRow(i);
				}
			}
		});

		btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmCliente.this.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(btnInserir)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnAlterar).addGap(18)
						.addComponent(btnExcluir).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnPesquisar).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnLimpar).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnSair)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btnInserir)
								.addComponent(btnAlterar).addComponent(btnExcluir).addComponent(btnPesquisar)
								.addComponent(btnLimpar).addComponent(btnSair))
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE).addContainerGap()));
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap().addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)));

		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String cod = tblConsulta.getValueAt(linha, 0).toString();
				String nome = tblConsulta.getValueAt(linha, 1).toString();
				String rg = tblConsulta.getValueAt(linha, 2).toString();
				String bairro = tblConsulta.getValueAt(linha, 3).toString();
				String cidade = tblConsulta.getValueAt(linha, 4).toString();
				String estado = tblConsulta.getValueAt(linha, 5).toString();
				String cep = tblConsulta.getValueAt(linha, 6).toString();
				String dataNasc = tblConsulta.getValueAt(linha, 7).toString();
				
				txtCod.setText(cod);
				txtNome.setText(nome);
				txtRG.setText(rg);
				txtBairro.setText(bairro);
				txtCidade.setText(cidade);
				cbxEstado.setSelectedItem(estado);
				txtCEP.setText(cep);
				txtDataNasc.setText(dataNasc);
			}
		});
		tblConsulta.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "Nome", "RG",
				"Bairro", "Cidade", "Estado", "CEP", "Data de Nascimento" }) {
			Class<?>[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblConsulta.getColumnModel().getColumn(7).setPreferredWidth(154);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}

	public void mostrarDados() {
		List<Cliente> listaCli = new ArrayList<>();
		ClienteController cc = new ClienteController();
		listaCli = cc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();

		for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
			tbm.removeRow(i);
		}
		int i = 0;
		for (Cliente c : listaCli) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(c.getCodCliente(), i, 0);
			tblConsulta.setValueAt(c.getNome(), i, 1);
			tblConsulta.setValueAt(c.getRg(), i, 2);
			tblConsulta.setValueAt(c.getBairro(), i, 3);
			tblConsulta.setValueAt(c.getCidade(), i, 4);
			tblConsulta.setValueAt(c.getEstado(), i, 5);
			tblConsulta.setValueAt(c.getCep(), i, 6);
			tblConsulta.setValueAt(Util.formatarDataDeLocalDateParaGui(c.getDataNasc()), i, 7);
			i++;
		}
	}

}
