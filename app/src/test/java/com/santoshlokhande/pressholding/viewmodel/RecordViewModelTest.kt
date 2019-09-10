package com.santoshlokhande.pressholding.viewmodel

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.santoshlokhande.pressholding.repository.RecordsRepository
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RecordViewModelTest {


    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var application: Application

    @Mock
    lateinit var recordViewModel: RecordViewModel

    @Mock
    lateinit var recordsRepository: RecordsRepository

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)
        this.recordViewModel = RecordViewModel(application)

    }

    @Test
    fun getAllRecords() {
        assertNotNull(recordViewModel.getAllRecords(10))
    }

    @Test
    fun retriveRecordList() {

        assertNotNull(recordViewModel.retriveRecordList(5))

    }

    @Test
    fun retriveError() {

        assertNotNull(recordViewModel.retriveError())

    }

    @After
    fun tearDown() {
    }


}