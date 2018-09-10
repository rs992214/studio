package pedrojoya.iessaladillo.es.pr243.base;

import android.support.v7.view.ActionMode;

// Extiende ActionMode.Callback para añadirle el evento de que cambia la selección.
public interface MultiChoiceModeListener extends ActionMode.Callback {

    void onSelectionChanged(ActionMode mode, int selected);

}