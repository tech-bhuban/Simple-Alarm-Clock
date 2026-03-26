

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.*;

public class AlarmClock extends JFrame {
    private JLabel timeLabel;
    private JTextField alarmField;
    private JButton setButton;
    private String alarmTime = "";
    
    public AlarmClock() {
        setTitle("Simple Alarm Clock");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Time display
        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(new Font("Digital", Font.BOLD, 32));
        add(timeLabel, BorderLayout.CENTER);
        
        // Alarm panel
        JPanel alarmPanel = new JPanel();
        alarmPanel.add(new JLabel("Set alarm (HH:MM): "));
        alarmField = new JTextField(5);
        setButton = new JButton("Set");
        alarmPanel.add(alarmField);
        alarmPanel.add(setButton);
        add(alarmPanel, BorderLayout.SOUTH);
        
        // Start clock
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
        
        setButton.addActionListener(e -> {
            alarmTime = alarmField.getText();
            setTitle("Alarm set for: " + alarmTime);
        });
    }
    
    private void updateTime() {
        String current = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        timeLabel.setText(current);
        
        String currentHM = current.substring(0, 5);
        if(!alarmTime.isEmpty() && currentHM.equals(alarmTime)) {
            JOptionPane.showMessageDialog(this, "⏰ WAKE UP! ⏰");
            alarmTime = "";
        }
    }
    
    public static void main(String[] args) {
        new AlarmClock().setVisible(true);
    
    }
}