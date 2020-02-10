import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class JTableModel extends AbstractTableModel {
        private static final long serialVersionUID = 1L;
        private static final String[] COLUMN_NAMES = new String[] {"Flight Number", "Departure Airport", "Arrival Ariport", "Departure Time",
    			"Arrival Time", "Date", "Capacity", "Fare", "Airline Company", "Reserve?"};
        private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class, String.class, String.class, String.class,
        																String.class, String.class, String.class,String.class,
        																String.class, JButton.class};

        private static int rowcount;
        
        static ArrayList<String[]> parseList = new ArrayList<String[]>();
        																
        public JTableModel(ArrayList<String[]> x) {
        	
        	parseList = x;
        }

		@Override public int getColumnCount() {
            return COLUMN_NAMES.length;
        }
        
        public void setRowCount(int x) {
            rowcount = x;
        }
        
        @Override public int getRowCount() {
            return rowcount;
        }

        @Override public String getColumnName(int columnIndex) {
            return COLUMN_NAMES[columnIndex];
        }

        @Override public Class<?> getColumnClass(int columnIndex) {
            return COLUMN_TYPES[columnIndex];
        }

        @Override public Object getValueAt(final int rowIndex, final int columnIndex) {
                /*Adding components*/
            switch (columnIndex) {
                case 0: return parseList.get(rowIndex)[0];
                case 1: return parseList.get(rowIndex)[1];
                case 2: return parseList.get(rowIndex)[2];
                case 3: return parseList.get(rowIndex)[3];
                case 4: return parseList.get(rowIndex)[4];
                case 5: return parseList.get(rowIndex)[5];
                case 6: return parseList.get(rowIndex)[6];
                case 7: return parseList.get(rowIndex)[7];
                case 8: return parseList.get(rowIndex)[8];
               /*Adding button and creating click listener*/
                case 9: final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
                        button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                                JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button), 
                                        "Reservation Succesful!");
                            }
                        });
                        return button;
                default: return "Error";
            }
        }   
    }