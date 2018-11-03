package cl.cutiko.mvpsample.main;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cl.cutiko.mvpsample.R;


public class MainFragment extends Fragment implements MainContract.View, View.OnClickListener {

    private MainContract.Presenter presenter;
    private ProgressDialog progressDialog;
    private TextView textView;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        textView = view.findViewById(R.id.clickTv);
        textView.setOnClickListener(this);
    }

    @Override
    public void loading() {
        progressDialog.show();
    }

    @Override
    public void empty() {
        textView.setText(R.string.empty);
        progressDialog.hide();
    }

    @Override
    public void success() {
        textView.setText(R.string.done);
        progressDialog.hide();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onClick(View v) {
        presenter.start();
    }
}
