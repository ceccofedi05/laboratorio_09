package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame("My first Java graphical interface");

    private SimpleGUI(final Controller controller) {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        final JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());
        final JTextArea text = new JTextArea();
        panel.add(text, BorderLayout.CENTER);
        final JButton button = new JButton("Save");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.saveContentToFile(text.getText());
                } catch (final IOException t) {
                    System.out.println(t.getMessage()); //NOPMD
                }
            }
        });
        panel.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * launches the application.
     * 
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUI(new Controller());
    }

}
