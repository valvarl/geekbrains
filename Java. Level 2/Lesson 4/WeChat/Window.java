package WeChat;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Window extends JFrame {
    Font sf;

    public Window() throws HeadlessException {
        setTitle("WeChat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(750, 600));

        try {
            sf = Font.createFont(Font.TRUETYPE_FONT,
                    Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("WeChat/SFUIText-Regular.ttf")));
            /*GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(Font.createFont(Font.TRUETYPE_FONT,
                    Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("WeChat/SFUIText-Regular.ttf"))));*/
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        add(new MessagePanel(this), BorderLayout.SOUTH);
        JScrollPane dialogue = new JScrollPane(new DialoguePanel(this));
        dialogue.setBorder(null);
        add(dialogue, BorderLayout.PAGE_START);

        setDefaultLookAndFeelDecorated(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
