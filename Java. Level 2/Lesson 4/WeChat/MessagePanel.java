package WeChat;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessagePanel extends JPanel {
    private Window window;
    private JTextArea ta;
    private JButton button;

    public MessagePanel(JFrame frame) {
        window = (Window) frame;

        JPanel tap = new RoundedPanel(15, Color.WHITE);
        ta = new JTextArea();
        ta.setColumns(40);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setFont(window.sf.deriveFont(14f));
        ta.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        JScrollPane scroll = new JScrollPane (ta);
        scroll.setBorder(null);
        tap.add(scroll);

        button = new JButton("Send");
        button.setFont(window.sf.deriveFont(14f));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!ta.getText().equals("")) {
                    System.out.println(((JScrollPane) window.getContentPane().getComponent(1)));
                    ((DialoguePanel) ((JScrollPane) window.getContentPane().getComponent(1)).getViewport().getView())
                            .add(ta.getText().strip(), DialoguePanel.USER);
                    ta.setText("");
                    ((JScrollPane) window.getContentPane().getComponent(1)).getViewport().getView().revalidate();
                }
            }
        });

        ta.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent caretEvent) {
                if (ta.getLineCount() <= 10){
                    ta.setRows(ta.getLineCount());
                    tap.revalidate();
                }
            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        add(tap, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.insets.left = 0;
        c.weightx = 0;
        c.gridx = 1;
        c.gridy = 0;
        add(button, c);
    }
}
