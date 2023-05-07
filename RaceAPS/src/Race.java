// import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Race extends JFrame implements ActionListener{
    private JTextField FirstRace, SecondRace, TotalTime;
    private JButton SaveButton, StartButton, LapButton, FinishButton, ResetButton;

    private Timer timer = new Timer();
    private static double value = 0;
    private boolean isfirstlap = false;
    private boolean isfinished = false;
    Double firstlap = 0.0;
    Double secondlap = 0.0;
    Double finishingtime = 0.0;
    public Race(){
        
        super("Corrida APS");
        
        FirstRace = new JTextField(10);
        FirstRace.setEditable(false);
        SecondRace = new JTextField(10);
        SecondRace.setEditable(false);
        TotalTime = new JTextField(10);
        TotalTime.setEditable(false);
        SaveButton = new JButton("Salvar");
        StartButton = new JButton("Iniciar Corrida");
        LapButton = new JButton("Marcar Volta");
        FinishButton = new JButton("Finalizar Corrida");
        ResetButton = new JButton("Resetar");
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 5));
        panel.add(new JLabel("Tempo da primeira volta:"));
        panel.add(FirstRace);
        panel.add(new JLabel("Tempo da segunda volta:"));
        panel.add(SecondRace);
        panel.add(StartButton);
        panel.add(LapButton);
        panel.add(FinishButton);
        panel.add(ResetButton);
        panel.add(SaveButton);
        panel.add(new JLabel("Esse e o tempo total da sua corrida:"));
        panel.add(TotalTime);
        Database database = new Database();
        ArrayList <Corrida> corrida = database.get();
        if (corrida.size() > 0){
            Corrida corridaAtual = corrida.get(0);
            FirstRace.setText(Double.toString(corridaAtual.getPrimeiraVolta()));
            SecondRace.setText(Double.toString(corridaAtual.getSegundaVolta()));
            TotalTime.setText(Double.toString(corridaAtual.getPrimeiraVolta() + corridaAtual.getSegundaVolta()));
        }
        else{
            FirstRace.setText(Double.toString(firstlap));
            SecondRace.setText(Double.toString(secondlap));
            TotalTime.setText(Double.toString(value));
        }
        


        setSize(1020, 860);
        getContentPane().add(panel);
        setVisible(true);
        StartButton.setEnabled(true);
        LapButton.setEnabled(false);
        FinishButton.setEnabled(false);
        // ResetButton.setEnabled(false);       


        StartButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent event){
                StartButton.setEnabled(false);
                LapButton.setEnabled(true);
                timer = new Timer();
                isfinished = false;
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        
                        if (!isfinished){
                            Double currentTotalTime = firstlap + secondlap; 
                            value += 1.0;
                            if (isfirstlap){
                                SecondRace.setText(Double.toString(value));
                                secondlap = value;
                            }
                            else{
                                FirstRace.setText(Double.toString(value));
                                firstlap = value;
                                
                            }
                            finishingtime = currentTotalTime + 1.0;
                            TotalTime.setText(Double.toString(currentTotalTime + 1.0));
                            
                        }
                       
                    }
                };
                timer.scheduleAtFixedRate(task, 0, 1000);
            }
        });
        LapButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent event){
                isfirstlap = true;
                value = 0.0;
                LapButton.setEnabled(false);
                FinishButton.setEnabled(true);
                
            }
        });
        FinishButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent event){
                isfinished = true;
                FinishButton.setEnabled(false);
                ResetButton.setEnabled(true);
            }
        });
        ResetButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent event){
                firstlap = 0.0;
                secondlap = 0.0;
                value = 0.0;
                isfirstlap = false;
                isfinished = true;
                FirstRace.setText(Double.toString(firstlap));
                SecondRace.setText(Double.toString(secondlap));
                TotalTime.setText(Double.toString(value));
                // ResetButton.setEnabled(false);
                StartButton.setEnabled(true);
                LapButton.setEnabled(false);
                FinishButton.setEnabled(false);
                timer.cancel();
                Database database = new Database();
                database.deleteAll();
            }
        });
        SaveButton.addActionListener(new ActionListener() {
            @Override  
            public void actionPerformed(ActionEvent event){
                Database database = new Database();
                database.insert(new Corrida(firstlap, secondlap));
            }
        });
    }
    
    public void actionPerformed(ActionEvent event){

    }
    public static void main(String[] args) throws Exception {
        Race janela = new Race();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
} 
