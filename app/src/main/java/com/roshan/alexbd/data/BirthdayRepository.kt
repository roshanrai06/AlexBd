package com.roshan.alexbd.data

import kotlinx.coroutines.flow.Flow

interface
  BirthdayRepository {
      suspend fun getList(): Flow<Response>
}