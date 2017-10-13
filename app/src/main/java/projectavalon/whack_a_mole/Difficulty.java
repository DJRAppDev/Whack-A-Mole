package projectavalon.whack_a_mole;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Difficulty extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty);

        Button easy = (Button)findViewById(R.id.easy);
        Button medium = (Button)findViewById(R.id.medium);
        Button hard = (Button)findViewById(R.id.hard);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Ez","easy mode");
                Intent intent = new Intent(Difficulty.this, Game.class);
                intent.putExtra("Difficulty","Easy");
                startActivity(intent);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Med","medium");
                Intent intent = new Intent(Difficulty.this, Game.class);
                intent.putExtra("Difficulty","Medium");
                startActivity(intent);
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Hard","hard");
                Intent intent = new Intent(Difficulty.this, Game.class);
                intent.putExtra("Difficulty","Hard");
                startActivity(intent);
            }
        });

    }
}
