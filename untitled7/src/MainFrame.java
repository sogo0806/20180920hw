import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame{
    private JButton jbn[] = new JButton[12];
    private Container cp;
    private JPanel jpnn = new JPanel();
    private JPanel jpnc = new JPanel(new GridLayout(3,4,3,3));
    private JPanel jpns = new JPanel();
    private JPasswordField jpw = new JPasswordField();
    private JLabel jlb = new JLabel();
    public MainFrame(){
        init();
    }
    public void init(){
        this.setBounds(100,100,500,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(jpnn,BorderLayout.NORTH);
        cp.add(jpnc,BorderLayout.CENTER);
        cp.add(jpns,BorderLayout.SOUTH);

        jpnn.add(jpw);
        jpns.add(jlb);


        for (int i = 0 ; i < 10 ; i++){
            jbn[i] = new JButton();
            jpnc.add(jbn[i]);
            jbn[i].setText(Integer.toString(i));

            jbn[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JButton tmp = (JButton) actionEvent.getSource();
                    jpw.setText(jpw.getText()+tmp.getText());
                }
            });
        }

        jbn[10] = new JButton("Submit");
        jbn[11] = new JButton("exit");

        jpnc.add(jbn[10]);
        jpnc.add(jbn[11]);


        jbn[10].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (jpw.getText().equals("123456")){
                    jlb.setText("成功");
                }else {
                    jlb.setText("失敗");
                }
            }
        });

        jbn[11].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }


}
