package com.jedisebas.systemyliczbowe.ui.notifications;

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

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final EditText binEt = root.findViewById(R.id.norbinEt);
        final EditText zmEt = root.findViewById(R.id.zmEt);
        final EditText uoEt = root.findViewById(R.id.uoEt);
        final EditText utEt = root.findViewById(R.id.utEt);
        final Button oblDwoj = root.findViewById(R.id.oblDwoj);
        final FloatingActionButton fab2 = root.findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binEt.setText("");
                zmEt.setText("");
                uoEt.setText("");
                utEt.setText("");
            }
        });

        oblDwoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    notificationsViewModel.letsCountThat(binEt, zmEt, uoEt, utEt);
                } catch (IsEmptyException e) {
                    e.printStackTrace();
                }
            }
        });

        return root;
    }
}