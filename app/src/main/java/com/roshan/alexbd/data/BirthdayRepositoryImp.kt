package com.roshan.alexbd.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class BirthdayRepositoryImp @Inject constructor(private val apiService: APIService) :
    BirthdayRepository {
    override suspend fun getList(): Flow<Response> {
        return flow {
            try {
                emit(Response())

                val response = apiService.getBirthdayList()
                emit(response)
            } catch (e: HttpException) {

            } catch (e: IOException) {

            }

        }
    }
}