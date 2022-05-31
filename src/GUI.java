import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

public class GUI implements ActionListener
{
    private JTextArea userInfo;
    private JTextField foodSelection;
    // private NetworkingClient client;
    private JButton sendButton;
    private JButton resetButton;
    private JCheckBox checkBox;
//    private RateMyFood rateMyFoodData;
    private JFrame frame;

    private BufferedImage image = new BufferedImage(10, 10, 2);

    private JLabel pictureLabel = null;

    public GUI()
    {
        userInfo = new JTextArea(3, 20);
        foodSelection = new JTextField();
        sendButton = new JButton("Send");
        resetButton = new JButton("Reset");


        // setup GUI and load screen
        setupGui();
    }

    private void setupGui()
    {
        //Creating a Frame
        frame = new JFrame("RateMyFood");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ends program when you hit the X

        // Creating an image from a jpg file stored in the src directory
//        ImageIcon image = new ImageIcon("https://cdn.uconnectlabs.com/wp-content/uploads/sites/7/2021/07/thumbs-up-4007573_640-e1631622199684.png?v=156236");
        //BufferedImage image = null;
        try
        {
            // we pick our own URL for the main visual when our GUI opens
            URL imageURL = new URL("https://cdn.uconnectlabs.com/wp-content/uploads/sites/7/2021/07/thumbs-up-4007573_640-e1631622199684.png?v=156236");
            image = ImageIO.read(imageURL);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        pictureLabel = new JLabel(new ImageIcon(image));
        JLabel welcomeLabel = new JLabel("Welcome to RateMyFood!");
        welcomeLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        welcomeLabel.setForeground(new Color(85, 213, 242));

        JPanel logoWelcomePanel = new JPanel(); // the panel is not visible in output
        logoWelcomePanel.add(pictureLabel);
        logoWelcomePanel.add(welcomeLabel);
        logoWelcomePanel.setVisible(true);

        // middle panel with weather list
        JPanel userPanel = new JPanel();
        // Maybe not?
        userInfo.setText("Screen loading...");
        userInfo.setFont(new Font("Helvetica", Font.PLAIN, 16));
        userInfo.setWrapStyleWord(true);
        userInfo.setLineWrap(true);
        userPanel.add(userInfo);

        //bottom panel with text field and buttons
        JPanel entryPanel = new JPanel(); // the panel is not visible in output
        JLabel foodPrefLabel = new JLabel("Enter food preference: ");

        foodSelection = new JTextField(10); // accepts up to 10 characters
        entryPanel.add(foodPrefLabel);
        entryPanel.add(foodSelection);
        entryPanel.add(sendButton);
        entryPanel.add(resetButton);
        entryPanel.add(checkBox);



        //Adding Components to the frame
        frame.add(logoWelcomePanel, BorderLayout.NORTH);
        frame.add(userInfo, BorderLayout.CENTER);
        frame.add(entryPanel, BorderLayout.SOUTH);

        // PART 2 -- SET UP EVENT HANDLING
        //setting up buttons to use ActionListener interface and actionPerformed method
        sendButton.addActionListener(this);
        resetButton.addActionListener(this);
        checkBox.addActionListener(this);

        // showing the frame
        frame.pack();
        frame.setVisible(true);
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     if(e.getSource().equals(sendButton))
    //     {
    //         try
    //         {
    //             weather.setTemperature(client.parseTemp(client.getJSON(zipEntryField.getText())));
    //             weather.setCondition(client.parseCondition(client.getJSON(zipEntryField.getText())));
    //             weatherInfo.setText("Temperature: " + weather.getTemperature() + "\nCondition: " + weather.getCondition());
    //             URL imageURL = new URL(client.parseImageURL(client.getJSON(zipEntryField.getText())));
    //             image = ImageIO.read(imageURL);
    //             pictureLabel = new JLabel(new ImageIcon(image));
    //             frame.pack();
    //             //setupGui(client.parseImageURL(client.getJSON(zipEntryField.getText())));
    //         }
    //         catch(Exception l)
    //         {
    //             System.out.println(l.getMessage());
    //         }



    //     }
    //     if (e.getSource().equals(resetButton))
    //     {
    //         zipEntryField.setText("");
    //         weatherInfo.setText("");
    //         checkBox = new JCheckBox("Celsius");
    //         weather.setFahrenheit(true);
    //     }
    //     if(e.getSource().equals(checkBox))
    //     {
    //         if(checkBox.isSelected())
    //         {
    //             weather.setFahrenheit(false);
    //         }
    //         else
    //         {
    //             weather.setFahrenheit(true);
    //         }
    //         weatherInfo.setText("Temperature: " + weather.getTemperature() + "\nCondition: " + weather.getCondition());
    //     }
    // }
}
