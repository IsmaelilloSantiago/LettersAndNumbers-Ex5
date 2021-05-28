package es.ulpgc.eite.cleancode.lettersandnumbers.letters;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.lettersandnumbers.data.LetterData;

public class LetterListModel implements LetterListContract.Model {

  public static String TAG = LetterListModel.class.getSimpleName();

  private String data;
  public List<LetterData> datasource;
  public List<String> letras;

  public LetterListModel(String data) {
    this.data = data;
    this.datasource = new ArrayList<>();
    this.letras = new ArrayList<>();
    this.letras.add("A");
    this.letras.add("B");
    this.letras.add("C");
    this.letras.add("D");
    this.letras.add("E");
  }

  @Override
  public List<LetterData> getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return datasource;
  }

  @Override
  public void onRestartScreen(List<LetterData> datasource) {
    // Log.e(TAG, "onRestartScreen()");
    this.datasource = datasource;
  }

  @Override
  public void onDataFromNextScreen(String data) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }

  @Override
  public void onDataFromPreviousScreen(String data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
  }

  @Override
  public void addLetra(int posicion) {
    datasource.add(posicion,new LetterData());
    datasource.get(posicion).letter = letras.get(posicion);

  }

}
