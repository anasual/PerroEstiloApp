package com.example.perroestilopfinal.ui.tienda;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.perroestilopfinal.R;

public class TiendaClienteFragment extends Fragment {

    private TiendaClienteViewModel mViewModel;

    public static TiendaClienteFragment newInstance() {
        return new TiendaClienteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tienda_cliente, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TiendaClienteViewModel.class);
        // TODO: Use the ViewModel
    }

}