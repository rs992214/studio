package es.iessaladillo.pedrojoya.pr132.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import es.iessaladillo.pedrojoya.pr132.data.Repository;

class MainFragmentViewModelFactory implements ViewModelProvider.Factory {

    private final Repository repository;

    public MainFragmentViewModelFactory(Repository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new MainFragmentViewModel(repository);
    }

}