package com.example.utils;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
	private static final long serialVersionUID = 1L;
    private JButton button;
    private String label;

    public ButtonEditor() {
        button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Define the action to be taken when the button is clicked
                System.out.println("View contact clicked!");
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        return label;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        return button;
    }
}
