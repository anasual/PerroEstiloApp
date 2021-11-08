package com.example.perroestilopfinal.ui.homeCliente;

import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.perroestilopfinal.R;
import com.example.perroestilopfinal.databinding.ItemCustomFixedSizeLayout3Binding;
import com.example.perroestilopfinal.databinding.ItemCustomFixedSizeLayout4Binding;


import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

public class HomeClienteFragment extends Fragment {

    private HomeClienteViewModel mViewModel;

    ImageCarousel carousel;
    ImageCarousel carousel6;
    ImageCarousel carousel4;
    ViewFlipper viewFlipper;

    List<CarouselItem> list = new ArrayList<>();
    List<CarouselItem> list2 = new ArrayList<>();
    List<CarouselItem> list3 = new ArrayList<>();

    public static HomeClienteFragment newInstance() {
        return new HomeClienteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_home_cliente, container, false);

        carousel = root.findViewById(R.id.carruselInicio);
        carousel6 = root.findViewById(R.id.carousel6);
        carousel4 = root.findViewById(R.id.carousel4);


        list.add(new CarouselItem(R.drawable.img1));
        list.add(new CarouselItem(R.drawable.img2));
        list.add(new CarouselItem(R.drawable.img3));
        list.add(new CarouselItem(R.drawable.img4));
        list.add(new CarouselItem(R.drawable.img5));

        carousel.setData(list);

        List<Integer> colorsForSix = new ArrayList<>();
        colorsForSix.add(R.color.flat_awesome_green_1);
        colorsForSix.add(R.color.flat_green_1);
        colorsForSix.add(R.color.flat_blue_1);
        colorsForSix.add(R.color.flat_pink_1);
        colorsForSix.add(R.color.flat_yellow_1);
        colorsForSix.add(R.color.flat_orange_1);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"Lorem ipsum");
        map.put(2,"Cum sociis");
        map.put(3,"Euismod lacinia");
        map.put(4,"Tincidunt ornare");
        map.put(5,"Pellentesque elit");
        map.put(0,"Semper eget");
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ultrices gravida dictum fusce ut placerat.");
        map2.put(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ultrices gravida dictum fusce ut placerat.");
        map2.put(2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ultrices gravida dictum fusce ut placerat.");
        map2.put(3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ultrices gravida dictum fusce ut placerat.");
        map2.put(4, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ultrices gravida dictum fusce ut placerat.");
        map2.put(5, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ultrices gravida dictum fusce ut placerat.");
        //map2.put(6, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ultrices gravida dictum fusce ut placerat.");


        carousel6.setCarouselListener(new CarouselListener() {
            @Nullable
            @Override
            public ViewBinding onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup parent) {
                // ...
                return ItemCustomFixedSizeLayout4Binding.inflate(layoutInflater, parent, false);
            }

            @Override
            public void onBindViewHolder(@NotNull ViewBinding binding, @NotNull CarouselItem item, int position) {
                // Convierte el enlace a la clase de enlace de vista devuelta del método onCreateViewHolder ().
                ItemCustomFixedSizeLayout4Binding currentBinding = (ItemCustomFixedSizeLayout4Binding) binding;

                int currentColor = ResourcesCompat.getColor(getResources(), colorsForSix.get(position), null);
                currentBinding.card.setCardBackgroundColor(currentColor);

                currentBinding.tvCaption.setText("-"+map.get(position));
                currentBinding.tvBody.setText(map2.get(position));
            }

            @Override
            public void onLongClick(int position, @NotNull CarouselItem carouselItem) {
                // ...
            }

            @Override
            public void onClick(int position, @NotNull CarouselItem carouselItem) {
                // ...
            }
        });

        list2.add(new CarouselItem());
        list2.add(new CarouselItem());
        list2.add(new CarouselItem());
        list2.add(new CarouselItem());
        list2.add(new CarouselItem());
        list2.add(new CarouselItem());
        carousel6.setData(list2);


        carousel4.setCarouselListener(new CarouselListener() {
            @Nullable
            @Override
            public ViewBinding onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup parent) {
                // ...
                return ItemCustomFixedSizeLayout3Binding.inflate(layoutInflater, parent, false);
            }

            @Override
            public void onBindViewHolder(@NotNull ViewBinding binding, @NotNull CarouselItem item, int position) {
                // Convierte el enlace a la clase de enlace de vista devuelta del método onCreateViewHolder ().
                ItemCustomFixedSizeLayout3Binding currentBinding = (ItemCustomFixedSizeLayout3Binding) binding;
                currentBinding.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                currentBinding.imageView.setImageResource(R.drawable.ic_notifications_black_24dp);
            }

            @Override
            public void onLongClick(int position, @NotNull CarouselItem carouselItem) {
                // ...
            }

            @Override
            public void onClick(int position, @NotNull CarouselItem carouselItem) {
                // ...
            }
        });

        list3.add(new CarouselItem(R.drawable.img5));
        list3.add(new CarouselItem(R.drawable.img2));
        list3.add(new CarouselItem(R.drawable.img2));
        list3.add(new CarouselItem(R.drawable.img2));
        list3.add(new CarouselItem(R.drawable.img2));
        list3.add(new CarouselItem(R.drawable.img2));
        carousel4.setData(list3);

        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeClienteViewModel.class);
        // TODO: Use the ViewModel
    }

}