package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc extends JFrame implements ActionListener {
    JButton [] numberButton = new JButton[10];
    JButton [] FunctionButton = new JButton[9];
    JButton addBut,subBut,mulBut,divBut;
    JButton eqlBut,decBut,clrBut,delBut,negBut;

    JTextField text;

    JPanel panel;

    Font font = new Font("MV boli",Font.PLAIN,30);

    double num1=0,num2=0,result;
    char operator;

    Calc(){
        this.setSize(420,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);


        text =new JTextField();
        text.setBounds(20,20,370,60);
        text.setFont(font);
        text.addActionListener(this);
        text.setEditable(false);

        clrBut =new JButton("clr");
        clrBut.setFocusable(false);


        delBut =new JButton("del");
        delBut.setFocusable(false);




         addBut =new JButton("+");
         subBut =new JButton("-");
         mulBut =new JButton("x");
         divBut =new JButton("/");
         decBut =new JButton(".");
         eqlBut =new JButton("=");
         negBut =new JButton("(-)");

        FunctionButton[0]=addBut;
        FunctionButton[1]=subBut;
        FunctionButton[2]=mulBut;
        FunctionButton[3]=divBut;
        FunctionButton[4]=decBut;
        FunctionButton[5]=eqlBut;
        FunctionButton[6]=clrBut;
        FunctionButton[7]=delBut;
        FunctionButton[8]=negBut;

        for (int i =0;i<9;i++){
            FunctionButton[i].addActionListener(this);
            FunctionButton[i].setFont(font);
            FunctionButton[i].setFocusable(false);
        }
        clrBut.setBounds(270,490,123,40);
        delBut.setBounds(145,490,123,40);
        negBut.setBounds(20,490,123,40);


        for (int i =0;i<10;i++){
            numberButton[i] =new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFocusable(false);
            numberButton[i].setFont(font);


        }

        panel =new JPanel();
        panel.setBounds(20,90,370,380);
        //panel.setBackground(Color.LIGHT_GRAY);
        //panel.setOpaque(true);
        panel.setLayout(new GridLayout(4,4,10,10));


        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addBut);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subBut);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulBut);
        panel.add(decBut);
        panel.add(numberButton[0]);
        panel.add(eqlBut);
        panel.add(divBut);

        this.add(negBut);
        this.add(clrBut);
        this.add(delBut);
        this.add(panel);
        this.add(text);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i =0 ;i<10;i++){
            if (e.getSource() == numberButton[i]){
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decBut){
            text.setText(text.getText().concat("."));
        }
        if (e.getSource() == addBut){
            num1 =Double.parseDouble(text.getText());
            operator ='+';
            text.setText("");
        }
        if (e.getSource() == subBut){
            num1 = Double.parseDouble(text.getText());
            operator='-';
            text.setText("");
        }
        if (e.getSource() == mulBut){
            num1 = Double.parseDouble(text.getText());
            operator='x';
            text.setText("");
        }
        if (e.getSource() == divBut){
            num1 = Double.parseDouble(text.getText());
            operator='/';
            text.setText("");
        }
        if (e.getSource() == eqlBut){
            num2 = Double.parseDouble(text.getText());
            switch(operator){
                case '+':
                    result =num1+num2;
                    break;
                case '-':
                    result =num1-num2;
                    break;
                case 'x':
                    result =num1*num2;
                    break;
                case '/':
                    result =num1/num2;
                    break;
            }
            text.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrBut){
            text.setText("");
        }
        if (e.getSource() == delBut){
            String s = text.getText();
            text.setText("");
            for(int i =0;i<s.length()-1;i++){
                text.setText(text.getText()+s.charAt(i));
            }
        }
        if(e.getSource() == negBut){
            double temp = Double.parseDouble(text.getText());
            temp *= -1;
            text.setText(String.valueOf(temp));
        }
    }
}
