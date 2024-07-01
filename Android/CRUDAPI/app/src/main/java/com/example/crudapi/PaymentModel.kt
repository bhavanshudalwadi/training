package com.example.crudapi

data class PaymentModel (
    val date: String,
    val total_collection: Double,
    val total_transactions: Int,
    val transactions: List<TransectionModel>
)