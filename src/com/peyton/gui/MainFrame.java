package com.peyton.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener, FocusListener {

	JPanel title = new JPanel();
	JPanel wordPanel = new JPanel();
	JPanel verbPanel = new JPanel();

	JLabel titlelabel = new JLabel();

	JLabel wordText = new JLabel("Palabra:");
	JTextField wordBox = new JTextField("~[PALABRA]~");
	JButton wordButton = new JButton("Buscar");

	JLabel verbText = new JLabel("Verbo:");
	JTextField verbBox = new JTextField("~[VERBO]~");
	JButton verbButton = new JButton("Buscar");

	Color originalBoxColor;
	Color focusBoxColor = Color.GREEN;

	public MainFrame() {
		JPanel title = new JPanel();
		JPanel wordPanel = new JPanel();
		JPanel verbPanel = new JPanel();

		// Titlepanel
		titlelabel.setText("Ayuda de Español!");
		title.add(titlelabel);

		// wordPanel

		wordButton.addActionListener(this);
		wordBox.addActionListener(this);
		originalBoxColor = wordBox.getBackground();
		wordBox.addFocusListener(this);
		wordPanel.setLayout(new BorderLayout());
		wordPanel.add(wordText, BorderLayout.NORTH);
		wordPanel.add(wordBox, BorderLayout.CENTER);
		wordPanel.add(wordButton, BorderLayout.SOUTH);

		// verbpanel
		verbButton.addActionListener(this);
		verbBox.addActionListener(this);
		verbBox.addFocusListener(this);
		verbPanel.setLayout(new BorderLayout());
		verbPanel.add(verbText, BorderLayout.NORTH);
		verbPanel.add(verbBox, BorderLayout.CENTER);
		verbPanel.add(verbButton, BorderLayout.SOUTH);

		setLayout(new GridLayout(3, 1));
		add(title);
		add(wordPanel);
		add(verbPanel);

		pack();
		setMinimumSize(new Dimension(200, 200));
		setLocationRelativeTo(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(wordBox) || e.getSource().equals(wordButton)) {
			System.out.println("WORD SENT");
		} else if (e.getSource().equals(verbBox) || e.getSource().equals(verbButton)) {
			System.out.println("VERB SENT");
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(wordBox)) {
			wordBox.setText("");
			wordBox.setBackground(Color.GREEN);
		} else if (e.getSource().equals(verbBox)) {
			verbBox.setText("");
			verbBox.setBackground(Color.GREEN);

		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource().equals(wordBox)) {
			wordBox.setBackground(originalBoxColor);
			
			if (wordBox.getText().equals("")) {
				wordBox.setText("~[PALABRA]~");
			}
		} else if (e.getSource().equals(verbBox)) {
			verbBox.setBackground(originalBoxColor);
			if (verbBox.getText().equals("")) {
				verbBox.setText("~[VERBO]~");
			}

		}

	}
}
