package com.synowkrz.shoplist.data

import com.synowkrz.shoplist.R

data class Area(val type: AreaType) {
    fun displayName() = mapAreaToDisplayName(type)
    fun icon() = mapAreaTypeToIcon(type)
}

fun mapAreaToDisplayName(type: AreaType) = when(type) {
        AreaType.FRUITS_AND_VEGETABLES -> R.string.fruits_and_vegetables_area
        AreaType.MEAT_AND_FISH -> R.string.meat_and_fish_area
        AreaType.MILK_AND_DIARY -> R.string.milk_and_diary_area
    }

fun mapAreaTypeToIcon(type: AreaType) = when(type) {
        AreaType.FRUITS_AND_VEGETABLES,
        AreaType.MEAT_AND_FISH,
        AreaType.MILK_AND_DIARY -> R.drawable.baseline_breakfast_dining_24
    }


enum class AreaType {
    FRUITS_AND_VEGETABLES,
    MEAT_AND_FISH,
    MILK_AND_DIARY
}