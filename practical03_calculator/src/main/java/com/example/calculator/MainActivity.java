package com.example.calculator;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText n1, n2;
    TextView result;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.num1);
        n2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        findViewById(R.id.add).setOnClickListener(v -> calculate('+'));
        findViewById(R.id.sub).setOnClickListener(v -> calculate('-'));
        findViewById(R.id.mul).setOnClickListener(v -> calculate('*'));
        findViewById(R.id.div).setOnClickListener(v -> calculate('/'));
    }

    void calculate(char op) {
        String a = n1.getText().toString();
        String b = n2.getText().toString();

        if (a.isEmpty() || b.isEmpty()) {
            result.setText("Enter both numbers");
            return;
        }

        double x = Double.parseDouble(a);
        double y = Double.parseDouble(b);
        double ans;

        switch (op) {
            case '+': ans = x + y; break;
            case '-': ans = x - y; break;
            case '*': ans = x * y; break;
            case '/':
                if (y == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                ans = x / y;
                break;
            default: return;
        }

        result.setText("Result: " + ans);
    }
}
