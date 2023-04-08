package Conversor;


	

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.text.DecimalFormat;

	@SuppressWarnings("serial")
	public class conversorTemperatura extends JFrame {

		private JTextField temperatura;
		private JComboBox<String> unidadTemperatura, unidad2;
		private JButton Converte, Voltar;
		private JLabel resultado;

		public conversorTemperatura() {

			setTitle("Conversor de Temperatura");
			setLayout(null);

			temperatura = new JTextField(10);
			temperatura.setBounds(160, 20, 150, 30);
			temperatura.setForeground(Color.WHITE);
			temperatura.setBackground(new Color(34, 124, 112));
			temperatura.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(temperatura);

			JLabel jlQuantidade = new JLabel("Quantidade:");
			jlQuantidade.setBounds(15, 20, 170, 30);
			jlQuantidade.setForeground(new Color(34, 124, 112));
			jlQuantidade.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(jlQuantidade);

			String[] items = { "Celsius", "Fahrenheit", "Kelvin" };
			unidadTemperatura = new JComboBox<String>(items);
			unidadTemperatura.setBounds(160, 60, 150, 30);
			unidadTemperatura.setForeground(Color.WHITE);
			unidadTemperatura.setBackground(new Color(34, 124, 112));
			unidadTemperatura.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(unidadTemperatura);

			JLabel jlUnidad = new JLabel("Temperatura a : ");
			jlUnidad.setBounds(15, 60, 170, 30);
			jlUnidad.setForeground(new Color(34, 124, 112));
			jlUnidad.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(jlUnidad);

			String[] items2 = { "Celsius", "Fahrenheit", "Kelvin" };
			unidad2 = new JComboBox<String>(items2);
			unidad2.setBounds(160, 120, 150, 30);
			unidad2.setForeground(Color.WHITE);
			unidad2.setBackground(new Color(34, 124, 112));
			unidad2.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(unidad2);

			JLabel jlCambio = new JLabel("Temperatura de : ");
			jlCambio.setBounds(15, 120, 150, 30);
			jlCambio.setForeground(new Color(34, 124, 112));
			jlCambio.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(jlCambio);

			Converte = new JButton("Converte");
			Converte.setBounds(15, 200, 120, 30);
			Converte.setForeground(Color.WHITE);
			Converte.setBackground(new Color(34, 124, 112));
			Converte.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(Converte);

			Converte.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					try {

						double quantidade = Double.parseDouble(temperatura.getText());

						String opcao1 = (String) unidadTemperatura.getSelectedItem();
						String opcao2 = (String) unidad2.getSelectedItem();
						double total = 0;

						if (opcao1.equals("Kelvin") && opcao2.equals("Celsius")) {
							total = quantidade - 273.15;

						} else if (opcao1.equals("Kelvin") && opcao2.equals("Fahrenheit")) {
							total = (quantidade - 273.15) * 9 / 5 + 32;

						} else if (opcao1.equals("Celsius") && opcao2.equals("Kelvin")) {
							total = quantidade + 273.15;

						} else if (opcao1.equals("Celsius") && opcao2.equals("Fahrenheit")) {
							total = (quantidade * 9 / 5) + 32;

						} else if (opcao1.equals("Fahrenheit") && opcao2.equals("Kelvin")) {
							total = (quantidade - 32) * 5 / 9 + 273.15;

						} else if (opcao1.equals("Fahrenheit") && opcao2.equals("Celsius")) {
							total = (quantidade - 32) * 5 / 9;

						}

						DecimalFormat df = new DecimalFormat("#.##");
						df.format(total);

						resultado.setText(quantidade + " " + opcao1 + " = " + total + " " + opcao2);

					} catch (NumberFormatException ex) {

						resultado.setText("Digite um número válido!");
					}

				}

			});
			setVisible(true);

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
			resultado.setBounds(15, 270, 270, 30);
			resultado.setForeground(new Color(34, 124, 112));
			resultado.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(resultado);

			setSize(350, 350);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);

		}

		public static void main(String[] args) {
			conversorTemperatura conversor2 = new conversorTemperatura();
			conversor2.setVisible(true);
		}

	}	





