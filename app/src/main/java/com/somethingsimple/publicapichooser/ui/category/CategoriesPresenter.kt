package com.somethingsimple.publicapichooser.ui.category

import com.github.terrakok.cicerone.Router
import com.somethingsimple.publicapichooser.data.repository.category.CategoryRepository
import com.somethingsimple.publicapichooser.data.vo.Category
import com.somethingsimple.publicapichooser.schedulers.Schedulers
import com.somethingsimple.publicapichooser.ui.IScreens
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class CategoriesPresenter(
    private val categoryRepository: CategoryRepository,
    private val router: Router,
    private val schedulers: Schedulers,
    private val appScreens: IScreens,
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

) :
    MvpPresenter<CategoriesView>() {
    class CategoryListPresenterImpl : CategoryListPresenter {
        val categories = mutableListOf<Category>()
        override var itemClickListener: ((CategoryItemView) -> Unit)? = null

        override fun getCount() = categories.size

        override fun bindView(view: CategoryItemView) {
            view.bind(categories[view.pos])
        }
    }

    val categoryListPresenter = CategoryListPresenterImpl()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        categoryListPresenter.itemClickListener = { itemView ->
            val category = categoryListPresenter.categories[itemView.pos]
            router.navigateTo(appScreens.apis(category.name))
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

    private fun onLoadError(throwable: Throwable?) {
        throwable?.let { viewState.loadingError(it.localizedMessage) }
    }

    private fun onCategoriesLoaded(categories: List<Category>) {
        categoryListPresenter.categories.clear()
        categoryListPresenter.categories.addAll(categories)
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