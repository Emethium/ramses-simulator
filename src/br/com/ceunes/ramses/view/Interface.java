package br.com.ceunes.ramses.view;

import java.awt.EventQueue;
import br.com.ceunes.ramses.read.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import br.com.ceunes.ramses.architecture.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class Interface extends JFrame {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	public ControlUnit controlUnit;
	public Circuit circuit = new Circuit();
	public TextProcessing read = new TextProcessing();
	public MemoriaProcessing memory = new MemoriaProcessing();
	private JPanel contentPane;

	/**
	 * /** declaration of all components
	 */
	public boolean first = true;
	public boolean fim = true;
	public JRadioButton CargaPC0 = new JRadioButton("0");
	public JRadioButton CargaPC1 = new JRadioButton("1");

	public JRadioButton CargaRA0;
	public JRadioButton CargaRA1;

	public JRadioButton CargaRI0 = new JRadioButton("0");
	public JRadioButton CargaRI1 = new JRadioButton("1");

	public JRadioButton CargaRX0 = new JRadioButton("0");
	public JRadioButton CargaRX1 = new JRadioButton("1");

	public JRadioButton CargaRB0 = new JRadioButton("0");
	public JRadioButton CargaRB1 = new JRadioButton("1");

	public JRadioButton CargaREM0 = new JRadioButton("0");
	public JRadioButton CargaREM1 = new JRadioButton("1");

	public JRadioButton CargaRDM0 = new JRadioButton("0");
	public JRadioButton CargaRDM1 = new JRadioButton("1");

	public JFormattedTextField ALUMSB = new JFormattedTextField();
	public JFormattedTextField ALU2MSB = new JFormattedTextField();
	public JFormattedTextField ALULSB = new JFormattedTextField();
	public JRadioButton Carry = new JRadioButton("Carry");
	public JRadioButton Zero = new JRadioButton("Zero");
	public JRadioButton Negativo = new JRadioButton("Negativo");

	public JFormattedTextField MUXS1 = new JFormattedTextField();
	public JFormattedTextField MUXS2 = new JFormattedTextField();
	public JFormattedTextField MUXS3 = new JFormattedTextField();
	public JFormattedTextField MUXS4 = new JFormattedTextField();
	public JFormattedTextField MUXS5 = new JFormattedTextField();

	public JRadioButton Read = new JRadioButton("Read");
	public JRadioButton Write = new JRadioButton("Write");
	public JFormattedTextField incrementaPC = new JFormattedTextField();
	public final JFormattedTextField valorRB = new JFormattedTextField();
	public final JFormattedTextField valorRX = new JFormattedTextField();
	public final JFormattedTextField valorRA = new JFormattedTextField();
	public JFormattedTextField valorRDM = new JFormattedTextField();
	public JFormattedTextField valorREM = new JFormattedTextField();
	public JTable tableMemory = new JTable();

	public JButton btnExecutar = new JButton("Executar");
	public JButton btnproximaInstrucao = new JButton("Próxima Instrução");
	public char cargaRa;

	/*
	 *  * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Interface() {
		Executar();
		proximaInstrucao();

		CargaRA1 = new JRadioButton("1");
		CargaRA0 = new JRadioButton("0");
		controlUnit = new ControlUnit(this, circuit);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel Cargas = new JPanel();

		JPanel ALU = new JPanel();

		JPanel MUX = new JPanel();

		JPanel MEMORIA = new JPanel();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				Cargas,
																				GroupLayout.PREFERRED_SIZE,
																				242,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(81))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								btnproximaInstrucao)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												MUX,
																												GroupLayout.PREFERRED_SIZE,
																												189,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												ALU,
																												GroupLayout.PREFERRED_SIZE,
																												242,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGap(5)))
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				MEMORIA,
																				GroupLayout.PREFERRED_SIZE,
																				184,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				15,
																				Short.MAX_VALUE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnExecutar)
																		.addGap(28)))));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																MEMORIA,
																GroupLayout.PREFERRED_SIZE,
																318,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				Cargas,
																				GroupLayout.PREFERRED_SIZE,
																				231,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								MUX,
																								0,
																								0,
																								Short.MAX_VALUE)
																						.addComponent(
																								ALU,
																								GroupLayout.DEFAULT_SIZE,
																								91,
																								Short.MAX_VALUE))
																		.addGap(8)))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnproximaInstrucao)
														.addComponent(
																btnExecutar))
										.addContainerGap()));
		btnproximaInstrucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JLabel lblMemria = new JLabel("Memória");

		Read.setEnabled(false);

		Write.setEnabled(false);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblPc = new JLabel("PC");

		incrementaPC.setEditable(false);
		incrementaPC.setText("0");
		GroupLayout gl_MEMORIA = new GroupLayout(MEMORIA);
		gl_MEMORIA
				.setHorizontalGroup(gl_MEMORIA
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_MEMORIA
										.createSequentialGroup()
										.addGroup(
												gl_MEMORIA
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_MEMORIA
																		.createSequentialGroup()
																		.addGap(60)
																		.addComponent(
																				lblMemria))
														.addGroup(
																gl_MEMORIA
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				scrollPane,
																				GroupLayout.PREFERRED_SIZE,
																				158,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_MEMORIA
																		.createSequentialGroup()
																		.addGap(18)
																		.addGroup(
																				gl_MEMORIA
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_MEMORIA
																										.createSequentialGroup()
																										.addComponent(
																												lblPc)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												incrementaPC,
																												GroupLayout.PREFERRED_SIZE,
																												60,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_MEMORIA
																										.createSequentialGroup()
																										.addComponent(
																												Read)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												Write)))))
										.addContainerGap(14, Short.MAX_VALUE)));
		gl_MEMORIA
				.setVerticalGroup(gl_MEMORIA
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_MEMORIA
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblMemria)
										.addPreferredGap(
												ComponentPlacement.RELATED, 16,
												Short.MAX_VALUE)
										.addGroup(
												gl_MEMORIA
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(Read)
														.addComponent(Write))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_MEMORIA
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblPc)
														.addComponent(
																incrementaPC,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												214, GroupLayout.PREFERRED_SIZE)
										.addGap(9)));
		tableMemory.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		tableMemory.setModel(new DefaultTableModel(
				new Object[][] { { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, }, new String[] {
						"End.", "Dado" }) {
			Class[] columnTypes = new Class[] { Integer.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableMemory.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(tableMemory);
		MEMORIA.setLayout(gl_MEMORIA);

		JLabel lblMux = new JLabel("MUX");

		JLabel lblS = new JLabel("S1");

		MUXS1.setEditable(false);
		MUXS1.setText("0");

		JLabel lblS_1 = new JLabel("S2");

		MUXS2.setEditable(false);
		MUXS2.setText("0");

		JLabel lblS_2 = new JLabel("S3");

		MUXS3.setEditable(false);
		MUXS3.setText("0");

		JLabel lblS_3 = new JLabel("S4");

		MUXS4.setEditable(false);
		MUXS4.setText("0");

		JLabel lblS_4 = new JLabel("S5");

		MUXS5.setEditable(false);
		MUXS5.setText("0");
		GroupLayout gl_MUX = new GroupLayout(MUX);
		gl_MUX.setHorizontalGroup(gl_MUX
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_MUX.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblMux)
								.addGap(18)
								.addGroup(
										gl_MUX.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_MUX.createSequentialGroup()
																.addComponent(
																		lblS_4,
																		GroupLayout.PREFERRED_SIZE,
																		17,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(12)
																.addComponent(
																		MUXS5,
																		GroupLayout.PREFERRED_SIZE,
																		22,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_MUX.createSequentialGroup()
																.addComponent(
																		lblS_2,
																		GroupLayout.PREFERRED_SIZE,
																		17,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(12)
																.addComponent(
																		MUXS3,
																		GroupLayout.PREFERRED_SIZE,
																		22,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(9)
																.addComponent(
																		lblS_3,
																		GroupLayout.PREFERRED_SIZE,
																		17,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(12)
																.addComponent(
																		MUXS4,
																		GroupLayout.PREFERRED_SIZE,
																		22,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_MUX.createSequentialGroup()
																.addComponent(
																		lblS)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		MUXS1,
																		GroupLayout.PREFERRED_SIZE,
																		22,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(9)
																.addComponent(
																		lblS_1)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		MUXS2,
																		GroupLayout.PREFERRED_SIZE,
																		22,
																		GroupLayout.PREFERRED_SIZE)))
								.addGap(69)));
		gl_MUX.setVerticalGroup(gl_MUX
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_MUX.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_MUX.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblMux)
												.addComponent(lblS)
												.addComponent(
														MUXS1,
														GroupLayout.PREFERRED_SIZE,
														14,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblS_1)
												.addComponent(
														MUXS2,
														GroupLayout.PREFERRED_SIZE,
														14,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_MUX.createParallelGroup(
												Alignment.LEADING)
												.addComponent(lblS_2)
												.addComponent(
														MUXS3,
														GroupLayout.PREFERRED_SIZE,
														14,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblS_3)
												.addComponent(
														MUXS4,
														GroupLayout.PREFERRED_SIZE,
														14,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_MUX.createParallelGroup(
												Alignment.LEADING)
												.addComponent(lblS_4)
												.addComponent(
														MUXS5,
														GroupLayout.PREFERRED_SIZE,
														14,
														GroupLayout.PREFERRED_SIZE))
								.addContainerGap(51, Short.MAX_VALUE)));
		MUX.setLayout(gl_MUX);

		JLabel lblAlu = new JLabel("ALU");

		ALUMSB.setEditable(false);
		ALUMSB.setText("0");

		ALU2MSB.setEditable(false);
		ALU2MSB.setText("0");

		ALULSB.setEditable(false);
		ALULSB.setText("0");

		GroupLayout gl_ALU = new GroupLayout(ALU);
		gl_ALU.setHorizontalGroup(gl_ALU
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_ALU.createSequentialGroup()
								.addGroup(
										gl_ALU.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_ALU.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		Carry)
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		Negativo)
																.addGap(4)
																.addComponent(
																		Zero))
												.addGroup(
														gl_ALU.createSequentialGroup()
																.addGap(57)
																.addComponent(
																		lblAlu)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		ALUMSB,
																		GroupLayout.PREFERRED_SIZE,
																		22,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		ALU2MSB,
																		GroupLayout.PREFERRED_SIZE,
																		22,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		ALULSB,
																		GroupLayout.PREFERRED_SIZE,
																		22,
																		GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(12, Short.MAX_VALUE)));
		Carry.setEnabled(false);
		Zero.setEnabled(false);
		Negativo.setEnabled(false);
		gl_ALU.setVerticalGroup(gl_ALU
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_ALU.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_ALU.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														ALU2MSB,
														GroupLayout.PREFERRED_SIZE,
														14,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														ALULSB,
														GroupLayout.PREFERRED_SIZE,
														14,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblAlu)
												.addComponent(
														ALUMSB,
														GroupLayout.PREFERRED_SIZE,
														14,
														GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(
										gl_ALU.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(Carry)
												.addComponent(Negativo)
												.addComponent(Zero))
								.addContainerGap(23, Short.MAX_VALUE)));
		ALU.setLayout(gl_ALU);

		JLabel lblCargaPc = new JLabel("Carga PC");

		CargaPC0.setEnabled(false);

		CargaPC1.setEnabled(false);

		JLabel lblCargaRa = new JLabel("Carga RA");

		CargaRA1.setEnabled(false);

		JLabel lblCargaRb = new JLabel("Carga RB");

		CargaRA0.setEnabled(false);

		CargaRI1.setEnabled(false);

		JLabel lblCargaRx = new JLabel("Carga RX");

		CargaRX0.setEnabled(false);

		CargaRX1.setEnabled(false);

		CargaRB0.setEnabled(false);

		CargaRB1.setEnabled(false);

		JLabel lblCargaRem = new JLabel("Carga REM");

		CargaREM0.setEnabled(false);

		CargaREM1.setEnabled(false);

		JLabel lblCargaRdm = new JLabel("Carga RDM");

		CargaRDM0.setEnabled(false);

		CargaRDM1.setEnabled(false);

		CargaRI0.setEnabled(false);
		valorREM.setEditable(false);
		valorRDM.setEditable(false);

		JLabel label = new JLabel("Carga RI");
		GroupLayout gl_Cargas = new GroupLayout(Cargas);
		gl_Cargas
				.setHorizontalGroup(gl_Cargas
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_Cargas
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_Cargas
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblCargaPc)
														.addComponent(
																lblCargaRx)
														.addComponent(
																lblCargaRem)
														.addComponent(
																label,
																GroupLayout.PREFERRED_SIZE,
																59,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblCargaRa)
														.addComponent(
																lblCargaRb)
														.addComponent(
																lblCargaRdm))
										.addGap(16)
										.addGroup(
												gl_Cargas
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addGroup(
																gl_Cargas
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				CargaPC0)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				CargaPC1))
														.addGroup(
																gl_Cargas
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				CargaRI0)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				CargaRI1))
														.addGroup(
																Alignment.TRAILING,
																gl_Cargas
																		.createSequentialGroup()
																		.addComponent(
																				CargaRX0)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				CargaRX1)
																		.addGap(18)
																		.addComponent(
																				valorRX,
																				GroupLayout.PREFERRED_SIZE,
																				37,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_Cargas
																		.createSequentialGroup()
																		.addGroup(
																				gl_Cargas
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								CargaRDM1)
																						.addGroup(
																								gl_Cargas
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												CargaRDM0)
																										.addGroup(
																												gl_Cargas
																														.createSequentialGroup()
																														.addComponent(
																																CargaREM0)
																														.addPreferredGap(
																																ComponentPlacement.UNRELATED)
																														.addComponent(
																																CargaREM1))))
																		.addGap(18)
																		.addGroup(
																				gl_Cargas
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								valorRDM,
																								GroupLayout.PREFERRED_SIZE,
																								37,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								valorREM,
																								GroupLayout.PREFERRED_SIZE,
																								37,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_Cargas
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				CargaRA0)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				CargaRA1)
																		.addGap(18)
																		.addComponent(
																				valorRA,
																				GroupLayout.PREFERRED_SIZE,
																				37,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_Cargas
																		.createSequentialGroup()
																		.addGap(1)
																		.addComponent(
																				CargaRB0)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				CargaRB1)
																		.addGap(18)
																		.addComponent(
																				valorRB,
																				GroupLayout.PREFERRED_SIZE,
																				37,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		valorRB.setEditable(false);
		valorRA.setEditable(false);
		valorRX.setEditable(false);
		gl_Cargas
				.setVerticalGroup(gl_Cargas
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_Cargas
										.createSequentialGroup()
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												gl_Cargas
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_Cargas
																		.createSequentialGroup()
																		.addGroup(
																				gl_Cargas
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_Cargas
																										.createSequentialGroup()
																										.addGap(23)
																										.addGroup(
																												gl_Cargas
																														.createParallelGroup(
																																Alignment.BASELINE)
																														.addComponent(
																																CargaRI1)
																														.addComponent(
																																CargaRI0)
																														.addComponent(
																																label))
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												valorRX,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_Cargas
																										.createSequentialGroup()
																										.addGroup(
																												gl_Cargas
																														.createParallelGroup(
																																Alignment.BASELINE)
																														.addComponent(
																																lblCargaPc)
																														.addComponent(
																																CargaPC1)
																														.addComponent(
																																CargaPC0))
																										.addGap(39)
																										.addComponent(
																												lblCargaRx)))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_Cargas
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								valorRA,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblCargaRa)
																						.addComponent(
																								CargaRA0)
																						.addComponent(
																								CargaRA1))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_Cargas
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								CargaRB0)
																						.addComponent(
																								CargaRB1)
																						.addComponent(
																								valorRB,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblCargaRb))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_Cargas
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblCargaRem)
																						.addComponent(
																								CargaREM0)
																						.addComponent(
																								CargaREM1)
																						.addComponent(
																								valorREM,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_Cargas
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_Cargas
																										.createParallelGroup(
																												Alignment.BASELINE)
																										.addComponent(
																												CargaRDM1)
																										.addComponent(
																												valorRDM,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_Cargas
																										.createParallelGroup(
																												Alignment.BASELINE)
																										.addComponent(
																												CargaRDM0)
																										.addComponent(
																												lblCargaRdm)))
																		.addGap(145))
														.addGroup(
																gl_Cargas
																		.createSequentialGroup()
																		.addGroup(
																				gl_Cargas
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								CargaRX1)
																						.addComponent(
																								CargaRX0))
																		.addGap(263)))));
		Cargas.setLayout(gl_Cargas);
		contentPane.setLayout(gl_contentPane);
		indices();
	}

	public void Executar() {
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (first) {
						memory.memoryRead(Interface.this, circuit);
						read.read(true, true, Interface.this, circuit);
						controlUnit.memoryDataValues();
						btnExecutar.setEnabled(false);
						btnproximaInstrucao.setEnabled(false);
					} else {
						read.read(true, true, Interface.this, circuit);
						controlUnit.memoryDataValues();
						btnExecutar.setEnabled(false);
						btnproximaInstrucao.setEnabled(false);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public void setFim(boolean Fim) {
		this.fim = Fim;
	}

	public void proximaInstrucao() {
		btnproximaInstrucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (first == true) {
						memory.memoryRead(Interface.this, circuit);
						controlUnit.memoryDataValues();
						read.read(false, true, Interface.this, circuit);
						first = false;
					} else
						read.loop(true);
					btnproximaInstrucao.setEnabled(fim);
					btnExecutar.setEnabled(fim);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public void RecebeCargaRA(char CargaRa) {
		this.cargaRa = CargaRa;
		if (cargaRa == '0') {
			CargaRA0.setSelected(true);
			CargaRA1.setSelected(false);
		}
		if (CargaRa == '1') {
			CargaRA1.setSelected(true);
			CargaRA0.setSelected(false);
		}
	}

	public void RecebeCargaRB(char cargaRb) {
		if (cargaRb == '0') {
			CargaRB0.setSelected(true);
			CargaRB1.setSelected(false);
		} else {
			CargaRB1.setSelected(true);
			CargaRB0.setSelected(false);
		}

	}

	public void RecebeCargaRX(char cargaRx) {

		if (cargaRx == '0') {
			CargaRX0.setSelected(true);
			CargaRX1.setSelected(false);
		} else {
			CargaRX1.setSelected(true);
			CargaRX0.setSelected(false);
		}
	}

	public void RecebeCargaREM(char cargaREM) {

		if (cargaREM == '0') {
			CargaREM0.setSelected(true);
			CargaREM1.setSelected(false);
		} else {
			CargaREM1.setSelected(true);
			CargaREM0.setSelected(false);
		}
	}

	public void RecebeCargaRDM(char cargaRDM) {

		if (cargaRDM == '0') {
			CargaRDM0.setSelected(true);
			CargaRDM1.setSelected(false);
		} else {
			CargaRDM1.setSelected(true);
			CargaRDM0.setSelected(false);
		}
	}

	public void RecebeCargaRI(char cargaRx) {

		if (cargaRx == '0') {
			CargaRI0.setSelected(true);
			CargaRI1.setSelected(false);
		} else {
			CargaRI1.setSelected(true);
			CargaRI0.setSelected(false);
		}
	}

	public void RecebeCargaS1(char cargaRI) {
		if (cargaRI == '0') {
			MUXS1.setText("0");
		}
		if (cargaRI == '1') {
			MUXS1.setText("1");
		}
	}

	public void RecebeCargaS2(char cargaS2) {
		if (cargaS2 == '0') {
			MUXS2.setText("0");
		}
		if (cargaS2 == '1') {
			MUXS2.setText("1");
		}
	}

	public void RecebeCargaS3(char cargaS3) {
		if (cargaS3 == '0') {
			MUXS3.setText("0");
		}
		if (cargaS3 == '1') {
			MUXS3.setText("1");
		}
	}

	public void RecebeCargaS4(char cargaS4) {
		if (cargaS4 == '0') {
			MUXS4.setText("0");
		}
		if (cargaS4 == '1') {
			MUXS4.setText("1");
		}
	}

	public void RecebeCargaS5(char cargaS5) {
		if (cargaS5 == '0') {
			MUXS5.setText("0");
		}
		if (cargaS5 == '1') {
			MUXS5.setText("1");
		}
	}

	public void RecebeCargaAluMSB(char cargaAluMsb) {
		if (cargaAluMsb == '0') {
			ALUMSB.setText("0");
		}
		if (cargaAluMsb == '1') {
			ALUMSB.setText("1");
		}
	}

	public void RecebeCargaAlu2MSB(char cargaAlu2Msb) {
		if (cargaAlu2Msb == '0') {
			ALU2MSB.setText("0");
		}
		if (cargaAlu2Msb == '1') {
			ALU2MSB.setText("1");
		}
	}

	public void RecebeCargaAluLSB(char cargaAluLSB) {
		if (cargaAluLSB == '0') {
			ALULSB.setText("0");
		}
		if (cargaAluLSB == '1') {
			ALULSB.setText("1");
		}
	}

	public void RecebeCargaCarry(byte cargaCarry) {
		if (cargaCarry == 0) {
			Carry.setSelected(false);
		} else
			Carry.setSelected(true);
	}

	public void RecebeCargaNegativo(byte cargaNegativo) {
		if (cargaNegativo == 0) {
			Negativo.setSelected(false);
		} else
			Negativo.setSelected(true);
	}

	public void RecebeCargaZero(byte cargaZero) {
		if (cargaZero == 0) {
			Zero.setSelected(false);
		} else
			Zero.setSelected(true);
	}

	public void RecebeCargaRead(char cargaRead) {
		if (cargaRead == '0') {
			Read.setSelected(false);
		} else
			Read.setSelected(true);
	}

	public void RecebeCargaWrite(char cargaWrite) {
		if (cargaWrite == '0') {
			Write.setSelected(false);
		} else
			Write.setSelected(true);
	}

	public void RecebeCargaPC(char cargaPC, byte value) {
		if (cargaPC == '0') {
			CargaPC0.setSelected(true);
			CargaPC1.setSelected(false);
		} else {
			CargaPC1.setSelected(true);
			CargaPC0.setSelected(false);
		}
		incrementaPC.setText(String.valueOf(value));
	}

	public void valorPC(byte cargaPC) {
		incrementaPC.setText(String.valueOf(cargaPC));
	}

	public void valorRA(byte cargaRA) {
		valorRA.setText(String.valueOf(cargaRA));
	}

	public void valorRB(byte cargaRB) {
		valorRB.setText(String.valueOf(cargaRB));
	}

	public void valorRX(byte cargaRX) {
		valorRX.setText(String.valueOf(cargaRX));
	}

	public void valorREM(byte cargaREM) {
		valorREM.setText(String.valueOf(cargaREM));
	}

	public void valorRDM(byte cargaRDM) {
		valorRDM.setText(String.valueOf(cargaRDM));
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void indices() {
		int i;
		// System.out.println(tableMemory.getRowCount());
		for (i = 0; i < 256; i++) {
			tableMemory.setValueAt(i, i, 0);
		}
	}

	public void updateMemoryList(Byte value, int row) {
		tableMemory.setValueAt(value, row, 1);
	}

	public void insertTable(byte value, int address) {
		tableMemory.setValueAt(value, address, 1);
	}
}
