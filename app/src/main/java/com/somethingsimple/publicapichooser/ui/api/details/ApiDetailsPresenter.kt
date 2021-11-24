package com.somethingsimple.publicapichooser.ui.api.details

import com.github.terrakok.cicerone.Router
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.publicapichooser.data.repository.publicapi.PublicApiRepository
import com.somethingsimple.publicapichooser.schedulers.DefaultSchedulersImpl
import com.somethingsimple.publicapichooser.ui.IScreens
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class ApiDetailsPresenter @AssistedInject constructor(
    @Assisted("id") private val id: String,
    @Assisted("screens") private val screens: IScreens,
    private val publicApiRepository: PublicApiRepository,
    private val router: Router,
    private val schedulers: DefaultSchedulersImpl
) : MvpPresenter<ApiDetailsView>() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        compositeDisposable.add(
            publicApiRepository
                .getPublicApiById(1)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    ::onApiByIdSuccess,
                    ::onError
                )
        )
    }

    private fun onError(throwable: Throwable?) {
        throwable?.let { viewState.showError(it.localizedMessage) }
    }

    private fun onApiByIdSuccess(apiEntry: ApiEntry?) {
        apiEntry?.let { viewState.showDetails(it) }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}