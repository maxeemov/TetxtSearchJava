import javax.swing.*;
import java.awt.event.*;

public class Frame extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JFormattedTextField formattedTextField;
    private JLabel count;
    private JLabel line;

    public Frame() {

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(300,400);
        setLocation(100,100);
        setResizable(false);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        if(!formattedTextField.getText().isEmpty()){
            Search search = new Search();
            line.setText("Количество совпадений:");
            count.setText(String.valueOf(search.loop(formattedTextField.getText())));

        }else  line.setText("Введите текст");


    }

    private void onCancel() {
        System.exit(0);
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void setCount(JLabel count) {
        this.count = count;
    }
}
