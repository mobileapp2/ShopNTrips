package com.imuons.shopntrips.adapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imuons.shopntrips.R;
import com.imuons.shopntrips.fragments.FundTransferReportFragment;
import com.imuons.shopntrips.fragments.ROIIncomeFragment;
import com.imuons.shopntrips.model.FundTransferReportRecordModel;
import com.imuons.shopntrips.model.RoiIncomeReportRecordModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FundTransferReportAdapter extends RecyclerView.Adapter<FundTransferReportAdapter.FundTransferReportAdapterHolder> {
    private List<FundTransferReportRecordModel> ftList = new ArrayList<>();
    private Context context;
    private FundTransferReportFragment fundTransferReportFragment;
    private String wdatefromurl,cdatefromurl;
    private Date datec,datew;
    private static int currentPosition = 0;

    public FundTransferReportAdapter(Context context, List<FundTransferReportRecordModel> ftList) {
        this.ftList = ftList;

        this.context = context;
        Log.e("list: ", ftList.size() + "");
    }

    @Override
    public FundTransferReportAdapter.FundTransferReportAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_fund_transfer_report, parent, false);
        return new FundTransferReportAdapter.FundTransferReportAdapterHolder(v);
    }

    @Override
    public void onBindViewHolder(final FundTransferReportAdapter.FundTransferReportAdapterHolder holder, final int position) {

        final FundTransferReportRecordModel fundTransferReportRecordModel = ftList.get(position);

        holder.hiddenlayout.setVisibility(View.GONE);
        wdatefromurl = fundTransferReportRecordModel.getEntryTime();
        if(wdatefromurl != null) {
            SimpleDateFormat simpleDateFormatw = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            try {
                datew = simpleDateFormatw.parse(wdatefromurl);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            DateFormat dateFormatw = new SimpleDateFormat("yyyy/MM/dd");
            String wcdate = dateFormatw.format(datew);
            holder.date.setText(wcdate);
        }else{
            holder.date.setText("-");
        }

//        cdatefromurl = withdrawHistoryRecordModel.getCompleteDate();
//        if(cdatefromurl != null) {
//        SimpleDateFormat simpleDateFormatc = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        try {
//        datew = simpleDateFormatc.parse(wdatefromurl);
//        } catch (ParseException e) {
//        e.printStackTrace();
//        }
//        DateFormat dateFormatc = new SimpleDateFormat("yyyy/MM/dd");
//        String ccdate = dateFormatc.format(datew);
//        holder.compledate.setText(ccdate);
//        }else {
//        holder.compledate.setText("-");
//        }


//        if (position % 2 == 0) {
//        holder.llmain.setBackgroundColor(Color.parseColor("#f5f4f4"));
//        } else {
//        holder.llmain.setBackgroundColor(Color.parseColor("#c9caca"));
//
//        }


        holder.srno.setText(String.valueOf(position + 1));

        holder.touser.setText(fundTransferReportRecordModel.getToUserId()+"("+fundTransferReportRecordModel.getToFullname()+")");


        holder.fromuser.setText(fundTransferReportRecordModel.getFromUserId()+"("+fundTransferReportRecordModel.getFromFullname()+")");

        int amtint = fundTransferReportRecordModel.getAmount();
        holder.amount.setText(String.valueOf(amtint));

        holder.status.setText(fundTransferReportRecordModel.getFundStatus());

        holder.type.setText(fundTransferReportRecordModel.getType());





        //if the position is equals to the item position which is to be expanded
        if (currentPosition == position) {
            //  holder.eye.setImageResource(R.drawable.closeeye);
            //creating an animation
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);

            //toggling visibility
            holder.hiddenlayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.hiddenlayout.startAnimation(slideDown);
        } else {
            // holder.eye.setImageResource(R.drawable.oprneye);
        }

        holder.llmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting the position of the item to expand it
                currentPosition = position;
                //reloding the list
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ftList.size();
    }

    public class FundTransferReportAdapterHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.srno)
        TextView srno;

        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.touser)
        TextView touser;
        @BindView(R.id.fromuser)
        TextView fromuser;
        @BindView(R.id.amount)
        TextView amount;
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.type)
        TextView type;




        @BindView(R.id.llmain)
        LinearLayout llmain;
        @BindView(R.id.hiddenlayout)
        LinearLayout hiddenlayout;
        View container;


        public FundTransferReportAdapterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            container = itemView;
        }
    }

}
