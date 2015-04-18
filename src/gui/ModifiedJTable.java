package gui;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class ModifiedJTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8253718684484994753L;
	//Members
	JTableHeader header = this.getTableHeader();

	
	ModifiedJTable(TableModel dm){
		super(dm);
		setShowHorizontalLines(false);
		setShowVerticalLines(false);
		setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 14));
		setForeground(new Color(244, 229, 192));
		header.setBackground(new Color(47, 52, 64));
		header.setForeground(new Color(244, 229, 192));
		header.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 16));
		header.setBorder(new LineBorder(new Color(244, 229, 192), 2));
		header.setOpaque(false);
		//cellborder is what I need to change
		setAutoResizeMode(this.AUTO_RESIZE_ALL_COLUMNS);
		setOpaque(false);
		setOpaque(false);
		((DefaultTableCellRenderer)this.getDefaultRenderer(Object.class)).setOpaque(false);
		setShowGrid(false);
		
	}

}
