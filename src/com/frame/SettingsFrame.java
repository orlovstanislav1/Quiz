package com.frame;

import com.quiz.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

public class SettingsFrame extends JFrame implements ActionListener {
    private final Settings settings = new Settings();
    private final JFrame frame = new JFrame();

    private final JButton saveButton;
    private final JButton noSaveButton;
    private final JTextField textField = new JTextField("Enter name");

    private final JComboBox<? extends String> themeChoose;
    private final JComboBox<? extends String> questionsCountChoose;

    private final JRadioButton timeChallenge;
    private final JRadioButton survivalChallenge;

    public SettingsFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        //определить перечень тем
        String[] themes = {"SPORT", "SCIENCE", "JAVA"};
        themeChoose = new JComboBox<>(themes);
        themeChoose.setFont(new Font("Courier", Font.BOLD, 25));
        themeChoose.setBackground(new Color(219, 206, 206));
        themeChoose.setForeground(new Color(95, 51, 51));
        themeChoose.setBounds(325, 200, 300, 50);
        themeChoose.addActionListener(this);
        themeChoose.setSelectedIndex(0);
        themeChoose.setVisible(true);
        themeChoose.setFocusable(true);
        ((JLabel) themeChoose.getRenderer()).setHorizontalAlignment(JLabel.CENTER);

        //определить кол-во вопросов
        String[] count = {"5", "10", "15"};
        questionsCountChoose = new JComboBox<>(count);
        questionsCountChoose.setFont(new Font("Courier", Font.BOLD, 25));
        questionsCountChoose.setBackground(new Color(219, 206, 206));
        questionsCountChoose.setForeground(new Color(95, 51, 51));
        questionsCountChoose.setBounds(300, 300, 300, 50);
        questionsCountChoose.addActionListener(this);
        questionsCountChoose.setSelectedIndex(0);
        questionsCountChoose.setVisible(true);

        JTextArea text = new JTextArea("Write Your name");
        JTextArea text2 = new JTextArea("Theme");
        JTextArea text3 = new JTextArea("Questions Count");
        JTextArea[] jTextAreas = {text, text2, text3};
        for (JTextArea j : jTextAreas) {
            j.setFont(new Font("Courier", Font.BOLD, 25));
            j.setVisible(true);
            j.setFont(new Font("Courier", Font.BOLD, 25));
            j.setAlignmentX(JTextField.CENTER);
            j.setBackground(new Color(50, 50, 50));
            j.setForeground(new Color(219, 206, 206));
            j.setCaretColor(Color.white);
            j.setEditable(false);
            frame.add(j);
        }

//
        text.setBounds(50, 100, 300, 100);
        text2.setBounds(50, 200, 300, 100);
        text3.setBounds(50, 300, 300, 100);
        String[] chooser = {"Time", "Survival"};

        timeChallenge = new JRadioButton("Timer");
        timeChallenge.addActionListener(this);
        survivalChallenge = new JRadioButton("Survival");
        survivalChallenge.addActionListener(this);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(timeChallenge);
        buttonGroup.add(survivalChallenge);

        timeChallenge.setBounds(100, 400, 200, 50);
        survivalChallenge.setBounds(400, 400, 200, 50);
        timeChallenge.setBackground(new Color(219, 206, 206));
        timeChallenge.setForeground(new Color(95, 51, 51));
        survivalChallenge.setBackground(new Color(219, 206, 206));
        survivalChallenge.setForeground(new Color(95, 51, 51));
        timeChallenge.setFont(new Font("Courier", Font.BOLD, 25));
        survivalChallenge.setFont(new Font("Courier", Font.BOLD, 25));

        textField.setBounds(325, 100, 300, 50);
        textField.setFont(new Font("Courier", Font.BOLD, 35));
        textField.setBackground(new Color(219, 206, 206));
        textField.setForeground(new Color(95, 51, 51));
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("Consolas", Font.PLAIN, 35));
        textField.setForeground(new Color(219, 206, 206));
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        saveButton = new JButton("Save and exit");
        saveButton.setBounds(120, 500, 150, 50);
        saveButton.setFont(new Font("Courier", Font.BOLD, 15));
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);
        saveButton.setBackground(new Color(50, 50, 50));
        saveButton.setForeground(new Color(219, 206, 206));

        noSaveButton = new JButton("Back");
        noSaveButton.setBounds(430, 500, 150, 50);
        noSaveButton.setFont(new Font("Courier", Font.BOLD, 15));
        noSaveButton.setFocusable(false);
        noSaveButton.addActionListener(this);
        noSaveButton.setBackground(new Color(50, 50, 50));
        noSaveButton.setForeground(new Color(219, 206, 206));

        frame.add(textField);
        frame.add(themeChoose);
        frame.add(questionsCountChoose);
        frame.add(saveButton);
        frame.add(noSaveButton);
        frame.add(timeChallenge);
        frame.add(survivalChallenge);

    }
//

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == themeChoose) {
            if (Objects.requireNonNull(themeChoose.getSelectedItem()).equals("JAVA"))
                settings.setFileQuestion("questions.json");
            if (themeChoose.getSelectedItem().equals("SCIENCE"))
                settings.setFileQuestion("questions.json");
            if (themeChoose.getSelectedItem().equals("SPORT"))
                settings.setFileQuestion("questions.json");
            // сохраняем в файл наш выбор темы
        }
        if (e.getSource() == questionsCountChoose) {
            // сохраняем в файл наш выбор темы
            settings.setTotal_questions(Integer.parseInt(Objects.requireNonNull(questionsCountChoose.getSelectedItem()).toString()));
        }
        //df/
        if (e.getSource() == saveButton) {
            // сохраняем в файл наш выбор имени  и го в меню
            frame.dispose();
            settings.setName(textField.getText());
            Settings.settingsWriter(settings); //сохраняем настройки в settings.json
            MainMenuFrame mainMenuFrame = new MainMenuFrame();
        }
        if (e.getSource() == noSaveButton) {
            // Домой без сохранения
            frame.dispose();
            MainMenuFrame mainMenuFrame = new MainMenuFrame();
        }
        if (e.getSource() == timeChallenge) {
            settings.setModeGame(timeChallenge.getText());
            // Выбран режим по времени
        }
        if (e.getSource() == survivalChallenge) {
            settings.setModeGame(survivalChallenge.getText());
            // Выбран режим выживания
        }

    }
}
