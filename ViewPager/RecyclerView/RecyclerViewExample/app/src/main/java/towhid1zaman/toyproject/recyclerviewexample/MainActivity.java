package towhid1zaman.toyproject.recyclerviewexample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel>arrContact = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager layoutManager = new
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerContact);
        recyclerView.setLayoutManager(layoutManager);

        arrContact.add(new ContactModel(R.drawable.a, "Zaman", "01933233333"));
        arrContact.add(new ContactModel(R.drawable.b, "Amzan", "01933233333"));
        arrContact.add(new ContactModel(R.drawable.c, "Mazan", "01933232333"));
        arrContact.add(new ContactModel(R.drawable.d, "Namaz", "01933223333"));
        arrContact.add(new ContactModel(R.drawable.e, "Maanz", "01934233333"));
        arrContact.add(new ContactModel(R.drawable.f, "Zanam", "01433233333"));
        arrContact.add(new ContactModel(R.drawable.g, "Aaamn", "01233233333"));
        arrContact.add(new ContactModel(R.drawable.a, "Towhid", "01133233333"));
        arrContact.add(new ContactModel(R.drawable.b, "Dihwot", "01233233333"));
        arrContact.add(new ContactModel(R.drawable.c, "Hidwot", "01333232333"));
        arrContact.add(new ContactModel(R.drawable.d, "Wtohid", "01433223333"));
        arrContact.add(new ContactModel(R.drawable.e, "Otwhid", "01534233333"));
        arrContact.add(new ContactModel(R.drawable.f, "Hwtoid", "01633233333"));
        arrContact.add(new ContactModel(R.drawable.g, "Dhitow", "01733233333"));

        RecyclerContactAdapter recyclerContactAdapter = new RecyclerContactAdapter(this, arrContact);
        recyclerView.setAdapter(recyclerContactAdapter);
    }
}
