/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1824350_coursework;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import static com.mycompany.w1824350_coursework.WestminsterSkinConsultationManager.*;
import javax.swing.table.*;
/**
 *
 * @author w18243503
 */
public class ConsultationFrame extends JFrame implements ActionListener {
    
    private JTable table;
    private JTextField tfForename;
    private JTextField tfSurname;
    private JTextField tfDay;
    private JTextField tfMonth;
    private JTextField tfYear;
    private JTextField tfMobileNo;
    private JTextField tfPatientID;
    private JTextArea taNotes;
    
    private JTextField tfCDay;
    private JTextField tfCMonth;
    private JTextField tfCYear;
    private JTextField tfHr;
    private JTextField tfMin;
    
    
    public ConsultationFrame() {
        
        String[] columnNames = {
        "Forename",
        "Surname",
        "Date of birth",
        "Mobile number",
        "Med licence no",
        "Specialisation"
        };
    
        Object[][] data = new Object[doctorList.size()][6];
        
        for (int i = 0; i < doctorList.size(); i++)
        {
            data[i][0] = doctorList.get(i).getForename();
            data[i][1] = doctorList.get(i).getSurname();
            data[i][2] = doctorList.get(i).getDoB().toString();
            data[i][3] = doctorList.get(i).getMobileNo();
            data[i][4] = doctorList.get(i).getMedLicenceNo();
            data[i][5] = doctorList.get(i).getSpectialisation();
        }
        
        table = new JTable(data, columnNames);
        
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        JScrollPane spForTable = new JScrollPane(table);
        table.setAutoCreateRowSorter(true);

        table.setEnabled(false);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(14, 2, 10, 5));
        
        JLabel lblForename = new JLabel("*Forename:");
        tfForename = new JTextField();
        
        JLabel lblSurname = new JLabel("*Surname:");
        tfSurname = new JTextField();
        
        JLabel lblDay = new JLabel("*DoB dd:");
        tfDay = new JTextField();
        
        JLabel lblMonth = new JLabel("*DoB mm");
        tfMonth = new JTextField();
        
        JLabel lblYear = new JLabel("*DoB yyyy");
        tfYear = new JTextField();
        
        JLabel lblMobileNo = new JLabel("*Mobile No: ");
        tfMobileNo = new JTextField();
        
        JLabel lblPatientID = new JLabel("*Patient ID: ");
        tfPatientID = new JTextField();
        
//        Booking details
        JLabel lblBook = new JLabel("Booking details:");
        JLabel empty = new JLabel("");
        
        JLabel lblCDay = new JLabel("*Day:");
        tfCDay = new JTextField();
        
        JLabel lblCMonth = new JLabel("*Month:");
        tfCMonth = new JTextField();
        
        JLabel lblCYear = new JLabel("*Year:");
        tfCYear = new JTextField();
        
        JLabel lblHr = new JLabel("*Hour:");
        tfHr = new JTextField();
        
        JLabel lblMin = new JLabel("*Minute:");
        tfMin = new JTextField();
        
        JButton btnAdd = new JButton("Add");
        JButton btnReset = new JButton("Reset");
        
        p1.add(lblForename);
        p1.add(tfForename);
        
        p1.add(lblSurname);
        p1.add(tfSurname);
        
        p1.add(lblDay);
        p1.add(tfDay);
        
        p1.add(lblMonth);
        p1.add(tfMonth);
        
        p1.add(lblYear);
        p1.add(tfYear);
        
        p1.add(lblMobileNo);
        p1.add(tfMobileNo);
        
        p1.add(lblPatientID);
        p1.add(tfPatientID);
        
        p1.add(lblBook);
        p1.add(empty);
        
        p1.add(lblCDay);
        p1.add(tfCDay);
        
        p1.add(lblCMonth);
        p1.add(tfCMonth);
        
        p1.add(lblCYear);
        p1.add(tfCYear);
        
        p1.add(lblHr);
        p1.add(tfHr);
        
        p1.add(lblMin);
        p1.add(tfMin);
        
        p1.add(btnReset);
        p1.add(btnAdd);
        
        taNotes = new JTextArea("Notes");
        JScrollPane spForNotes = new JScrollPane(taNotes);
        JButton btnClear = new JButton("Clear");
        
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout(10, 10));
        
        p2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        p2.add(p1, BorderLayout.NORTH);
        p2.add(spForNotes, BorderLayout.CENTER);
        p2.add(btnClear, BorderLayout.SOUTH);
        
        JPanel p3 = new JPanel();
        p3.add(spForTable);
        
        JPanel p4 = new JPanel();
        p4.add(p2, BorderLayout.WEST);
        p4.add(p3, BorderLayout.EAST);
        
        add(p4);
        
        btnAdd.addActionListener(this);
    }
    
    public void addConsultation() {
        if (
                tfForename.getText().isEmpty() | 
                tfSurname.getText().isEmpty() | 
                tfDay.getText().isEmpty() | 
                tfMonth.getText().isEmpty() | 
                tfYear.getText().isEmpty() | 
                tfMobileNo.getText().isEmpty() | 
                tfPatientID.getText().isEmpty() |
                tfCDay.getText().isEmpty() |
                tfCMonth.getText().isEmpty() |
                tfCYear.getText().isEmpty() |
                tfHr.getText().isEmpty() |
                tfMin.getText().isEmpty()
                )
        {
            JOptionPane.showMessageDialog(this, "All Fields Required marked with *");
            return;
        } else {
            Patient patient = new Patient();
            Consultation consultation = new Consultation();
            
            patient.setForename(tfForename.getText());
            patient.setSurname(tfSurname.getText());
            patient.dateOfBirth.setDay(tfDay.getText());
            patient.dateOfBirth.setMonth(tfMonth.getText());
            patient.dateOfBirth.setYear(tfYear.getText());
            patient.setMobileNo(tfMobileNo.getText());
            
            int i = 0;
            Boolean found = false;
            while (i < patientList.size())
            {
                if (tfPatientID.getText().equals(patientList.get(i).getPatientID()))
                {
                    consultation.setCost(25);
                    found = true;
                    break;
                } else {
                    i++;
                }
            }
            if (i == patientList.size() && found == false) {
                patient.setPatientID(tfPatientID.getText());
                consultation.setCost(15);
            }
            if (taNotes.getText().equals("Notes") | taNotes.getText().equals("")){
                consultation.setNotes("N/A");
            } else {
                consultation.setNotes(taNotes.getText());
            }
            consultation.date.setDay(tfCDay.getText());
            consultation.date.setMonth(tfCMonth.getText());
            consultation.date.setYear(tfCYear.getText());
            
            patientList.add(patient);
            savePatient();
            
            consultationList.add(consultation);
            saveConsultation();
        }
    }
    
    public void reset() {
        tfForename.setText("");
        tfSurname.setText("");
        tfDay.setText("");
        tfMonth.setText("");
        tfYear.setText("");
        tfMobileNo.setText("");
        tfPatientID.setText("");
    }
    
    public void clear() {
        taNotes.setText("Notes");
    }
    
    public void savePatient() {
        File file = new File("WestminsterSkinConsultationPatients.txt");
        try {
            FileOutputStream writeData = new FileOutputStream("WestminsterSkinConsultationPatients.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(patientList);
            writeStream.flush();
            writeStream.close();
            System.out.println("Patient stored\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void saveConsultation() {
        File file = new File("WestminsterSkinConsultations.txt");
        try {
            FileOutputStream writeData = new FileOutputStream("WestminsterSkinConsultations.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(consultationList);
            writeStream.flush();
            writeStream.close();
            System.out.println("Data Stored\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        String btnLabel = evt.getActionCommand();
        
        if (btnLabel.equals("Add")) {
            addConsultation();
        } else if (btnLabel.equals("Reset")) {
            reset();
        } else if (btnLabel.equals("Clear")){
            clear();
        }
    }
}
