package view;

import controller.BoardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame {
    public StartFrame() {
        //Новое окно
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3, 1));


        //Кнопки выбора режима
        JLabel gamemode_label = new JLabel("Выберите режим: ");
        ButtonGroup g1 = new ButtonGroup();
        JRadioButton gamemode_r1 = new JRadioButton("2 игрока");
        g1.add(gamemode_r1);
        JRadioButton gamemode_r2 = new JRadioButton("против компьютера");
        g1.add(gamemode_r2);


        //Установка шрифтов
        Font fdata = new Font("Arial", Font.PLAIN, 20);
        gamemode_label.setFont(fdata);
        gamemode_r1.setFont(fdata);
        gamemode_r2.setFont(fdata);


        //Панель для кнопок выбора режима
        JPanel data = new JPanel();
        data.setLayout(new GridLayout(3, 1));
        data.add(gamemode_label);
        data.add(gamemode_r1);
        data.add(gamemode_r2);


        //Кнопка начала игры
        JButton play = new JButton("Начать");
        play.setPreferredSize(new Dimension(120, 50));
        play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new Board(gamemode_r1.isSelected() ? 1 : 2, new BoardController());
                frame.setVisible(false);
                frame.dispose();
            }
        });


        //Заполняем окно
        frame.add(data);
        frame.add(play);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Начальный экран");
    }
}
