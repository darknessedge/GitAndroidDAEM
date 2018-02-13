package mx.unam.aragon.fes.diplo.gitandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    protected Button boton, boton2, boton3;
    protected TextView texto;
    private Bitmap imagendescargada;
    private ImageView miimagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.boton);
        boton2 = findViewById(R.id.boton2);
        boton3 = findViewById(R.id.boton3);
        texto = findViewById(R.id.texto);
        miimagen = findViewById(R.id.miimagen);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                texto.setText("Hola GitHUB");
                Toast.makeText(MainActivity.this,
                        "Secambio el mensaje en el textView", Toast.LENGTH_SHORT).show();
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText("Hola Diplomado Android");
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    new DescargarImagen().execute(
                            new URL("https://vignette.wikia.nocookie.net/toontown/images/8/82/Toony_Toons.png"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });


    }
    class DescargarImagen extends AsyncTask<URL, Integer, Bitmap> {
        @Override
        protected Bitmap doInBackground(URL... urls) {
            try {
                imagendescargada = BitmapFactory.decodeStream(urls[0].openConnection().getInputStream());

            } catch (Exception e) {
                Log.e("diplo", "Error" + e.toString());
            }
            return imagendescargada;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {

            miimagen.setImageBitmap(imagendescargada);
            super.onPostExecute(bitmap);
        }

    }
}
