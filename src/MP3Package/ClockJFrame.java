/*
 * File: ClockJFrame.java
 * Author: Arin Santry
 * Date Due: 3/12/19
 * Disc: Show the current system time in words, like a physical word clock
 */
package MP3Package;
import javax.swing.Timer;
import java.time.LocalTime;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClockJFrame extends javax.swing.JFrame{
    
    
    /**
     * Creates new form ClockJFrame
     */
    public ClockJFrame() {
        getContentPane().setBackground(java.awt.Color.BLACK);
        initComponents();
    }
    
    private LocalTime time = LocalTime.now(); // initialize local time
    private String timeString = time.toString(); // convert time to string
    private String hourSubstring = timeString.substring(0, 2); // get hour as a string
    private String minuteSubstring = timeString.substring(3, 5); // get minutes as a string
    private int hourInt = Integer.parseInt(hourSubstring); // make hour an int
    private int minuteInt = Integer.parseInt(minuteSubstring); // make minutes an int
    private final Color DIM = new Color(51, 51, 51); // set dim color
    private int remainMinute; // how many squares will be lit
    
    /**
     * getHour
     * gets hour info from time, decides which hour label to light
     */
    private void getHour()
    {
        // repeat hourSubstring and hourInt to make sure they update
        hourSubstring = timeString.substring(0, 2);
        hourInt = Integer.parseInt(hourSubstring);
        
        // when to display "one" as the hour
        if((hourInt == 1 && minuteInt <= 30) || (hourInt == 0 && minuteInt > 30)
            || (hourInt == 13 && minuteInt <= 30) || (hourInt == 12 && minuteInt > 30))
        {
            resetHour();
            lightLabel(oneHourLabel);
        }
        
        // when to display "two" as the hour
        else if ((hourInt == 2 && minuteInt <= 30) || (hourInt == 1 && minuteInt > 30)
                 || (hourInt == 14 && minuteInt <= 30) || (hourInt == 13 && minuteInt > 30))
        {
            resetHour();
            lightLabel(twoHourLabel);
        }
        
        // when to display "three" as the hour
        else if ((hourInt == 3 && minuteInt <= 30) || (hourInt == 2 && minuteInt > 30)
                || (hourInt == 15 && minuteInt <= 30) || (hourInt == 14 && minuteInt > 30))
        {
            resetHour();
            lightLabel(threeHourLabel);
        }
        
        // when to display "four" as the hour
        else if ((hourInt == 4 && minuteInt <= 30) || (hourInt == 3 && minuteInt > 30)
                || (hourInt == 16 && minuteInt <=30) || (hourInt == 15 && minuteInt > 30))
        {
            resetHour();
            lightLabel(fourHourLabel);
        }
        
        // when to display "five" as the hour
        else if ((hourInt == 5 && minuteInt <= 30) || (hourInt == 4 && minuteInt > 30)
                || (hourInt == 17 && minuteInt <= 30) || (hourInt == 16 && minuteInt > 30))
        {
            resetHour();
            lightLabel(fiveHourLabel);
        }
        
        // when to display "six" as the hour
        else if ((hourInt == 6 && minuteInt <= 30) || (hourInt == 5 && minuteInt > 30)
                || (hourInt == 18 && minuteInt <= 30) || (hourInt == 17 && minuteInt > 30))
        {
            resetHour();
            lightLabel(sixHourLabel);
        }
        
        // when to display "seven" as the hour
        else if ((hourInt == 7 && minuteInt <= 30) || (hourInt == 6 && minuteInt > 30)
                || (hourInt == 19 && minuteInt <= 30) || (hourInt == 18 && minuteInt > 30))
        {
            resetHour();
            lightLabel(sevenHourLabel);
        }
            
        // when to display "eight" as the hour
        else if ((hourInt == 8 && minuteInt <= 30) || (hourInt == 7 && minuteInt > 30)
                || (hourInt == 20 && minuteInt <= 30) || (hourInt == 19 && minuteInt > 30))
        {
            resetHour();
            lightLabel(eightHourLabel);
        }
    
        // when to display "nine" as the hour
        else if ((hourInt == 9 && minuteInt <= 30) || (hourInt == 8 && minuteInt > 30)
                || (hourInt == 21 && minuteInt <= 30) || (hourInt == 20 && minuteInt > 30))
        {
            resetHour();
            lightLabel(nineHourLabel);
        }
    
        // when to display "ten" as the hour
        else if ((hourInt == 10 && minuteInt <= 30) || (hourInt == 9 && minuteInt > 30)
                || (hourInt == 22 && minuteInt <= 30) || (hourInt == 21 && minuteInt > 30))
        {
            resetHour();
            lightLabel(tenHourLabel);
        }
    
        // when to display "eleven" as the hour
        else if ((hourInt == 11 && minuteInt <= 30) || (hourInt == 10 && minuteInt > 30)
                || (hourInt == 23 && minuteInt <= 30) || (hourInt == 22 && minuteInt > 30))
        {
            resetHour();
            lightLabel(elevenHourLabel);
        }
    
        // when to display "twelve" as the hour
        else if ((hourInt == 12 && minuteInt <= 30) || (hourInt == 11 && minuteInt > 30)
                || (hourInt == 0 && minuteInt <= 30) || (hourInt == 23 && minuteInt > 30))
        {
            resetHour();
            lightLabel(twelveHourLabel);
        }
    }
    
    
    /**
     * getMinute
     * get the minute info from the time
     * decide which of the minute labels to light
     */
    private void getMinute()
    {
        // repeat minuteSubstring and minuteInt to make sure they update
        minuteSubstring = timeString.substring(3, 5);
        minuteInt = Integer.parseInt(minuteSubstring);
        
        // when to display "past"
        if (minuteInt >= 0 && minuteInt < 5)
        {
            resetMinute();
            lightLabel(pastLabel);
            remainMinute = minuteInt;
        }
        
        // when to display "five minutes past"
        else if (minuteInt >= 5 && minuteInt < 10)
        {
            resetMinute();
            lightLabel(fiveLabel);
            lightLabel(minutesLabel);
            lightLabel(pastLabel);
            remainMinute = minuteInt - 5;
        }
        
        // when to display "ten minutes past"
        else if (minuteInt >= 10 && minuteInt < 15)
        {
            resetMinute();
            lightLabel(tenLabel);
            lightLabel(minutesLabel);
            lightLabel(pastLabel);
            remainMinute = minuteInt - 10;
        }
        
        // when to display "quarter past"
        else if (minuteInt >= 15 && minuteInt < 20)
        {
            resetMinute();
            lightLabel(quarterLabel);
            lightLabel(pastLabel);
            remainMinute = minuteInt - 15;
        }
        
        // when to display "twenty minutes past"
        else if (minuteInt >= 20 && minuteInt < 25)
        {
            resetMinute();
            lightLabel(twentyLabel);
            lightLabel(minutesLabel);
            lightLabel(pastLabel);
            remainMinute = minuteInt - 20;
        }
        
        // when to display "twenty five minutes past"
        else if (minuteInt >= 25 && minuteInt < 30)
        {
            resetMinute();
            lightLabel(twentyLabel);
            lightLabel(fiveLabel);
            lightLabel(minutesLabel);
            lightLabel(pastLabel);
            remainMinute = minuteInt - 25;
        }
        
        // when to display "half past" (only at 30)
        else if (minuteInt == 30)
        {
            resetMinute();
            lightLabel(halfLabel);
            lightLabel(pastLabel);
            remainMinute = 0;
        }
        
        // when to display "twenty five minutes to"
        else if (minuteInt > 30 && minuteInt <= 35)
        {
            resetMinute();
            lightLabel(twentyLabel);
            lightLabel(fiveLabel);
            lightLabel(minutesLabel);
            lightLabel(toLabel);
            remainMinute = 35 - minuteInt;
        }
        
        // when to display "twenty minutes to"
        else if (minuteInt > 35 && minuteInt <= 40)
        {
            resetMinute();
            lightLabel(twentyLabel);
            lightLabel(minutesLabel);
            lightLabel(toLabel);
            remainMinute = 40 - minuteInt;
        }
        
        // when to display "quarter to"
        else if (minuteInt > 40 && minuteInt <= 45)
        {
            resetMinute();
            lightLabel(quarterLabel);
            lightLabel(toLabel);
            remainMinute = 45 - minuteInt;
        }
        
        // when to display "ten minutes to"
        else if (minuteInt > 45 && minuteInt <= 50)
        {
            resetMinute();
            lightLabel(tenLabel);
            lightLabel(minutesLabel);
            lightLabel(toLabel);
            remainMinute = 50 - minuteInt;
        }
        
        // when to display "five minutes to"
        else if (minuteInt > 50 && minuteInt <= 55)
        {
            resetMinute();
            lightLabel(fiveLabel);
            lightLabel(minutesLabel);
            lightLabel(toLabel);
            remainMinute = 55 - minuteInt;
        }
        
        // when to display "to"
        else if (minuteInt > 55 && minuteInt <= 59)
        {
            resetMinute();
            lightLabel(toLabel);
            remainMinute = 60 - minuteInt;
        }
        
        // how many minute squares to light
        switch (remainMinute) {
                case 0:
                    dimLabel(squareLabel1);
                    dimLabel(squareLabel2);
                    dimLabel(squareLabel3);
                    dimLabel(squareLabel4);
                    break;
                case 1:
                    lightLabel(squareLabel1);
                    dimLabel(squareLabel2);
                    dimLabel(squareLabel3);
                    dimLabel(squareLabel4);
                    break;
                case 2:
                    lightLabel(squareLabel1);
                    lightLabel(squareLabel2);
                    dimLabel(squareLabel3);
                    dimLabel(squareLabel4);
                    break;
                case 3:
                    lightLabel(squareLabel1);
                    lightLabel(squareLabel2);
                    lightLabel(squareLabel3);
                    dimLabel(squareLabel4);
                    break;
                case 4:
                    lightLabel(squareLabel1);
                    lightLabel(squareLabel2);
                    lightLabel(squareLabel3);
                    lightLabel(squareLabel4);
                    break;
                default:
                    break;
            }
    }
    
    /**
     * resetHour
     * resets all hour labels to their dim color
     */
    private void resetHour()
    {
        dimLabel(oneHourLabel);
        dimLabel(twoHourLabel);
        dimLabel(threeHourLabel);
        dimLabel(fourHourLabel);
        dimLabel(fiveHourLabel);
        dimLabel(sixHourLabel);
        dimLabel(sevenHourLabel);
        dimLabel(eightHourLabel);
        dimLabel(nineHourLabel);
        dimLabel(tenHourLabel);
        dimLabel(elevenHourLabel);
        dimLabel(twelveHourLabel);
    }
    
    /**
     * resetMinute
     * resets all minute labels to their dim color
     */
    private void resetMinute()
    {
        dimLabel(halfLabel);
        dimLabel(tenLabel);
        dimLabel(quarterLabel);
        dimLabel(twentyLabel);
        dimLabel(fiveLabel);
        dimLabel(minutesLabel);
        dimLabel(toLabel);
        dimLabel(pastLabel);
    }
    
    /**
     * getTime
     * checks local time every second and sets timeString
     */
    private void getTime()
    {
        // not using swing timers but it works
        // sorry, only way I could figure it out
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                try
                {
                while(true)
                {
                    time = LocalTime.now();
                    getHour();
                    getMinute();
                    timeString = time.toString();

                    
                        Thread.sleep(1000);
                 }
                }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                
            }
        };
        
        Thread thread = new Thread(runnable);
        thread.start();
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstRowPanel = new javax.swing.JPanel();
        itIsLabel = new javax.swing.JLabel();
        halfLabel = new javax.swing.JLabel();
        tenLabel = new javax.swing.JLabel();
        secondRowPanel = new javax.swing.JPanel();
        quarterLabel = new javax.swing.JLabel();
        twentyLabel = new javax.swing.JLabel();
        thirdRowPanel = new javax.swing.JPanel();
        fiveLabel = new javax.swing.JLabel();
        minutesLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        fourthRowPanel = new javax.swing.JPanel();
        pastLabel = new javax.swing.JLabel();
        twoHourLabel = new javax.swing.JLabel();
        threeHourLabel = new javax.swing.JLabel();
        fifthRowPanel = new javax.swing.JPanel();
        oneHourLabel = new javax.swing.JLabel();
        fourHourLabel = new javax.swing.JLabel();
        fiveHourLabel = new javax.swing.JLabel();
        sixthRowPanel = new javax.swing.JPanel();
        sixHourLabel = new javax.swing.JLabel();
        sevenHourLabel = new javax.swing.JLabel();
        eightHourLabel = new javax.swing.JLabel();
        seventhRowPanel = new javax.swing.JPanel();
        nineHourLabel = new javax.swing.JLabel();
        tenHourLabel = new javax.swing.JLabel();
        elevenHourLabel = new javax.swing.JLabel();
        eighthRowPanel = new javax.swing.JPanel();
        twelveHourLabel = new javax.swing.JLabel();
        oclockLabel = new javax.swing.JLabel();
        squareLabel1 = new javax.swing.JLabel();
        squareLabel2 = new javax.swing.JLabel();
        squareLabel3 = new javax.swing.JLabel();
        squareLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(564, 565));
        setMinimumSize(new java.awt.Dimension(564, 565));
        setPreferredSize(new java.awt.Dimension(564, 565));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        firstRowPanel.setBackground(new java.awt.Color(0, 0, 0));
        firstRowPanel.setMaximumSize(new java.awt.Dimension(32767, 50));
        firstRowPanel.setMinimumSize(new java.awt.Dimension(147, 50));
        firstRowPanel.setPreferredSize(new java.awt.Dimension(492, 50));
        firstRowPanel.setLayout(new java.awt.GridLayout(1, 3));

        itIsLabel.setBackground(new java.awt.Color(0, 0, 0));
        itIsLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        itIsLabel.setForeground(new java.awt.Color(255, 255, 255));
        itIsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        itIsLabel.setText("IT IS");
        firstRowPanel.add(itIsLabel);

        halfLabel.setBackground(new java.awt.Color(0, 0, 0));
        halfLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        halfLabel.setForeground(new java.awt.Color(51, 51, 51));
        halfLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        halfLabel.setText("HALF");
        firstRowPanel.add(halfLabel);

        tenLabel.setBackground(new java.awt.Color(0, 0, 0));
        tenLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        tenLabel.setForeground(new java.awt.Color(51, 51, 51));
        tenLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenLabel.setText("TEN");
        firstRowPanel.add(tenLabel);

        secondRowPanel.setBackground(new java.awt.Color(0, 0, 0));
        secondRowPanel.setMaximumSize(new java.awt.Dimension(32767, 50));
        secondRowPanel.setMinimumSize(new java.awt.Dimension(100, 50));
        secondRowPanel.setLayout(new java.awt.GridLayout(1, 2));

        quarterLabel.setBackground(new java.awt.Color(0, 0, 0));
        quarterLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        quarterLabel.setForeground(new java.awt.Color(51, 51, 51));
        quarterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quarterLabel.setText("QUARTER");
        quarterLabel.setMaximumSize(new java.awt.Dimension(60, 50));
        quarterLabel.setMinimumSize(new java.awt.Dimension(60, 50));
        quarterLabel.setPreferredSize(new java.awt.Dimension(60, 50));
        secondRowPanel.add(quarterLabel);

        twentyLabel.setBackground(new java.awt.Color(0, 0, 0));
        twentyLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        twentyLabel.setForeground(new java.awt.Color(51, 51, 51));
        twentyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twentyLabel.setText("TWENTY");
        secondRowPanel.add(twentyLabel);

        thirdRowPanel.setBackground(new java.awt.Color(0, 0, 0));
        thirdRowPanel.setMaximumSize(new java.awt.Dimension(32767, 50));
        thirdRowPanel.setMinimumSize(new java.awt.Dimension(100, 50));
        thirdRowPanel.setPreferredSize(new java.awt.Dimension(0, 50));
        thirdRowPanel.setLayout(new java.awt.GridLayout(1, 3));

        fiveLabel.setBackground(new java.awt.Color(0, 0, 0));
        fiveLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        fiveLabel.setForeground(new java.awt.Color(51, 51, 51));
        fiveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveLabel.setText("FIVE");
        thirdRowPanel.add(fiveLabel);

        minutesLabel.setBackground(new java.awt.Color(0, 0, 0));
        minutesLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        minutesLabel.setForeground(new java.awt.Color(51, 51, 51));
        minutesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minutesLabel.setText("MINUTES");
        thirdRowPanel.add(minutesLabel);

        toLabel.setBackground(new java.awt.Color(0, 0, 0));
        toLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        toLabel.setForeground(new java.awt.Color(51, 51, 51));
        toLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toLabel.setText("TO");
        toLabel.setMaximumSize(new java.awt.Dimension(14, 14));
        toLabel.setMinimumSize(new java.awt.Dimension(14, 14));
        toLabel.setPreferredSize(new java.awt.Dimension(14, 14));
        thirdRowPanel.add(toLabel);

        fourthRowPanel.setBackground(new java.awt.Color(0, 0, 0));
        fourthRowPanel.setMaximumSize(new java.awt.Dimension(32767, 50));
        fourthRowPanel.setMinimumSize(new java.awt.Dimension(100, 50));
        fourthRowPanel.setPreferredSize(new java.awt.Dimension(583, 50));
        fourthRowPanel.setLayout(new java.awt.GridLayout(1, 3));

        pastLabel.setBackground(new java.awt.Color(0, 0, 0));
        pastLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        pastLabel.setForeground(new java.awt.Color(51, 51, 51));
        pastLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pastLabel.setText("PAST");
        fourthRowPanel.add(pastLabel);

        twoHourLabel.setBackground(new java.awt.Color(0, 0, 0));
        twoHourLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        twoHourLabel.setForeground(new java.awt.Color(51, 51, 51));
        twoHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoHourLabel.setText("TWO");
        fourthRowPanel.add(twoHourLabel);

        threeHourLabel.setBackground(new java.awt.Color(0, 0, 0));
        threeHourLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        threeHourLabel.setForeground(new java.awt.Color(51, 51, 51));
        threeHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeHourLabel.setText("THREE");
        fourthRowPanel.add(threeHourLabel);

        fifthRowPanel.setBackground(new java.awt.Color(0, 0, 0));
        fifthRowPanel.setMaximumSize(new java.awt.Dimension(32767, 50));
        fifthRowPanel.setMinimumSize(new java.awt.Dimension(100, 50));
        fifthRowPanel.setPreferredSize(new java.awt.Dimension(611, 50));
        fifthRowPanel.setLayout(new java.awt.GridLayout(1, 3));

        oneHourLabel.setBackground(new java.awt.Color(0, 0, 0));
        oneHourLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        oneHourLabel.setForeground(new java.awt.Color(51, 51, 51));
        oneHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneHourLabel.setText("ONE");
        fifthRowPanel.add(oneHourLabel);

        fourHourLabel.setBackground(new java.awt.Color(0, 0, 0));
        fourHourLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        fourHourLabel.setForeground(new java.awt.Color(51, 51, 51));
        fourHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourHourLabel.setText("FOUR");
        fifthRowPanel.add(fourHourLabel);

        fiveHourLabel.setBackground(new java.awt.Color(0, 0, 0));
        fiveHourLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        fiveHourLabel.setForeground(new java.awt.Color(51, 51, 51));
        fiveHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveHourLabel.setText("FIVE");
        fifthRowPanel.add(fiveHourLabel);

        sixthRowPanel.setBackground(new java.awt.Color(0, 0, 0));
        sixthRowPanel.setMaximumSize(new java.awt.Dimension(32767, 50));
        sixthRowPanel.setMinimumSize(new java.awt.Dimension(100, 50));
        sixthRowPanel.setPreferredSize(new java.awt.Dimension(580, 50));
        sixthRowPanel.setLayout(new java.awt.GridLayout(1, 3));

        sixHourLabel.setBackground(new java.awt.Color(0, 0, 0));
        sixHourLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        sixHourLabel.setForeground(new java.awt.Color(51, 51, 51));
        sixHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixHourLabel.setText("SIX");
        sixthRowPanel.add(sixHourLabel);

        sevenHourLabel.setBackground(new java.awt.Color(0, 0, 0));
        sevenHourLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        sevenHourLabel.setForeground(new java.awt.Color(51, 51, 51));
        sevenHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenHourLabel.setText("SEVEN");
        sixthRowPanel.add(sevenHourLabel);

        eightHourLabel.setBackground(new java.awt.Color(0, 0, 0));
        eightHourLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        eightHourLabel.setForeground(new java.awt.Color(51, 51, 51));
        eightHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightHourLabel.setText("EIGHT");
        sixthRowPanel.add(eightHourLabel);

        seventhRowPanel.setBackground(new java.awt.Color(0, 0, 0));
        seventhRowPanel.setMaximumSize(new java.awt.Dimension(32767, 50));
        seventhRowPanel.setMinimumSize(new java.awt.Dimension(100, 50));
        seventhRowPanel.setPreferredSize(new java.awt.Dimension(0, 50));
        seventhRowPanel.setLayout(new java.awt.GridLayout(1, 3));

        nineHourLabel.setBackground(new java.awt.Color(0, 0, 0));
        nineHourLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        nineHourLabel.setForeground(new java.awt.Color(51, 51, 51));
        nineHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineHourLabel.setText("NINE");
        seventhRowPanel.add(nineHourLabel);

        tenHourLabel.setBackground(new java.awt.Color(0, 0, 0));
        tenHourLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        tenHourLabel.setForeground(new java.awt.Color(51, 51, 51));
        tenHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenHourLabel.setText("TEN");
        seventhRowPanel.add(tenHourLabel);

        elevenHourLabel.setBackground(new java.awt.Color(0, 0, 0));
        elevenHourLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        elevenHourLabel.setForeground(new java.awt.Color(51, 51, 51));
        elevenHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenHourLabel.setText("ELEVEN");
        seventhRowPanel.add(elevenHourLabel);

        eighthRowPanel.setBackground(new java.awt.Color(0, 0, 0));
        eighthRowPanel.setMaximumSize(new java.awt.Dimension(32767, 50));
        eighthRowPanel.setMinimumSize(new java.awt.Dimension(100, 50));
        eighthRowPanel.setPreferredSize(new java.awt.Dimension(0, 50));
        eighthRowPanel.setLayout(new java.awt.GridLayout(1, 2));

        twelveHourLabel.setBackground(new java.awt.Color(0, 0, 0));
        twelveHourLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        twelveHourLabel.setForeground(new java.awt.Color(51, 51, 51));
        twelveHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveHourLabel.setText("TWELVE");
        eighthRowPanel.add(twelveHourLabel);

        oclockLabel.setBackground(new java.awt.Color(0, 0, 0));
        oclockLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        oclockLabel.setForeground(new java.awt.Color(255, 255, 255));
        oclockLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oclockLabel.setText("O'CLOCK");
        eighthRowPanel.add(oclockLabel);

        squareLabel1.setBackground(new java.awt.Color(0, 0, 0));
        squareLabel1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        squareLabel1.setForeground(new java.awt.Color(51, 51, 51));
        squareLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        squareLabel1.setText("■");

        squareLabel2.setBackground(new java.awt.Color(0, 0, 0));
        squareLabel2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        squareLabel2.setForeground(new java.awt.Color(51, 51, 51));
        squareLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        squareLabel2.setText("■");

        squareLabel3.setBackground(new java.awt.Color(0, 0, 0));
        squareLabel3.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        squareLabel3.setForeground(new java.awt.Color(51, 51, 51));
        squareLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        squareLabel3.setText("■");

        squareLabel4.setBackground(new java.awt.Color(0, 0, 0));
        squareLabel4.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        squareLabel4.setForeground(new java.awt.Color(51, 51, 51));
        squareLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        squareLabel4.setText("■");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eighthRowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sixthRowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(fifthRowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(fourthRowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(firstRowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addComponent(secondRowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thirdRowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seventhRowPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(squareLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(squareLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(squareLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(squareLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(firstRowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(secondRowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thirdRowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fourthRowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fifthRowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sixthRowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seventhRowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eighthRowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(squareLabel2)
                    .addComponent(squareLabel3)
                    .addComponent(squareLabel4)
                    .addComponent(squareLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getTime(); // start getTime when window is opened
        // this probably isn't needed but I can't delete it so it's staying
    }//GEN-LAST:event_formWindowOpened


    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClockJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClockJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClockJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClockJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClockJFrame().setVisible(true);
            }
        });      
    }
    
    public void lightLabel(JLabel label)
    {
        label.setForeground(Color.WHITE);
    }
    
    public void dimLabel(JLabel label)
    {
        label.setForeground(DIM);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eightHourLabel;
    private javax.swing.JPanel eighthRowPanel;
    private javax.swing.JLabel elevenHourLabel;
    private javax.swing.JPanel fifthRowPanel;
    private javax.swing.JPanel firstRowPanel;
    private javax.swing.JLabel fiveHourLabel;
    private javax.swing.JLabel fiveLabel;
    private javax.swing.JLabel fourHourLabel;
    private javax.swing.JPanel fourthRowPanel;
    private javax.swing.JLabel halfLabel;
    private javax.swing.JLabel itIsLabel;
    private javax.swing.JLabel minutesLabel;
    private javax.swing.JLabel nineHourLabel;
    private javax.swing.JLabel oclockLabel;
    private javax.swing.JLabel oneHourLabel;
    private javax.swing.JLabel pastLabel;
    private javax.swing.JLabel quarterLabel;
    private javax.swing.JPanel secondRowPanel;
    private javax.swing.JLabel sevenHourLabel;
    private javax.swing.JPanel seventhRowPanel;
    private javax.swing.JLabel sixHourLabel;
    private javax.swing.JPanel sixthRowPanel;
    private javax.swing.JLabel squareLabel1;
    private javax.swing.JLabel squareLabel2;
    private javax.swing.JLabel squareLabel3;
    private javax.swing.JLabel squareLabel4;
    private javax.swing.JLabel tenHourLabel;
    private javax.swing.JLabel tenLabel;
    private javax.swing.JPanel thirdRowPanel;
    private javax.swing.JLabel threeHourLabel;
    private javax.swing.JLabel toLabel;
    private javax.swing.JLabel twelveHourLabel;
    private javax.swing.JLabel twentyLabel;
    private javax.swing.JLabel twoHourLabel;
    // End of variables declaration//GEN-END:variables
}
