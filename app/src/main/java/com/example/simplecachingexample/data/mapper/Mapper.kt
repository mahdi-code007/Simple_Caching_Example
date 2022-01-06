package com.example.simplecachingexample.data.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}