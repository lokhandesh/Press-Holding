package com.santoshlokhande.pressholding.repository

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.santoshlokhande.pressholding.viewmodel.RecordViewModel
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RecordsRepositoryTest {


    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var application: Application

    @Mock
    lateinit var recordsRepository: RecordsRepository

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)
        this.recordsRepository = RecordsRepository(application)

    }

    @Test
    fun getAllRecordList() {
        assertNotNull(recordsRepository.getAllRecordList())
    }

    @Test
    fun getError() {
        assertNotNull(recordsRepository.getError())

    }

    @Test
    fun insert() {
      //  assertNotNull(recordsRepository.insert())

    }

    @Test
    fun retriveRecordList() {
        assertNotNull(recordsRepository.retriveRecordList(10))

    }

    @After
    fun tearDown() {
    }

}