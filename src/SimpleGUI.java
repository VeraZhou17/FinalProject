import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGUI implements MouseListener, KeyListener, ActionListener
{
    JPanel iconPanel;
    JFrame frame;
    GridLayout layout;

    public SimpleGUI() {
        setup();
    }

    private void setup() {
        // create frame
        frame = new JFrame("Simple");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create panel to hold image labels
        iconPanel = new JPanel();

        // set up panel to "listen for" mouse clicks and key presses
        iconPanel.addMouseListener(this);
        iconPanel.addKeyListener(this);

        // create 12 image labels
        JLabel lbl1 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        JLabel lbl2 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        JLabel lbl3 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        JLabel lbl4 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        JLabel lbl5 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        JLabel lbl6 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        JLabel lbl7 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        JLabel lbl8 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        JLabel lbl9 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        JLabel lbl10 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        JLabel lbl11 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        JLabel lbl12 = new JLabel(new ImageIcon("src/placeholder.jpg"));

        // add image labels to the panel
        iconPanel.add(lbl1);
        iconPanel.add(lbl2);
        iconPanel.add(lbl3);
        iconPanel.add(lbl4);
        iconPanel.add(lbl5);
        iconPanel.add(lbl6);
        iconPanel.add(lbl7);
        iconPanel.add(lbl8);
        iconPanel.add(lbl9);
        iconPanel.add(lbl10);
        iconPanel.add(lbl11);
        iconPanel.add(lbl12);

        // use a GridLayout to automatically arrange 12 images in 4 rows and 3 columns
        layout = new GridLayout(4, 3);
        layout.setHgap(5);  // horizontal spacing between images
        layout.setVgap(10);  // vertical spacing between images
        iconPanel.setLayout(layout);  // add the layout to the panel

        // add panel to frame on north side
        frame.add(iconPanel, BorderLayout.NORTH);

        // create a new panel for a button
        JPanel buttonPanel = new JPanel();
        JButton button = new JButton("click me");

        // set up button to listen for key presses
        button.addKeyListener(this);

        // set up button to listen for button clicks
        button.addActionListener(this);

        // add button to panel, then add panel to frame on south side
        buttonPanel.add(button);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // pack and display frame
        frame.pack();
        frame.setVisible(true);
    }

    // MOUSELISTENER INTERFACE METHODS
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY() + " " + e.getButton());
    }

    public void mousePressed(MouseEvent e) {
        // do nothing, but must add method to satisfy interface
    }

    public void mouseReleased(MouseEvent e) {
        // do nothing, but must add method to satisfy interface
    }

    public void mouseEntered(MouseEvent e) {
        // do nothing, but must add method to satisfy interface
    }

    public void mouseExited(MouseEvent e) {
        // do nothing, but must add method to satisfy interface
    }

    // KEYLISTENER INTERFACE METHODS
    public void keyTyped(KeyEvent e) {
        // do nothing, but must add method to satisfy interface
    }

    public void keyPressed(KeyEvent e) {
        // do nothing, but must add method to satisfy interface
    }

    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    // ACTIONLISTENER INTERFACE METHODS (for button clicks)
    public void actionPerformed(ActionEvent e) {

        // add three more images to icon panel and repack frame
        JLabel newLabel1 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        JLabel newLabel2 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        JLabel newLabel3 = new JLabel(new ImageIcon("src/placeholder.jpg"));
        iconPanel.add(newLabel1);
        iconPanel.add(newLabel2);
        iconPanel.add(newLabel3);

        // get current number of rows in iconPanel's gridlayout object
        int newNumRows = layout.getRows() + 1;

        // set layout to have one additional row to hold 3 more images
        // (NOTE! this layout object is the same one already applied to iconPanel,
        // as done on line 59, so modifying it here will reflect in iconPanel)
        layout.setRows(newNumRows);

        // repack frame to update size
        frame.pack();
    }
}
