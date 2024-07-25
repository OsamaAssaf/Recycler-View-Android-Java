package com.assaf.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView contactsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        contactsRecyclerView = findViewById(R.id.contacts_recycler_view);

        final ArrayList<ContactModel> contacts = new ArrayList<>();
        contacts.add(new ContactModel("John Doe", "john.doe@ex.com", "https://picsum.photos/200"));
        contacts.add(new ContactModel("Jane Smith", "jane.smith@ex.com", "https://picsum.photos/200"));
        contacts.add(new ContactModel("Michael Johnson", "michael.johnson@ex.com", "https://picsum.photos/200"));
        contacts.add(new ContactModel("Emily Davis", "emily.davis@ex.com", "https://picsum.photos/200"));
        contacts.add(new ContactModel("John Doe", "john.doe@ex.com", "https://picsum.photos/200"));
        contacts.add(new ContactModel("Jane Smith", "jane.smith@ex.com", "https://picsum.photos/200"));
        contacts.add(new ContactModel("Michael Johnson", "michael.johnson@ex.com", "https://picsum.photos/200"));
        contacts.add(new ContactModel("Emily Davis", "emily.davis@ex.com", "https://picsum.photos/200"));

        final ContactsRecyclerViewAdapter contactsRecyclerViewAdapter = new ContactsRecyclerViewAdapter(this);
        contactsRecyclerViewAdapter.setContacts(contacts);

        contactsRecyclerView.setAdapter(contactsRecyclerViewAdapter);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}