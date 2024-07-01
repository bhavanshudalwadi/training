import { FlatList, ScrollView, StyleSheet, Text, View, ViewToken } from 'react-native'
import React from 'react'
import MovieCard from '../components/MovieCard'
import { useSharedValue } from 'react-native-reanimated'

const movieList = [
    {
        title: "Pets",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129",
        imdb_rating: 9.5,
        date_of_release: "11 October",
        watch_count: 771261
    },
    {
        title: "Boss Baby",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129",
        imdb_rating: 9.1,
        date_of_release: "11 October",
        watch_count: 771261
    },
    {
        title: "Big Hero 6",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129",
        imdb_rating: 9.1,
        date_of_release: "11 October",
        watch_count: 771261
    },
    {
        title: "Incredibles 2",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129",
        imdb_rating: 9.1,
        date_of_release: "11 October",
        watch_count: 771261
    },
    {
        title: "Cars 3",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129",
        imdb_rating: 9.1,
        date_of_release: "11 October",
        watch_count: 771261
    },
    {
        title: "Minions",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129",
        imdb_rating: 9.1,
        date_of_release: "11 October",
        watch_count: 771261
    },
    {
        title: "Pets 2",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129",
        imdb_rating: 9.5,
        date_of_release: "11 October",
        watch_count: 771261
    },
    {
        title: "Boss Baby 2",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129",
        imdb_rating: 9.1,
        date_of_release: "11 October",
        watch_count: 771261
    },
    {
        title: "Another Big Hero",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129",
        imdb_rating: 9.1,
        date_of_release: "11 October",
        watch_count: 771261
    },
    {
        title: "Incredibles 3",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129",
        imdb_rating: 9.1,
        date_of_release: "11 October",
        watch_count: 771261
    },
    {
        title: "Cars 4",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129",
        imdb_rating: 9.1,
        date_of_release: "11 October",
        watch_count: 771261
    },
    {
        title: "Minions 2",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129",
        imdb_rating: 9.1,
        date_of_release: "11 October",
        watch_count: 771261
    }
]

export default function Screen2() {

    const viewableItems = useSharedValue<ViewToken[]>([])

    return (
        <FlatList
            data={movieList}
            renderItem={({ item }) => (
                <MovieCard
                    img={item.img}
                    title={item.title}
                    imdb_rating={item.imdb_rating}
                    date_of_release={item.date_of_release}
                    watch_count={item.watch_count}
                    viewableItems={viewableItems}
                />
            )}
            onViewableItemsChanged={({viewableItems: vItems}) => {
                viewableItems.value = vItems;
            }}
            keyExtractor={(item, index) => item.title}
        />
    )
}

const styles = StyleSheet.create({
    header: {
        fontSize: 25,
        marginVertical: 20,
        textAlign: 'center',
        fontWeight: 'bold'
    },
})