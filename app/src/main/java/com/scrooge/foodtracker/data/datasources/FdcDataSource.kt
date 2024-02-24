package com.scrooge.foodtracker.data.datasources

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import gov.usda.fdc.api.FDCApi
import gov.usda.fdc.model.SearchResultFood
import okhttp3.OkHttpClient
import javax.inject.Inject

class FdcDataSource @Inject constructor(private val fdcApi: FDCApi) {
    fun searchIngredients(searchTerm: String): List<SearchResultFood> {
        return fdcApi.getFoodsSearch(
            query = searchTerm,
            dataType = listOf(FDCApi.DataTypeGetFoodsSearch.Foundation),
            sortBy = FDCApi.SortByGetFoodsSearch.LowercaseDescriptionPeriodKeyword,
            sortOrder = FDCApi.SortOrderGetFoodsSearch.Asc
        ).foods ?: emptyList()
    }
}

@Module
@InstallIn(ViewModelComponent::class)
class FdcApiModule {
    @Provides
    fun provideFdcApi() = FDCApi(
        client = OkHttpClient.Builder()
            .addInterceptor {
                it.proceed(
                    it.request().newBuilder()
                        .header("x-api-key", "YYB6WrlJWIAUpfc7sG1FNkF3Sm5lf1aLhvBhOvcf") // TODO insert proper api key
                        .build()
                )
            }.build()
    )
}
