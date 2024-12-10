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
        RecyclerView recyclerView = findViewById(R.id.recyclerContact);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrContact.add(new ContactModel(R.drawable.a, "Zaman", "01933233333"));
        arrContact.add(new ContactModel(R.drawable.b, "Amzan", "01933233333"));
        arrContact.add(new ContactModel(R.drawable.c, "Mazan", "01933232333"));
        arrContact.add(new ContactModel(R.drawable.d, "Namaz", "01933223333"));
        arrContact.add(new ContactModel(R.drawable.e, "Maanz", "01934233333"));
        arrContact.add(new ContactModel(R.drawable.f, "Zanam", "01433233333"));
        arrContact.add(new ContactModel(R.drawable.f, "Aaamn", "01433233333"));
    }
}
