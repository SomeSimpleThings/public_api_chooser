package com.somethingsimple.publicapichooser.ui.api.list

import com.github.terrakok.cicerone.Router
import com.somethingsimple.publicapichooser.data.repository.publicapi.PublicApiRepository
import com.somethingsimple.publicapichooser.data.vo.ApiEntry
import com.somethingsimple.publicapichooser.schedulers.Schedulers
import com.somethingsimple.publicapichooser.ui.IScreens
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class PublicApisPresenter @AssistedInject constructor(
    @Assisted("category") private val category: String,
    @Assisted("screens") private val screens: IScreens,
    private val publicApiRepository: PublicApiRepository,
    private val router: Router,
    private val schedulers: Schedulers
) :
    MvpPresenter<PublicApisView>() {
    class PublicApisListPresenterImpl : PublicApiListPresenter {
        val apis = mutableListOf<ApiEntry>()
        override var itemClickListener: ((PublicApiItemView) -> Unit)? = null

        override fun getCount() = apis.size
        override fun clear() = apis.clear()


        override fun bindView(view: PublicApiItemView) {
            view.bind(apis[view.pos])
        }

        override fun addAll(newList: List<ApiEntry>) {
            apis.addAll(newList)
        }

        override fun getItemAtPos(pos: Int): ApiEntry? = apis.getOrNull(pos)
    }

    val apiListPresenter = PublicApisListPresenterImpl()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        apiListPresenter.itemClickListener = { itemView ->
            val apiEntry = apiListPresenter.apis[itemView.pos]
            router.navigateTo(screens.apiDetails(apiEntry.id))
        }
    }

    private fun loadData() {
        compositeDisposable.add(
            publicApiRepository.getPublicApiForCategory(category)
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
        apiListPresenter.clear()
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