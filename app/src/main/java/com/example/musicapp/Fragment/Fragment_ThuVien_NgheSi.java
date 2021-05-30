package com.example.musicapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.Adapter.ThuVienNgheSiAdapter;
import com.example.musicapp.Model.NgheSi;
import com.example.musicapp.R;
import com.example.musicapp.Service.APIService;
import com.example.musicapp.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ThuVien_NgheSi  extends Fragment {

    View view;
    ThuVienNgheSiAdapter thuVienNgheSiAdapter;
    RecyclerView recyclerViewNgheSi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thuvien_nghesi, container, false);
        recyclerViewNgheSi = view.findViewById(R.id.recyclerviewnthuvienghesi);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<NgheSi>> callback = dataservice.GetNgheSiCurrent();
        callback.enqueue(new Callback<List<NgheSi>>() {
            @Override
            public void onResponse(Call<List<NgheSi>> call, Response<List<NgheSi>> response) {
                ArrayList<NgheSi> mangnghesi = (ArrayList<NgheSi>) response.body();
                thuVienNgheSiAdapter = new ThuVienNgheSiAdapter(getActivity(), mangnghesi);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewNgheSi.setLayoutManager(linearLayoutManager);
                recyclerViewNgheSi.setAdapter(thuVienNgheSiAdapter);
            }

            @Override
            public void onFailure(Call<List<NgheSi>> call, Throwable t) {

            }

        });
    }

}
