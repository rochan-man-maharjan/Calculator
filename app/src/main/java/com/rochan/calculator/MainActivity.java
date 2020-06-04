package com.rochan.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPlus,btnMinus,btnMultiply,btnDivision,btnEqual,btnClear,btnDot,btnBracket,btnPercent;
    TextView tvInput,tvOutput;
    String Process;
    Boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiply = findViewById(R.id.btnMultiply);

        btnEqual = findViewById(R.id.btnEqual);

        btnClear = findViewById(R.id.btnClear);
        btnDot = findViewById(R.id.btnDot);
        btnBracket = findViewById(R.id.btnBracket);
        btnPercent = findViewById(R.id.btnPercent);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "0");

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "1");

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "2");

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "3");

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "4");

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "5");

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "6");

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "7");

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "8");

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "9");

            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "+");

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "-");

            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "x");

            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "x");

            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "÷");

            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + ".");

            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();
                tvInput.setText(Process + "%");

            }
        });

        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBracket) {
                    Process = tvInput.getText().toString();
                    tvInput.setText(Process + ")");
                    checkBracket = false;
                } else {
                    Process = tvInput.getText().toString();
                    tvInput.setText(Process + "(");
                    checkBracket = true;
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = tvInput.getText().toString();

                Process = Process.replaceAll("x", "*");
                Process = Process.replaceAll("%", "/100");
                Process = Process.replaceAll("÷", "/");
                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable, Process, "javascript", 1, null).toString();
                } catch (Exception e) {
                        finalResult="0";
                }

                tvOutput.setText(finalResult);
            }
        });



    }
}
