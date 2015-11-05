// Programmers: Chris Griffith, Oliver San Juan, Muhammad, Ken Devane
// Assignment:  Project 3, Data Structure Visualization
// Date:        November 4, 2015
// Description: This class is the GUI interface for visualizing 
//              the stack data structure. 

import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.*;
import java.lang.Object;
import javax.swing.JOptionPane;

public class StackGUI extends JApplet implements ActionListener
{
    // Declarations of class-wide variables
    private Object       object;                 // Object to be push/popped
    private JFrame       frame;                  // Used for pop up windows
    // TODO: Pop-up for stack size
    private JLabel       pushLabel;              // Label for push textbox
    private JTextField   pushText;               // Field to input push choice from user
    private JButton      pushButton;             // Button to push value on to stack
    private JButton      popButton;              // Button to pop value off of stack
    private JButton      createStack;            // Button to draw the stack
    private JButton      reset;                  // Button to reset stack
    private Color        colorSelected;          // Color of the drawings
    private String       message;                // Input to be pushed onto stack
    private int          appletWidth;            // Applet pixel width
    private int          appletHeight;           // Applet pixel Height
    private int          stackSize;              // Size of stack entered by user
    private int          xLoc;                   // X coordinate
    private int          yLoc;                   // Y coordinate
    private int          stackWidth;             // Stack width
    private int          stackHeight;            // Stack height
    

    // Initializing all elements of the GUI
    @Override
    public void init()
    {
        this.setupGUI();                     // setup the gui
    }

    private void setupGUI()
    // POST: a gui interface is created
    {
        JPanel panel;                          // Main panel
        JPanel topRow;                         // Top row GUI components panel
        GridLayout layout;                     // Border layout 

        colorSelected = new Color(0, 0, 0);    // Drawing color starts as black until changed
        
        appletHeight = getHeight();            // Height of applet in pixels
        appletWidth = getWidth();              // Width of applet in pixels
        message = "";                          // Default message

        xLoc = 0;                              // Default stack size and location values
        yLoc = 0;
        stackHeight = 0;
        stackWidth = 0;

        // Create gui components
        panel = new JPanel();
        topRow = new JPanel();
        layout = new GridLayout(2, 1);
        pushLabel = new JLabel("Input to push onto stack:");
        pushText = new JTextField(10);
        pushButton = new JButton("Push");
        popButton = new JButton("Pop");
        createStack = new JButton("Create Stack");
        reset = new JButton("Reset");

        panel.setLayout(new BorderLayout());

        // background color for north panel
        topRow.setBackground(new Color(220, 255, 193));

        // set panel size
        topRow.setSize(appletHeight / 4, appletWidth);

        topRow.setLayout(layout);

        layout.setHgap(10);
        layout.setVgap(10);

        // Add action listener to text field and buttons
        pushText.addActionListener(this);
        pushButton.addActionListener(this);
        popButton.addActionListener(this);
        createStack.addActionListener(this);
        reset.addActionListener(this);

        // Add components to the panel
        topRow.add(createStack);
        topRow.add(pushButton);
        topRow.add(popButton);
        topRow.add(pushLabel);
        topRow.add(pushText);
        //topRow.add(reset);
 
        // Add panel to GUI
        add(panel);
        panel.add(topRow, BorderLayout.NORTH);
    }

    // Display results
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        appletHeight = getHeight();              // Height of applet in pixels
        appletWidth = getWidth();                // Width of applet in pixels

        // TODO: ScaledPoints class

        g.drawRect(xLoc, yLoc, stackWidth, stackHeight);
        
    }

    // Process user actions
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int    stackSize;              //User's desired stack size

        if(e.getSource() == createStack)         // User clicked create stack button
        {
            try
            {
                while(true)
                {
                    stackSize = Integer.parseInt(JOptionPane.showInputDialog("Please enter a stack size"
                        + " greater than 0 and less than or equal to 100"));

                    if(stackSize >0 && stackSize <=100)     //Check for valid stack size
                    {
                        break;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "That is not a valid value. Please try again");
                    }
                }

                //TODO:
                //Set the Stack's location and height and width

                createStack.setEnabled(false);    //Deactivate because user can create stack once

            }
            catch(NullPointerException npe)
            {
                //Do nothing
            }

        }
    
        if(e.getSource() == pushButton)          // User clicked push button
        {
            try
            {
                message = pushText.getText();
            }
            catch(NullPointerException npe)
            {
                message = "";
            }

            // TODO: put message into stack object
            
            // TODO: call push from stack back-end class and update paint
        }

        if(e.getSource() == popButton)
        {
            // TODO: // call pop from stack and update paint

        }

        repaint();
    }
}
