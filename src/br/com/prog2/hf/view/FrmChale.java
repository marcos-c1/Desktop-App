package br.com.prog2.hf.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
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

import br.com.prog2.hf.controller.ChaleController;
import br.com.prog2.hf.model.Chale;
import java.awt.Font;
@SuppressWarnings("serial")
public class FrmChale extends JFrame {

	private JPanel contentPane;
	private JTable tblConsulta;
	private JLabel lblCod;
	private JLabel lblLocalizacao;
	private JLabel lblCapacidade;
	private JLabel lblValorAltoDa;
	private JLabel lblValorBaixoDa;
	private JTextField txtLoc;
	private JTextField txtCod;
	private JTextField txtCapacidade;
	private JTextField txtValor1;
	private JTextField txtValor2;
	private JButton btnInserir;
	private JButton btnAlterar;
	private JButton btnLimpar;
	private JButton btnPesquisar;
	private JButton btnExcluir;
	private JButton btnSair;
	private JLabel lblMensagem;
	private JLabel lblReal1;
	private JLabel lblReal2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChale frame = new FrmChale();
					frame.setTitle("Cadastro de Chalé");
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
	public FrmChale() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_2.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 557, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(14, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap().addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)));

		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String cod = tblConsulta.getValueAt(linha, 0).toString();
				String loc = tblConsulta.getValueAt(linha, 1).toString();
				String cap = tblConsulta.getValueAt(linha, 2).toString();
				String valor1 = tblConsulta.getValueAt(linha, 3).toString();
				String valor2 = tblConsulta.getValueAt(linha, 4).toString();
				txtCod.setText(cod);
				txtLoc.setText(loc);
				txtCapacidade.setText(cap);
				txtValor1.setText(valor1);
				txtValor2.setText(valor2);
			}
		});
		tblConsulta.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00F3digo", "Localiza\u00E7\u00E3o", "Capacidade", "Valor Alto", "Valor Baixo" }) {
			Class<?>[] columnTypes = new Class[] { String.class, String.class, Integer.class, Double.class, Double.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(108);
		tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(118);
		tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(95);
		tblConsulta.getColumnModel().getColumn(4).setPreferredWidth(115);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);

		btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale ch = new Chale();
				ChaleController cc = new ChaleController();
				ch.setCod_chale(txtCod.getText());
				ch.setLocalizacao(txtLoc.getText());
				ch.setCapacidade((Integer.parseInt(txtCapacidade.getText())));
				ch.setValorBaixaEstacao(Double.parseDouble(txtValor1.getText()));
				ch.setValorAltaEstacao(Double.parseDouble(txtValor2.getText()));
				if (cc.pesquisarPorCod(ch.getCod_chale()) != null) {
					JOptionPane.showMessageDialog(null, "Chalé já existente", "Error", JOptionPane.ERROR_MESSAGE);
				}
				lblMensagem.setText(cc.inserir(ch));
				mostrarDados();
			}
		});

		btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale ch = new Chale();
				ChaleController cc = new ChaleController();
				ch.setCod_chale(txtCod.getText());
				ch.setLocalizacao(txtLoc.getText());
				ch.setCapacidade((Integer.parseInt(txtCapacidade.getText())));
				ch.setValorBaixaEstacao(Double.parseDouble(txtValor1.getText()));
				ch.setValorAltaEstacao(Double.parseDouble(txtValor2.getText()));
				lblMensagem.setText(cc.alterar(ch));
				mostrarDados();
			}
		});

		btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale ch = new Chale();
				ChaleController cc = new ChaleController();
				ch.setCod_chale(txtCod.getText());
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse chale:" + txtLoc.getText() + "?",
						"Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(cc.excluir(ch));
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
				txtLoc.setText("");
				txtCapacidade.setText("");
				txtValor1.setText("");
				txtValor2.setText("");
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
				FrmChale.this.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(6).addComponent(btnInserir)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnAlterar)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnExcluir).addGap(12)
						.addComponent(btnPesquisar).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnLimpar).addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addComponent(btnSair).addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap(22, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btnInserir)
								.addComponent(btnAlterar).addComponent(btnExcluir).addComponent(btnPesquisar)
								.addComponent(btnLimpar).addComponent(btnSair))
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		lblCod = new JLabel("Código do Chale:");

		lblLocalizacao = new JLabel("Localização:");

		lblCapacidade = new JLabel("Capacidade:");

		lblValorAltoDa = new JLabel("Valor Alto da Estação:");
		lblValorAltoDa.setFont(new Font("Dialog", Font.BOLD, 12));

		lblValorBaixoDa = new JLabel("Valor Baixo da Estação:");
		lblValorBaixoDa.setFont(new Font("Dialog", Font.BOLD, 12));

		txtLoc = new JTextField();
		txtLoc.setColumns(10);

		txtCod = new JTextField();
		txtCod.setColumns(10);

		txtCapacidade = new JTextField();
		txtCapacidade.setColumns(10);

		txtValor1 = new JTextField();
		txtValor1.setColumns(10);

		txtValor2 = new JTextField();
		txtValor2.setColumns(10);

		lblReal1 = new JLabel("R$");
		lblReal1.setForeground(Color.BLACK);

		lblReal2 = new JLabel("R$");
		lblReal2.setForeground(Color.BLACK);

		lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setFont(new Font("Dialog", Font.BOLD, 9));
		lblMensagem.setForeground(Color.BLUE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCapacidade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblValorBaixoDa)
								.addComponent(lblValorAltoDa))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblReal1)
								.addComponent(lblReal2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtValor2, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
								.addComponent(txtValor1, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(12)
								.addComponent(lblCod)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtCod))
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblLocalizacao)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtLoc, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(489)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCod)
						.addComponent(txtCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocalizacao)
						.addComponent(txtLoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCapacidade)
								.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(4)
									.addComponent(lblValorBaixoDa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblReal1)
								.addComponent(txtValor1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(4)
									.addComponent(lblValorAltoDa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblReal2)
								.addComponent(txtValor2))))
					.addGap(18)
					.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	public void mostrarDados() {
		List<Chale> listaCh = new ArrayList<>();
		ChaleController cc = new ChaleController();
		listaCh = cc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();

		for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
			tbm.removeRow(i);
		}
		int i = 0;
		for (Chale ch : listaCh) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(ch.getCod_chale(), i, 0);
			tblConsulta.setValueAt(ch.getLocalizacao(), i, 1);
			tblConsulta.setValueAt(ch.getCapacidade(), i, 2);
			tblConsulta.setValueAt(ch.getValorAltaEstacao(), i, 3);
			tblConsulta.setValueAt(ch.getValorBaixaEstacao(), i, 4);
			i++;
		}
	}
}
