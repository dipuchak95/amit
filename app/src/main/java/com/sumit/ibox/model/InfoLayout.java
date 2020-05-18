package com.sumit.ibox.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sumit.ibox.R;

public class InfoLayout {

//    private android.app.AlertDialog alertDialog;
//    private UserInterface userInterface;
//    private Activity activity;
//
//    public NoDataLayout(Activity activity, android.app.AlertDialog alertDialog, UserInterface userInterface) {
//        this.activity = activity;
//        this.alertDialog = alertDialog;
//        this.userInterface = userInterface;
//
//        customizeLayout();
//    }
//
//    private void customizeLayout() {
//        alertDialog.setCanceledOnTouchOutside(false);
//        alertDialog.setInverseBackgroundForced(true);
//        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//            @Override
//            public void onCancel(DialogInterface dialog) {
//                activity.onBackPressed();
//            }
//        });
//    }
//
//    public void setMessage(CharSequence message) {
//        try {
//            userInterface.getTvMessage().setText(message);
//        }catch (Exception ignored){}
//    }
//
//    public void show() {
//        try {
//            alertDialog.show();
//        }catch (Exception ignored){}
//    }
//
//    public void cancel() {
//        try {
//            alertDialog.cancel();
//        }catch (Exception ignored){}
//    }
//
//    public void dismiss() {
//        try {
//            alertDialog.dismiss();
//        }catch (Exception ignored){}
//    }
//
//    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
//        alertDialog.setOnCancelListener(onCancelListener);
//    }
//
//    public static class Builder{
//
//        private Context context;
//        private android.app.AlertDialog.Builder alertDialogBuilder;
//        private UserInterface userInterface;
//        private DialogInterface.OnClickListener dPosClickListener;
//        private DialogInterface.OnClickListener dNegClickListener;
//        private android.app.AlertDialog alertDialog;
//        private View.OnClickListener vPosClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertDialog.dismiss();
//                dPosClickListener.onClick(null, Integer.MAX_VALUE);
//            }
//        };
//
//        public Builder(Context context) {
//            this.context = context;
//            alertDialogBuilder = new android.app.AlertDialog.Builder(context);
//            LayoutInflater layoutInflater;
//            layoutInflater = LayoutInflater.from(context);
//            View view;
//            view = layoutInflater.inflate(R.layout.no_data_layout, null);
//            ImageView ivImage;
//            TextView tvMessage, tvActionBtn;
//            ivImage = view.findViewById(R.id.no_data_image);
//            tvMessage = view.findViewById(R.id.no_data_info_text);
//            tvActionBtn = view.findViewById(R.id.no_data_action_button);
//            userInterface = new UserInterface(ivImage, tvMessage, tvActionBtn);
//            alertDialogBuilder.setView(view);
//        }
//
//        public Builder(Context context, int themeResId) {
//            new Builder(context);
//        }
//
//        public Builder setActionButton(CharSequence text, DialogInterface.OnClickListener listener) {
//            this.dPosClickListener = listener;
//            userInterface.getTvActionBtn().setText(text);
//            userInterface.getTvActionBtn().setVisibility(View.VISIBLE);
//            if(listener != null)
//                userInterface.getTvActionBtn().setOnClickListener(vPosClickListener);
//            return this;
//        }
//
//        public Builder setMessage(String string) {
//            userInterface.getTvMessage().setText(string);
//            return this;
//        }
//
//        public Builder setImage(int id) {
//            userInterface.getIvImage().setImageResource(id);
//            return this;
//        }
//
//        public NoDataLayout create() {
//            alertDialog = alertDialogBuilder.create();
//            return new NoDataLayout((Activity) context, alertDialog, userInterface);
//        }
//
//        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
//            alertDialogBuilder.setOnCancelListener(onCancelListener);
//            return this;
//        }
//    }
//
//    private static class UserInterface{
//        private ImageView ivImage;
//        private TextView tvMessage, tvActionBtn;
//
//        public ImageView getIvImage() {
//            return ivImage;
//        }
//
//        public TextView getTvMessage() {
//            return tvMessage;
//        }
//
//        public TextView getTvActionBtn() {
//            return tvActionBtn;
//        }
//
//        public UserInterface(ImageView ivImage, TextView tvMessage, TextView tvActionBtn) {
//            this.ivImage = ivImage;
//            this.tvMessage = tvMessage;
//            this.tvActionBtn = tvActionBtn;
//        }
//    }
    private View rootView;
    private View layout;

    public InfoLayout(Context context, int layoutId){
        this.rootView = ((Activity)context).getWindow().getDecorView().findViewById(android.R.id.content);
        this.layout = rootView.findViewById(layoutId);
    }

    public void setImage(int id){
        ImageView imageView;
        imageView = rootView.findViewById(R.id.no_data_image);
        imageView.setImageResource(id);
    }

    public void setMessage(String msg){
        TextView textView;
        textView = rootView.findViewById(R.id.no_data_info_text);
        textView.setText(msg);
    }

    public void setActionButton(String name, View.OnClickListener onClickListener){
        TextView textView;
        textView = rootView.findViewById(R.id.no_data_action_button);
        textView.setVisibility(View.VISIBLE);
        textView.setText(name);
        textView.setOnClickListener(onClickListener);
    }

    public void show(){
        layout.setVisibility(View.VISIBLE);
    }

    public void remove(){
        layout.setVisibility(View.GONE);
    }
}
