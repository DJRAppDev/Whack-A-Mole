package projectavalon.whack_a_mole;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class End extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end);
        String s = getIntent().getStringExtra("score");
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(s);

        Button but = (Button) findViewById(R.id.restartButton);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(End.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button bt2 = (Button) findViewById(R.id.exitButton);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
