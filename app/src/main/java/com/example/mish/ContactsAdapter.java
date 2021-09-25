package com.example.mish;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mish.DBPhandler;

import java.util.ArrayList;
import java.util.List;
public class ContactsAdapter extends  RecyclerView.Adapter<ContactsAdapter.ViewHolder>{

    private Context context;
    //Activity activity;
    RecyclerView CommentList;
    //String x;
    ArrayList<Contacts> contactsArrayList = new ArrayList<>();

    //RecyclerView rList;
    // final View.OnClickListener onClickListener = new ContactsAdapter.MyOnClickListner();


    public ContactsAdapter(Context context, ArrayList<Contacts> contactsArrayList) {
        // this.activity=activity;
        this.context = context;
        this.contactsArrayList = contactsArrayList;

    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_review_act2, parent, false);
        // view.setOnClickListener(onClickListener);
        ContactsAdapter.ViewHolder viewHolder = new ContactsAdapter.ViewHolder(view);


        return viewHolder;
        // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_review_act2, parent, false);
        // return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //Contacts contacts = dataholder.get(i);
        // holder.username.setText(contacts.getUsername());
        //holder.comment.setText(contacts.getComment());
        // holder.date.setText(contacts.getDate());

        //x=contactsArrayList.get(position).getComment();
        holder.username.setText(contactsArrayList.get(position).getUsername());
        holder.comment.setText(contactsArrayList.get(position).getComment());
        holder.date.setText(contactsArrayList.get(position).getDate());
        holder.mainCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert(position);


            }
        });

    }

    DBPhandler dbHandler = new DBPhandler(context);

    private void alert(int s) {
        AlertDialog dlg = new AlertDialog.Builder(context)
                .setTitle("Alert!!!")
                .setMessage("Do you want to Edit this comment?")

                .setNegativeButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Intent intent = new Intent(context, EditAct2.class);
                        intent.putExtra("comment", contactsArrayList.get(s).getComment());
                        // activity.startActivityForResult(intent,1);
                        context.startActivity(intent);

                    }
                })
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {



                        Intent intent = new Intent(context, comments.class);
                        context.startActivity(intent);
                        // dialog.dismiss();
                    }
                })
                .create();
        dlg.show();
    }

    @Override
    public int getItemCount() {
        return contactsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView username;
        TextView comment;
        TextView date;
        CardView mainCardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.name_txt);
            comment = itemView.findViewById(R.id.comment_txt);
            date = itemView.findViewById(R.id.date_txt);
            mainCardView=itemView.findViewById(R.id.mainCardView);

        }
    }


}

