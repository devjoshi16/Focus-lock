package com.example.FocusLock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;
        import androidx.annotation.NonNull;

public class AdapterDevice extends RecyclerView.Adapter<AdapterDevice.Holder>{

    ArrayList<String> Device_namelist,Device_adresslist;
//    player player = new player().getInstance();
    HostPageActivity hostPageActivity=new HostPageActivity();
    Context context;
    public AdapterDevice(Context context,ArrayList<String> Device_namelist,ArrayList<String> Device_adresslist){
        this.Device_namelist=Device_namelist;
        this.Device_adresslist=Device_adresslist;
        this.context=context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.device_list, parent, false);
        return new Holder(listItem);
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.Device_name.setText(Device_namelist.get(holder.getAdapterPosition()));
        holder.Device_adress.setText(Device_adresslist.get(holder.getAdapterPosition()));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                hostPageActivity.play(context,paths.get(holder.getAdapterPosition()),holder.getAdapterPosition());
//                MainActivity.updatecurrent(holder.getAdapterPosition());
//                Toast.makeText(AdapterDevice.this,"on Click",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return Device_namelist.size();
    }


    public class Holder extends RecyclerView.ViewHolder{

        TextView Device_name,Device_adress;
        LinearLayout layout;

        public Holder(@NonNull View itemView) {
            super(itemView);
            Device_name=itemView.findViewById(R.id.device_name);
            Device_adress=itemView.findViewById(R.id.device_address);
            layout=itemView.findViewById(R.id.layout_song_perticular);
        }
    }
}
