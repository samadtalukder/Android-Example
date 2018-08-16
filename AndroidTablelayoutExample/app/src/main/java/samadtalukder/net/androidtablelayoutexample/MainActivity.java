package samadtalukder.net.androidtablelayoutexample;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String[] companies={"Google", "Windows", "iPhone", "Nokia", "Samsung",
            "Google", "Windows", "iPhone", "Nokia", "Samsung",
            "Google", "Windows", "iPhone", "Nokia", "Samsung"};
    String[] os={"Android", "Mango", "iOS", "Symbian", "Bada",
            "Android", "Mango", "iOS", "Symbian", "Bada",
            "Android", "Mango", "iOS", "Symbian", "Bada"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTableHeadersData();
        addTableRowData();
        /*proName = findViewById(R.id.product_name);
        proName.setText("Product Name");*/
    }

    /*Programmatically textview*/
    private TextView getTextView(int id,String text,int textColor,int BackgroundColor){
        TextView textView = new TextView(this);
        textView.setId(id);
        textView.setText(text);
        textView.setTextColor(textColor);
        textView.setBackgroundColor(BackgroundColor);
        textView.setLayoutParams(getLayoutParams());
        textView.setPadding(20,20,20,20);
        textView.setOnClickListener(this);

        return textView;
    }
    @NonNull
    private LayoutParams getLayoutParams() {
        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(5,0,0,5);
        return params;
    }
    @NonNull
    private TableLayout.LayoutParams getTableLayoutParams(){
        return new TableLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
    }

    private void addTableHeadersData() {
        TableLayout tableLayout = findViewById(R.id.table);
        TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(getLayoutParams());
        tableRow.addView(getTextView(0,"Company", Color.WHITE,Color.BLUE));
        tableRow.addView(getTextView(0,"OS", Color.WHITE,Color.BLUE));
        tableLayout.addView(tableRow,getTableLayoutParams());
    }
    private void addTableRowData() {
        int numOfCompanies = companies.length;
        TableLayout tableLayout2 = findViewById(R.id.table);
        for (int i=0;i<numOfCompanies;i++){
            TableRow tableRow2 = new TableRow(this);
            tableRow2.setLayoutParams(getLayoutParams());
            tableRow2.addView(getTextView(i+1,companies[i],Color.WHITE, ContextCompat.getColor(this,R.color.colorAccent)));
            tableRow2.addView(getTextView(i+1,os[i],Color.WHITE, ContextCompat.getColor(this,R.color.colorAccent)));
            tableLayout2.addView(tableRow2,getTableLayoutParams());
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        TextView tv = findViewById(id);
        if (null != tv) {
            Log.i("onClick", "Clicked on row :: " + id);
            Toast.makeText(this, "Clicked on row :: " + id + ", Text :: " + tv.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
