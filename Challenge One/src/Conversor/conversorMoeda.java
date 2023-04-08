package Conversor;



	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.text.DecimalFormat;

	@SuppressWarnings("serial")
	public class conversorMoeda extends JFrame {

		private JTextField Valor;
		private JComboBox<String> fromMoedas;
		private JComboBox<String> toMoedas;
		private JButton Converte, Voltar;
		private JLabel resultado;

		public conversorMoeda() {

			setTitle("Conversor de Moeda");
			setLayout(null);

			Valor = new JTextField(10);
			Valor.setBounds(160, 20, 150, 30);
			Valor.setForeground(Color.WHITE);
			Valor.setBackground(new Color(34, 124, 112));
			Valor.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(Valor);

			JLabel jlValor = new JLabel("Valor : ");
			jlValor.setBounds(15, 20, 170, 30);
			jlValor.setForeground(new Color(34, 124, 112));
			jlValor.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(jlValor);

			String[] items = { "REAL", "DOLAR", "EURO", "LIBRA", "P.ARGENTINO", "P.CHILENO" };
			fromMoedas = new JComboBox<String>(items);
			fromMoedas.setBounds(160, 60, 150, 30);
			fromMoedas.setForeground(Color.WHITE);
			fromMoedas.setBackground(new Color(34, 124, 112));
			fromMoedas.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(fromMoedas);

			JLabel jlBase = new JLabel("Moeda base : ");
			jlBase.setBounds(15, 60, 170, 30);
			jlBase.setForeground(new Color(34, 124, 112));
			jlBase.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(jlBase);

			String[] items2 = { "REAL", "DOLAR", "EURO", "LIBRA", "P.ARGENTINO", "P.CHILENO" };
			toMoedas = new JComboBox<String>(items2);
			toMoedas.setBounds(160, 120, 150, 30);
			toMoedas.setForeground(Color.WHITE);
			toMoedas.setBackground(new Color(34, 124, 112));
			toMoedas.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(toMoedas);

			JLabel jlCambio = new JLabel("Cambio a : ");
			jlCambio.setBounds(15, 120, 150, 30);
			jlCambio.setForeground(new Color(34, 124, 112));
			jlCambio.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(jlCambio);

			Converte = new JButton("Converte");
			Converte.setBounds(15, 200, 120, 30);
			Converte.setForeground(Color.WHITE);
			Converte.setBackground(new Color(34, 124, 112));
			Converte.setFont(new Font("Tahoma", Font.BOLD, 16));

			Converte.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					converteMoeda();

				}

			});
			add(Converte);

			Voltar = new JButton("Voltar");
			Voltar.setBounds(190, 200, 120, 30);
			Voltar.setForeground(Color.WHITE);
			Voltar.setBackground(new Color(34, 124, 112));
			Voltar.setFont(new Font("Tahoma", Font.BOLD, 16));

			Voltar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					dispose();
					principal principalframe = new principal();
					principalframe.setVisible(true);

				}

			});
			add(Voltar);

			resultado = new JLabel(" ");
			resultado.setBounds(50, 270, 250, 30);
			resultado.setForeground(new Color(34, 124, 112));
			resultado.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(resultado);

			setSize(600, 450);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

		private void converteMoeda() {

			try {

				double quantidade = Double.parseDouble(Valor.getText());
				String de = (String) fromMoedas.getSelectedItem();
				String para = (String) toMoedas.getSelectedItem();

				double estimado = 0;

				if (de.equals("REAL") && para.equals("DOLAR")) {
					estimado = 0.20;
				} else if (de.equals("REAL") && para.equals("EURO")) {
					estimado = 0.18;
				} else if (de.equals("REAL") && para.equals("LIBRA")) {
					estimado = 0.16;
				} else if (de.equals("REAL") && para.equals("P.ARGENTINO")) {
					estimado = 41.43;
				} else if (de.equals("REAL") && para.equals("P.CHILENO")) {
					estimado = 157.27;
				} else if (de.equals("DOLAR") && para.equals("REAL")) {
					estimado = 5.04;
				} else if (de.equals("EURO") && para.equals("REAL")) {
					estimado = 5.48;
				} else if (de.equals("LIBRA") && para.equals("REAL")) {
					estimado = 6.24;
				} else if (de.equals("P.ARGENTINO") && para.equals("REAL")) {
					estimado = 0.024;
				} else if (de.equals("P.CHILENO") && para.equals("REAL")) {
					estimado = 0.006;
				} else if (de.equals("DOLAR") && para.equals("EURO")) {
					estimado = 0.92;

				} else if (de.equals("DOLAR") && para.equals("LIBRA")) {
					estimado = 0.81;
				}

				else if (de.equals("DOLAR") && para.equals("P.ARGENTINO")) {
					estimado = 208.91;
				}

				else if (de.equals("DOLAR") && para.equals("P.CHILENO")) {
					estimado = 793.00;
				}

				else if (de.equals("EURO") && para.equals("DOLAR")) {
					estimado = 1.09;
				}

				else if (de.equals("EURO") && para.equals("LIBRA")) {
					estimado = 0.88;
				}

				else if (de.equals("EURO") && para.equals("P.ARGENTINO")) {
					estimado = 227.03;
				}

				else if (de.equals("EURO") && para.equals("P.CHILENO")) {
					estimado = 861.65;
				}

				else if (de.equals("LIBRA") && para.equals("DOLAR")) {
					estimado = 1.24;
				}

				else if (de.equals("LIBRA") && para.equals("EURO")) {
					estimado = 1.14;
				}

				else if (de.equals("LIBRA") && para.equals("P.ARGENTINO")) {
					estimado = 258.69;
				}

				else if (de.equals("LIBRA") && para.equals("P.CHILENO")) {
					estimado = 985.37;
				}

				else if (de.equals("P.ARGENTINO") && para.equals("DOLAR")) {
					estimado = 0.004;
				}

				else if (de.equals("P.ARGENTINO") && para.equals("EURO")) {
					estimado = 0.004;
				}

				else if (de.equals("P.ARGENTINO") && para.equals("LIBRA")) {
					estimado = 0.003;
				}

				else if (de.equals("P.ARGENTINO") && para.equals("P.CHIL")) {
					estimado = 3.80;
				}

				else if (de.equals("P.CHILENO") && para.equals("DOLAR")) {
					estimado = 0.001;
				}

				else if (de.equals("P.CHILENO") && para.equals("EURO")) {
					estimado = 0.001;
				}

				else if (de.equals("P.CHILENO") && para.equals("LIBRA")) {
					estimado = 0.001;
				}

				else if (de.equals("P.CHILENO") && para.equals("P.ARGENTINO")) {
					estimado = 0.26;
				}

				DecimalFormat df = new DecimalFormat("#.##");
				String total = df.format(quantidade * estimado);
				resultado.setText(quantidade + " " + de + " = " + total + " " + para);

			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(this, "Por favor, digite um número válido!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}

		public static void main(String[] args) {
			conversorMoeda conversor1 = new conversorMoeda();
			conversor1.setVisible(true);
		}

	}	




