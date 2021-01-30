package com.jedisebas.systemyliczbowe.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jedisebas.systemyliczbowe.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        textView.setText("Jest to aplikacja przeliczająca główne systemy pozycyjne takie jak " +
                "binarny, decymalny, oktalny i hexadecymalny oraz znak-moduł, zapis uzupełnień do 1 i " +
                "uzupełnień do 2. \nWybierz opcje na dole ekranu.");
        return root;
    }
}
