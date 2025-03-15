package dev.ernandorezende.translator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Frame {

    private final Translator translator;

    private final JTextArea txtrSourcetextarea = new JTextArea();
    private final JTextArea txtTargetTextarea = new JTextArea();
    private final JComboBox<String> sourceComboBox;
    private final JComboBox<String> targetComboBox;

    public Frame(Translator translator, String[] languages) {
        this.translator = translator;
        sourceComboBox = new JComboBox<>(languages);
        targetComboBox = new JComboBox<>(languages);

        JFrame frame = new JFrame();
        frame.setBounds(100, 100,600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ER Translator");
        frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

        JPanel sourcePanel = new JPanel();
        frame.getContentPane().add(sourcePanel);
        sourcePanel.setLayout(null);

        txtrSourcetextarea.setLineWrap(true);
        txtrSourcetextarea.setWrapStyleWord(true);

        txtrSourcetextarea.setText("Enter Here to translate");
        txtrSourcetextarea.setBounds(22, 65, 248, 264);
        sourcePanel.add(txtrSourcetextarea);

        sourceComboBox.setBounds(32, 23, 216, 31);
        sourcePanel.add(sourceComboBox);

        JLabel lblTo = new JLabel("To =>");
        lblTo.setBounds(257, 31, 70, 15);
        sourcePanel.add(lblTo);

        JPanel targetPanel = new JPanel();
        frame.getContentPane().add(targetPanel);
        targetPanel.setLayout(null);

        txtTargetTextarea.setLineWrap(true);
        txtTargetTextarea.setWrapStyleWord(true);
        txtTargetTextarea.setBounds(12, 65, 248, 264);
        targetPanel.add(txtTargetTextarea);

        targetComboBox.setBounds(22, 23, 216, 31);
        targetPanel.add(targetComboBox);

        JButton btnTranslate = new JButton("Translate");
        btnTranslate.addActionListener(this::btnTranslateEvent);
        btnTranslate.setBounds(40, 330, 200, 30);
        targetPanel.add(btnTranslate);

        frame.setVisible(true);
    }

    void btnTranslateEvent(ActionEvent event) {
        txtTargetTextarea.setText(this.translator.translate(txtrSourcetextarea.getText(),
                ((String) Objects.requireNonNull(sourceComboBox.getSelectedItem())).substring(0,2),
                ((String) Objects.requireNonNull(targetComboBox.getSelectedItem())).substring(0,2)));
    }
}
