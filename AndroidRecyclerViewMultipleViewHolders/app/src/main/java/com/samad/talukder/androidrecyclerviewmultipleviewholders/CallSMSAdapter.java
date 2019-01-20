package com.samad.talukder.androidrecyclerviewmultipleviewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CallSMSAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static int TYPE_CALL = 1, TYPE_SMS = 2;
    private List<Object> callSMSFeed = new ArrayList<>();
    private Context context;

    public CallSMSAdapter(Context context) {
        this.context = context;
    }

    public void setCallSMSFeed(List<Object> callSMSFeed) {
        this.callSMSFeed = callSMSFeed;
    }

    // We need to override this as we need to differentiate
    // which type viewHolder to be attached
    // This is being called from onBindViewHolder() method
    @Override
    public int getItemViewType(int position) {
        if (callSMSFeed.get(position) instanceof Call) {
            return TYPE_CALL;
        } else if (callSMSFeed.get(position) instanceof SMS) {
            return TYPE_SMS;
        }
        return -1;
    }

    // Invoked by layout manager to replace the contents of the views
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case TYPE_CALL:
                Call call = (Call) callSMSFeed.get(position);
                ((CallViewHolder) holder).showCallDetails(call);
                break;
            case TYPE_SMS:
                SMS sms = (SMS) callSMSFeed.get(position);
                ((SMSViewHolder) holder).showSmsDetails(sms);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return callSMSFeed.size();
    }

    // Invoked by layout manager to create new views
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Attach layout for single cell
        int layout = 0;
        RecyclerView.ViewHolder viewHolder;
        // Identify viewType returned by getItemViewType(...)
        // and return ViewHolder Accordingly
        switch (viewType) {
            case TYPE_CALL:
                layout = R.layout.call_view_layout;
                View callsView = LayoutInflater
                        .from(parent.getContext())
                        .inflate(layout, parent, false);
                viewHolder = new CallViewHolder(callsView);
                break;
            case TYPE_SMS:
                layout = R.layout.sms_view_layout;
                View smsView = LayoutInflater
                        .from(parent.getContext())
                        .inflate(layout, parent, false);
                viewHolder = new SMSViewHolder(smsView);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    // First ViewHolder of object type Call
    // Reference to the views for each call items to display desired information
    public class CallViewHolder extends RecyclerView.ViewHolder {

        private TextView callerNameTextView, callTimeTextView;

        public CallViewHolder(View itemView) {
            super(itemView);
            // Initiate view
            callerNameTextView = (TextView) itemView.findViewById(R.id.callerName);
            callTimeTextView = (TextView) itemView.findViewById(R.id.callTime);
        }

        public void showCallDetails(Call call) {
            // Attach values for each item
            String callerName = call.getCallerName();
            String callTime = call.getCallTime();
            callerNameTextView.setText(callerName);
            callTimeTextView.setText(callTime);
        }
    }

    // Second ViewHolder of object type SMS
    // Reference to the views for each call items to display desired information
    public class SMSViewHolder extends RecyclerView.ViewHolder {

        private TextView senderNameTextView, smsContentTextView, smsTimeTextView;

        public SMSViewHolder(View itemView) {
            super(itemView);
            // Initiate view
            senderNameTextView = (TextView) itemView.findViewById(R.id.senderName);
            smsContentTextView = (TextView) itemView.findViewById(R.id.smsContent);
            smsTimeTextView = (TextView) itemView.findViewById(R.id.smsTime);
        }

        public void showSmsDetails(SMS sms) {
            // Attach values for each item
            String senderName = sms.getSenderName();
            String smsContent = sms.getSmsContent();
            String smsTime = sms.getSmsTime();
            senderNameTextView.setText(senderName);
            smsContentTextView.setText(smsContent);
            smsTimeTextView.setText(smsTime);
        }
    }
}

