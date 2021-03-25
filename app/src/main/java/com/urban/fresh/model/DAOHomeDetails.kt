package com.urban.fresh.model


import com.google.gson.annotations.SerializedName

data class DAOHomeDetails(
    @SerializedName("components")
    var components: List<Component>,
    @SerializedName("success")
    var success: Boolean
) {
    data class Component(
        @SerializedName("AdsBanner")
        var adsBanner: List<AdsBanner>,
        @SerializedName("CarouselBanner")
        var carouselBanner: List<Any>,
        @SerializedName("categorydata")
        var categorydata: List<Categorydata>,
        @SerializedName("name")
        var name: String,
        @SerializedName("StaticBanner")
        var staticBanner: List<StaticBanner>
    ) {
        data class AdsBanner(
            @SerializedName("banner_alt")
            var bannerAlt: String,
            @SerializedName("banner_description")
            var bannerDescription: String,
            @SerializedName("banner_id")
            var bannerId: Int,
            @SerializedName("banner_image")
            var bannerImage: String,
            @SerializedName("banner_name")
            var bannerName: String
        )

        data class Categorydata(
            @SerializedName("category_description")
            var categoryDescription: String,
            @SerializedName("category_id")
            var categoryId: Int,
            @SerializedName("category_name")
            var categoryName: String,
            @SerializedName("category_picture")
            var categoryPicture: String
        )

        data class StaticBanner(
            @SerializedName("banner_alt")
            var bannerAlt: String,
            @SerializedName("banner_description")
            var bannerDescription: String,
            @SerializedName("banner_id")
            var bannerId: Int,
            @SerializedName("banner_image")
            var bannerImage: String,
            @SerializedName("banner_name")
            var bannerName: String
        )
    }
}