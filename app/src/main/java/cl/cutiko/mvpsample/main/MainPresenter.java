package cl.cutiko.mvpsample.main;

import android.os.Handler;

import java.util.Random;

class MainPresenter implements MainContract.Presenter, Runnable {

    private final MainContract.View callback;
    private static final int LOADING = 3000;

    MainPresenter(MainContract.View callback) {
        this.callback = callback;
        callback.setPresenter(this);
    }

    @Override
    public void start() {
        //AsyncTask simulation
        callback.loading();
        new Handler().postDelayed(this, LOADING);
    }

    @Override
    public void done() {
        int random = new Random().nextInt(100)+1;
        if (random%2 == 0) {
            callback.success();
        } else {
            callback.empty();
        }
    }

    @Override
    public void run() {
        done();
    }
}
