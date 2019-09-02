package com.samad_talukder.androidcustomlistviewpopulatingdatafromarraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etAddress;
    private Button btnInsert;
    private ListView lvShowData;
    private String name, address;
    private int id = 0;
    private ArrayList<DataModel> dataModelArrayList;
    private CustomListDataAdapter customListDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        btnInsert = findViewById(R.id.btnInsert);
        lvShowData = findViewById(R.id.lvShowData);

        dataModelArrayList = new ArrayList<>();


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id++;
                name = etName.getText().toString().trim();
                address = etAddress.getText().toString().trim();

                // DataModel dataModel = new DataModel(id, name, address);

                DataModel dataModel = new DataModel();

                dataModel.setId(id);
                dataModel.setName(name);
                dataModel.setAddress(address);

                dataModelArrayList.add(dataModel);
                lvShowData.setAdapter(customListDataAdapter);
                customListDataAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "ID: " + dataModel.getId() + " \n Name: " + dataModel.getName() + "\n Address: " + dataModel.getAddress(), Toast.LENGTH_SHORT).show();
            }
        });

        /*dataModelArrayList.add(new DataModel(1,"H","D"));
        dataModelArrayList.add(new DataModel(1,"H","D"));
        dataModelArrayList.add(new DataModel(1,"H","F"));
        dataModelArrayList.add(new DataModel(1,"H","F"));*/

        customListDataAdapter = new CustomListDataAdapter(getApplicationContext(), R.layout.view_row, dataModelArrayList);

        lvShowData.setAdapter(customListDataAdapter);
        customListDataAdapter.notifyDataSetChanged();
        lvShowData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "" + i, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
