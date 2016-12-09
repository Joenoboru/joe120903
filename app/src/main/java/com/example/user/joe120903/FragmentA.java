package com.example.user.joe120903;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {
    Button btn2;

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        //tv在FragmentA中,在onCreateView階段抓取沒問題
        final TextView tv = (TextView) v.findViewById(R.id.textView);
        Button btn = (Button) v.findViewById(R.id.button);
        btn2 = (Button) v.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Hello Hello");
            }
        });

        return v;
    }

    //按btn2讓fragmentb內容改變,抓取tv2的程式碼要放在onActivityCreated內,因為若放在onCreateView內的話
    //,它比onActivityCreated先執行,tv2還沒產生故抓不到資訊而為null,因此要放在onActivityCreated內
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final TextView tv2 = (TextView) getActivity().findViewById(R.id.textView2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText("Hello 3333");
            }
        });
    }

}
