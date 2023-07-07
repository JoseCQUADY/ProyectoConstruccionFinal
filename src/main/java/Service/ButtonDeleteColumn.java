package Service;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.AbstractCellEditor;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 * Clase que crea un botón para eliminar cuentas
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
 */
public class ButtonDeleteColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private JButton renderButton;
    private JButton editButton;
    private JTable table;
    private String buttonText;
    private ActionListener listener;

    /**
     * Clase modelo para el objeto Bank
     * Con sus atributos, constructor, métodos de acceso y métodos propios
     * 
     * @param table
     * @param column
     */
    public ButtonDeleteColumn(JTable table, int column) {
        super(); 
        renderButton = new JButton();
        editButton = new JButton();
        editButton.setFocusPainted(false);
        editButton.addActionListener(this);
        this.table = table;

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer(this);
        columnModel.getColumn(column).setCellEditor(this);
        
    }
    
    /**
     * Método para asignarle un texto al botón
     * 
     * @param text
     */
    public void setButtonText(String text) {
        buttonText = text;
    }

    /**
     * Método para asignarle un listener al botón
     * Para saber cuando se le hace click al botón
     * 
     * @param listener
     */
    public void setButtonClickListener(ActionListener listener) {
        this.listener = listener;
    }

    /**
     * Método para establecer el background del botón y los textos
     * Establece el diseño
     * 
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     * @return renderButton
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (hasFocus) {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        } else if (isSelected) {
            renderButton.setForeground(table.getSelectionForeground());
            renderButton.setBackground(table.getSelectionBackground());
        } else {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }

        renderButton.setText((value == null) ? "" : value.toString());
        return renderButton;
    }

    /**
     * Método para editar el texto del botón
     * 
     * @param table
     * @param value
     * @param isSelected
     * @param row
     * @param column
     * @return editButton
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        editButton.setText(buttonText);
        return editButton;
    }

    /**
     * Méotodo para obtener el texto que llevará el botón
     * 
     * @return buttonText
     */
    @Override
    public Object getCellEditorValue() {
        return buttonText;
    }

    /**
     * Método de la clase implementada ActionListener que detecta y maneja eventos (clic en botones)
     * Utilizado para el funcionamiento y uso de los botones de la vista Sign Up 
     * Mediante condicionales
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.convertRowIndexToModel(table.getEditingRow());
        fireEditingStopped();

        if (listener != null) {
            listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, String.valueOf(row)));
        }
    }
}