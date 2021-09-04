package com.example.wuxinmima;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class mimaAdapter extends ArrayAdapter<mima> {
    private int resourceId;
    public mimaAdapter(Context context,int textViewResoureId,List<mima> objects){
        super(context,textViewResoureId,objects);
        resourceId = textViewResoureId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        mima mima = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView 名称 = (TextView) view.findViewById(R.id.密码名称);
        名称.setText(mima.get名称());
        return view;
    }
}
