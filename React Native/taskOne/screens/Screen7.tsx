import { FlatList, StyleSheet } from 'react-native'
import React, { useEffect, useState } from 'react'
import { GluestackUIProvider, View } from '@gluestack-ui/themed'
import ProductCard from '../components/ProductCard'
import { config } from '@gluestack-ui/config'
import { Text } from '@gluestack-ui/themed'

const Screen7 = () => {
    const [products, setProducts] = useState([])

    const fetchProducts = async () => {
        try {
            const res = await fetch('https://dummyjson.com/products')
            if(res.ok) {
                const jsonData = await res.json()
                setProducts(jsonData.products)
            }else {
                console.log({ res })
            }
        } catch (error) {
            console.log({ error })
        }
    }

    useEffect(() => {
        fetchProducts()
    }, [])

    return (
        <GluestackUIProvider config={config}>
            <Text alignSelf='center'>API Call: https://dummyjson.com/products</Text>
            <FlatList
                data={products}
                numColumns={2}
                horizontal={false}
                contentContainerStyle={{margin: 10}}
                renderItem={({item}: any) => (
                    <ProductCard name={item.title} img={item.thumbnail} desc={item.description} price={item.price} mrp={item.mrp} category={item.category} />
                )}
                keyExtractor={(item: any) => item.id}
            />
        </GluestackUIProvider>
    )
}

export default Screen7

const styles = StyleSheet.create({})