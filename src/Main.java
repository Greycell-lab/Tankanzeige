import javax.swing.*;
import java.awt.*;

public class Main {
    static Timer timerFahren;
    static Timer timerTanken;
    public static void main(String[] args) {
            Tank tank = new Tank(100);
            JFrame frame = new JFrame("Tank");
            frame.setSize(250, 250);
            ImageIcon icon = new ImageIcon("tank.png");
            frame.setIconImage(icon.getImage());
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout());
            JTextField füllstand = new JTextField();
            füllstand.setBounds(0, 0, 250, 250);
            füllstand.setEditable(false);
            füllstand.setText(tank.getFüllstand() + "%");
            füllstand.setBackground(Color.BLACK);
            füllstand.setForeground(Color.WHITE);
            füllstand.setHorizontalAlignment(SwingConstants.CENTER);
            Font font = new Font(null, 0, 45);
            füllstand.setFont(font);
            frame.add(füllstand);
            frame.setVisible(true);
            timerFahren = new Timer(25, tankLeeren -> {
                tank.setFüllstand();
                füllstand.setText(tank.getFüllstand() + "%");
                if (tank.getFüllstand() < 100) füllstand.setForeground(Color.GREEN);
                if (tank.getFüllstand() < 75) füllstand.setForeground(Color.YELLOW);
                if (tank.getFüllstand() < 50) füllstand.setForeground(Color.ORANGE);
                if (tank.getFüllstand() < 25) füllstand.setForeground(Color.RED);
                if (tank.getFüllstand() == 0) {
                    tank.setLeer(true);
                    timerFahren.stop();
                }
            });
            timerTanken = new Timer(50, tankFüllen -> {
                tank.setFüllstand();
                füllstand.setText(tank.getFüllstand() + "%");
                if (tank.getFüllstand() > 25) füllstand.setForeground(Color.ORANGE);
                if (tank.getFüllstand() > 50) füllstand.setForeground(Color.YELLOW);
                if (tank.getFüllstand() > 75) füllstand.setForeground(Color.GREEN);
                if (tank.getFüllstand() == 100) {
                    tank.setLeer(false);
                    timerTanken.stop();
                }
            });
           while(true) {
               if (!tank.getLeer()) {
                   timerTanken.stop();
                   timerFahren.start();
               } else {
                   timerFahren.stop();
                   timerTanken.start();
               }
           }
    }
}