package es.ulpgc.eite.cleancode.lettersandnumbers.numbers;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.lettersandnumbers.data.NumberData;

public class NumberListModel implements NumberListContract.Model {

  public static String TAG = NumberListModel.class.getSimpleName();

  private String data;
  public List<NumberData> datasource;

  public NumberListModel(String data) {
    this.data = data;
    this.datasource = new ArrayList<>();

  }

  @Override
  public List<NumberData> getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return this.datasource;


  }

  @Override
  public void onRestartScreen(List<NumberData> data) {
    // Log.e(TAG, "onRestartScreen()");
    this.datasource = data;
  }

  @Override
  public void onDataFromNextScreen(String data) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }

  @Override
  public void onDataFromPreviousScreen(String data) {
    Log.e(TAG, "onDataFromPreviousScreen()");
  }

  @Override
  public void addNum(int cuenta) {
    NumberData valor = new NumberData();
    valor.number = cuenta++;
    datasource.add(valor);
  }
}
