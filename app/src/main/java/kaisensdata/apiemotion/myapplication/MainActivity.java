package kaisensdata.apiemotion.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editText = findViewById(R.id.editTextTextPersonName);
        this.textView = findViewById(R.id.reponse);

        final Button button = findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Request request = new Request(editText.getText().toString());

                sendNetworkRequest(request);
            }
        });
    }

    private void sendNetworkRequest(Request request) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://prod.kaisens.fr:3002/emotion/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        JsonPlaceHolder js = retrofit.create(JsonPlaceHolder.class);
        Call<Reponse> call = js.submit(request);

        call.enqueue(new Callback<Reponse>() {

            @Override
            public void onResponse(Call<Reponse> call, Response<Reponse> response) {
                Reponse responses = response.body();
                System.out.println(responses.toString());
                textView.setText(responses.toString());
            }

            @Override
            public void onFailure(Call<Reponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                System.out.println(t.getMessage());
            }
        });
    }
}