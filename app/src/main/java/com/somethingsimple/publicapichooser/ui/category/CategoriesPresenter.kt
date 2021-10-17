package com.somethingsimple.publicapichooser.ui.category

import com.github.terrakok.cicerone.Router
import com.somethingsimple.publicapichooser.data.repository.category.CategoryRepository
import com.somethingsimple.publicapichooser.data.vo.Category
import com.somethingsimple.publicapichooser.schedulers.Schedulers
import com.somethingsimple.publicapichooser.ui.IScreens
import com.somethingsimple.publicapichooser.ui.common.ListPresenter
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class CategoriesPresenter(
    private val categoryRepository: CategoryRepository,
    private var categoryListPresenter: ListPresenter<CategoryItemView, Category>,
    private val router: Router,
    private val schedulers: Schedulers,
    private val appScreens: IScreens,
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

) :
    MvpPresenter<CategoriesView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        categoryListPresenter.itemClickListener = { itemView ->
            categoryListPresenter.getItemAtPos(itemView.pos)?.let {
                router.navigateTo(appScreens.apis(it.name))

            }
        }
    }

    private fun loadData() {
        compositeDisposable.add(
            categoryRepository.getCategories()
                .observeOn(schedulers.main())
                .subscribe(
                    ::onCategoriesLoaded,
                    ::onLoadError
                )
        )
    }

    private fun onLoadError(throwable: Throwable) {
        viewState.loadingError(throwable.localizedMessage)

    }

    private fun onCategoriesLoaded(categories: List<Category>) {
        categoryListPresenter.clear()
        categoryListPresenter.addAll(categories)
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