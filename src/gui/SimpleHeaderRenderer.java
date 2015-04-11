package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
 
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
 
/**
 * A simple renderer class for JTable component.
 * @author www.codejava.net
 * http://www.codejava.net/java-se/swing/jtable-column-header-custom-renderer-examples
 *
 */
public class SimpleHeaderRenderer extends JLabel implements TableCellRenderer {
 
    public SimpleHeaderRenderer() {
        setFont(new Font("Montserrat", Font.BOLD, 14));
        setForeground(Color.BLACK);
        //setBackground(new Color(47, 52, 64));
        //setBorder(BorderFactory.createEtchedBorder());
        setBorder(BorderFactory.createEmptyBorder());
        
    }
     
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
 
}