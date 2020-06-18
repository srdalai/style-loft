package com.sdtechnocrat.styleloft.model

data class PaymentMethodData(var cardNumber: String, var cardExpiry: String, var cardCVV: String, var nameOnCard: String, var cardType: String, var cardProvider: String, var bankName: String, var isSelected: Boolean)