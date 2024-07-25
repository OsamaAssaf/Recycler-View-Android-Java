package com.assaf.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.ViewHolder> {

    private ArrayList<ContactModel> contacts = new ArrayList<>();
    private Context context;

    public ContactsRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String name = contacts.get(position).getName();
        final String email = contacts.get(position).getEmail();
        final String imageUrl = contacts.get(position).getImageUrl();
        holder.name.setText(name);
        holder.email.setText(email);
        Glide
                .with(context)
                .load(imageUrl)
                .into(holder.image);
        holder.parent.setOnClickListener(v -> Toast.makeText(context,name, Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setContacts(ArrayList<ContactModel> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView parent;
        private TextView name;
        private TextView email;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            name = itemView.findViewById(R.id.contact_name);
            email = itemView.findViewById(R.id.contact_email);
            image = itemView.findViewById(R.id.contact_image);

        }
    }
}
