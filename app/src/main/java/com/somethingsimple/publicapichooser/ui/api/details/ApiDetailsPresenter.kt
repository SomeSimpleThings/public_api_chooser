package com.somethingsimple.publicapichooser.ui.api.details

import com.github.terrakok.cicerone.Router
import com.somethingsimple.publicapichooser.data.repository.publicapi.PublicApiRepository
import com.somethingsimple.publicapichooser.data.vo.ApiEntry
import com.somethingsimple.publicapichooser.ui.IScreens
import com.somethingsimple.publicapichooser.schedulers.Schedulers
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class ApiDetailsPresenter @AssistedInject constructor(
    @Assisted("id") private val id: Long,
    @Assisted("screens") private val screens: IScreens,
    private val publicApiRepository: PublicApiRepository,
    private val router: Router,
    private val schedulers: Schedulers
) : MvpPresenter<ApiDetailsView>() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        compositeDisposable.add(
            publicApiRepository
                .getPublicApiById(id)
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