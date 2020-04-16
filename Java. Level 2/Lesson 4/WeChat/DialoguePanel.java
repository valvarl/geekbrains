package WeChat;

import javax.swing.*;
import java.awt.*;

public class DialoguePanel extends JPanel {
    public static final int USER = 1;
    public static final int PEN_PAL = 2;

    private Window window;
    private GridBagConstraints c = new GridBagConstraints();
    private int lineCounter = 0;

    public DialoguePanel(JFrame frame) {
        super(new GridBagLayout());
        window = (Window) frame;

        c.fill = GridBagConstraints.RELATIVE;
        c.insets = new Insets(10,10,0,10);
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;
    }

    public class line extends RoundedPanel {
        JTextArea line;
        public line(String text) {
            super(18, Color.WHITE);
            line = new JTextArea(text);
            line.setColumns(40);
            line.setLineWrap(true);
            line.setWrapStyleWord(true);
            line.setFont(window.sf.deriveFont(14f));
            line.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
            add(line);
        }
    }

    public void add(String text, int from){

        c.gridy = lineCounter++;
        if (from == USER){
            c.anchor = GridBagConstraints.NORTHWEST;
            add(new line(text), c);
        } else if (from == PEN_PAL) {
            c.anchor = GridBagConstraints.NORTHEAST;
            add(new line(text), c);
        }
        revalidate();
    }
}
