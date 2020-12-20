package Lab8;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Program
{
    private JLabel framevar;
    private JLabel resX;
    private JLabel resY;
    private JLabel resN;
    private JTextField dX;
    private JTextField dY;
    private JTextField dN;
    public Program ()
    {
        final JFrame jfrm = new JFrame ( "Kurashova, OOP" );
        jfrm.setSize ( 310, 100);
        jfrm.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        jfrm.setLayout ( new FlowLayout ( FlowLayout.LEFT ) );
        jfrm.setLocationRelativeTo(null);

        framevar = new JLabel ( "Enter X:" );
        jfrm.add ( framevar );
        dX = new JTextField ( 8 );
        jfrm.add ( dX );
        resX = new JLabel (); 
        jfrm.add ( resX );
        
        framevar = new JLabel ( "Enter Y:" );
        jfrm.add ( framevar );
        dY = new JTextField ( 8 );
        jfrm.add ( dY );
        resY = new JLabel (); 
        jfrm.add ( resY );
        
        framevar = new JLabel ( "Enter N" );
        jfrm.add ( framevar );
        dN = new JTextField ( 8 );
        jfrm.add ( dN );
        resN = new JLabel (); 
        jfrm.add ( resN );
        
        final JButton bt = new JButton ( "Calculate" ); 
        bt.addActionListener ( new ActionListener()
        {
            public void actionPerformed ( ActionEvent e )
            {
                String numberX = dX.getText ();
                String numberY = dY.getText ();
                String numberN = dN.getText ();
                try
                {
                    int numberx = Integer.parseInt ( numberX );
                    int numbery = Integer.parseInt ( numberY );
                    int numbern = Integer.parseInt ( numberN );
                    
                    Decision d = new Decision();
                     d.FirstDecision(numbery, numberx, numbern);
                    d.SecondDecision(numbery, numberx, numbern);
                }
                catch ( NumberFormatException ex )
                {
                    JOptionPane.showMessageDialog ( jfrm, "Error", "Incorrect input",  //Error message
                            JOptionPane.ERROR_MESSAGE );
                }
            }
        } );
        jfrm.add ( bt );
        jfrm.setVisible ( true );
    }
    public static void main ( String[] args )
    {
        SwingUtilities.invokeLater ( new Runnable(){
            public void run ()
            {
                new Program ();
            }
        } );
    }
}