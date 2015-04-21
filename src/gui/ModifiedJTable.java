package gui;
import java.awt.Color;
import java.awt.Component;
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
	protected Font font = new Font("Helvetica", Font.PLAIN, 14);

	
	ModifiedJTable(TableModel dm){
		super(dm);
		//setBorder(null);
		setShowVerticalLines(false);
		setShowGrid(false);
		setShowHorizontalLines(false);
		setFont(font);
		setForeground(new Color(244, 229, 192));
		header.setBackground(new Color(244, 229, 192));
		header.setForeground(new Color(47, 52, 64));
		header.setFont(new Font("Helvetica", Font.BOLD, 16));
		header.setBorder(new LineBorder(new Color(244, 229, 192), 2));
		header.setOpaque(false);
		//header.setBorder(null);
		//cellborder is what I need to change
		setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		setOpaque(false);
		((DefaultTableCellRenderer)this.getDefaultRenderer(Object.class)).setOpaque(false);
	}
	
	/*public void setFont(){
		
	}*/
	
	public void updateRowHeights()
	{
	    try
	    {
	        for (int row = 0; row < this.getRowCount(); row++)
	        {
	            int rowHeight = this.getRowHeight();

	            for (int column = 0; column < this.getColumnCount(); column++)
	            {
	                Component comp = this.prepareRenderer(this.getCellRenderer(row, column), row, column);
	                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
	            }

	            this.setRowHeight(row, rowHeight);
	        }
	    }
	    catch(ClassCastException e) {}
	}

}
