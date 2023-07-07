package com.converter.onlineshoppingapplication.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.converter.onlineshoppingapplication.R;
import com.converter.onlineshoppingapplication.cart2Fragment;
import com.converter.onlineshoppingapplication.databinding.FragmentCartBinding;

public class CartFragment extends Fragment {

    private FragmentCartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Your order has successfully placed", Toast.LENGTH_SHORT).show();
                Fragment fragment2 = new cart2Fragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.frameLayout, fragment2).commit();
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}