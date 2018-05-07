package id.chirikualii.codingtest.main;

import java.util.List;

public interface IMainView {
    void setOnSuccsess(List<String> listDogs);
    void setOnError();
    void setonLoading();
}
