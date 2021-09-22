package dongdang.androind.kinolights.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.model.bl.ViewManageService;
import dongdang.androind.kinolights.model.vo.FaqItemVO;

public class FaqRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<FaqItemVO> arrayList;
    public FaqRecyclerViewAdapter(ArrayList<FaqItemVO> arrayList){
        this.arrayList = arrayList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //xml세팅
        View xView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faq,parent,false);
        return new RowCell(xView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //아이템 세팅
        ((RowCell)holder).faqContentTextView.setText(arrayList.get(position).getContent());
        ((RowCell)holder).faqHeaderTextView.setText(arrayList.get(position).getTitle());

        arrayList.get(position).setHeaderLayout(((RowCell)holder).faqHeaderLayout);
        arrayList.get(position).setContentLayout(((RowCell)holder).faqContentLayout);
        arrayList.get(position).getHeaderLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewManageService.setVisibleFaqItem((LinearLayout)v);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    private class RowCell extends RecyclerView.ViewHolder {
        private TextView faqHeaderTextView;
        private TextView faqContentTextView;
        private LinearLayout faqHeaderLayout;
        private LinearLayout faqContentLayout;

        public RowCell(final View view) {
            super(view);
            faqHeaderTextView = (TextView)view.findViewById(R.id.faqHeaderTextView);
            faqContentTextView = (TextView)view.findViewById(R.id.faqContentTextView);

            faqHeaderLayout = (LinearLayout)view.findViewById(R.id.faqHeaderLayout);
            faqContentLayout = (LinearLayout)view.findViewById(R.id.faqContentLayout);
        }


    }
}