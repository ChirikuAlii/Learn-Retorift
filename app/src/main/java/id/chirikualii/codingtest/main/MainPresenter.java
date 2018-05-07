package id.chirikualii.codingtest.main;

import java.util.List;

public class MainPresenter implements IMainPresenter ,IMainInteractor.listener{

    IMainView view;
    IMainInteractor interactor = new MainInteractor(this);

    public MainPresenter(IMainView view) {
        this.view = view;
    }

    @Override
    public void onSuccsess(List<String> dogList) {
        view.setOnSuccsess(dogList);
    }

    @Override
    public void onError() {
        view.setOnError();
    }

    @Override
    public void onLoading() {
        view.setonLoading();
    }

    @Override
    public void performLoadData() {
        interactor.loadData();
    }
}
