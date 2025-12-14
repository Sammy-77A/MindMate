import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContactPanel extends JPanel {

    public ContactPanel() {
        // Match the layout and background color of the original code
        setLayout(null);
        setBackground(new Color(0x56365c));

        // --- 1. TITLE ---
        JLabel profile = new JLabel("CONTACT US");
        profile.setForeground(new Color(0xffffff));
        profile.setFont(new Font("Arial", Font.BOLD, 33));
        profile.setHorizontalAlignment(JLabel.CENTER);
        profile.setBounds(20, 30, 300, 40);
        add(profile);

        // --- 2. NAME ---
        JLabel name = new JLabel("NAME");
        name.setForeground(new Color(0xE6D9F2));
        name.setFont(new Font("Arial", Font.BOLD, 12));
        name.setBounds(40, 90, 80, 20);
        add(name);

        JTextField name1 = new JTextField("Enter Your Full Name");
        styleField(name1);
        name1.setBounds(40, 110, 280, 35);
        addPlaceholder(name1, "Enter Your Full Name");
        add(name1);

        // --- 3. EMAIL ---
        JLabel email = new JLabel("EMAIL");
        email.setForeground(new Color(0xE6D9F2));
        email.setFont(new Font("Arial", Font.BOLD, 12));
        email.setBounds(40, 160, 80, 20);
        add(email);

        JTextField email1 = new JTextField("Enter Your Email");
        styleField(email1);
        email1.setBounds(40, 180, 280, 35);
        addPlaceholder(email1, "Enter Your Email");
        add(email1);

        // --- 4. PHONE ---
        JLabel phone = new JLabel("PHONE");
        phone.setForeground(new Color(0xE6D9F2));
        phone.setFont(new Font("Arial", Font.BOLD, 12));
        phone.setBounds(40, 230, 80, 20);
        add(phone);

        JTextField phnField = new JTextField("Enter Your Phone Number");
        styleField(phnField);
        phnField.setBounds(40, 250, 280, 35);
        addPlaceholder(phnField, "Enter Your Phone Number");

        // Number validation
        phnField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) || phnField.getText().length() >= 10) {
                    e.consume();
                }
            }
        });
        add(phnField);

        // --- 5. ADDRESS ---
        JLabel address = new JLabel("ADDRESS");
        address.setForeground(new Color(0xE6D9F2));
        address.setFont(new Font("Arial", Font.BOLD, 12));
        address.setBounds(40, 300, 80, 20);
        add(address);

        JTextField addr = new JTextField("Enter Your Home/Work Address");
        styleField(addr);
        addr.setBounds(40, 320, 280, 35);
        addPlaceholder(addr, "Enter Your Home/Work Address");
        add(addr);

        // --- 6. SEND BUTTON ---
        JButton button = new JButton("SEND");
        button.setForeground(new Color(0x2b0071));
        button.setBackground(new Color(0xdcddff));
        button.setBounds(140, 380, 80, 35);
        button.addActionListener(e -> {
            String n = name1.getText(), em = email1.getText(), p = phnField.getText(), a = addr.getText();

            if (n.equals("Enter Your Full Name"))
                n = "";
            if (em.equals("Enter Your Email"))
                em = "";
            if (p.equals("Enter Your Phone Number"))
                p = "";
            if (a.equals("Enter Your Home/Work Address"))
                a = "";

            if (n.isEmpty() || em.isEmpty() || p.isEmpty() || a.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Missing Info",
                        JOptionPane.WARNING_MESSAGE);
            } else if (!em.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                JOptionPane.showMessageDialog(this, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (p.length() != 10) {
                JOptionPane.showMessageDialog(this, "Phone must be 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Message sent successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        add(button);
    }

    // Helper to style fields consistently
    private void styleField(JTextField f) {
        f.setForeground(Color.GRAY);
        f.setFont(new Font("Arial", Font.BOLD, 12));
        f.setBackground(Color.WHITE);
        f.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    // Helper for placeholder logic
    private void addPlaceholder(JTextField f, String text) {
        f.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (f.getText().equals(text)) {
                    f.setText("");
                    f.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (f.getText().isEmpty()) {
                    f.setText(text);
                    f.setForeground(Color.GRAY);
                }
            }
        });
    }
}