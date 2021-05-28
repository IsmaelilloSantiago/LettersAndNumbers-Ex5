package es.ulpgc.eite.cleancode.lettersandnumbers.numbers;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.lettersandnumbers.app.LettersToNumbersState;
import es.ulpgc.eite.cleancode.lettersandnumbers.app.NumbersToLettersState;
import es.ulpgc.eite.cleancode.lettersandnumbers.data.NumberData;

public interface NumberListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(NumberListViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);

    void onResume();
    void onStart();
    void onRestart();
    void onBackPressed();
    void onPause();
    void onDestroy();

    void onClickNumberListCell(NumberData data);
    void onClickNumberListButton();
  }

  interface Model {
    List<NumberData> getStoredData();
    void onDataFromNextScreen(String data);
    void onRestartScreen(List<NumberData> data);
    void onDataFromPreviousScreen(String data);
    void addNum(int cuenta);

    void aumentarCuenta();
    int getCuenta();
    void setCuenta(int cuenta);
  }


}
