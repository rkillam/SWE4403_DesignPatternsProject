package view.windows;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */

import util.Logger;

import javax.swing.*;
import java.awt.*;

abstract public class Window extends JFrame {
    protected static final Logger logger = Logger.getInstance();

    abstract protected Dimension createWindowSizeDimension();
    abstract protected LayoutManager createLayout();

    public Window(String title) {
        super();
        setTitle(title);
        setSize(createWindowSizeDimension());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(createLayout());
    }
}

