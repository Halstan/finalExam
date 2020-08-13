package com.example.finalexam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.finalexam.Class.User;
import com.example.finalexam.R;

import java.util.List;

public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.ViewHolder> {

    private List<User> userList;

    public AdapterUsers(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public AdapterUsers.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_items_users, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUsers.ViewHolder holder, int position) {

        holder.idUser.setText(userList.get(position).getIdUser().toString());
        holder.nombre.setText(userList.get(position).getNombre());
        holder.username.setText(userList.get(position).getUsername());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idUser, nombre, username;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idUser = itemView.findViewById(R.id.txtIdUser);
            nombre = itemView.findViewById(R.id.txtNombreUser);
            username = itemView.findViewById(R.id.txtUsernameU);
        }
    }
}
