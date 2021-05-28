package es.ulpgc.eite.cleancode.lettersandnumbers.numbers;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.lettersandnumbers.R;
import es.ulpgc.eite.cleancode.lettersandnumbers.app.AppMediator;

public class NumberListScreen {

  public static void configure(NumberListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    String data = context.get().getString(R.string.app_name);

    AppMediator mediator = AppMediator.getInstance();

    NumberListContract.Presenter presenter = new NumberListPresenter(mediator);
    NumberListContract.Model model = new NumberListModel(data);
    presenter.injectModel(model);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
