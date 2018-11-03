package cl.cutiko.mvpsample.main;

import cl.cutiko.mvpsample.BasePresenter;
import cl.cutiko.mvpsample.BaseView;

interface MainContract {

    interface View extends BaseView<Presenter> {
        void loading();
        void empty();
        void success();
    }

    interface Presenter extends BasePresenter {
        void done();
    }

}
