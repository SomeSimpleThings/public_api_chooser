package com.somethingsimple.publicapichooser.ui.api

import com.github.terrakok.cicerone.Router
import com.somethingsimple.publicapichooser.data.repository.publicapi.PublicApiRepository
import com.somethingsimple.publicapichooser.data.vo.ApiEntry
import com.somethingsimple.publicapichooser.exception.CategoryNotFound
import com.somethingsimple.publicapichooser.schedulers.Schedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class PublicApisPresenter(
    private val publicApiRepository: PublicApiRepository,
    private val router: Router,
    private val schedulers: Schedulers,
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

) :
    MvpPresenter<PublicApisView>() {
    class PublicApisListPresenterImpl : PublicApiListPresenter {
        val apis = mutableListOf<ApiEntry>()
        override var itemClickListener: ((PublicApiItemView) -> Unit)? = null

        override fun getCount() = apis.size

        override fun bindView(view: PublicApiItemView) {
            view.bind(apis[view.pos])
        }
    }

    val apiListPresenter = PublicApisListPresenterImpl()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun getApisForCategory(categoryName: String?) {
        categoryName?.let { loadData(it) } ?: onLoadError(CategoryNotFound())
    }

    private fun loadData(categoryName: String) {
        compositeDisposable.add(
            publicApiRepository.getPublicApiForCategory(categoryName)
                .observeOn(schedulers.main())
                .subscribe(
                    ::apisLoaded,
                    ::onLoadError
                )
        )
    }

    private fun onLoadError(throwable: Throwable?) {
        throwable?.let { viewState.loadingError(it.localizedMessage) }
    }

    private fun apisLoaded(apis: List<ApiEntry>) {
        apiListPresenter.apis.clear()
        apiListPresenter.apis.addAll(apis)
        viewState.updateList()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }


}