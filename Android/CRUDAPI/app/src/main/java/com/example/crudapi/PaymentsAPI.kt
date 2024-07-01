package com.example.crudapi

import retrofit2.Response
import retrofit2.http.GET

interface PaymentsAPI {
    @GET("/payments-api/getPayments.php")
    suspend fun getPayments(): Response<List<PaymentModel>>
}