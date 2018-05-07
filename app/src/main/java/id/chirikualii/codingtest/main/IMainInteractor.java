package id.chirikualii.codingtest.main;

import java.util.List;

public interface IMainInteractor {
    void loadData();

    interface listener{
        void onSuccsess(List<String> dogList);
        void onError();
        void onLoading();
    }
}
