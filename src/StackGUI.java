// Programmers: Chris Griffith, Oliver San Juan, Muhammad, Ken
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
    private JTextField   pushText;               // Field to input push choice from user
    private JButton      pushButton;             // Button to push value on to stack
    private JButton      popButton;              // Button to pop value off of stack
    private JButton      createStack;            // Button to draw the stack
    private JButton      reset;                  // Button to reset stack
    private Color        colorSelected;          // Color of the drawings
    private int          appletWidth;            // Applet pixel width
    private int          appletHeight;           // Applet pixel Height
    private int          stackSize;              // Size of stack entered by user
    private int          xLoc;                   // X coordinate
    private int          yLoc;                   // Y coordinate

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

        // Create gui components
        panel = new JPanel();
        topRow = new JPanel();
        layout = new GridLayout(1, 5);
        pushText = new JTextField(5);
        pushButton = new JButton("Push");
        popButton = new JButton("Pop");
        createStack = new JButton("Create Stack");
        reset = new JButton("Reset");

        panel.setLayout(new FlowLayout());

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
        topRow.add(pushText);
        topRow.add(pushButton);
        topRow.add(popButton);
        topRow.add(reset);
 
        // create new borderlayout
        //topRow.setLayout(new BorderLayout());
        
        // Add panel to GUI
        add(panel);
        panel.add(topRow, BorderLayout.CENTER);
    }

    // Display results
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        appletHeight = getHeight();              // Height of applet in pixels
        appletWidth = getWidth();                // Width of applet in pixels
    }

    // Process user actions
    @Override
    public void actionPerformed(ActionEvent e)
    {

        repaint();
    }
}
