package view;

import controller.BoardController;
import model.Cell;
import model.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Board {
    private JPanel board_panel;
    private BoardController controller;
    private JFrame main_window;

    public Board(int gameMode, BoardController tb) {
        this.controller = tb;

        main_window = new JFrame();
        board_panel = new JPanel();
        board_panel.setLayout(new GridLayout(3, 3));
        addButtons();


        // Делаем размер с половину экрана
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension d = kit.getScreenSize();
        main_window.setSize(d.width / 2, d.height / 2);


        main_window.setLocationRelativeTo(null);
        main_window.setTitle("Крестики-нолики");
        main_window.setVisible(true);
        main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addButtons() {
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Cell btn = new Cell(i, j, index++);
                btn.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Cell b = (Cell) e.getSource();
                        if (controller.move(b.x, b.y)) {
                            b.setText(controller.getCellValue(b.x, b.y));
                            b.setBackground(Color.BLACK);
                            b.setEnabled(false);

                            // проверка на окончание игры
                            GameState gs = controller.getGameState();
                            if (gs != GameState.IN_PROGRESS) {
                                main_window.setVisible(false);
                                main_window.dispose();
                                main_window.setEnabled(false);
                                new GameOverFrame(gs);
                            }
                        }
                    }
                });
                board_panel.add(btn);
            }
        }
        main_window.add(board_panel);
    }
}
