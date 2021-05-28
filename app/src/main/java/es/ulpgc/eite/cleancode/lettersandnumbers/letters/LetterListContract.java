package es.ulpgc.eite.cleancode.lettersandnumbers.letters;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.lettersandnumbers.app.LettersToNumbersState;
import es.ulpgc.eite.cleancode.lettersandnumbers.app.NumbersToLettersState;
import es.ulpgc.eite.cleancode.lettersandnumbers.data.LetterData;

public interface LetterListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(LetterListViewModel viewModel);
    void navigateToNextScreen();

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

    void onClickLetterListCell(LetterData data);
    void onClickLetterListButton();
  }

  interface Model {
    List<LetterData>  getStoredData();
    void onDataFromNextScreen(String data);
    void onRestartScreen(List<LetterData> datasource);
    void onDataFromPreviousScreen(String data);
    void addLetra(int posicion);



  }


}
