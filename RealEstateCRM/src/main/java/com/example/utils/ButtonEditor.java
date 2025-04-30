package com.example.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.*;
import java.util.function.Consumer;

public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private boolean isPushed;
    private Consumer<Object> onClick;

    public ButtonEditor(JCheckBox checkBox, Consumer<Object> onClick) {
        super(checkBox);
        this.button = new JButton();
        this.button.setOpaque(true);
        this.onClick = onClick;

        button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        button.setText((value == null) ? "Action" : value.toString());
        isPushed = true;

        // Attach row-specific logic if needed
        button.putClientProperty("row", row);
        button.putClientProperty("value", value);
        button.putClientProperty("table", table);

        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed && onClick != null) {
            JTable table = (JTable) button.getClientProperty("table");
            int row = (int) button.getClientProperty("row");

            Object rowData = ((DefaultTableModel) table.getModel()).getValueAt(row, 0); // assuming contact ID or name
            onClick.accept(rowData);
        }
        isPushed = false;
        return button.getText();
    }
}
