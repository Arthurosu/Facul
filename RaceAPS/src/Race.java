import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Race extends JFrame implements ActionListener{
    private JTextField RaceName, FirstRace, SecondRace, TotalTime;
    private JButton SumButton;
ss
    public Race(){
        super("Corrida APS");
        RaceName = new JTextField(10);
        FirstRace = new JTextField(10);
        SecondRace = new JTextField(10);
        TotalTime = new JTextField(10);
        TotalTime.setEditable(false);
        SumButton = new JButton("Calcular.");
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("De um nome para sua corrida:"));
        panel.add(RaceName);
        panel.add(new JLabel("Tempo da primeira volta:"));
        panel.add(FirstRace);
        panel.add(new JLabel("Tempo da segunda votla:"));
        panel.add(SecondRace);
        panel.add(new JLabel("Esse e o tempo total da sua corrida:"));
        panel.add(TotalTime);
        panel.add(SumButton);
        


        setSize(550, 300);
        getContentPane().add(panel);
        setVisible(true);
        SumButton.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent event){
        Double firstRace = Double.parseDouble(FirstRace.getText());
        Double secondRace = Double.parseDouble(SecondRace.getText());
        Double sum = firstRace + secondRace;
        TotalTime.setText(Double.toString(sum));
    }
    public static void main(String[] args) throws Exception {
        Race janela = new Race();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
} 
