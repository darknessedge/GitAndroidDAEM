package mx.unam.aragon.fes.diplo.gitandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected Button boton, boton2;
    protected TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=findViewById(R.id.boton);
        boton2=findViewById(R.id.boton2);
        texto=findViewById(R.id.texto);

    boton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            texto.setText("Hola GitHUB");
        }
    });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText("Hola Diplomado Android");
            }
        });


    }


}
