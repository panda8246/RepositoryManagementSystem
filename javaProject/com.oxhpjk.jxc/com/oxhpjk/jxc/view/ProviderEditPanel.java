package com.oxhpjk.jxc.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.oxhpjk.jxc.commom.CommonFactory;
import com.oxhpjk.jxc.commom.Constants;
import com.oxhpjk.jxc.model.Customer;
import com.oxhpjk.jxc.model.Item;
import com.oxhpjk.jxc.model.Provider;
import com.oxhpjk.jxc.service.CustomerService;
import com.oxhpjk.jxc.service.ProviderService;
import java.awt.Font;

public class ProviderEditPanel extends JPanel implements ActionListener{
	private ProviderService providerService;
	private JComboBox comboBox;
	private JTextField nameTf;
	private JTextField addressTf;
	private JTextField shortTf;
	private JTextField zipTf;
	private JTextField telTf;
	private JTextField faxTf;
	private JTextField conTf;
	private JTextField phoneTf;
	private JTextField bankTf;
	private JTextField accountTf;
	private JTextField emailTf;
    private Item selectedItem;
	/**
	 * Create the panel.
	 */
	public 	ProviderEditPanel() {
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		
		zipTf = new JTextField();
		zipTf.setColumns(30);
		
		JLabel label = new JLabel("��Ӧ���ʱࣺ");
		label.setFont(new Font("����", Font.PLAIN, 15));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 364, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(zipTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 51, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(zipTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		
		telTf = new JTextField();
		telTf.setColumns(30);
		
		JLabel label_1 = new JLabel("��Ӧ�̵绰��");
		label_1.setFont(new Font("����", Font.PLAIN, 15));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 364, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(telTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 51, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(telTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		
		faxTf = new JTextField();
		faxTf.setColumns(30);
		
		JLabel label_2 = new JLabel("��Ӧ�̴��棺");
		label_2.setFont(new Font("����", Font.PLAIN, 15));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 364, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(faxTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 51, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(faxTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_6 = new JPanel();
		
		conTf = new JTextField();
		conTf.setColumns(30);
		
		JLabel label_3 = new JLabel("��ϵ��Ա��");
		label_3.setFont(new Font("����", Font.PLAIN, 15));
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 364, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(conTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 51, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(conTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_7 = new JPanel();
		
		phoneTf = new JTextField();
		phoneTf.setColumns(30);
		
		JLabel label_4 = new JLabel("��ϵ�绰��");
		label_4.setFont(new Font("����", Font.PLAIN, 15));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGap(0, 364, Short.MAX_VALUE)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(phoneTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGap(0, 51, Short.MAX_VALUE)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(phoneTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		
		JPanel panel_8 = new JPanel();
		
		bankTf = new JTextField();
		bankTf.setColumns(30);
		
		JLabel label_5 = new JLabel("�������У�");
		label_5.setFont(new Font("����", Font.PLAIN, 15));
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGap(0, 364, Short.MAX_VALUE)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bankTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGap(0, 51, Short.MAX_VALUE)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(bankTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_8.setLayout(gl_panel_8);
		
		JPanel panel_9 = new JPanel();
		
		accountTf = new JTextField();
		accountTf.setColumns(30);
		
		JLabel label_6 = new JLabel("�����˻���");
		label_6.setFont(new Font("����", Font.PLAIN, 15));
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGap(0, 364, Short.MAX_VALUE)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(accountTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGap(0, 51, Short.MAX_VALUE)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(accountTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_9.setLayout(gl_panel_9);
		
		JPanel panel_10 = new JPanel();
		
		emailTf = new JTextField();
		emailTf.setColumns(30);
		
		JLabel label_7 = new JLabel("��Ӧ�����䣺");
		label_7.setFont(new Font("����", Font.PLAIN, 15));
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGap(0, 364, Short.MAX_VALUE)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(emailTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_panel_10.setVerticalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGap(0, 51, Short.MAX_VALUE)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_10.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7)
						.addComponent(emailTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_10.setLayout(gl_panel_10);
		
		JPanel panel_11 = new JPanel();
		
		JLabel label_8 = new JLabel("ѡ��Ӧ�̣�");
		label_8.setFont(new Font("����", Font.PLAIN, 15));
		
		comboBox = new JComboBox();
		comboBox.setPreferredSize(new Dimension(100, 21));
        //��comboBox����ѡ���¼�
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAction();
			}

		});
		GroupLayout gl_panel_11 = new GroupLayout(panel_11);
		gl_panel_11.setHorizontalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_8)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_panel_11.setVerticalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_11.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_8)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel_11.setLayout(gl_panel_11);
		
		JPanel panel_12 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_12, GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
								.addComponent(panel_6, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(panel_8, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
								.addComponent(panel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
								.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
								.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_11, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(panel_12, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton updateBtn = new JButton("�޸�");
		updateBtn.setFont(new Font("����", Font.PLAIN, 15));
		//���޸İ�ť�󶨵���¼�
		updateBtn.addActionListener(this);
		panel_12.add(updateBtn);
		
		JButton deleteBtn = new JButton("ɾ��");
		deleteBtn.setFont(new Font("����", Font.PLAIN, 15));
		//��ɾ����ť�󶨵���¼�
		deleteBtn.addActionListener(this);
		panel_12.add(deleteBtn);
		
		JLabel lblNewLabel_2 = new JLabel("��Ӧ�̼�ƣ�");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 15));
		
		shortTf = new JTextField();
		shortTf.setColumns(30);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(shortTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(shortTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("��Ӧ�̵�ַ��");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
		
		addressTf = new JTextField();
		addressTf.setColumns(30);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addressTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(382, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(addressTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("��Ӧ��ȫ�ƣ�");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 15));
		
		nameTf = new JTextField();
		nameTf.setColumns(30);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(379, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(nameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
        
		providerService =  CommonFactory.getProviderService();
		//��ʼ���ͻ�����ѡ���
		initComboBox();
	}
	/**
	 * ��ʼ����Ӧ������ѡ���
	 */
	public void initComboBox() {
		//��ȡ���ݿ��е�����
		List<Provider> list = providerService.findProvider(null);
		//���������б��������ģ��
		Vector<Item> items = new Vector<>();
		//��������б���е����ݣ�����ظ�
		comboBox.removeAllItems();
		//������������
		for(int i=0;i<list.size();i++) {
			Item item = new Item();
			item.setId(list.get(i).getId());
			item.setName(list.get(i).getCustomerName());
			if(items.contains(item)) {//��������а�����Ԫ�أ��Ͳ������
				continue;			
			}
			items.add(item);	
			comboBox.addItem(item);
		}
	}
	/**
	 * �����б�����¼�
	 */
	private void selectAction() {
	
		if(!(comboBox.getSelectedItem() instanceof Item)) {
			return;
		}
		selectedItem = (Item) comboBox.getSelectedItem();
		System.out.println(selectedItem.getId()+","+selectedItem.getName());
		//���ݿͻ���Ų�ѯ���ݿ�
		Provider c = new Provider();
		c.setId(selectedItem.getId());
		List<Provider> cust = providerService.findProvider(c);
		setData(cust.get(0));//�ü��ϲ������ظ���ֻ��һ��
		
	}
	/**
	 * ������������
	 * @param c
	 */
	private void setData(Provider c) {
		nameTf.setText(c.getCustomerName());
		addressTf.setText(c.getAddress());
		shortTf.setText(c.getShorts());
		zipTf.setText(c.getZip());
		telTf.setText(c.getTelephone());
		faxTf.setText(c.getFax());
		conTf.setText(c.getContacts());
		phoneTf.setText(c.getPhone());
		bankTf.setText(c.getBank());
		accountTf.setText(c.getBank());
		emailTf.setText(c.getMail());
	}
	/**
	 * ����¼�
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String target = e.getActionCommand();
		switch (target) {
		case "�޸�":
			//��ȡ�ͻ����
			String id = selectedItem.getId();
			//У��
			//��ʽУ��
			ProviderInternalFrame.dataCheck(nameTf.getText().trim(),
					addressTf.getText().trim(),
					shortTf.getText().trim(),
					zipTf.getText().trim(),
					telTf.getText().trim(),
					faxTf.getText().trim(),
					conTf.getText().trim(),
					phoneTf.getText().trim(),
					emailTf.getText().trim(),
					bankTf.getText().trim(),
					accountTf.getText().trim());
			//�޸�����			
			boolean result = providerService.updateProvider(new Provider(id, 
					nameTf.getText().trim(), shortTf.getText().trim(),addressTf.getText().trim(), 
					zipTf.getText().trim(), 
					telTf.getText().trim(), faxTf.getText().trim(), 
					conTf.getText().trim(), phoneTf.getText().trim(), 
					bankTf.getText().trim(), accountTf.getText(), 
					emailTf.getText().trim(), 1));
			if(result==true) {
				JOptionPane.showMessageDialog(null, "��Ӧ����Ϣ�޸ĳɹ���","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "��Ӧ����Ϣ�޸�ʧ�ܣ�","����",JOptionPane.WARNING_MESSAGE);
			}
			break;
        case "ɾ��":
			int type = JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ����ǰ��Ӧ�̣�", "��ܰ��ʾ", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(type==0) {//ɾ��
				//��ȡ�ͻ����
				String sid = selectedItem.getId();
				boolean r = providerService.updateProvider(sid, Constants.DATA_DEL);
				if(r==true) {
					JOptionPane.showMessageDialog(null, "��Ӧ����Ϣɾ���ɹ���","��ʾ",JOptionPane.INFORMATION_MESSAGE);
					//���½���
					initComboBox();
				}else {
					JOptionPane.showMessageDialog(null, "��Ӧ����Ϣɾ��ʧ�ܣ�","����",JOptionPane.WARNING_MESSAGE);
				}
			}
			break;

		default:
			break;
		}
		
	}
}