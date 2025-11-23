package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame("frame");

    private SimpleGUIWithFileChooser(final Controller cntrl) {
    //Frame configuration
    final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final int sw = (int) screen.getWidth();
    final int sh = (int) screen.getHeight();
    frame.setSize(sw / PROPORTION, sh / PROPORTION);

    final JTextField txtFld = new JTextField(cntrl.getCurrentFilePath());
    txtFld.setEditable(false);
    final JButton button = new JButton("Browse...");
    final JButton save = new JButton("Save");
    final JTextField textarea = new JTextField();
    //Panel configuration
    final JPanel panel1 = new JPanel();
    final JPanel panel2 = new JPanel();
    panel2.setLayout(new BorderLayout());
    panel1.setLayout(new BorderLayout());
    frame.add(panel1);
    panel1.add(panel2, BorderLayout.NORTH);
    panel2.add(txtFld, BorderLayout.CENTER);
    panel2.add(button, BorderLayout.AFTER_LINE_ENDS);
    panel1.add(save, BorderLayout.SOUTH);
    panel1.add(textarea, BorderLayout.CENTER);
    save.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            try {
                cntrl.saveContentToFile(textarea.getText());
            } catch (final IOException t) {
                System.out.println(t.getMessage()); //NOPMD
            }
        }
    });
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
            final JFileChooser chooser = new JFileChooser(txtFld.getText());
            final int result = chooser.showSaveDialog(frame);
            switch (result) {
                case JFileChooser.APPROVE_OPTION:
                    cntrl.setCurrentFile(chooser.getSelectedFile());
                    txtFld.setText(chooser.getSelectedFile().getPath());
                    break;
                case JFileChooser.CANCEL_OPTION:
                    break;
                default: 
                    try {
                        JOptionPane.showMessageDialog(frame, result);
                    } catch (final HeadlessException t) {
                        System.out.println(t.getMessage()); //NOPMD
                    }
            }
        }

    });
    frame.setVisible(true);
    }

    /**
     * launches the application.
     * 
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser(new Controller());
    }

}
