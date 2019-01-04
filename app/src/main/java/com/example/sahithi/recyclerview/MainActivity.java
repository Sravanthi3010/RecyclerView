package com.example.sahithi.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String operating_system_types[] = {
            "Microsoft Windows",
            "linux",
            "Ubuntu",
            "Chrome OS",
            "Red Hat Linux",
            "mac OS",
            "Open SUSE",
    };

    private final String operating_system_logos[] = {
            "https://www.seeklogo.net/wp-content/uploads/2012/06/microsoft-windows-logo-vector-01.png",
            "https://upload.wikimedia.org/wikipedia/commons/a/af/Tux.png",
            "https://assets.ubuntu.com/v1/57a889f6-ubuntu-logo112.png",
            "https://www.xda-developers.com/files/2018/01/Chromebook-Soraka-Poppy-Chrome-OS.jpg",
            "https://seeklogo.com/images/L/Linux_Red_Hat-logo-8B748E6BCC-seeklogo.com.png",
            "https://www.logolynx.com/images/logolynx/13/137fbbc45babc1c2df798ebbac18eca5.png",
            "https://en.opensuse.org/images/4/44/Button-filled-colour.png",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<OSTypes> osTypes = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(),osTypes);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList<OSTypes> prepareData(){

        ArrayList<OSTypes> os_type = new ArrayList<>();
        for(int i=0;i<operating_system_types.length;i++){
            OSTypes OSTypes = new OSTypes();
            OSTypes.setOperating_system_type(operating_system_types[i]);
            OSTypes.setOperating_system_logo(operating_system_logos[i]);
            os_type.add(OSTypes);
        }
        return os_type;
    }
}