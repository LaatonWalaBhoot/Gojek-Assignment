package com.gojek.gojekassignment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.gojek.gojekassignment.core.models.Repository
import com.gojek.gojekassignment.di.networkModule
import com.gojek.gojekassignment.di.repoModule
import com.gojek.gojekassignment.di.viewModelModule
import com.gojek.gojekassignment.ui.main.MainRepo
import com.gojek.gojekassignment.ui.main.MainViewModel
import org.junit.*
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by LaatonWalaBhoot on 11/06/21.
 */
class MainViewModelTest : KoinTest {

    val viewModel: MainViewModel by inject()
    val repository: MainRepo by inject()


    @Mock
    lateinit var data: Observer<List<Repository>>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        startKoin {
            modules(
                listOf(networkModule, repoModule, viewModelModule)
            )
        }
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun `test api call returns data`() {
        val list = repository.getRepositories().blockingGet()
        viewModel.repositories.observeForever(data)
        Assert.assertNotNull(viewModel.repositories.value)
        Mockito.verify(data).onChanged(list)
    }


}