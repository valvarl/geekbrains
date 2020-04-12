import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import javax.swing.JFrame;
public class TextLayoutLineBreakerMeasurer extends JFrame {
    String m = "\u05E9\u05DC\u05D5\u05DD \u05E2\u05D5\u05DC\u05DD";
    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font font = new Font("LucidaSans", Font.PLAIN, 14);
        AttributedString messageAS = new AttributedString(m);
        messageAS.addAttribute(TextAttribute.FONT, font);
        AttributedCharacterIterator messageIterator = messageAS.getIterator();
        FontRenderContext messageFRC = graphics2D.getFontRenderContext();
        LineBreakMeasurer messageLBM = new LineBreakMeasurer(messageIterator,
                messageFRC);
        Insets insets = getInsets();
        float wrappingWidth = getSize().width - insets.left - insets.right;
        float x = insets.left;
        float y = insets.top;
        while (messageLBM.getPosition() < messageIterator.getEndIndex()) {
            TextLayout textLayout = messageLBM.nextLayout(wrappingWidth);
            y += textLayout.getAscent();
            textLayout.draw(graphics2D, x, y);
            y += textLayout.getDescent() + textLayout.getLeading();
            x = insets.left;
        }
    }
    public static void main(String[] args) {
        JFrame frame = new TextLayoutLineBreakerMeasurer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(200,200);
        frame.setVisible(true);
    }
}