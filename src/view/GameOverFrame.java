package view;

import model.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverFrame {
    public GameOverFrame(GameState endState) {

        //Создаём окно
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 1));


        //Заголовок
        JLabel title;
        if (endState == GameState.WINNER)
            title = new JLabel(((endState.winner.equals("X")) ? "Игрок 2 " : "Игрок 1 ") + " победитель!", SwingConstants.CENTER);
        else
            title = new JLabel("НИЧЬЯ! ", SwingConstants.CENTER);


        //Кнопка выхода
        JButton newgame = new JButton("Начать новую игру");
        newgame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new StartFrame();
                frame.setVisible(false);
                frame.dispose();
            }
        });


        //Установка шрифтов
        Font fontdata = new Font("Arial", Font.PLAIN, 42);
        title.setFont(fontdata);
        newgame.setFont(fontdata);


        //Настраиваем окно
        frame.add(title);
        frame.add(newgame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Игра закончена!");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
    }
}
