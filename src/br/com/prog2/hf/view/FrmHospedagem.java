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

import br.com.prog2.hf.controller.ChaleController;
import br.com.prog2.hf.controller.HospedagemController;
import br.com.prog2.hf.model.Chale;
import br.com.prog2.hf.model.Hospedagem;
import br.com.prog2.hf.util.Util;

@SuppressWarnings("serial")
public class FrmHospedagem extends JFrame {

	private JPanel contentPane;
	private JTable tblConsulta;
	private MaskFormatter mascaraData = null;
	private JTextField txtCod;
	private JTextField txtValor;
	private JTextField txtDesconto;
	private JButton btnInserir;
	private JButton btnAlterar;
	private JButton btnLimpar;
	private JButton btnPesquisar;
	private JButton btnExcluir;
	private JButton btnSair;
	private JComboBox<String> cbxChale;
	private JComboBox<String> cbxEstado;
	private JLabel lblMensagem;
	List<Chale> listaChale;
	private JLabel lblPessoas;
	private JTextField textField;
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataFinal;
	private JLabel lblChale;
	private JLabel lblValor;
	private JLabel lblDataDeIncio;
	private JLabel lblDataDeSada;
	private JLabel lblCdigo;
	private JLabel lblRS;
	private JLabel lblEstado;
	private JLabel lblDdmmmmmmmm;
	private JLabel lblDdmmmmmmmm_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHospedagem frame = new FrmHospedagem();
					frame.pack();
					frame.setTitle("Hospedagem");
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
	public FrmHospedagem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 635, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 604, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE).addComponent(panel_2,
										Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE).addContainerGap()));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE).addContainerGap()));
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap().addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)));

		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				//String cod_chale = tblConsulta.getValueAt(linha, 0).toString();
				String cod_hosp = tblConsulta.getValueAt(linha, 1).toString();
				String est = tblConsulta.getValueAt(linha, 2).toString();
				String dataInicio = tblConsulta.getValueAt(linha, 3).toString();
				String dataFinal = tblConsulta.getValueAt(linha, 4).toString();
				String qtdPessoas = tblConsulta.getValueAt(linha, 5).toString();
				String desc = tblConsulta.getValueAt(linha, 6).toString();
				String valor = tblConsulta.getValueAt(linha, 7).toString();
				txtCod.setText(cod_hosp);
				cbxEstado.setSelectedItem(est);
				txtDataInicio.setText(dataInicio);
				txtDataFinal.setText(dataFinal);
				textField.setText(qtdPessoas);
				txtDesconto.setText(desc);
				txtValor.setText(valor);

				Integer pos = 0;
				for (Chale c : listaChale) {
					if (c.getCod_chale().equals(tblConsulta.getValueAt(linha, 0).toString())) {
						pos = listaChale.indexOf(c);
					}
				}
				cbxChale.setSelectedItem(listaChale.get(pos).getLocalizacao());
			}
		});

		tblConsulta.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo_Chale", "C\u00F3digo",
				"Estado", "Data de entrada", "Data de Sa\u00EDda", "Qtd de pessoas", "Desconto", "Valor" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					Integer.class, Double.class, Double.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(78);
		tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(129);
		tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(119);
		tblConsulta.getColumnModel().getColumn(4).setPreferredWidth(126);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);

		btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Hospedagem h = new Hospedagem();
				HospedagemController hc = new HospedagemController();
				Integer pos = 0;
				for (Chale c : listaChale) {
					if (c.getLocalizacao().equals(cbxChale.getSelectedItem())) {
						pos = listaChale.indexOf(c);
					}
				}
				h.setCod_hosp(txtCod.getText());
				h.setCod_chale(listaChale.get(pos).getCod_chale());
				h.setEstado(cbxEstado.getSelectedItem().toString());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataInicio.getText());
				int[] dataFormatada1 = Util.formatarDataDeGuiParaLocalDate(txtDataFinal.getText());
				h.setDataInicio(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
				h.setDataFim(LocalDate.of(dataFormatada1[2], dataFormatada1[1], dataFormatada1[0]));
				h.setQtdPessoas(Integer.parseInt(textField.getText()));
				h.setDesconto(Double.parseDouble(txtDesconto.getText()));
				h.setValorFinal(Double.parseDouble(txtValor.getText()));
				if (hc.pesquisarPorHospedagens(h.getCod_hosp()) != null) {
					JOptionPane.showMessageDialog(null, "Já foi Hospedado!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					lblMensagem.setText(hc.inserir(h));/* Mesmo teste na Classe 'teste' */
				}
				mostrarDados();

			}
		});

		btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem h = new Hospedagem();
				HospedagemController hc = new HospedagemController();
				Integer pos = 0;
				for (Chale c : listaChale) {
					if (c.getLocalizacao().equals(cbxChale.getSelectedItem())) {
						pos = listaChale.indexOf(c);
					}
				}
				h.setCod_hosp(txtCod.getText());
				h.setCod_chale(listaChale.get(pos).getCod_chale());
				h.setEstado(cbxEstado.getSelectedItem().toString());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataInicio.getText());
				int[] dataFormatada1 = Util.formatarDataDeGuiParaLocalDate(txtDataFinal.getText());
				h.setDataInicio(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
				h.setDataFim(LocalDate.of(dataFormatada1[2], dataFormatada1[1], dataFormatada1[0]));
				h.setQtdPessoas(Integer.parseInt(textField.getText()));
				h.setDesconto(Double.parseDouble(txtDesconto.getText()));
				h.setValorFinal(Double.parseDouble(txtValor.getText()));
				if (hc.pesquisarPorHospedagens(h.getCod_hosp()) != null) {
					JOptionPane.showMessageDialog(null, "Já foi Hospedado!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					lblMensagem.setText(hc.alterar(h));/* Mesmo teste na Classe 'teste' */
				}
				mostrarDados();

			}
		});

		btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Hospedagem h = new Hospedagem();
				HospedagemController hc = new HospedagemController();
				Integer pos = 0;
				for (Chale c : listaChale) {
					if (c.getLocalizacao().equals(cbxChale.getSelectedItem())) {
						pos = listaChale.indexOf(c);
					}
				}
				h.setCod_hosp(txtCod.getText());
				h.setCod_chale(listaChale.get(pos).getCod_chale());
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,
						"Deseja excluir essa Hospedagem nº: " + txtCod.getText() + "?", "Exclusão",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

				if (JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(hc.excluir(h));
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
				txtDataInicio.setText("");
				txtDataFinal.setText("");
				txtDesconto.setText("");
				txtValor.setText("");
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
				FrmHospedagem.this.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(btnInserir)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnAlterar)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnExcluir).addGap(18)
						.addComponent(btnPesquisar).addGap(18).addComponent(btnLimpar).addGap(18).addComponent(btnSair)
						.addContainerGap(43, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap(30, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btnInserir)
								.addComponent(btnAlterar).addComponent(btnExcluir).addComponent(btnPesquisar)
								.addComponent(btnLimpar).addComponent(btnSair))
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setForeground(Color.BLUE);

		lblChale = new JLabel("Chale:");

		lblValor = new JLabel("Valor:");

		lblDataDeSada = new JLabel("Data de Saída:");

		lblDataDeIncio = new JLabel("Data de Início:");

		lblCdigo = new JLabel("Código:");

		txtCod = new JTextField();
		txtCod.setColumns(10);
		ChaleController cc = new ChaleController();
		cbxChale = new JComboBox<String>();
		listaChale = cc.listarTodos();
		for (Chale c : listaChale) {
			cbxChale.addItem(c.getLocalizacao());
		}
		txtValor = new JTextField();
		txtValor.setColumns(10);

		lblRS = new JLabel("R$");
		lblRS.setForeground(Color.BLACK);

		lblEstado = new JLabel("Estado:");

		cbxEstado = new JComboBox<String>();
		cbxEstado.setModel(new DefaultComboBoxModel<String>(
				new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

		lblDdmmmmmmmm = new JLabel("dd/mmmm/MMMM");
		lblDdmmmmmmmm.setForeground(Color.RED);

		lblDdmmmmmmmm_1 = new JLabel("dd/mmmm/MMMM");
		lblDdmmmmmmmm_1.setForeground(Color.RED);

		JLabel lblDesconto = new JLabel("Desconto:");

		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);

		lblPessoas = new JLabel("Pessoas:");

		textField = new JTextField();
		textField.setColumns(10);
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		txtDataInicio = new JFormattedTextField(mascaraData);

		txtDataFinal = new JFormattedTextField(mascaraData);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false).addGroup(gl_panel
								.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblCdigo)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtCod))
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblDataDeSada)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtDataFinal,
														GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblDataDeIncio)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtDataInicio,
														GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
										.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblDdmmmmmmmm)
												.addGap(18).addComponent(lblPessoas)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField, 0, 0, Short.MAX_VALUE))
										.addGroup(gl_panel.createSequentialGroup().addGap(65).addComponent(lblDesconto)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txtDesconto,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)))
										.addComponent(lblDdmmmmmmmm_1))
								.addGap(49))
								.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblMensagem)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(lblValor).addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblRS).addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtValor, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblChale).addGap(8)
												.addComponent(cbxChale, GroupLayout.PREFERRED_SIZE, 303,
														GroupLayout.PREFERRED_SIZE)
												.addGap(61).addComponent(lblEstado)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(cbxEstado,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)))
										.addGap(69)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblChale)
								.addComponent(cbxChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEstado).addComponent(
										cbxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(18)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblCdigo).addComponent(txtCod, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblDesconto)
												.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblDataDeIncio)
										.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDdmmmmmmmm))
								.addGroup(gl_panel.createSequentialGroup().addGap(4).addComponent(lblPessoas)))
								.addComponent(
										textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
								.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblDataDeSada)
										.addComponent(txtDataFinal, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDdmmmmmmmm_1))
								.addGap(18).addComponent(lblMensagem))
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblRS)
										.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lblValor))
						.addContainerGap()));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	public void mostrarDados() {
		List<Hospedagem> listaHosp = new ArrayList<>();
		HospedagemController hc = new HospedagemController();
		listaHosp = hc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		
		for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
			tbm.removeRow(i);
		}
		int i = 0;
		for (Hospedagem h : listaHosp) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(h.getCod_chale(), i, 0);
			tblConsulta.setValueAt(h.getCod_hosp(), i, 1);
			tblConsulta.setValueAt(h.getEstado(), i, 2);
			tblConsulta.setValueAt(Util.formatarDataDeLocalDateParaGui(h.getDataInicio()), i, 3);
			tblConsulta.setValueAt(Util.formatarDataDeLocalDateParaGui(h.getDataFim()), i, 4);
			tblConsulta.setValueAt(h.getQtdPessoas(), i, 5);
			tblConsulta.setValueAt(h.getDesconto(), i, 6);
			h.setValorFinal(h.calculaValor(h.getValorFinal(), h.getDesconto()));
			tblConsulta.setValueAt(h.getValorFinal(), i, 7);
			i++;
		}

	}
}
