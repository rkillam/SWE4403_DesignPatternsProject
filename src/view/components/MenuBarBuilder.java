package view.components;

import view.commands.Command;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class MenuBarBuilder {
    private JMenuBar menuBar;
    private JMenu currentMenu;

    public MenuBarBuilder() {
        this.menuBar = new JMenuBar();
    }

    public MenuBarBuilder addMenu(String label) {
        JMenu menu = new JMenu(label);
        this.menuBar.add(menu);
        this.currentMenu = menu;

        return this;
    }

    public MenuBarBuilder addItem(String name) {
        return addItem(name, null, null);
    }

    public MenuBarBuilder addItem(String name, final Command clickEventCallback) {
        return addItem(name, clickEventCallback, null);
    }

    public MenuBarBuilder addItem(String label, final Command clickEventCallback, String keyboardShortcut) {
        if(this.currentMenu != null) {
            JMenuItem item = new JMenuItem(label);

            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    clickEventCallback.execute();
                }
            });

            if(keyboardShortcut != null) {
                item.setAccelerator(KeyStroke.getKeyStroke(keyboardShortcut));
            }

            this.currentMenu.add(item);
        }

        return this;
    }

    public JMenuBar getResult() {
        return this.menuBar;
    }
}
