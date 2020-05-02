package ru.simonoff.simplefreecalculator;

import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorModel {
    private TextView _Input, _Result;
    private ArrayList<Character>  _ArithmeticOperations = new ArrayList<Character>(
            Arrays.<Character>asList('+', '−', '×','÷')
);
    public CalculatorModel(TextView input, TextView result){
        _Input = input;
        _Result = result;
    }

    public void AppendDot(){
        String oldStr = _Input.getText().toString(),
                appendStr="";
        if(oldStr.isEmpty()){
            appendStr="0.";
        }
        else{
            if(oldStr.charAt(oldStr.length()-1)!='.'){
                appendStr=".";
            }
        }
        _Input.append(appendStr);
    }
    public  void AppendPlus(){
        String oldStr = _Input.getText().toString(),
                newStr="";
        if(_ArithmeticOperations.contains(oldStr.charAt(oldStr.length()-1))){
            newStr = oldStr.substring(0, oldStr.length()-1)+"+";
        }
        else {
            newStr = oldStr+"+";
        }
        _Input.setText(newStr);
    }
    public  void AppendMinus(){
        String oldStr = _Input.getText().toString(),
                newStr="";
        if(_ArithmeticOperations.contains(oldStr.charAt(oldStr.length()-1))){
            newStr = oldStr.substring(0, oldStr.length()-1)+"−";
        }
        else {
            newStr = oldStr+"−";
        }
        _Input.setText(newStr);
    }
    public  void AppendMultiply(){
        String oldStr = _Input.getText().toString(),
                newStr="";
        if(_ArithmeticOperations.contains(oldStr.charAt(oldStr.length()-1))){
            newStr = oldStr.substring(0, oldStr.length()-1)+"×";
        }
        else {
            newStr = oldStr+"×";
        }
        _Input.setText(newStr);
    }
    public  void AppendDivision(){
        String oldStr = _Input.getText().toString(),
                newStr="";
        if(_ArithmeticOperations.contains(oldStr.charAt(oldStr.length()-1))){
            newStr = oldStr.substring(0, oldStr.length()-1)+"÷";
        }
        else {
            newStr = oldStr+"÷";
        }
        _Input.setText(newStr);
    }
    public  void AppendOpenBracket(){
        _Input.append("(");
    }
    public  void AppendCloseBracket(){
        _Input.append(")");
    }
    public  void PrintResult(){
        String expression = _Input.getText().toString();
        expression = expression.replace('÷', '/');
        expression = expression.replace('×', '*');
        expression = expression.replace('−', '-');

        try {
            Expression e = new ExpressionBuilder(expression).build();
            double res = e.evaluate();
             double x = res % 1;
            NumberFormat nf = new DecimalFormat("#.####");
            String resStr =  nf.format(res);
            if(resStr.length()<14){
                _Result.setText(resStr);
            }
            else {
                resStr = String.format("%.8e", res);
                _Result.setText(resStr);
            }
        }
        catch (Exception ex){
            _Result.setText("Error!");
        }
    }
    public  void Reset(){
        _Input.setText("");
        _Result.setText("");
    }
    public  void Backspace(){
        String oldStr = _Input.getText().toString();
        if(!oldStr.isEmpty()){
            _Input.setText(oldStr.substring(0, oldStr.length()-1));
            _Result.setText("");
        }
    }
}