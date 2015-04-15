/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */

package view.windows;

import java.awt.*;

import backend.BackendFacade;
import view.commands.*;
import util.KeyboardShortcutBuilder;
import view.component.menu_bar.MenuBarBuilder;
import view.components.EditorHTMLInsertionBar;
import view.components.TextEditorPane;

import javax.swing.*;

public class MainWindow extends Window {
    private BackendFacade backendFacade;

    public MainWindow() {
        super("HTML Editor");
        this.backendFacade = new BackendFacade();

        // Set up the status bar.
        // TODO: Delete
//        this.getContentPane().add(new EditorHTMLInsertionBar(), BorderLayout.SOUTH);

        // Set up the editor.
        JTextPane textPane = new TextEditorPane(this.backendFacade);
        JScrollPane scrollTextEditor = new JScrollPane(textPane);
        this.getContentPane().add(scrollTextEditor, BorderLayout.CENTER);

        // Build the menu bar.
        MenuBarBuilder menuBarBuilder = new MenuBarBuilder();

        menuBarBuilder
                .addMenu("File")
                .addItem(
                        "Open...",
                        new OpenCommand(this.backendFacade),
                        new KeyboardShortcutBuilder()
                            .addCommandKey(KeyboardShortcutBuilder.CONTROL)
                            .setKey('o')
                            .getResult()
                )
                .addItem(
                        "Save",
                        new SaveCommand(this.backendFacade),
                        new KeyboardShortcutBuilder()
                            .addCommandKey(KeyboardShortcutBuilder.CONTROL)
                            .setKey('s')
                            .getResult()
                )
                .addItem(
                        "Save As...",
                        new SaveAsCommand(this.backendFacade),
                        new KeyboardShortcutBuilder()
                            .addCommandKey(KeyboardShortcutBuilder.CONTROL)
                            .addCommandKey(KeyboardShortcutBuilder.SHIFT)
                            .setKey('s')
                            .getResult()
                )
                .addMenu("Edit")
                .addItem(
                        "Undo",
                        new UndoCommand(this.backendFacade),
                        new KeyboardShortcutBuilder()
                            .addCommandKey(KeyboardShortcutBuilder.CONTROL)
                            .setKey('z')
                            .getResult()
                )
                .addItem(
                        "Redo",
                        new RedoCommand(this.backendFacade),
                        new KeyboardShortcutBuilder()
                            .addCommandKey(KeyboardShortcutBuilder.CONTROL)
                            .setKey('y')
                            .getResult()
                )
                .addMenu("View")
                .addItem(
                        "Show HTML Tags",
                        new ShowHTMLTagsCommand(this.backendFacade)
                )
                .addItem(
                        "Hide HTML Tags",
                        new HideHTMLTagsCommand(this.backendFacade)
                );

        this.setJMenuBar(menuBarBuilder.getResult());
        logger.log(this.getClass(), "Editor is ready.");
    }

    @Override
    protected Dimension createWindowSizeDimension() {
        return new Dimension(1250, 650);
    }

    @Override
    protected LayoutManager createLayout() {
        return new BorderLayout();
    }
}
