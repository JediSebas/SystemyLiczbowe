package com.jedisebas.systemyliczbowe.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jedisebas.systemyliczbowe.IsEmptyException;
import com.jedisebas.systemyliczbowe.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final EditText decEt = root.findViewById(R.id.decEt);
        final EditText binEt = root.findViewById(R.id.binEt);
        final EditText octEt = root.findViewById(R.id.octEt);
        final EditText hexEt = root.findViewById(R.id.hexEt);
        final Button obl = root.findViewById(R.id.oblGlow);

        final FloatingActionButton fab = root.findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decEt.setText("");
                binEt.setText("");
                octEt.setText("");
                hexEt.setText("");
            }
        });

        obl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    dashboardViewModel.letsDoThat(decEt, binEt, octEt, hexEt);
                } catch (IsEmptyException e) {
                    e.printStackTrace();
                }
            }
        });
        return root;
    }
}