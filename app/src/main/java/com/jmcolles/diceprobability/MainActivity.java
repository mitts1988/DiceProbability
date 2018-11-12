package com.jmcolles.diceprobability;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button calculate, d4Plus, d4Minus, d6Plus, d6Minus, d8Plus, d8Minus,
            d10Plus, d10Minus, d12Plus, d12Minus, d20Plus, d20Minus,
            checkPlus, checkMinus, modifierPlus, modifierMinus, clear, graph;
    EditText d4Count,d6Count,d8Count,d10Count,d12Count,d20Count,checkCount, modifierCount;
    TextView result;
//    Integer[] probabilityResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate = findViewById(R.id.Calculate);
        clear = findViewById(R.id.Clear);
//        graph = findViewById(R.id.graph);

        d4Plus = findViewById(R.id.D4Plus);
        d4Minus = findViewById(R.id.D4Minus);
        d6Plus = findViewById(R.id.D6Plus);
        d6Minus = findViewById(R.id.D6Minus);
        d8Plus = findViewById(R.id.D8Plus);
        d8Minus = findViewById(R.id.D8Minus);
        d10Plus = findViewById(R.id.D10Plus);
        d10Minus = findViewById(R.id.D10Minus);
        d12Plus = findViewById(R.id.D12Plus);
        d12Minus = findViewById(R.id.D12Minus);
        d20Plus = findViewById(R.id.D20Plus);
        d20Minus = findViewById(R.id.D20Minus);
        checkPlus = findViewById(R.id.CheckPlus);
        checkMinus = findViewById(R.id.CheckMinus);
        modifierPlus = findViewById(R.id.ModifierPlus);
        modifierMinus = findViewById(R.id.ModifierMinus);

        d4Count = findViewById(R.id.D4Count);
        d6Count = findViewById(R.id.D6Count);
        d8Count = findViewById(R.id.D8Count);
        d10Count = findViewById(R.id.D10Count);
        d12Count = findViewById(R.id.D12Count);
        d20Count = findViewById(R.id.D20Count);
        checkCount = findViewById(R.id.CheckNumber);
        modifierCount = findViewById(R.id.ModifierNumber);

        result = findViewById(R.id.Result);

        calculate.setOnClickListener(onClickListener);
        clear.setOnClickListener(onClickListener);
//        graph.setOnClickListener(onClickListener);
        d4Plus.setOnClickListener(onClickListener);
        d4Minus.setOnClickListener(onClickListener);
        d6Plus.setOnClickListener(onClickListener);
        d6Minus.setOnClickListener(onClickListener);
        d8Plus.setOnClickListener(onClickListener);
        d8Minus.setOnClickListener(onClickListener);
        d10Plus.setOnClickListener(onClickListener);
        d10Minus.setOnClickListener(onClickListener);
        d12Plus.setOnClickListener(onClickListener);
        d12Minus.setOnClickListener(onClickListener);
        d20Plus.setOnClickListener(onClickListener);
        d20Minus.setOnClickListener(onClickListener);
        checkPlus.setOnClickListener(onClickListener);
        checkMinus.setOnClickListener(onClickListener);
        modifierPlus.setOnClickListener(onClickListener);
        modifierMinus.setOnClickListener(onClickListener);
    }

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(final View v) {
            int num;
            switch(v.getId()){
                case R.id.Calculate:
                    int[] dice = new int[6];
                    dice[0] = Integer.parseInt(d4Count.getText().toString());
                    dice[1] = Integer.parseInt(d6Count.getText().toString());
                    dice[2] = Integer.parseInt(d8Count.getText().toString());
                    dice[3] = Integer.parseInt(d10Count.getText().toString());
                    dice[4] = Integer.parseInt(d12Count.getText().toString());
                    dice[5] = Integer.parseInt(d20Count.getText().toString());

                    int check = Integer.parseInt(checkCount.getText().toString());
                    int modifier = Integer.parseInt(modifierCount.getText().toString());

                    DiceProbability prob = new DiceProbability(dice, modifier, check);
                    if(prob.min <= prob.modifiedCheck){
                        prob.calculate(0);
                        prob.checkResults();
                    }else{
                        prob.percentage = 100;
                    }

                    String percentage = Double.toString(prob.percentage)+"%";

                    result.setText(String.valueOf(percentage));
                    break;
//                case R.id.graph:
////                    Intent intent = new Intent(this, GraphActivity.class);
////                    intent.putExtra();
//                    break;

                case R.id.D4Plus:
                    num = Integer.parseInt(d4Count.getText().toString());
                    num++;
                    d4Count.setText(String.valueOf(num));
                    break;
                case R.id.D4Minus:
                    num = Integer.parseInt(d4Count.getText().toString());
                    num--;
                    if(num < 0){
                        num = 0;
                    }
                    d4Count.setText(String.valueOf(num));
                    break;
                case R.id.D6Plus:
                    num = Integer.parseInt(d6Count.getText().toString());
                    num++;
                    d6Count.setText(String.valueOf(num));
                    break;
                case R.id.D6Minus:
                    num = Integer.parseInt(d6Count.getText().toString());
                    num--;
                    if(num < 0){
                        num = 0;
                    }
                    d6Count.setText(String.valueOf(num));
                    break;
                case R.id.D8Plus:
                    num = Integer.parseInt(d8Count.getText().toString());
                    num++;
                    d8Count.setText(String.valueOf(num));
                    break;
                case R.id.D8Minus:
                    num = Integer.parseInt(d8Count.getText().toString());
                    num--;
                    if(num < 0){
                        num = 0;
                    }
                    d8Count.setText(String.valueOf(num));
                    break;
                case R.id.D10Plus:
                    num = Integer.parseInt(d10Count.getText().toString());
                    num++;
                    d10Count.setText(String.valueOf(num));
                    break;
                case R.id.D10Minus:
                    num = Integer.parseInt(d10Count.getText().toString());
                    num--;
                    if(num < 0){
                        num = 0;
                    }
                    d10Count.setText(String.valueOf(num));
                    break;
                case R.id.D12Plus:
                    num = Integer.parseInt(d12Count.getText().toString());
                    num++;
                    d12Count.setText(String.valueOf(num));
                    break;
                case R.id.D12Minus:
                    num = Integer.parseInt(d12Count.getText().toString());
                    num--;
                    if(num < 0){
                        num = 0;
                    }
                    d12Count.setText(String.valueOf(num));
                    break;
                case R.id.D20Plus:
                    num = Integer.parseInt(d20Count.getText().toString());
                    num++;
                    d20Count.setText(String.valueOf(num));
                    break;
                case R.id.D20Minus:
                    num = Integer.parseInt(d20Count.getText().toString());
                    num--;
                    if(num < 0){
                        num = 0;
                    }
                    d20Count.setText(String.valueOf(num));
                    break;
                case R.id.CheckPlus:
                    num = Integer.parseInt(checkCount.getText().toString());
                    num++;
                    checkCount.setText(String.valueOf(num));
                    break;
                case R.id.CheckMinus:
                    num = Integer.parseInt(checkCount.getText().toString());
                    num--;
                    if(num < 0){
                        num = 0;
                    }
                    checkCount.setText(String.valueOf(num));
                    break;
                case R.id.ModifierPlus:
                    num = Integer.parseInt(modifierCount.getText().toString());
                    num++;
                    modifierCount.setText(String.valueOf(num));
                    break;
                case R.id.ModifierMinus:
                    num = Integer.parseInt(modifierCount.getText().toString());
                    num--;
                    modifierCount.setText(String.valueOf(num));
                    break;
                case R.id.Clear:
                    d4Count.setText(String.valueOf(0));
                    d6Count.setText(String.valueOf(0));
                    d8Count.setText(String.valueOf(0));
                    d10Count.setText(String.valueOf(0));
                    d12Count.setText(String.valueOf(0));
                    d20Count.setText(String.valueOf(0));
                    checkCount.setText(String.valueOf(0));
                    modifierCount.setText(String.valueOf(0));
                    break;
            }
        }
    };

    public void calculateButtonOnClick(View v){
        result.setText("Calculating...");
        System.out.print("asdf");
        int[] dice = new int[6];
        dice[0] = Integer.parseInt(d4Count.getText().toString());
        dice[1] = Integer.parseInt(d6Count.getText().toString());
        dice[2] = Integer.parseInt(d8Count.getText().toString());
        dice[3] = Integer.parseInt(d10Count.getText().toString());
        dice[4] = Integer.parseInt(d12Count.getText().toString());
        dice[5] = Integer.parseInt(d20Count.getText().toString());

        int check = Integer.parseInt(checkCount.getText().toString());
        int modifier = Integer.parseInt(modifierCount.getText().toString());

        DiceProbability prob = new DiceProbability(dice, check, modifier);

        prob.calculate(0);
        prob.checkResults();
        String percentage = Double.toString(prob.percentage);

        result.setText(percentage);
    }
}
