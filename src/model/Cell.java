package model;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {

    public int idx;
    public int x;
    public int y;

    public Cell(int x, int y, int idx) {
        super();
        this.idx = idx;
        this.x = x;
        this.y = y;
        setFont(new Font("Arial", Font.PLAIN, 42));
    }

}
