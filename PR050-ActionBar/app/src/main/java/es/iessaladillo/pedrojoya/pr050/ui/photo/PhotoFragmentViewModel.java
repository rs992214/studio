package es.iessaladillo.pedrojoya.pr050.ui.photo;

import androidx.lifecycle.ViewModel;

class PhotoFragmentViewModel extends ViewModel {

    private int effectId;

    int getEffectId() {
        return effectId;
    }

    void setEffectId(int effectId) {
        this.effectId = effectId;
    }

}