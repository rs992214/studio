package es.iessaladillo.pedrojoya.pr169.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import es.iessaladillo.pedrojoya.pr169.base.RequestState;
import es.iessaladillo.pedrojoya.pr169.data.remote.Api;
import es.iessaladillo.pedrojoya.pr169.data.remote.YandexLiveData;

class MainActivityViewModel extends ViewModel {

    private final YandexLiveData yandexLiveData;

    public MainActivityViewModel(Api api) {
        yandexLiveData = new YandexLiveData(api);
    }

    public LiveData<RequestState> getTranslation() {
        return yandexLiveData;
    }

    public void translateFromApi(String word) {
        yandexLiveData.translate(word);
    }

    @Override
    protected void onCleared() {
        yandexLiveData.cancel();
        super.onCleared();
    }

}
