package com.samad.talukder.androidcheckedtextviewexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.Toast;

public class CheckedTextViewAdapter extends BaseAdapter {
    private String[] names;
    private Context context;
    private String value;

    public CheckedTextViewAdapter(String[] names, Context context) {
        this.names = names;
        this.context = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mLayoutInflater.inflate(R.layout.items_list, null);

            final CheckedTextView checkedTextView = convertView.findViewById(R.id.checkedItemTextView);
            checkedTextView.setText(names[position]);
            checkedTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkedTextView.isChecked()) {
                        value = "Un-Checked";
                        checkedTextView.setCheckMarkDrawable(0);
                        checkedTextView.setChecked(false);
                    } else {
                        value = "Checked";
                        checkedTextView.setCheckMarkDrawable(R.drawable.check);
                        checkedTextView.setChecked(true);
                    }
                    Toast.makeText(context, value, Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }
}
