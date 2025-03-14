package dev.ernandorezende.translator;

import javax.swing.JFrame;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

public class App {

	private Translator translator;

    public App() {
		initialize();
	}

    /**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		translator = new Translator();
        LanguagesRepository languagesRepository = new LanguagesRepository();

        JFrame frame = new JFrame();
		frame.setBounds(100, 100,600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("ER Translator");
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel sourcePanel = new JPanel();
		frame.getContentPane().add(sourcePanel);
		sourcePanel.setLayout(null);
		
		final JTextArea txtrSourcetextarea = new JTextArea();
		txtrSourcetextarea.setLineWrap(true);
		txtrSourcetextarea.setWrapStyleWord(true);
		txtrSourcetextarea.setText("Enter Here to translate");
		txtrSourcetextarea.setBounds(22, 65, 248, 264);
		sourcePanel.add(txtrSourcetextarea);
		
		final JComboBox<String> sourceComboBox = new JComboBox<>(languagesRepository.getLanguages());
		sourceComboBox.setBounds(32, 23, 216, 31);
		sourcePanel.add(sourceComboBox);
		
		JLabel lblTo = new JLabel("To->");
		lblTo.setBounds(257, 31, 70, 15);
		sourcePanel.add(lblTo);
		
		JPanel targetPanel = new JPanel();
		frame.getContentPane().add(targetPanel);
		targetPanel.setLayout(null);
		
		final JTextArea txtTargetTextarea = new JTextArea();
		txtTargetTextarea.setLineWrap(true);
		txtTargetTextarea.setWrapStyleWord(true);
		txtTargetTextarea.setBounds(12, 65, 248, 264);
		targetPanel.add(txtTargetTextarea);
		
		final JComboBox<String> targetComboBox = new JComboBox<>(languagesRepository.getLanguages());
		targetComboBox.setBounds(22, 23, 216, 31);
		targetPanel.add(targetComboBox);
		
		JButton btnTranslate = new JButton("Translate");
		btnTranslate.addActionListener(e -> txtTargetTextarea.setText(translator.translate(txtrSourcetextarea.getText(),
                                            ((String)sourceComboBox.getSelectedItem()).substring(0,2),
                                            ((String)targetComboBox.getSelectedItem()).substring(0,2))));
		btnTranslate.setBounds(40, 330, 200, 30);
		targetPanel.add(btnTranslate);

		frame.setVisible(true);
	}

    public static void main(String[] args) {
    	new App();
    	
    }
}
