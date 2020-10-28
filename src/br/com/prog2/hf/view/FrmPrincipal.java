package br.com.prog2.hf.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.pack();
					frame.setTitle("Sistema");
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
	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Cadastro");
		menuBar.add(mnCliente);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCliente fc = new FrmCliente();
				fc.pack();
				fc.setTitle("Cadastro de Cliente");
				fc.setLocationRelativeTo(null);
				fc.setVisible(true);
			}
		});
		mnCliente.add(mntmCliente);
		
		JMenuItem mntmChale = new JMenuItem("Chale");
		mntmChale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmChale fch = new FrmChale();
				fch.pack();
				fch.setTitle("Cadastro de Chale");
				fch.setLocationRelativeTo(null);
				fch.setVisible(true);
			}
		});
		mnCliente.add(mntmChale);
		
		JMenuItem mntmHospedagem = new JMenuItem("Hospedagem");
		mntmHospedagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			FrmHospedagem fh = new FrmHospedagem();
			fh.pack();
			fh.setTitle("Hospedagens");
			fh.setLocationRelativeTo(null);
			fh.setVisible(true);
			}
		});
		mnCliente.add(mntmHospedagem);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnCliente.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 440, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 260, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
