package es.ulpgc.eite.cleancode.lettersandnumbers.letters;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.lettersandnumbers.app.AppMediator;
import es.ulpgc.eite.cleancode.lettersandnumbers.app.LettersToNumbersState;
import es.ulpgc.eite.cleancode.lettersandnumbers.app.NumbersToLettersState;
import es.ulpgc.eite.cleancode.lettersandnumbers.data.LetterData;

public class LetterListPresenter implements LetterListContract.Presenter {

  public static String TAG = LetterListPresenter.class.getSimpleName();

  private WeakReference<LetterListContract.View> view;
  private LetterListState state;
  private LetterListContract.Model model;
  private AppMediator mediator;

  public LetterListPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getLetterListState();
  }

  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new LetterListState();
    }
    state.poscionArrayletras = 0;
    state.cuentaNumero = 1;

    /*
    // use passed state if is necessary
    LetterListState savedState = router.getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromPreviousScreen(savedState.data);
    }
    */

  }

  @Override
  public void onRestart() {
    // Log.e(TAG, "onRestart()");

    // update the model if is necessary
    model.onRestartScreen(state.datasource);
  }

  @Override
  public void onResume() {
    // Log.e(TAG, "onResume()");

    // use passed state if is necessary
    NumbersToLettersState savedState = getStateFromNextScreen();


    if (savedState != null) {
      Log.e(TAG,savedState.cuenta + "");
      // update the model if is necessary
      model.onDataFromNextScreen(savedState.data);

      state.cuentaNumero = savedState.cuenta;


    }


    // call the model and update the state

    //state.data = model.getStoredData();

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
  }

  @Override
  public void onPause() {
    // Log.e(TAG, "onPause()");
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");
  }


  private void passStateToNextScreen(LettersToNumbersState state) {
    mediator.setNextLetterListScreenState(state);
  }

  /*
  private void passStateToPreviousScreen(LetterListState state) {
    mediator.setPreviousLetterListScreenState(state);
  }

  private LetterListState getStateFromPreviousScreen() {
    return mediator.getPreviousLetterListScreenState();
  }
  */

  private NumbersToLettersState getStateFromNextScreen() {
    return mediator.getNextLetterListScreenState();
  }

  @Override
  public void onClickLetterListCell(LetterData data) {
    Log.e(TAG, "onClickLetterListCell()");
    state.idLetra = data.id;

    LettersToNumbersState estado = new LettersToNumbersState();
    estado.cuenta = state.cuentaNumero;
    estado.id = state.idLetra;
    passStateToNextScreen(estado);


    view.get().navigateToNextScreen();

  }

  @Override
  public void onClickLetterListButton() {
    Log.e(TAG, "onClickLetterListButton()");
    model.addLetra(state.poscionArrayletras);
    state.datasource = model.getStoredData();
    state.poscionArrayletras++;
    onResume();

  }

  @Override
  public void injectView(WeakReference<LetterListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(LetterListContract.Model model) {
    this.model = model;
  }

}
