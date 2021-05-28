package es.ulpgc.eite.cleancode.lettersandnumbers.numbers;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.lettersandnumbers.data.NumberData;

public class NumberListViewModel {

  // put the view state here
  public String data;
  public List<NumberData> datasource;
  public int cuenta;
  public int posicionArray;
  public NumberListViewModel() {
    datasource = new ArrayList<>();
  }
}
