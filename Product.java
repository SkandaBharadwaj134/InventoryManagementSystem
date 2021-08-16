package CRUD;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Product {

	private JFrame frame;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtCategory;
	private JTextField txtPrice;
	private JTable table;
	DefaultTableModel model;
	private JTextField txtFilter;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product window = new Product();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Product() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 868, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inventory Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(328, 11, 268, 81);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(73, 121, 88, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(73, 169, 88, 37);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Category");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(73, 219, 88, 37);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Price");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(73, 275, 88, 37);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		txtID = new JTextField();
		txtID.setBounds(179, 131, 135, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(179, 169, 135, 20);
		frame.getContentPane().add(txtName);
		
		txtCategory = new JTextField();
		txtCategory.setColumns(10);
		txtCategory.setBounds(179, 219, 135, 20);
		frame.getContentPane().add(txtCategory);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(179, 275, 135, 20);
		frame.getContentPane().add(txtPrice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(445, 114, 350, 369);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				
				txtID.setText(model.getValueAt(i, 0).toString());
				txtName.setText(model.getValueAt(i, 1).toString());
				txtCategory.setText(model.getValueAt(i, 2).toString());
				txtPrice.setText(model.getValueAt(i, 3).toString());
				
			
			}
		});
		model=new DefaultTableModel();
		Object[] column= {"Product ID","Name","Category","Price"};
		final Object[] row= new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().equals("")||txtName.getText().equals("")||txtCategory.getText().equals("")||txtPrice.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Fill Complete Information");
				}
				else
				{
				row[0]=txtID.getText();
				row[1]=txtName.getText();
				row[2]=txtCategory.getText();
				row[3]=txtPrice.getText();
				model.addRow(row);
				txtID.setText("");
				txtName.setText("");
				txtCategory.setText("");
				txtPrice.setText("");
				JOptionPane.showMessageDialog(null,"Saved Successfully!");
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(73, 362, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if(i>=0)
				{
				model.removeRow(i);
				JOptionPane.showMessageDialog(null,"Deleted Successfully!");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please select a row");
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(72, 415, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnNewButton_1_1 = new JButton("Update");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if(i>=0)
				{
				model.setValueAt(txtID.getText(), i, 0);
				model.setValueAt(txtName.getText(), i, 1);
				model.setValueAt(txtCategory.getText(), i, 2);
				model.setValueAt(txtPrice.getText(), i, 3);
				JOptionPane.showMessageDialog(null,"Updated Successfully!");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please select a row");
				}
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(179, 364, 89, 23);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Clear");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtName.setText("");
				txtCategory.setText("");
				txtPrice.setText("");
				
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1_1.setBounds(179, 417, 89, 23);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		txtFilter = new JTextField();
		txtFilter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String query=txtFilter.getText().toLowerCase();
				filter(query);
			}
		});
		
		txtFilter.setBounds(582, 83, 135, 20);
		frame.getContentPane().add(txtFilter);
		txtFilter.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Search Product");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(445, 77, 122, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
	}
	private void filter(String query)
	{
		TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(query));
	}
}
