package com.example.testandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button[] buttons = new Button[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        buttons[4] = findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);
        buttons[6] = findViewById(R.id.button7);
        buttons[7] = findViewById(R.id.button8);
        buttons[8] = findViewById(R.id.button9);

        findViewById(R.id.reset).setOnClickListener(v->resetGame());

        // Назначаем клики
        for (Button button : buttons) {
            button.setOnClickListener(v -> buttonClick(v, checkTurn(findViewById(R.id.textView3))));
        }
    }
    public void buttonClick(View v, Boolean x){
        v.setEnabled(false);
        Button b =(Button)v;
        b.setText(x?"X":"O");

        ((TextView)findViewById(R.id.textView3)).setText(x?"O" + " its your turn":"X" + " its your turn");
        checkWin();
    }
    public void checkWin(){
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // горизонтали
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // вертикали
                {0, 4, 8}, {2, 4, 6}             // диагонали
        };

        for (int i=0; i<winConditions.length;i++) {
            Button button1 = buttons[winConditions[i][0]];
            Button button2 = buttons[winConditions[i][1]];
            Button button3 = buttons[winConditions[i][2]];
            if(button1.getText().equals(button2.getText()) && button2.getText().equals((button3.getText())) &&
            !button1.getText().equals("PressMe")) {
                showWinDialog(button1.getText().toString());
            }
        }
    }

    public  boolean checkTurn(TextView t){
        return t.getText().equals("X its your turn");
    }

    private void showWinDialog(String winner) {
        new AlertDialog.Builder(this)
                .setTitle("Победа!")
                .setMessage("Игрок " + winner + " выиграл!")
                .setPositiveButton("ОК", (dialog, which) -> resetGame())
                .setCancelable(false)
                .show();
    }

    public void resetGame() {
        for (Button button : buttons) {
            button.setText("PressMe");
            button.setEnabled(true);
        }
        ((TextView)findViewById(R.id.textView3)).setText("X its your turn");
    }

    public void onClickTransport(View view){
        EditText t = findViewById(R.id.source);
        String input=t.getText().toString();
        ((TextView)(findViewById(R.id.content))).setText(input);
        Log.i("onClickTransport", "123");
        Toast.makeText(this, input, Toast.LENGTH_LONG).show();
    }
}
