package dongdang.androind.kinolights.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;
import dongdang.androind.kinolights.model.vo.EventItemDTO;
import dongdang.androind.kinolights.view.MainActivity;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<EventItemDTO> eventList;

    //getting the context and product list with constructor
    public EventAdapter(Context mCtx, List<EventItemDTO> eventList) {
        this.mCtx = mCtx;
        this.eventList = eventList;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_event, null);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        //getting the product of the specified position
        final EventItemDTO event = eventList.get(position);

        //binding the data with the viewholder views
        holder.evtTvTitle.setText(event.getEvtTitle());
        holder.evtTvContent.setText(event.getEvtSummary());
        holder.evtImgView.setImageDrawable(mCtx.getResources().getDrawable(event.getImage()));

        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = (View)View.inflate(v.getContext(),R.layout.dialog_event,null);
                Button dialogEnquireExitButton = (Button)dialogView.findViewById(R.id.dialogEventExitButton);
                ImageView imageView = dialogView.findViewById(R.id.eventContentImageView);
                imageView.setImageResource(event.getImage());
                TextView textView = dialogView.findViewById(R.id.eventContentTextView);
                textView.setText(event.getEvtContent());
                AlertDialog.Builder dlg = new AlertDialog.Builder(v.getContext());
                final AlertDialog alertDialog = dlg.create();
                alertDialog.setView(dialogView);
                alertDialog.show();
                dialogEnquireExitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
            }
        });
    }


    @Override
    public int getItemCount() {
        return eventList.size();
    }


    class EventViewHolder extends RecyclerView.ViewHolder {

        TextView evtTvTitle, evtTvContent;
        ImageView evtImgView;
        Button btnMore;
        /*TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;*/

        public EventViewHolder(View itemView) {
            super(itemView);
            evtTvTitle = itemView.findViewById(R.id.evtTvTitle);
            evtTvContent = itemView.findViewById(R.id.evtTvContent);
            evtImgView = itemView.findViewById(R.id.evtImgView);
            btnMore = itemView.findViewById(R.id.btnMore);

            btnMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

           /* textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);*/
        }
    }






}
