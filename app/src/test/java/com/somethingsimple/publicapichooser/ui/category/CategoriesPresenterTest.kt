package com.somethingsimple.publicapichooser.ui.category

class CategoriesPresenterTest {

//    lateinit var categoriesPresenter: CategoriesPresenter
//
//    @Mock
//    lateinit var categoryRepository: CategoryRepository
//
//    @Mock
//    lateinit var router: Router
//
//    @Mock
//    lateinit var schedulers: DefaultSchedulersImpl
//
//    @Mock
//    lateinit var screens: IScreens
//
////    @Mock
////    lateinit var categoriesViewState: `CategoriesView$$State`
//
//    @Mock
//    lateinit var categoriesView: CategoriesView
//
//    @Mock
//    lateinit var compositeDisposable: CompositeDisposable
//
//    @Mock
//    lateinit var categoryListPresenter: ListPresenter<CategoryItemView, Category>
//
//    lateinit var categories: List<Category>
//
//    @Before
//    fun setUp() {
//        MockitoAnnotations.openMocks(this)
//        categoriesPresenter = CategoriesPresenter(
//            categoryRepository,
//            categoryListPresenter,
//            router,
//            schedulers,
//            screens,
//            compositeDisposable
//        )
//        categories = listOf(
//            Category("1"),
//            Category("2"),
//            Category("3")
//        )
////        categoriesPresenter.setViewState(categoriesViewState)
//        whenever(schedulers.main()).thenReturn(io.reactivex.rxjava3.schedulers.Schedulers.trampoline())
//
//    }
//
//    @Test
//    fun onFirstViewAttachViewStateInitSuccess() {
////        whenever(categoryRepository.getCategories()).thenReturn(Single.just(categories))
//        categoriesPresenter.attachView(categoriesView)
////        verify(categoriesViewState).init()
//        verify(categoryRepository).getCategories()
////        verify(categoriesViewState).updateList()
//        verify(categoryListPresenter).clear()
//        verify(categoryListPresenter).addAll(categories)
//
//    }
//
//    @Test
//    fun onFirstViewAttachViewStateInitFailure() {
//        val error = Throwable("Some exception happend")
//        whenever(categoryRepository.getCategories()).thenReturn(Single.error(error))
//        categoriesPresenter.attachView(categoriesView)
//        verify(categoryRepository).getCategories()
////        verify(categoriesViewState).loadingError(error.localizedMessage)
//    }
//
//
//    @Test
//    fun onDestroy() {
//        categoriesPresenter.onDestroy()
//        verify(compositeDisposable, only()).dispose()
//        assertEquals(compositeDisposable.size(), 0)
//    }
//
//    @Test
//    fun backPressedRouterExit() {
//        categoriesPresenter.backPressed()
//        verify(router).exit()
//    }
//
//    @Test
//    fun backPressedReturnsTrue() {
//        assert(categoriesPresenter.backPressed())
//    }
}