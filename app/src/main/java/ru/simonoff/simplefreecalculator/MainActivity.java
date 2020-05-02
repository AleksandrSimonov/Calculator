package ru.simonoff.simplefreecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.*;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot;
        Button btnPlus, btnMinus, btnMultiply, btnDivision, btnOB, btnCB;
        Button btnEqual, btnReset;
        ImageButton btnBackspace;
        final TextView input, result;

        String process;

        btn0 = findViewById(R.id.zero);
        btn1 = findViewById(R.id.one);
        btn2 = findViewById(R.id.two);
        btn3 = findViewById(R.id.three);
        btn4 = findViewById(R.id.four);
        btn5 = findViewById(R.id.five);
        btn6 = findViewById(R.id.six);
        btn7 = findViewById(R.id.seven);
        btn8 = findViewById(R.id.eight);
        btn9 = findViewById(R.id.nine);
        btnDot = findViewById(R.id.dot);

        btnPlus = findViewById(R.id.plus);
        btnMinus = findViewById(R.id.minus);
        btnMultiply = findViewById( R.id.multiply);
        btnDivision = findViewById( R.id.division);
        btnOB = findViewById( R.id.open_bracket);
        btnCB = findViewById(R.id.close_bracket);

        btnEqual = findViewById( R.id.equals);
        btnBackspace = findViewById( R.id.backspace);
        btnReset = findViewById( R.id.reset);

        input = findViewById( R.id.input);
        result = findViewById( R.id.result);

        final CalculatorModel calculator = new CalculatorModel(input, result);

        input.setMovementMethod(new ScrollingMovementMethod());

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append("9");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.AppendDot();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.AppendPlus();
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.AppendMinus();
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.AppendMultiply();
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.AppendDivision();
            }
        });
        btnOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.AppendOpenBracket();
            }
        });
        btnCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.AppendCloseBracket();
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.PrintResult();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.Reset();
            }
        });
        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.Backspace();
            }
        });
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ((TextView) findViewById(R.id.input)).setText(savedInstanceState.getString("input"));
        ((TextView) findViewById(R.id.result)).setText(savedInstanceState.getString("result"));
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("input", ((TextView) findViewById(R.id.input)).getText().toString());
        outState.putString("result", ((TextView) findViewById(R.id.result)).getText().toString());
    }
}
