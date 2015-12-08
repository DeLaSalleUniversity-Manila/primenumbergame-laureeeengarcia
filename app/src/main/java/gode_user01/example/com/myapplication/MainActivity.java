package gode_user01.example.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random();
    }

    private int number;
    private int score;
    private boolean answer;

    public void onClickPrime(View view){
        answer = true;
        Answer();
        Score();
        Random();
    }

    public void onClickComposite(View view){
        answer = false;
        Answer();
        Score();
        Random();
    }

    private void Answer() {
        if (!(isPrime(number) ^ answer)) {
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            score = score - 5;
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Previous number: "+ number,Toast.LENGTH_SHORT).show();
    }

    private boolean isPrime(int value){
        Boolean temp = true;
        for (int divisor = 2; divisor < Math.sqrt(value); divisor++) {
            if (value % divisor == 0) {
                temp = false;
            }
        }
        return temp; 
    }

    private void Random(){
        Random r = new Random();
        number = 2 + r.nextInt(1000);
        TextView tv = (TextView) findViewById(R.id.Number);
        tv.setText("" + number);
    }

    private void Score(){
        TextView tv = (TextView) findViewById(R.id.Score);
        tv.setText("Score: " + score + ".");
    }


}
