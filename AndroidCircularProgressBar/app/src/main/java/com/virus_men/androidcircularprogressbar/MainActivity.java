package com.virus_men.androidcircularprogressbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.events.DecoEvent;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView tvMonthYear, tvStatus, tvIncome, tvExpense, tvTotalBalance;
    private DecoView decoView;
    private double balance, income, expense;
    private Context context;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        initViews();
        //
        // show current month year method
        showCurentMonthYear();
        //
        income = 5000;
        expense = 4400;
        balance = income - expense;
        //
        tvIncome.setText("Income: " + income);
        tvExpense.setText("Expense: " + expense);
        tvTotalBalance.setText("Balance: " + balance);
        //
        if (expense <= 0.5d * income) {
            tvStatus.setText("Good");
            tvStatus.setTextColor(Color.parseColor("#FF81C788"));
        } else if ((expense >= 0.51d * income) && (expense <= 0.8d * income)) {
            tvStatus.setText("Warning");
            tvStatus.setTextColor(Color.parseColor("#FFFFDC15"));
        } else if ((expense < 0.81d * income) || (expense > income)) {
            if (expense > income) {
                tvStatus.setText("Danger");
                tvStatus.setTextColor(Color.parseColor("#FFFF4141"));
            } else {
                tvStatus.setText("Bad");
                tvStatus.setTextColor(Color.parseColor("#FFFF4141"));
            }
        } else {
            tvStatus.setText("Bad");
            tvStatus.setTextColor(Color.parseColor("#FFFFDC15"));
        }
        double x = expense / income * 100.0d;
        if (income == 0 && expense == 0){
            balance = 0;
            tvTotalBalance.setText("Let's Begin");
            tvTotalBalance.setTextColor(Color.parseColor("#FF000000"));
        }
        if (income != 0 || expense != 0){
            balance = x;
        }else {
            balance = 100.00;
            tvStatus.setText("danger!");
            tvStatus.setTextColor(Color.parseColor("#FFFF4141"));
        }
        decoView.addSeries(new SeriesItem.Builder(
                Color.argb(255, 129, 199, 136))
                .setRange(0.0f, 100.0f, 100.0f)
                .setInitialVisibility(false).setLineWidth(40.0f).build());
        int seriesIndex = decoView.addSeries(new SeriesItem.Builder(
                Color.argb(255, 224, 67, 54))
                .setRange(0.0f, 100.0f, 0.0f)
                .setInitialVisibility(false).setLineWidth(40.0f).build());
        decoView.addEvent(new DecoEvent.Builder(DecoEvent.EventType.EVENT_SHOW, true).setDelay(1).setDuration(1001).build());
        decoView.addEvent(new DecoEvent.Builder((float) balance).setIndex(seriesIndex).setDelay(1002).build());

    }



    private void initViews() {
        tvMonthYear = findViewById(R.id.month_year);
        tvStatus = findViewById(R.id.status);
        tvIncome = findViewById(R.id.income);
        tvExpense = findViewById(R.id.expense);
        tvTotalBalance = findViewById(R.id.balance);
        decoView = findViewById(R.id.arcView);
    }

    @SuppressLint("SetTextI18n")
    private void showCurentMonthYear() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        String strMonth = BuildConfig.FLAVOR;
        switch (month) {
            case 1:
                strMonth = "January";
                break;
            case 2:
                strMonth = "February";
                break;
            case 3:
                strMonth = "March";
                break;
            case 4:
                strMonth = "April";
                break;
            case 5:
                strMonth = "May";
                break;
            case 6:
                strMonth = "June";
                break;
            case 7:
                strMonth = "July";
                break;
            case 8:
                strMonth = "August";
                break;
            case 9:
                strMonth = "September";
                break;
            case 10:
                strMonth = "October";
                break;
            case 11:
                strMonth = "November";
                break;
            case 12:
                strMonth = "December";
                break;
            default:
                strMonth = "Error";
                break;
        }
        tvMonthYear.setText(strMonth + "-" + year);
    }

}
