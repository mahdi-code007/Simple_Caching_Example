package com.example.simplecachingexample.data.mapper

import com.example.simplecachingexample.data.model.RestaurantModel

class RestaurantsMapper : Mapper<RestaurantModel , Restaurants> {
    override fun map(input: RestaurantModel): Restaurants {
        return Restaurants(
            address = input.address,
            id = input.id,
            logo = input.logo,
            name = input.name,
            type = input.type
        )
    }
}